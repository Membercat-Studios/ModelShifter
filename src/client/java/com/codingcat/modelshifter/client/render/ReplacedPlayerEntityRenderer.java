package com.codingcat.modelshifter.client.render;

import com.codingcat.modelshifter.client.ModelShifterClient;
import com.codingcat.modelshifter.client.api.model.PlayerModel;
import com.codingcat.modelshifter.client.render.entity.ReplacedPlayerEntity;
import net.minecraft.client.network.AbstractClientPlayerEntity;
import net.minecraft.client.render.RenderLayer;
import net.minecraft.client.render.VertexConsumerProvider;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.text.Text;
import net.minecraft.util.Identifier;
//? >=1.21.3 {
import net.minecraft.client.render.entity.state.EntityRenderState;
import net.minecraft.client.render.entity.state.PlayerEntityRenderState;
import org.jetbrains.annotations.Nullable;
//?}
import software.bernie.geckolib.model.DefaultedEntityGeoModel;
import software.bernie.geckolib.renderer.GeoReplacedEntityRenderer;

public class ReplacedPlayerEntityRenderer extends GeoReplacedEntityRenderer<AbstractClientPlayerEntity, ReplacedPlayerEntity> {
    private final Identifier modelIdentifier;

    public ReplacedPlayerEntityRenderer(EntityRendererFactory.Context renderManager, PlayerModel model) {
        super(renderManager,
                new DefaultedEntityGeoModel<ReplacedPlayerEntity>(model.getModelDataIdentifier()).withAltTexture(ModelShifterClient.EMPTY_TEXTURE),
                new ReplacedPlayerEntity(model::getCurrentAnimation, true, false));
        this.modelIdentifier = model.getModelDataIdentifier();
    }

    public Identifier getModelIdentifier() {
        return this.modelIdentifier;
    }

    //? >=1.21.3 {
    @SuppressWarnings("ParameterCanBeLocal")
    //?}
    public void render(AbstractClientPlayerEntity clientPlayer, Identifier skin, float partialTick, MatrixStack matrixStack, VertexConsumerProvider vertexConsumerProvider, int i) {
        //? >=1.21.3 {
        partialTick = this.partialTick;
        //?}
        this.currentEntity = clientPlayer;
        RenderLayer type = getRenderType(animatable, skin, vertexConsumerProvider, partialTick);
        defaultRender(matrixStack, animatable, vertexConsumerProvider, type, null,
                //? <1.21.3 {
                /*0,
                *///?}
                partialTick, i);
        this.currentEntity = null;
    }

    //? >=1.21.3 {
    @Override
    protected void renderLabelIfPresent(EntityRenderState state, Text text, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
    }

    @SuppressWarnings("UnstableApiUsage")
    @Override
    public @Nullable EntityRenderState createRenderState() {
        return new PlayerEntityRenderState();
    }

    //?} else if >1.20.4 {
    /*@Override
    protected void renderLabelIfPresent(AbstractClientPlayerEntity entity, Text text, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light, float tickDelta) {
    }

    *///?} else {
    /*@Override
    protected void renderLabelIfPresent(AbstractClientPlayerEntity entity, Text text, MatrixStack matrices, VertexConsumerProvider vertexConsumers, int light) {
    }
    *///?}
}