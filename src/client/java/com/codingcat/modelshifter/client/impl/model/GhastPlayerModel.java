package com.codingcat.modelshifter.client.impl.model;

import com.codingcat.modelshifter.client.ModelShifterClient;
import com.codingcat.modelshifter.client.api.model.PlayerModel;
import com.codingcat.modelshifter.client.api.renderer.DisabledFeatureRenderers;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.LivingEntity;
import net.minecraft.util.Identifier;

import java.util.Set;

public class GhastPlayerModel extends PlayerModel {
    public GhastPlayerModel() {
        super(Identifier.of(ModelShifterClient.MOD_ID, "ghast_player"), Set.of("bug_finder"), new DisabledFeatureRenderers(
                true,
                true,
                true,
                true,
                true,
                true,
                true,
                true
        ));
    }

    @Override
    public void modifyHeldItemRendering(LivingEntity entity, MatrixStack matrixStack) {}

    @Override
    public void modifyElytraRendering(LivingEntity entity, MatrixStack matrixStack) {}
}
