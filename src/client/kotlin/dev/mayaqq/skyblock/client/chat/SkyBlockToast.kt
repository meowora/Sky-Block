package dev.mayaqq.skyblock.client.chat

import earth.terrarium.olympus.client.ui.UIConstants
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.toasts.Toast
import net.minecraft.client.gui.components.toasts.ToastManager
import net.minecraft.client.renderer.RenderType
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack

class SkyBlockToast(val icon: ItemStack, val title: Component, val text: Component, val visibilityTime: Float = 5000.0F, var visibility: Toast.Visibility? = Toast.Visibility.HIDE) : Toast {
    override fun getWantedVisibility(): Toast.Visibility? = this.visibility


    override fun update(
        toastManager: ToastManager,
        visibilityTime: Long
    ) {
        visibility = if (visibilityTime.toDouble() >= this.visibilityTime * toastManager.notificationDisplayTimeMultiplier) Toast.Visibility.HIDE else Toast.Visibility.SHOW
    }

    override fun render(
        guiGraphics: GuiGraphics,
        font: Font,
        visibilityTime: Long
    ) {
        guiGraphics.blitSprite(RenderType::guiTextured, UIConstants.BUTTON.enabled, 0, 0, this.width(), this.height())
        guiGraphics.drawString(font, title, 30, 7, -1, false)
        guiGraphics.drawString(font, text, 30, 18, -1, false)

        guiGraphics.renderFakeItem(icon, 8, 8)
    }
}
