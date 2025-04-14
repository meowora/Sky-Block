@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    alias(libs.plugins.loom)
    kotlin("jvm") version "2.0.20"
    alias(libs.plugins.publish)
}

version = project.property("mod_version") as String
group = project.property("maven_group") as String

base {
    archivesName.set(project.property("archives_base_name") as String)
}

val targetJavaVersion = 21
java {
    toolchain.languageVersion = JavaLanguageVersion.of(targetJavaVersion)
    withSourcesJar()
}

loom {
    splitEnvironmentSourceSets()

    accessWidenerPath = file("src/main/resources/skyblock.accesswidener")

    mods {
        register("skyblock") {
            sourceSet("main")
            sourceSet("client")
        }
    }

    runs {
        getByName("client") {
            programArg("--quickPlayMultiplayer=hypixel.net")
            vmArg("-Ddevauth.enabled=true")
            vmArg("-Dskyblockapi.debug=true")
        }
    }
}

repositories {
    maven("https://maven.terraformersmc.com/")  // Mod Menu
    maven("https://maven.parchmentmc.org") // Parchment Mappings
    maven("https://pkgs.dev.azure.com/djtheredstoner/DevAuth/_packaging/public/maven/v1") // DevAuth
    maven("https://repo.hypixel.net/repository/Hypixel/") // Hypixel API
    maven("https://api.modrinth.com/maven") // Hypixel API kotlin
    maven("https://nexus.resourcefulbees.com/repository/maven-public/") // Skyblock API
}

dependencies {
    minecraft(libs.minecraft)
    mappings(loom.layered {
        officialMojangMappings()
        parchment(libs.parchment)
    })
    modImplementation(libs.fabric)
    modImplementation(libs.kotlin.lang)

    modImplementation(libs.fapi)

    include(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.core)

    modImplementation(libs.modmenu)
    include(libs.sbapi)
    modImplementation(libs.sbapi)

    modImplementation(libs.resourceful.config)
    modImplementation(libs.resourceful.config.kotlin)

    modRuntimeOnly(libs.devauth)
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("minecraft_version", libs.versions.minecraft.get())
    inputs.property("loader_version", libs.versions.fabric.get())
    inputs.property("kotlin_loader_version", libs.versions.kotlin)
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to libs.versions.minecraft.get(),
            "loader_version" to libs.versions.fabric.get(),
            "kotlin_loader_version" to libs.versions.kotlin
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    options.encoding = "UTF-8"
    options.release.set(targetJavaVersion)
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions.jvmTarget.set(JvmTarget.fromTarget(targetJavaVersion.toString()))
}

tasks.jar {
    from("LICENSE") {
        rename { "${it}_${project.base.archivesName}" }
    }
}

publishMods {
    file.set(tasks.remapJar.get().archiveFile)
    modLoaders.add("fabric")
    type.set(STABLE)

    modrinth {
        accessToken = providers.environmentVariable("MODRINTH_TOKEN")
        projectId = "vUfww66P"
        minecraftVersions.add("1.21.5")

        requires { slug = "fabric-api" }
        requires { slug = "fabric-language-kotlin" }
        requires { slug = "hypixel-mod-api" }
        requires { slug = "resourceful-config" }
    }
}