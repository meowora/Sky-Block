package dev.mayaqq.skyblock.client.config

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.misc.RegisterCommandsEvent
import tech.thatgravyboat.skyblockapi.helpers.McClient

object ConfigManager {
    private val configurator = Configurator("skyblock")

    init {
        configurator.register(Config::class.java)
    }

    @Subscription
    fun onRegisterCommands(event: RegisterCommandsEvent) {
        event.register("sky-block") {
            callback {
                McClient.setScreen(ResourcefulConfigScreen.get(null, configurator, Config::class.java))
            }
        }
    }

    fun save() {
        configurator.saveConfig(Config::class.java)
    }
}