package dev.mayaqq.skyblock.client.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption.Separator
import dev.mayaqq.skyblock.client.chat.HidingOption

@ConfigInfo(titleTranslation = "config.skyblock.chat.title")
@Category("chat")
object ChatConfig {
    @Separator("Lobby")
    @ConfigEntry(id = "lobbyJoinMessage", translation = "config.skyblock.chat.lobby.lobbyJoinMessage")
    var lobbyJoinMessage = HidingOption.DISABLED

    @Separator("System")
    @ConfigEntry(id = "gexpGain", translation = "config.skyblock.chat.system.gexpGain")
    var gexpGain = HidingOption.DISABLED
    @ConfigEntry(id = "profileId", translation = "config.skyblock.chat.system.profileId")
    var profileId = HidingOption.DISABLED
    @ConfigEntry(id = "playingOnProfile", translation = "config.skyblock.chat.system.playingOnProfile")
    var playingOnProfile = HidingOption.DISABLED
    @ConfigEntry(id = "watchdogReport", translation = "config.skyblock.chat.system.watchdogReport")
    var watchdogReport = HidingOption.DISABLED

    @Separator("Action Bar")
    @ConfigEntry(id = "abilityUse", translation = "config.skyblock.chat.actionBar.abilityUse")
    var abilityUse = false
    @ConfigEntry(id = "previousAbilityRemoved", translation = "config.skyblock.chat.actionBar.previousAbilityRemoved")
    var previousAbilityRemoved = HidingOption.DISABLED

    @Separator("Skyblock")
    @ConfigEntry(id = "welcomeToSkyblock", translation = "config.skyblock.chat.welcomeToSkyblock")
    var welcomeToSkyblock = HidingOption.DISABLED
    @ConfigEntry(id = "fireSale", translation = "config.skyblock.chat.fireSale")
    var fireSale = HidingOption.DISABLED
    @ConfigEntry(id = "allowance", translation = "config.skyblock.chat.allowance")
    var allowance = HidingOption.DISABLED
    @ConfigEntry(id = "npc", translation = "config.skyblock.chat.npc")
    var npc = HidingOption.DISABLED
    @ConfigEntry(id = "npcBuy", translation = "config.skyblock.chat.npcBuy")
    var npcBuy = HidingOption.DISABLED
    @ConfigEntry(id = "buyLimit", translation = "config.skyblock.chat.buyLimit")
    var buyLimit = HidingOption.DISABLED

    @Separator("Travel")
    @ConfigEntry(id = "warping", translation = "config.skyblock.chat.travel.warping")
    var warping = HidingOption.DISABLED
    @ConfigEntry(id = "sendingToServer", translation = "config.skyblock.chat.travel.sendingToServer")
    var sendingToServer = HidingOption.DISABLED
    @ConfigEntry(id = "unknownDestination", translation = "config.skyblock.chat.travel.unknownDestination")
    var unknownDestination = HidingOption.DISABLED

    @Separator("Dungeon Hub")
    @ConfigEntry(id = "dungeonReward", translation = "config.skyblock.chat.dungeonHub.dungeonReward")
    var dungeonReward = HidingOption.DISABLED

    @Separator("Dungeon")
    @ConfigEntry(id = "cannotUseOutsideDungeon", translation = "config.skyblock.chat.dungeon.cannotUseOutsideDungeon")
    var cannotUseOutsideDungeon = HidingOption.DISABLED
    @ConfigEntry(id = "queuing", translation = "config.skyblock.chat.dungeon.queuing")
    var queuing = HidingOption.DISABLED
    @ConfigEntry(id = "starting", translation = "config.skyblock.chat.dungeon.starting")
    var starting = HidingOption.DISABLED
    @ConfigEntry(id = "statsDoubled", translation = "config.skyblock.chat.dungeon.statsDoubled")
    var statsDoubled = HidingOption.DISABLED
    @ConfigEntry(id = "classMessage", translation = "config.skyblock.chat.dungeon.classMessage")
    var classMessage = HidingOption.DISABLED
    @ConfigEntry(id = "requestedDungeonAlready", translation = "config.skyblock.chat.dungeon.requestedDungeonAlready")
    var requestedDungeonAlready = HidingOption.DISABLED
    @ConfigEntry(id = "selectedClassMessage", translation = "config.skyblock.chat.dungeon.selectedClassMessage")
    var selectedClassMessage = HidingOption.DISABLED

    @Separator("Mining")
    @ConfigEntry(id = "windChangedDirection", translation = "config.skyblock.chat.mining.windChangedDirection")
    var windChangedDirection = HidingOption.DISABLED
    @ConfigEntry(id = "eventStarting", translation = "config.skyblock.chat.mining.eventStarting")
    var eventStarting = HidingOption.DISABLED
    @ConfigEntry(id = "FallenStar", translation = "config.skyblock.chat.mining.FallenStar")
    var FallenStar = HidingOption.DISABLED

    @Separator("Item")
    @ConfigEntry(id = "cannotUseItem", translation = "config.skyblock.chat.item.cannotUseItem")
    var cannotUseItem = HidingOption.DISABLED
    @ConfigEntry(id = "abilityCooldown", translation = "config.skyblock.chat.item.abilityCooldown")
    var abilityCooldown = HidingOption.DISABLED
    @ConfigEntry(id = "zombieSwordNoMoreCharges", translation = "config.skyblock.chat.item.zombieSwordNoMoreCharges")
    var zombieSwordNoMoreCharges = HidingOption.DISABLED

    @Separator("Miscellaneous")
    @ConfigEntry(id = "ringing", translation = "config.skyblock.chat.misc.ringing")
    var ringing = HidingOption.DISABLED
    @ConfigEntry(id = "alreadyFoundFairySoul", translation = "config.skyblock.chat.misc.alreadyFoundFairySoul")
    var alreadyFoundFairySoul = HidingOption.DISABLED

    @Separator("Ironman")
    @ConfigEntry(id = "auctionDisallowed", translation = "config.skyblock.chat.ironman.auctionDisallowed")
    var auctionDisallowed = HidingOption.DISABLED

    @Separator("Century Cake")
    @ConfigEntry(id = "wrongTeam", translation = "config.skyblock.chat.centuryCake.wrongTeam")
    var wrongTeam = HidingOption.DISABLED
    @ConfigEntry(id = "tooMuchCake", translation = "config.skyblock.chat.centuryCake.tooMuchCake")
    var tooMuchCake = HidingOption.DISABLED
    @ConfigEntry(id = "notAPlayer", translation = "config.skyblock.chat.centuryCake.notAPlayer")
    var notAPlayer = HidingOption.DISABLED
}