import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "2.0.20"
    id("fabric-loom") version "1.9-SNAPSHOT"
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
    minecraft("com.mojang:minecraft:${project.property("minecraft_version")}")
    mappings(loom.layered {
        officialMojangMappings()
        parchment("org.parchmentmc.data:parchment-${project.properties["minecraft_version"]}:${project.properties["parchment_version"]}@zip")
    })
    modImplementation("net.fabricmc:fabric-loader:${project.property("loader_version")}")
    modImplementation("net.fabricmc:fabric-language-kotlin:${project.property("kotlin_loader_version")}")

    modImplementation("net.fabricmc.fabric-api:fabric-api:${project.property("fabric_version")}")

    implementation(include("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.10.1")!!)

    modImplementation("com.terraformersmc:modmenu:${project.properties["modmenu_version"]}")
    modImplementation(include("net.hypixel:mod-api:${project.properties["hypixel_api_version"]}")!!)
    modImplementation("maven.modrinth:hypixel-mod-api:${project.properties["hypixel_api_version_modrinth"]}")
    modImplementation(include("tech.thatgravyboat:skyblock-api-${project.properties["minecraft_version"]}:${project.properties["skyblock_api_version"]}")!!)

    modImplementation("com.teamresourceful.resourcefulconfig:resourcefulconfig-fabric-${project.properties["minecraft_version"]}:${project.properties["resourceful_config_version"]}")
    modImplementation("com.teamresourceful.resourcefulconfigkt:resourcefulconfigkt-fabric-1.21.3:${project.properties["resourceful_config_kt_version"]}")

    modRuntimeOnly("me.djtheredstoner:DevAuth-fabric:${project.properties["devauth_version"]}")
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
