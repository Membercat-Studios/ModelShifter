package com.codingcat.modelshifter.client.impl;

import com.codingcat.modelshifter.client.ModelShifterClient;
import com.codingcat.modelshifter.client.api.model.PlayerModel;
import com.codingcat.modelshifter.client.api.registry.ModelRegistry;
import com.codingcat.modelshifter.client.impl.model.AmongUsPlayerModel;
import com.codingcat.modelshifter.client.impl.model.CatPlayerModel;
import com.codingcat.modelshifter.client.impl.model.ChestPlayerModel;
import com.codingcat.modelshifter.client.impl.model.WitherPlayerModel;
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class Models {

    public static void registerAll() {
        register("cat", new CatPlayerModel());
        register("among_us", new AmongUsPlayerModel());
        register("wither", new WitherPlayerModel());
        register("chest", new ChestPlayerModel());
    }

    private static void register(String id, PlayerModel playerModel) {
        ModelRegistry.register(new Identifier(ModelShifterClient.MOD_ID, id), playerModel);
    }

    @Nullable
    public static String getTranslationKey(PlayerModel model) {
        Optional<Identifier> id = ModelRegistry.findId(model);
        return id.map(Models::getTranslationKey).orElse(null);
    }

    @NotNull
    public static String getTranslationKey(Identifier id) {
        return String.format("modelshifter.model.%s", id.getPath());
    }
}