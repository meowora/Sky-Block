package dev.mayaqq.skyblock.client.config

import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColor
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColorValue
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigInfo
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigLink
import com.teamresourceful.resourcefulconfig.api.types.options.TranslatableValue
import net.fabricmc.loader.api.FabricLoader

class ConfigInfoProvider : ResourcefulConfigInfo {

    private val self = FabricLoader.getInstance().getModContainer("skyblock").get()

    override fun title(): TranslatableValue = TranslatableValue("Sky-Block (v${self.metadata.version.friendlyString})")
    override fun description(): TranslatableValue = TranslatableValue("Customizable mod for Hypixel Skyblock removing/moving chat messages")


    override fun links(): Array<ResourcefulConfigLink> = arrayOf(
        ResourcefulConfigLink.create(
            "https://modrinth.com/project/Sky-Block",
            "modrinth",
            TranslatableValue("Modrinth")
        ),
        ResourcefulConfigLink.create(
            "https://github.com/MayaqqDev/Sky-Block",
            "code",
            TranslatableValue("GitHub")
        )
    )

    override fun icon(): String = "box"
    override fun color(): ResourcefulConfigColor = ResourcefulConfigColorValue.create("#FFFFFF")
    override fun isHidden(): Boolean = false
}