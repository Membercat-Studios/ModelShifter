package com.codingcat.modelshifter.client.impl.model;

import com.codingcat.modelshifter.client.ModelShifterClient;
import com.codingcat.modelshifter.client.api.entity.EntityRenderStateWrapper;
import com.codingcat.modelshifter.client.api.model.ModelDimensions;
import com.codingcat.modelshifter.client.api.model.PlayerModel;
import com.codingcat.modelshifter.client.api.renderer.feature.FeatureRendererStates;
import com.codingcat.modelshifter.client.api.renderer.GuiRenderInfo;
import com.codingcat.modelshifter.client.api.renderer.feature.FeatureRendererType;
import com.codingcat.modelshifter.client.impl.Creators;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import software.bernie.geckolib.constant.DefaultAnimations;

import java.util.Set;

public class SquarePlayerModel extends PlayerModel {
    public SquarePlayerModel() {
        super(Identifier.of(ModelShifterClient.MOD_ID, "square_player"), Set.of(Creators.BUG),
                new ModelDimensions(1f, 1f, -0.8f));
    }

    @Override
    protected @NotNull FeatureRendererStates createFeatureRendererStates() {
        return new FeatureRendererStates()
                .add(FeatureRendererType.HELD_ITEM, SquarePlayerModel::modifyHeldItemRendering)
                .add(FeatureRendererType.ELYTRA, SquarePlayerModel::modifyElytraRendering)
                .add(FeatureRendererType.TRIDENT_RIPTIDE);
    }

    @Override
    protected @NotNull GuiRenderInfo createGuiRenderInfo() {
        return new GuiRenderInfo()
                .setButtonAnimation(DefaultAnimations.WALK)
                .setInventoryRenderTweakFunction(SquarePlayerModel::modifyGuiInventoryRendering);
    }

    private static void modifyGuiInventoryRendering(MatrixStack matrixStack) {
        matrixStack.translate(0f,0.2f,0f);
    }

    private static void modifyHeldItemRendering(EntityRenderStateWrapper state, MatrixStack matrixStack) {
        matrixStack.translate(0.5f, 0.35f, -0.5f);
        if (state.isInSneakingPose()) {
            matrixStack.scale(1f, 1f, 0.55f);
            matrixStack.translate(0f,0f,-0.8f);
        }
    }

    private static void modifyElytraRendering(EntityRenderStateWrapper state, MatrixStack matrixStack) {
        matrixStack.scale(1.1f, 0.65f, 0.9f);
        matrixStack.translate(0f, 1f, 0.35f);
        if (state.isInSneakingPose())
            matrixStack.translate(0f,0.2f,0f);
    }
}
