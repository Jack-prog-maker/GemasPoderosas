package com.blackhole.game;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;



public class AssetDescriptors {

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.FONT, BitmapFont.class);

    public static final AssetDescriptor<Skin> SKIN =
            new AssetDescriptor<Skin>(AssetPaths.SKIN, Skin.class);

    public static final AssetDescriptor<Sound> COIN =
            new AssetDescriptor<Sound>(AssetPaths.COIN_SOUND, Sound.class);

    public static final AssetDescriptor<Sound> LOSE =
            new AssetDescriptor<Sound>(AssetPaths.LOSE_SOUND, Sound.class);

    private AssetDescriptors() {
    }
}
