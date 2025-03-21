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
import software.bernie.geckolib.constant.DefaultAnimations;

import java.util.Set;

public class CroissantPlayerModel extends PlayerModel {
    public CroissantPlayerModel() {
        super(Identifier.of(ModelShifterClient.MOD_ID, "croissant_player"), Set.of(Creators.BUG),
                new ModelDimensions(0.6f, 1.5f, -0.5f, true));
    }

    @Override
    protected @NotNull FeatureRendererStates createFeatureRendererStates() {
        return new FeatureRendererStates()
                .add(FeatureRendererType.HELD_ITEM_RIGHT)
                .add(FeatureRendererType.ELYTRA, CroissantPlayerModel::modifyCloakRendering)
                .add(FeatureRendererType.CAPE, CroissantPlayerModel::modifyCloakRendering)
                .add(FeatureRendererType.TRIDENT_RIPTIDE);
    }

    @Override
    protected @NotNull GuiRenderInfo createGuiRenderInfo() {
        return new GuiRenderInfo()
                .setButtonAnimation(DefaultAnimations.IDLE)
                .setButtonRenderTweakFunction(CroissantPlayerModel::modifyGuiRendering)
                .setShowcaseRenderTweakFunction(CroissantPlayerModel::modifyGuiRendering);
    }

    private static void modifyGuiRendering(MatrixStack matrixStack) {
        matrixStack.translate(0f,0.2f,0f);
    }

    private static void modifyCloakRendering(EntityRenderStateWrapper state, MatrixStack poseStack) {
        poseStack.scale(0.5f,0.5f,0.5f);
    }
}