package dev.mayaqq.skyblock.client.config

import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigColorValue
import com.teamresourceful.resourcefulconfig.api.types.info.ResourcefulConfigLink
import com.teamresourceful.resourcefulconfigkt.api.ConfigKt
import dev.mayaqq.skyblock.client.SkyblockClient
import dev.mayaqq.skyblock.client.chat.SpamChat

object Config : ConfigKt("sky-block") {
    var enabled by boolean("enabled", false) {
        name = Translated("config.skyblock.enabled")
    }

    val extra by observable(
        strings {
            translation = "config.skyblock.extra"
        },
        wrapped(SpamChat::onExtraChange),
    )

    private fun wrapped(function: (Array<out String>) -> Unit): (Array<out String>, Array<out String>) -> Unit {
        return { _, new -> function(new) }
    }

    val extraUi by observable(
        strings {
            translation = "config.skyblock.extraUi"
        },
        wrapped(SpamChat::onExtraUiChange),
    )

    init {
        separator {
            title = "Extras"
        }
    }

    var abilityUse by boolean("abilityUse", false) {
        translation = "config.skyblock.actionBar.abilityUse"
    }

    override val name = Literal("Sky-Block (v${SkyblockClient.self.metadata.version.friendlyString})")
    override val description = Literal("Customizable mod for Hypixel Skyblock removing/moving chat messages")

    override val links = arrayOf(
        ResourcefulConfigLink.create(
            "https://modrinth.com/project/hypixel-sky-block",
            "modrinth",
            Literal("Modrinth"),
        ),
        ResourcefulConfigLink.create(
            "https://github.com/MayaqqDev/Sky-Block",
            "code",
            Literal("GitHub"),
        ),
    )

    override val icon = "box"
    override val color: ResourcefulConfigColorValue = ResourcefulConfigColorValue.create("#fbb8ff")
    override val hidden = false
}
