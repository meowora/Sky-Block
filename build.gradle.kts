@file:Suppress("UnstableApiUsage")

import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("fabric-loom") version libs.versions.loom
    kotlin("jvm") version libs.versions.kotlin
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

    implementation(include(libs.kotlinx.coroutines.core)!!)

    modImplementation(libs.modmenu)
    modImplementation(include(libs.sbapi)!!)

    modImplementation(libs.resourceful.config)
    modImplementation(libs.resourceful.config.kotlin)

    modRuntimeOnly(libs.devauth)
}

tasks.processResources {
    inputs.property("version", project.version)
    inputs.property("minecraft_version", project.property("minecraft_version"))
    inputs.property("loader_version", project.property("loader_version"))
    filteringCharset = "UTF-8"

    filesMatching("fabric.mod.json") {
        expand(
            "version" to project.version,
            "minecraft_version" to project.property("minecraft_version"),
            "loader_version" to project.property("loader_version"),
            "kotlin_loader_version" to project.property("kotlin_loader_version")
        )
    }
}

tasks.withType<JavaCompile>().configureEach {
    // ensure that the encoding is set to UTF-8, no matter what the system default is
    // this fixes some edge cases with special characters not displaying correctly
    // see http://yodaconditions.net/blog/fix-for-java-file-encoding-problems-with-gradle.html
    // If Javadoc is generated, this must be specified in that task too.
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
}