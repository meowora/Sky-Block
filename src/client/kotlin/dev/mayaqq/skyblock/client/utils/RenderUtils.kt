package dev.mayaqq.skyblock.client.utils

import com.mojang.blaze3d.vertex.PoseStack
import net.minecraft.client.gui.GuiGraphics

inline fun GuiGraphics.pushPop(action: PoseStack.() -> Unit) {
    this.pose().pushPop(action)
}

inline fun PoseStack.pushPop(action: PoseStack.() -> Unit) {
    this.pushPose()
    this.action()
    this.popPose()
}