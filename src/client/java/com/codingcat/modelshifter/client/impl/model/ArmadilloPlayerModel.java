package com.codingcat.modelshifter.client.impl.model;

import com.codingcat.modelshifter.client.ModelShifterClient;
import com.codingcat.modelshifter.client.api.entity.EntityRenderStateWrapper;
import com.codingcat.modelshifter.client.api.model.ModelDimensions;
import com.codingcat.modelshifter.client.api.model.PlayerModel;
import com.codingcat.modelshifter.client.api.renderer.GuiRenderInfo;
import com.codingcat.modelshifter.client.api.renderer.feature.FeatureRendererStates;
import com.codingcat.modelshifter.client.api.renderer.feature.FeatureRendererType;
import com.codingcat.modelshifter.client.impl.Creators;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;

import java.util.Set;

public class ArmadilloPlayerModel extends PlayerModel {
    public ArmadilloPlayerModel() {
        super(Identifier.of(ModelShifterClient.MOD_ID, "armadillo_player"), Set.of(Creators.BUG),
                new ModelDimensions(0.8f, 0.8f, -1.2f, false));
    }

    @Override
    protected @NotNull FeatureRendererStates createFeatureRendererStates() {
        return new FeatureRendererStates()
                .setSillyHatRenderModifier(ArmadilloPlayerModel::modifySillyHatRendering)
                .add(FeatureRendererType.HELD_ITEM_LEFT)
                .add(FeatureRendererType.HELD_ITEM_RIGHT)
                .add(FeatureRendererType.ELYTRA, ArmadilloPlayerModel::modifyCloakRendering)
                .add(FeatureRendererType.CAPE, ArmadilloPlayerModel::modifyCloakRendering)
                .add(FeatureRendererType.TRIDENT_RIPTIDE);
    }

    @Override
    protected @NotNull GuiRenderInfo createGuiRenderInfo() {
        return new GuiRenderInfo()
                .setButtonRenderTweakFunction(ArmadilloPlayerModel::modifyGuiButtonRendering);
    }

    private static void modifyGuiButtonRendering(MatrixStack matrixStack) {
        matrixStack.scale(1.3f, 1.3f, 1.3f);
    }

    private static void modifyCloakRendering(EntityRenderStateWrapper stateWrapper, MatrixStack poseStack) {
        poseStack.scale(0.8f, 0.8f, 0.8f);
    }

    private static void modifySillyHatRendering(MatrixStack poseStack) {
        poseStack.scale(0.32f, 0.32f, 0.32f);
    }
}
