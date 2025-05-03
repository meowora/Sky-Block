package dev.mayaqq.skyblock.client.chat

import com.squareup.kotlinpoet.AnnotationSpec
import com.squareup.kotlinpoet.FileSpec
import com.squareup.kotlinpoet.PropertySpec
import com.squareup.kotlinpoet.TypeSpec
import com.teamresourceful.resourcefulconfig.api.annotations.Category
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import dev.mayaqq.skyblock.client.config.categories.ChatConfig
import java.io.File
import kotlin.io.path.toPath

enum class Messages(
    // language=RegExp
    regex0: String
) {
    // Lobby
    LOBBY_JOIN("""(?:>>> )?[\s\S]*joined the lobby!(?: <<<)?"""),

    // Ability
    PREVIOUS_ABILITY_REMOVED("""Your previous [\s\S]* was removed!"""),

    // System
    GEXP_GAIN("""You earned \d+ GEXP from playing [\s\S]*!"""),
    PROFILE_ID("""Profile ID: [\s\S]*"""),
    PLAYING_ON_PROFILE("""You are playing on profile: [\s\S]*"""),
    WATCHDOG_REPORT(
        """[\s\S]*(\\\[WATCHDOG ANNOUNCEMENT]|Watchdog has banned|Staff have banned an additional|Blacklisted modifications are a bannable offense!)[\s\S]*"""
    ),

    // Skyblock
    SKYBLOCK_WELCOME("""Welcome to Hypixel SkyBlock!"""),
    FIRE_SALE("""A FIRE SALE [\s\S]*"""),
    ALLOWANCE("""ALLOWANCE! You earned [\s\S]* coins!"""),
    NPC("""\\\[NPC] [\s\S]*"""),
    NPC_BUY("""You bought [\s\S]* x\d+ for [\d.]+[\dA-Za-z]* Coins!"""),
    BUY_LIMIT("""You may only buy up to [\s\S]* of this item each day!"""),

    // Travel
    WARPING("""Warping..."""),
    SENDING_TO_SERVER("""Sending to server [\s\S]*"""),
    UNKNOWN_DESTINATION(
        """Unknown destination! Check the Fast Travel menu to view options!""",),

    // Dungeon Hub
    DUNGEON_REWARD("""RARE REWARD! .+ found a .+ in their .+!"""),

    // Dungeon
    CANNOT_USE_OUTSIDE_DUNGEON("""You can only use this item in dungeons!"""),
    QUEUING("""Queuing... \\(Attempt [\s\S]{3}\\)"""),
    STARTING("""Starting in \d second(s)?."""),
    STATS_DOUBLED(
        """Your [\s\S]* stats are doubled because you are the only player using this class!""",),
    CLASS_MESSAGE("""\[(Mage|Healer|Berserk|Archer|Tank)] [\s\S]*"""),
    DUNGEON_REQUESTED_ALREADY(
        """You have already requested a server! Please wait a bit.""",),
    SELECTED_CLASS_MESSAGE("""You have selected the [\s\S]* Dungeon Class!"""),

    // Mining
    WIND_CHANGED_DIRECTION("""The wind has changed direction!"""),
    EVENT_STARTING("""[\s\S]{3}The [\s\S]* event starts in 20 seconds![\s\S]*"""),
    FALLEN_STAR("""✯ A Fallen Star has crashed at Cliffside Veins![\s\S]*"""),

    // Item
    CANNOT_USE_ITEM("""Cannot use this item here!"""),
    ABILITY_COOLDOWN("""Ability is on cooldown for [\s\S]*"""),
    ZOMBIE_SWORD_NO_MORE_CHARGES("""No more charges, next one in [\s\S]*"""),

    // Miscellaneous
    RINGING("""✆ RING...(?![\s\S]*\[PICK UP])[\s\S]*"""),
    ALREADY_FOUND_FAIRY_SOUL("""You have already found that Fairy Soul!"""),

    // Ironman
    AUCTION_DISALLOWED(
        """You can't use the Auction House while playing on your current profile type!""",),

    // Century Cake
    WRONG_TEAM(
        """This person is not on the right team! Feed this cake to someone on the .* Team!""",),
    TOO_MUCH_CAKE(
        """This person has had too much cake today!""",),
    NOT_A_PLAYER(
        """Click a player on a matching team to feed them this cake! This isn't a player!""",),
    NOT_YOUR_CAKE(
        """This Century Cake Slice is for .*, sorry!""",),
    ;

    val regex = Regex(regex0)

    fun option(): HidingOption {
        return this.name.let { ChatConfig::class.java.getField(it).get(ChatConfig) as HidingOption }
    }

    companion object {
        fun generate() {
            val values = entries.toTypedArray()

            val file = FileSpec.builder("dev.mayaqq.client.config", "ChatConfig")
                .indent("    ")
                .addType(
                    TypeSpec.objectBuilder("ChatConfig").apply {
                        this.addAnnotation(AnnotationSpec.builder(ConfigInfo::class).addMember("titleTranslation = \"config.skyblock.chat.title\"").build())
                        this.addAnnotation(AnnotationSpec.builder(Category::class).addMember("chat").build())
                        for (value in entries) {
                            addProperty(
                            PropertySpec.builder(value.name, HidingOption::class)
                                .initializer("${HidingOption::class.simpleName}.${HidingOption.DISABLED.name}")
                                .addAnnotation(AnnotationSpec.builder(ConfigEntry::class).addMember("id = \"${value.name}\", translation = \"config.skyblock.chat.${value.name}\"").build())
                                .build()
                        )
                        }
                    }.build()
                )

            // write into the actual location
            file.build().writeTo(File("src/client/kotlin/dev/mayaqq/skyblock/client/config/ChatConfig.kt"))

        }
    }
}