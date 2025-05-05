package dev.mayaqq.skyblock.client.chat

import earth.terrarium.olympus.client.ui.UIConstants
import net.minecraft.client.gui.Font
import net.minecraft.client.gui.GuiGraphics
import net.minecraft.client.gui.components.toasts.Toast
import net.minecraft.client.gui.components.toasts.ToastManager
import net.minecraft.client.renderer.RenderType
import net.minecraft.network.chat.Component
import net.minecraft.world.item.ItemStack

class SkyBlockToast(val icon: ItemStack?, val title: Component, val text: Component, val visibilityTime: Float = 5000.0F, var visibility: Toast.Visibility? = Toast.Visibility.HIDE) : Toast {
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
        var x = 30
        if (icon != null) {
            guiGraphics.renderFakeItem(icon, 8, 8)
            x = 8
        }
        guiGraphics.drawString(font, title, x, 7, -1, true)
        guiGraphics.drawString(font, text, x, 18, -1, true)
    }
}
