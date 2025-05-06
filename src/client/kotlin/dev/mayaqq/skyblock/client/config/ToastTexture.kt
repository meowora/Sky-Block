package dev.mayaqq.skyblock.client.config

import earth.terrarium.olympus.client.ui.UIConstants
import net.minecraft.resources.ResourceLocation

enum class ToastTexture(val texture: ResourceLocation) {
    NORMAL(UIConstants.BUTTON.enabled),
    DARK(UIConstants.DARK_BUTTON.enabled),
    GREEN(UIConstants.PRIMARY_BUTTON.enabled),
    RED(UIConstants.DANGER_BUTTON.enabled),

    VANILLA(ResourceLocation.withDefaultNamespace("toast/advancement")),
    SKYCUBED(ResourceLocation.fromNamespaceAndPath("skycubed", "textures/gui/sprites/background")),
}
