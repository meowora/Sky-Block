package dev.mayaqq.skyblock.client.config

import com.teamresourceful.resourcefulconfig.api.annotations.Comment
import com.teamresourceful.resourcefulconfig.api.annotations.Config
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigEntry
import com.teamresourceful.resourcefulconfig.api.annotations.ConfigInfo
import com.teamresourceful.resourcefulconfig.api.types.entries.Observable
import dev.mayaqq.skyblock.client.config.categories.ChatConfig

@Config(
    "sky-block",
    categories = [
        ChatConfig::class
    ]
)
@ConfigInfo.Provider(ConfigInfoProvider::class)
object Config {
    @ConfigEntry(id = "enabled", translation = "config.skyblock.enabled")
    var enabled = true

    @ConfigEntry(id = "extra", translation = "config.skyblock.extra")
    @Comment("", translation = "config.skyblock.extra.desc")
    val extra: Observable<Array<String>> = Observable.of(
        arrayOf()
    )

    @ConfigEntry(id = "extraUi", translation = "config.skyblock.extraUi")
    @Comment("", translation = "config.skyblock.extraUi.desc")
    val extraUi: Observable<Array<String>> = Observable.of(
        arrayOf()
    )
}