package dev.mayaqq.skyblock.client.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption
import dev.mayaqq.skyblock.client.chat.HidingOption

@ConfigInfo(titleTranslation = "config.skyblock.chat.title")
@Category("chat")
object ChatConfig {
    @ConfigOption.Separator("Lobby")
    @ConfigEntry(id = "lobbyJoinMessage", translation = "config.skyblock.chat.lobby.lobbyJoinMessage")
    var lobbyJoinMessage = HidingOption.DISABLED

    @ConfigOption.Separator("System")
    @ConfigEntry(id = "gexpGain", translation = "config.skyblock.chat.system.gexpGain")
    var gexpGain = HidingOption.DISABLED
    @ConfigEntry(id = "profileId", translation = "config.skyblock.chat.system.profileId")
    var profileId = HidingOption.DISABLED
    @ConfigEntry(id = "playingOnProfile", translation = "config.skyblock.chat.system.playingOnProfile")
    var playingOnProfile = HidingOption.DISABLED
    @ConfigEntry(id = "watchdogReport", translation = "config.skyblock.chat.system.watchdogReport")
    var watchdogReport = HidingOption.DISABLED

    @ConfigOption.Separator("Action Bar")
    @ConfigEntry(id = "abilityUse", translation = "config.skyblock.chat.actionBar.abilityUse")
    var abilityUse = false

    @ConfigOption.Separator("Skyblock")
    @ConfigEntry(id = "welcomeToSkyblock", translation = "config.skyblock.chat.welcomeToSkyblock")
    var welcomeToSkyblock = HidingOption.DISABLED

    @ConfigOption.Separator("Travel")
    @ConfigEntry(id = "warping", translation = "config.skyblock.chat.travel.warping")
    var warping = HidingOption.DISABLED
    @ConfigEntry(id = "sendingToServer", translation = "config.skyblock.chat.travel.sendingToServer")
    var sendingToServer = HidingOption.DISABLED

    @ConfigOption.Separator("Dungeon Hub")
    @ConfigEntry(id = "dungeonReward", translation = "config.skyblock.chat.dungeonHub.dungeonReward")
    var dungeonReward = HidingOption.DISABLED

    @ConfigOption.Separator("Item")
    @ConfigEntry(id = "zombieSwordNoMoreCharges", translation = "config.skyblock.chat.item.zombieSwordNoMoreCharges")
    var zombieSwordNoMoreCharges = HidingOption.DISABLED

    @ConfigOption.Separator("Miscellaneous")
    @ConfigEntry(id = "ringing", translation = "config.skyblock.chat.misc.ringing")
    var ringing = HidingOption.DISABLED
    @ConfigEntry(id = "alreadyFoundFairySoul", translation = "config.skyblock.chat.misc.alreadyFoundFairySoul")
    var alreadyFoundFairySoul = HidingOption.DISABLED
}