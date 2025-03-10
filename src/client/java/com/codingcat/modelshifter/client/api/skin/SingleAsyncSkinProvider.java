package com.codingcat.modelshifter.client.api.skin;

import com.mojang.authlib.GameProfile;
//? >=1.21.3 {
import net.minecraft.client.util.SkinTextures;
//?}
import net.minecraft.util.Identifier;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public interface SingleAsyncSkinProvider {
    default void setProfileAndFetch(GameProfile profile) {
        this.setProfile(profile);
        this.fetchSkin();
    }

    void setProfile(GameProfile profile);

    void fetchSkin();

    //? >=1.21.3 {
    SkinTextures getSkinTextures();
    //?}

    @NotNull
    default Identifier getSkin() {
        return this.getSkinOrNull() != null ? this.getSkinOrNull() : this.getDefaultSkin(null);
    }

    @Nullable
    Identifier getSkinOrNull();

    default boolean hasSkin() {
        return getSkinOrNull() != null;
    }

    @NotNull
    Identifier getDefaultSkin(@Nullable GameProfile profile);
}
