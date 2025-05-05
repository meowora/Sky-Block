package dev.mayaqq.skyblock.client.chat

import com.teamresourceful.resourcefulconfig.api.types.ResourcefulConfigElement
import com.teamresourceful.resourcefulconfig.api.types.elements.ResourcefulConfigEntryElement
import dev.mayaqq.skyblock.client.utils.DynamicEntryData
import dev.mayaqq.skyblock.client.utils.DynamicSeparator
import dev.mayaqq.skyblock.client.utils.ResourcefulConfigEnumValueEntry

enum class MessageCategory {
    LOBBY,
    ABILITY,
    SYSTEM,
    SKYBLOCK,
    TRAVEL,
    DUNGEON_HUB,
    DUNGEON,
    MINING,
    ITEM,
    MISC,
    IRONMAN,
    CENTURY_CAKE,
}

enum class SpamMessage(
    // language=RegExp
    regex: String,
    val category: MessageCategory,
) : ResourcefulConfigEnumValueEntry, ResourcefulConfigEntryElement {
    // Lobby
    LOBBY_JOIN(
        """(?:>>> )?[\s\S]*joined the lobby!(?: <<<)?""",
        MessageCategory.LOBBY,
    ),

    // Ability
    PREVIOUS_ABILITY_REMOVED(
        """Your previous [\s\S]* was removed!""",
        MessageCategory.ABILITY,
    ),

    // System
    GEXP_GAIN(
        """You earned \d+ GEXP from playing [\s\S]*!""",
        MessageCategory.SYSTEM,
    ),
    PROFILE_ID(
        """Profile ID: [\s\S]*""",
        MessageCategory.SYSTEM,
    ),
    PLAYING_ON_PROFILE(
        """You are playing on profile: [\s\S]*""",
        MessageCategory.SYSTEM,
    ),
    WATCHDOG_REPORT(
        """[\s\S]*(\\\[WATCHDOG ANNOUNCEMENT]|Watchdog has banned|Staff have banned an additional|Blacklisted modifications are a bannable offense!)[\s\S]*""",
        MessageCategory.SYSTEM,
    ),

    // Skyblock
    SKYBLOCK_WELCOME(
        """Welcome to Hypixel SkyBlock!""",
        MessageCategory.SKYBLOCK,
    ),
    FIRE_SALE(
        """A FIRE SALE [\s\S]*""",
        MessageCategory.SKYBLOCK,
    ),
    ALLOWANCE(
        """ALLOWANCE! You earned [\s\S]* coins!""",
        MessageCategory.SKYBLOCK,
    ),
    NPC(
        """\\\[NPC] [\s\S]*""",
        MessageCategory.SKYBLOCK,
    ),
    NPC_BUY(
        """You bought [\s\S]* x\d+ for [\d.]+[\dA-Za-z]* Coins!""",
        MessageCategory.SKYBLOCK,
    ),
    BUY_LIMIT(
        """You may only buy up to [\s\S]* of this item each day!""",
        MessageCategory.SKYBLOCK,
    ),

    // Travel
    WARPING(
        """Warping...""",
        MessageCategory.TRAVEL,
    ),
    SENDING_TO_SERVER(
        """Sending to server [\s\S]*""",
        MessageCategory.TRAVEL,
    ),
    UNKNOWN_DESTINATION(
        """Unknown destination! Check the Fast Travel menu to view options!""",
        MessageCategory.TRAVEL,
    ),

    // Dungeon Hub
    DUNGEON_REWARD(
        """RARE REWARD! .+ found a .+ in their .+!""",
        MessageCategory.DUNGEON_HUB,
    ),

    // Dungeon
    CANNOT_USE_OUTSIDE_DUNGEON(
        """You can only use this item in dungeons!""",
        MessageCategory.DUNGEON,
    ),
    QUEUING(
        """Queuing... \\(Attempt [\s\S]{3}\\)""",
        MessageCategory.DUNGEON,
    ),
    STARTING(
        """Starting in \d second(s)?.""",
        MessageCategory.DUNGEON,
    ),
    STATS_DOUBLED(
        """Your [\s\S]* stats are doubled because you are the only player using this class!""",
        MessageCategory.DUNGEON,
    ),
    CLASS_MESSAGE(
        """\[(Mage|Healer|Berserk|Archer|Tank)] [\s\S]*""",
        MessageCategory.DUNGEON,
    ),
    DUNGEON_REQUESTED_ALREADY(
        """You have already requested a server! Please wait a bit.""",
        MessageCategory.DUNGEON,
    ),
    SELECTED_CLASS_MESSAGE(
        """You have selected the [\s\S]* Dungeon Class!""",
        MessageCategory.DUNGEON,
    ),

    // Mining
    WIND_CHANGED_DIRECTION(
        """The wind has changed direction!""",
        MessageCategory.MINING,
    ),
    EVENT_STARTING(
        """[\s\S]{3}The [\s\S]* event starts in 20 seconds![\s\S]*""",
        MessageCategory.MINING,
    ),
    FALLEN_STAR(
        """✯ A Fallen Star has crashed at Cliffside Veins![\s\S]*""",
        MessageCategory.MINING,
    ),

    // Item
    CANNOT_USE_ITEM(
        """Cannot use this item here!""",
        MessageCategory.ITEM,
    ),
    ABILITY_COOLDOWN(
        """Ability is on cooldown for [\s\S]*""",
        MessageCategory.ITEM,
    ),
    ZOMBIE_SWORD_NO_MORE_CHARGES(
        """No more charges, next one in [\s\S]*""",
        MessageCategory.ITEM,
    ),

    // Miscellaneous
    RINGING(
        """✆ RING...(?![\s\S]*\[PICK UP])[\s\S]*""",
        MessageCategory.MISC,
    ),
    ALREADY_FOUND_FAIRY_SOUL(
        """You have already found that Fairy Soul!""",
        MessageCategory.MISC,
    ),

    // Ironman
    AUCTION_DISALLOWED(
        """You can't use the Auction House while playing on your current profile type!""",
        MessageCategory.IRONMAN,
    ),

    // Century Cake
    WRONG_TEAM(
        """This person is not on the right team! Feed this cake to someone on the .* Team!""",
        MessageCategory.CENTURY_CAKE,
    ),
    TOO_MUCH_CAKE(
        """This person has had too much cake today!""",
        MessageCategory.CENTURY_CAKE,
    ),
    NOT_A_PLAYER(
        """Click a player on a matching team to feed them this cake! This isn't a player!""",
        MessageCategory.CENTURY_CAKE,
    ),
    NOT_YOUR_CAKE(
        """This Century Cake Slice is for .*, sorry!""",
        MessageCategory.CENTURY_CAKE,
    ),
    ;

    var option: HidingOption = HidingOption.DISABLED

    override fun defaultValue() = HidingOption.DISABLED
    override fun objectType() = HidingOption::class.java
    override fun get() = option

    override fun setEnum(value: Enum<*>?) = runCatching {
        option = value as HidingOption
    }.isSuccess

    val entryData = DynamicEntryData("config.skyblock.chat.${category.name.lowercase()}.${name.lowercase()}", "")
    override fun options() = entryData

    override fun reset() {
        option = HidingOption.DISABLED
    }

    override fun id() = name
    override fun entry() = this

    val regex: Regex = Regex(regex)

    fun option() = option

    companion object {
        fun entriesWithSeparators(): List<ResourcefulConfigElement> {
            return entries.groupBy { it.category }.flatMap { (category, entries) ->
                buildList {
                    add(DynamicSeparator(category.name, ""))
                    addAll(entries)
                }
            }
        }
    }
}
