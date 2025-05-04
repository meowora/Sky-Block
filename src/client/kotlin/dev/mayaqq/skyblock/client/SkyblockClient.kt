package dev.mayaqq.skyblock.client

import dev.mayaqq.skyblock.client.chat.SpamChat
import dev.mayaqq.skyblock.client.config.ConfigManager
import net.fabricmc.api.ModInitializer
import net.fabricmc.loader.api.FabricLoader
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import tech.thatgravyboat.skyblockapi.api.SkyBlockAPI

const val MODID = "skyblock"
const val MODNAME = "Sky-Block"

object SkyblockClient : ModInitializer, Logger by LoggerFactory.getLogger(MODID) {
    val self = FabricLoader.getInstance().getModContainer("skyblock").get()
    override fun onInitialize() {
        SkyBlockAPI.eventBus.register(SpamChat)
        SkyBlockAPI.eventBus.register(ConfigManager)
    }
}
