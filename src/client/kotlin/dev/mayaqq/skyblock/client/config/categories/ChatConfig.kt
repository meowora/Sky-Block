package dev.mayaqq.skyblock.client.config.categories

import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigOption
import dev.mayaqq.skyblock.client.chat.HidingOption

@ConfigInfo(titleTranslation = "config.skyblock.chat.title")
@Category("chat")
public object ChatConfig {
    @ConfigOption.Separator("LOBBY")
    @ConfigEntry(id = "LOBBY_JOIN", translation = "config.skyblock.chat.lobby.lobby_join")
    public var LOBBY_JOIN: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("ABILITY")
    @ConfigEntry(id = "PREVIOUS_ABILITY_REMOVED", translation = "config.skyblock.chat.ability.previous_ability_removed")
    public var PREVIOUS_ABILITY_REMOVED: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("SYSTEM")
    @ConfigEntry(id = "GEXP_GAIN", translation = "config.skyblock.chat.system.gexp_gain")
    public var GEXP_GAIN: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "PROFILE_ID", translation = "config.skyblock.chat.system.profile_id")
    public var PROFILE_ID: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "PLAYING_ON_PROFILE", translation = "config.skyblock.chat.system.playing_on_profile")
    public var PLAYING_ON_PROFILE: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "WATCHDOG_REPORT", translation = "config.skyblock.chat.system.watchdog_report")
    public var WATCHDOG_REPORT: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("SKYBLOCK")
    @ConfigEntry(id = "SKYBLOCK_WELCOME", translation = "config.skyblock.chat.skyblock.skyblock_welcome")
    public var SKYBLOCK_WELCOME: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "FIRE_SALE", translation = "config.skyblock.chat.skyblock.fire_sale")
    public var FIRE_SALE: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "ALLOWANCE", translation = "config.skyblock.chat.skyblock.allowance")
    public var ALLOWANCE: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "NPC", translation = "config.skyblock.chat.skyblock.npc")
    public var NPC: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "NPC_BUY", translation = "config.skyblock.chat.skyblock.npc_buy")
    public var NPC_BUY: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "BUY_LIMIT", translation = "config.skyblock.chat.skyblock.buy_limit")
    public var BUY_LIMIT: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("TRAVEL")
    @ConfigEntry(id = "WARPING", translation = "config.skyblock.chat.travel.warping")
    public var WARPING: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "SENDING_TO_SERVER", translation = "config.skyblock.chat.travel.sending_to_server")
    public var SENDING_TO_SERVER: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "UNKNOWN_DESTINATION", translation = "config.skyblock.chat.travel.unknown_destination")
    public var UNKNOWN_DESTINATION: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("DUNGEON_HUB")
    @ConfigEntry(id = "DUNGEON_REWARD", translation = "config.skyblock.chat.dungeon_hub.dungeon_reward")
    public var DUNGEON_REWARD: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("DUNGEON")
    @ConfigEntry(id = "CANNOT_USE_OUTSIDE_DUNGEON", translation = "config.skyblock.chat.dungeon.cannot_use_outside_dungeon")
    public var CANNOT_USE_OUTSIDE_DUNGEON: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "QUEUING", translation = "config.skyblock.chat.dungeon.queuing")
    public var QUEUING: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "STARTING", translation = "config.skyblock.chat.dungeon.starting")
    public var STARTING: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "STATS_DOUBLED", translation = "config.skyblock.chat.dungeon.stats_doubled")
    public var STATS_DOUBLED: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "CLASS_MESSAGE", translation = "config.skyblock.chat.dungeon.class_message")
    public var CLASS_MESSAGE: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "DUNGEON_REQUESTED_ALREADY", translation = "config.skyblock.chat.dungeon.dungeon_requested_already")
    public var DUNGEON_REQUESTED_ALREADY: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "SELECTED_CLASS_MESSAGE", translation = "config.skyblock.chat.dungeon.selected_class_message")
    public var SELECTED_CLASS_MESSAGE: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("MINING")
    @ConfigEntry(id = "WIND_CHANGED_DIRECTION", translation = "config.skyblock.chat.mining.wind_changed_direction")
    public var WIND_CHANGED_DIRECTION: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "EVENT_STARTING", translation = "config.skyblock.chat.mining.event_starting")
    public var EVENT_STARTING: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "FALLEN_STAR", translation = "config.skyblock.chat.mining.fallen_star")
    public var FALLEN_STAR: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("ITEM")
    @ConfigEntry(id = "CANNOT_USE_ITEM", translation = "config.skyblock.chat.item.cannot_use_item")
    public var CANNOT_USE_ITEM: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "ABILITY_COOLDOWN", translation = "config.skyblock.chat.item.ability_cooldown")
    public var ABILITY_COOLDOWN: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "ZOMBIE_SWORD_NO_MORE_CHARGES", translation = "config.skyblock.chat.item.zombie_sword_no_more_charges")
    public var ZOMBIE_SWORD_NO_MORE_CHARGES: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("MISC")
    @ConfigEntry(id = "RINGING", translation = "config.skyblock.chat.misc.ringing")
    public var RINGING: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "ALREADY_FOUND_FAIRY_SOUL", translation = "config.skyblock.chat.misc.already_found_fairy_soul")
    public var ALREADY_FOUND_FAIRY_SOUL: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("IRONMAN")
    @ConfigEntry(id = "AUCTION_DISALLOWED", translation = "config.skyblock.chat.ironman.auction_disallowed")
    public var AUCTION_DISALLOWED: HidingOption = HidingOption.DISABLED

    @ConfigOption.Separator("CENTURY_CAKE")
    @ConfigEntry(id = "WRONG_TEAM", translation = "config.skyblock.chat.century_cake.wrong_team")
    public var WRONG_TEAM: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "TOO_MUCH_CAKE", translation = "config.skyblock.chat.century_cake.too_much_cake")
    public var TOO_MUCH_CAKE: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "NOT_A_PLAYER", translation = "config.skyblock.chat.century_cake.not_a_player")
    public var NOT_A_PLAYER: HidingOption = HidingOption.DISABLED

    @ConfigEntry(id = "NOT_YOUR_CAKE", translation = "config.skyblock.chat.century_cake.not_your_cake")
    public var NOT_YOUR_CAKE: HidingOption = HidingOption.DISABLED
}
