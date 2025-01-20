package dev.mayaqq.skyblock.client

import dev.mayaqq.skyblock.client.chat.SpamChat
import dev.mayaqq.skyblock.client.config.ConfigManager
import net.fabricmc.api.ModInitializer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import tech.thatgravyboat.skyblockapi.api.SkyBlockAPI

const val MODID = "skyblock"
const val MODNAME = "Sky-Block"

object SkyblockClient : ModInitializer, Logger by LoggerFactory.getLogger(MODID) {

    override fun onInitialize() {
        SkyBlockAPI.eventBus.register(SpamChat)
        SkyBlockAPI.eventBus.register(ConfigManager)
    }
}
