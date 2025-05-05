package dev.mayaqq.skyblock.client.chat

import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import tech.thatgravyboat.skyblockapi.utils.text.Text

data class ToastData(val duration: Float, val title: String, val body: String, val icon: ItemStack) {
    fun buildTitle(regexResult: MatchResult): Component {
        // format groupValues into the title string
        return Text.of(title.replace(Regex("\\{(\\d+)}")) { matchResult ->
            val groupIndex = matchResult.groupValues[1].toInt()
            regexResult.groupValues.getOrNull(groupIndex) ?: ""
        })
    }

    fun buildBody(regexResult: MatchResult): Component {
        return Text.of(body.replace(Regex("\\{(\\d+)}")) { matchResult ->
            val groupIndex = matchResult.groupValues[1].toInt()
            regexResult.groupValues.getOrNull(groupIndex) ?: ""
        })
    }
}
