package dev.mayaqq.skyblock.client.chat

import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack
import tech.thatgravyboat.skyblockapi.utils.regex.component.ComponentMatchResult
import tech.thatgravyboat.skyblockapi.utils.text.CommonText
import tech.thatgravyboat.skyblockapi.utils.text.Text

data class ToastData(val duration: Float, val title: String, val body: String, val icon: ItemStack) {
    fun buildTitle(regexResult: ComponentMatchResult): Component {
        val pattern = Regex("\\{(\\d+)}")
        var lastEnd = 0
        var result = Component.empty()

        pattern.findAll(title).forEach { matchResult ->
            val beforeText = title.substring(lastEnd, matchResult.range.first)
            if (beforeText.isNotEmpty()) {
                result = result.append(Text.of(beforeText))
            }

            val groupIndex = matchResult.groupValues[1].toInt()
            val groupValue = regexResult[groupIndex] ?: CommonText.EMPTY
            result = result.append(regexResult[groupIndex] ?: groupValue)

            lastEnd = matchResult.range.last + 1
        }

        // Add remaining text after last placeholder
        val remainingText = title.substring(lastEnd)
        if (remainingText.isNotEmpty()) {
            result = result.append(Text.of(remainingText))
        }

        return result
    }

    fun buildBody(regexResult: ComponentMatchResult): Component {
        val pattern = Regex("\\{(\\d+)}")
        var lastEnd = 0
        var result = Component.empty()

        pattern.findAll(body).forEach { matchResult ->
            val beforeText = body.substring(lastEnd, matchResult.range.first)
            if (beforeText.isNotEmpty()) {
                result = result.append(Text.of(beforeText))
            }

            val groupIndex = matchResult.groupValues[1].toInt()
            val groupValue = regexResult[groupIndex] ?: CommonText.EMPTY
            result = result.append(regexResult[groupIndex] ?: groupValue)

            lastEnd = matchResult.range.last + 1
        }

        // Add remaining text after last placeholder
        val remainingText = body.substring(lastEnd)
        if (remainingText.isNotEmpty()) {
            result = result.append(Text.of(remainingText))
        }

        return result
    }
}
