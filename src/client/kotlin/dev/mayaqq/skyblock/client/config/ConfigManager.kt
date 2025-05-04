@file:Suppress("ERROR_SUPPRESSION")
package dev.mayaqq.skyblock.client.config

import com.teamresourceful.resourcefulconfig.api.client.ResourcefulConfigScreen
import com.teamresourceful.resourcefulconfig.api.loader.Configurator
import com.teamresourceful.resourcefulconfig.api.types.ResourcefulConfig
import com.teamresourceful.resourcefulconfig.api.types.ResourcefulConfigElement
import dev.mayaqq.skyblock.client.chat.SpamMessage
import dev.mayaqq.skyblock.client.utils.DynamicConfigCategory
import dev.mayaqq.skyblock.client.utils.DynamicInfo
import tech.thatgravyboat.skyblockapi.api.events.base.Subscription
import tech.thatgravyboat.skyblockapi.api.events.misc.RegisterCommandsEvent
import tech.thatgravyboat.skyblockapi.helpers.McClient

object ConfigManager {
    private val configurator = Configurator("skyblock")

    @Suppress("INVISIBLE_MEMBER", "INVISIBLE_REFERENCE")
    val config = Config.build(null)

    init {
        config.createDynamic("chat", "config.skyblock.chat.title", elements = SpamMessage.entriesWithSeparators())
        configurator.register(config)
    }

    fun ResourcefulConfig.createDynamic(id: String, title: String, description: String = "", elements: List<ResourcefulConfigElement> = emptyList()) {
        this.categories().put(
            id,
            DynamicConfigCategory(
                DynamicInfo(-1, title, description),
                id,
                elements,
                config,
            ),
        )
    }

    @Subscription
    fun onRegisterCommands(event: RegisterCommandsEvent) {
        event.register("sky-block") {
            callback {
                McClient.setScreen(ResourcefulConfigScreen.get(null, config))
            }
        }
    }

    fun save() {
        configurator.saveConfig(Config::class.java)
    }
}
