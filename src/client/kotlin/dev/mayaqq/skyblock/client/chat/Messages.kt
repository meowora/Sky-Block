package dev.mayaqq.skyblock.client.chat

import dev.mayaqq.skyblock.client.config.categories.ChatConfig
import java.util.function.Supplier

enum class Messages(val regex: Regex, val option: Supplier<HidingOption>) {
    // Lobby
    LOBBY_JOIN(Regex("""(?:>>> )?[\s\S]*joined the lobby!(?: <<<)?"""), { ChatConfig.lobbyJoinMessage }),
    // System
    GEXP_GAIN(Regex("""You earned \\d+ GEXP from playing [\s\S]*!"""), { ChatConfig.gexpGain }),
    PROFILE_ID(Regex("""Profile ID: [\s\S]*"""), { ChatConfig.profileId }),
    PLAYING_ON_PROFILE(Regex("""You are playing on profile: [\s\S]*"""), { ChatConfig.playingOnProfile }),
    WATCHDOG_REPORT(Regex("""[\s\S]*(\\\[WATCHDOG ANNOUNCEMENT]|Watchdog has banned|Staff have banned an additional|Blacklisted modifications are a bannable offense!)[\s\S]*"""), { ChatConfig.watchdogReport }),
    // Skyblock
    SKYBLOCK_WELCOME(Regex("""Welcome to Hypixel SkyBlock!"""), { ChatConfig.welcomeToSkyblock }),
    FIRE_SALE(Regex("""A FIRE SALE [\s\S]*"""), { ChatConfig.fireSale }),
    // Travel
    WARPING(Regex("""Warping..."""), { ChatConfig.warping }),
    SENDING_TO_SERVER(Regex("""Sending to server [\s\S]*"""), { ChatConfig.sendingToServer }),
    // Dungeon Hub
    DUNGEON_REWARD(Regex("""RARE REWARD! .+ found a .+ in their .+!"""), { ChatConfig.dungeonReward }),
    // Item
    CANNOT_USE_ITEM(Regex("""Cannot use this item here!"""), { ChatConfig.cannotUseItem }),
    ABILITY_COOLDOWN(Regex("""Ability is on cooldown for [\s\S]*"""), { ChatConfig.abilityCooldown }),
    ZOMBIE_SWORD_NO_MORE_CHARGES(Regex("""No more charges, next one in [\s\S]*"""), { ChatConfig.zombieSwordNoMoreCharges }),
    // Miscellaneous
    RINGING(Regex("""✆ RING...[\s\S]*"""), { ChatConfig.ringing }),
    ALREADY_FOUND_FAIRY_SOUL(Regex("""You have already found that Fairy Soul!"""), { ChatConfig.alreadyFoundFairySoul });
}