package com.codingcat.modelshifter.client.api.renderer;

public record FeatureRendererStates(
        boolean disableArmor,
        boolean disableElytra,
        boolean disableHeldItem,
        boolean disableStuckArrows,
        boolean disableDeadmau5Ears,
        boolean disableCape,
        boolean disableTridentRiptide,
        boolean disableStuckStingers
) {
}