package dev.mayaqq.skyblock.client.chat

import dev.mayaqq.skyblock.client.config.categories.ChatConfig
import java.util.function.Supplier

enum class Messages(val regex: Regex, val option: Supplier<HidingOption>) {
    // Lobby
    LOBBY_JOIN(Regex("""(?:>>> )?[\s\S]*joined the lobby!(?: <<<)?"""), { ChatConfig.lobbyJoinMessage }),
    // Ability
    PREVIOUS_ABILITY_REMOVED(Regex("""Your previous [\s\S]* was removed!"""), { ChatConfig.previousAbilityRemoved }),
    // System
    GEXP_GAIN(Regex("""You earned \d+ GEXP from playing [\s\S]*!"""), { ChatConfig.gexpGain }),
    PROFILE_ID(Regex("""Profile ID: [\s\S]*"""), { ChatConfig.profileId }),
    PLAYING_ON_PROFILE(Regex("""You are playing on profile: [\s\S]*"""), { ChatConfig.playingOnProfile }),
    WATCHDOG_REPORT(Regex("""[\s\S]*(\\\[WATCHDOG ANNOUNCEMENT]|Watchdog has banned|Staff have banned an additional|Blacklisted modifications are a bannable offense!)[\s\S]*"""), { ChatConfig.watchdogReport }),
    // Skyblock
    SKYBLOCK_WELCOME(Regex("""Welcome to Hypixel SkyBlock!"""), { ChatConfig.welcomeToSkyblock }),
    FIRE_SALE(Regex("""A FIRE SALE [\s\S]*"""), { ChatConfig.fireSale }),
    ALLOWANCE(Regex("""ALLOWANCE! You earned [\s\S]* coins!"""), { ChatConfig.allowance }),
    NPC(Regex("""\\\[NPC] [\s\S]*"""), { ChatConfig.npc }),
    NPC_BUY(Regex("""You bought [\s\S]* x\d+ for [\d.]+[\dA-Za-z]* Coins!"""), { ChatConfig.npcBuy }),
    BUY_LIMIT(Regex("""You may only buy up to [\s\S]* of this item each day!"""), { ChatConfig.buyLimit }),
    // Travel
    WARPING(Regex("""Warping..."""), { ChatConfig.warping }),
    SENDING_TO_SERVER(Regex("""Sending to server [\s\S]*"""), { ChatConfig.sendingToServer }),
    UNKNOWN_DESTINATION(Regex("""Unknown destination! Check the Fast Travel menu to view options!"""), { ChatConfig.unknownDestination }),
    // Dungeon Hub
    DUNGEON_REWARD(Regex("""RARE REWARD! .+ found a .+ in their .+!"""), { ChatConfig.dungeonReward }),
    // Dungeon
    CANNOT_USE_OUTSIDE_DUNGEON(Regex("""You can only use this item in dungeons!"""), { ChatConfig.cannotUseOutsideDungeon }),
    QUEUING(Regex("""Queuing... \\(Attempt [\s\S]{3}\\)"""), { ChatConfig.queuing }),
    STARTING(Regex("""Starting in \d second(s)?."""), { ChatConfig.starting }),
    STATS_DOUBLED(Regex("""Your [\s\S]* stats are doubled because you are the only player using this class!"""), { ChatConfig.statsDoubled }),
    CLASS_MESSAGE(Regex("""\[(Mage|Healer|Berserk|Archer|Tank)] [\s\S]*"""), { ChatConfig.classMessage }),
    DUNGEON_REQUESTED_ALREADY(Regex("""You have already requested a server! Please wait a bit."""), { ChatConfig.requestedDungeonAlready }),
    SELECTED_CLASS_MESSAGE(Regex("""You have selected the [\s\S]* Dungeon Class!"""), { ChatConfig.selectedClassMessage }),
    // Mining
    WIND_CHANGED_DIRECTION(Regex("""The wind has changed direction!"""), { ChatConfig.windChangedDirection }),
    EVENT_STARTING(Regex("""[\s\S]{3}The [\s\S]* event starts in 20 seconds![\s\S]*"""), { ChatConfig.eventStarting }),
    FALLEN_STAR(Regex("""✯ A Fallen Star has crashed at Cliffside Veins![\s\S]*"""), { ChatConfig.FallenStar }),
    // Item
    CANNOT_USE_ITEM(Regex("""Cannot use this item here!"""), { ChatConfig.cannotUseItem }),
    ABILITY_COOLDOWN(Regex("""Ability is on cooldown for [\s\S]*"""), { ChatConfig.abilityCooldown }),
    ZOMBIE_SWORD_NO_MORE_CHARGES(Regex("""No more charges, next one in [\s\S]*"""), { ChatConfig.zombieSwordNoMoreCharges }),
    // Miscellaneous
    RINGING(Regex("""✆ RING...[\s\S]*"""), { ChatConfig.ringing }),
    ALREADY_FOUND_FAIRY_SOUL(Regex("""You have already found that Fairy Soul!"""), { ChatConfig.alreadyFoundFairySoul }),
    // Ironman
    AUCTION_DISALLOWED(Regex("""You can't use the Auction House while playing on your current profile type!"""), { ChatConfig.auctionDisallowed }),
}