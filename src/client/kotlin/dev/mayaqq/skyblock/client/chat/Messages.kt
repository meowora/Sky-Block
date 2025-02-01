package dev.mayaqq.skyblock.client.chat

import dev.mayaqq.skyblock.client.config.categories.ChatConfig
import java.util.function.Supplier

enum class Messages(
    // language=RegExp
    regex0: String,
    val option: Supplier<HidingOption>
) {
    // Lobby
    LOBBY_JOIN("""(?:>>> )?[\s\S]*joined the lobby!(?: <<<)?""", { ChatConfig.lobbyJoinMessage }),

    // Ability
    PREVIOUS_ABILITY_REMOVED("""Your previous [\s\S]* was removed!""", { ChatConfig.previousAbilityRemoved }),

    // System
    GEXP_GAIN("""You earned \d+ GEXP from playing [\s\S]*!""", { ChatConfig.gexpGain }),
    PROFILE_ID("""Profile ID: [\s\S]*""", { ChatConfig.profileId }),
    PLAYING_ON_PROFILE("""You are playing on profile: [\s\S]*""", { ChatConfig.playingOnProfile }),
    WATCHDOG_REPORT(
        """[\s\S]*(\\\[WATCHDOG ANNOUNCEMENT]|Watchdog has banned|Staff have banned an additional|Blacklisted modifications are a bannable offense!)[\s\S]*""",
        { ChatConfig.watchdogReport }
    ),

    // Skyblock
    SKYBLOCK_WELCOME("""Welcome to Hypixel SkyBlock!""", { ChatConfig.welcomeToSkyblock }),
    FIRE_SALE("""A FIRE SALE [\s\S]*""", { ChatConfig.fireSale }),
    ALLOWANCE("""ALLOWANCE! You earned [\s\S]* coins!""", { ChatConfig.allowance }),
    NPC("""\\\[NPC] [\s\S]*""", { ChatConfig.npc }),
    NPC_BUY("""You bought [\s\S]* x\d+ for [\d.]+[\dA-Za-z]* Coins!""", { ChatConfig.npcBuy }),
    BUY_LIMIT("""You may only buy up to [\s\S]* of this item each day!""", { ChatConfig.buyLimit }),

    // Travel
    WARPING("""Warping...""", { ChatConfig.warping }),
    SENDING_TO_SERVER("""Sending to server [\s\S]*""", { ChatConfig.sendingToServer }),
    UNKNOWN_DESTINATION(
        """Unknown destination! Check the Fast Travel menu to view options!""",
        { ChatConfig.unknownDestination }),

    // Dungeon Hub
    DUNGEON_REWARD("""RARE REWARD! .+ found a .+ in their .+!""", { ChatConfig.dungeonReward }),

    // Dungeon
    CANNOT_USE_OUTSIDE_DUNGEON("""You can only use this item in dungeons!""", { ChatConfig.cannotUseOutsideDungeon }),
    QUEUING("""Queuing... \\(Attempt [\s\S]{3}\\)""", { ChatConfig.queuing }),
    STARTING("""Starting in \d second(s)?.""", { ChatConfig.starting }),
    STATS_DOUBLED(
        """Your [\s\S]* stats are doubled because you are the only player using this class!""",
        { ChatConfig.statsDoubled }),
    CLASS_MESSAGE("""\[(Mage|Healer|Berserk|Archer|Tank)] [\s\S]*""", { ChatConfig.classMessage }),
    DUNGEON_REQUESTED_ALREADY(
        """You have already requested a server! Please wait a bit.""",
        { ChatConfig.requestedDungeonAlready }),
    SELECTED_CLASS_MESSAGE("""You have selected the [\s\S]* Dungeon Class!""", { ChatConfig.selectedClassMessage }),

    // Mining
    WIND_CHANGED_DIRECTION("""The wind has changed direction!""", { ChatConfig.windChangedDirection }),
    EVENT_STARTING("""[\s\S]{3}The [\s\S]* event starts in 20 seconds![\s\S]*""", { ChatConfig.eventStarting }),
    FALLEN_STAR("""✯ A Fallen Star has crashed at Cliffside Veins![\s\S]*""", { ChatConfig.FallenStar }),

    // Item
    CANNOT_USE_ITEM("""Cannot use this item here!""", { ChatConfig.cannotUseItem }),
    ABILITY_COOLDOWN("""Ability is on cooldown for [\s\S]*""", { ChatConfig.abilityCooldown }),
    ZOMBIE_SWORD_NO_MORE_CHARGES("""No more charges, next one in [\s\S]*""", { ChatConfig.zombieSwordNoMoreCharges }),

    // Miscellaneous
    RINGING("""✆ RING...[\s\S]*""", { ChatConfig.ringing }),
    ALREADY_FOUND_FAIRY_SOUL("""You have already found that Fairy Soul!""", { ChatConfig.alreadyFoundFairySoul }),

    // Ironman
    AUCTION_DISALLOWED(
        """You can't use the Auction House while playing on your current profile type!""",
        { ChatConfig.auctionDisallowed }),

    // Century Cake
    WRONG_TEAM(
        """This person is not on the right team! Feed this cake to someone on the .* Team!""",
        { ChatConfig.wrongTeam }),
    TOO_MUCH_CAKE(
        """This person has had too much cake today!""",
        { ChatConfig.tooMuchCake }),
    NOT_A_PLAYER(
        """Click a player on a matching team to feed them this cake! This isn't a player!""",
        { ChatConfig.notAPlayer }),
    NOT_YOUR_CAKE(
        """This Century Cake Slice is for .*, sorry!""",
        { ChatConfig.notYourCake }),
    ;

    val regex = Regex(regex0)
}