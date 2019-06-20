package com.blackhole.game.Assets;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.ParticleEffect;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;



public class AssetDescriptors {

    public static final AssetDescriptor<BitmapFont> FONT =
            new AssetDescriptor<BitmapFont>(AssetPaths.FONT, BitmapFont.class);

    public static final AssetDescriptor<TextureAtlas> GAME_PLAY =
            new AssetDescriptor<TextureAtlas>(AssetPaths.GAME_PLAY, TextureAtlas.class);

    public static final AssetDescriptor<Skin> SKIN =
            new AssetDescriptor<Skin>(AssetPaths.SKIN, Skin.class);

    public static final AssetDescriptor<Sound> COIN =
            new AssetDescriptor<Sound>(AssetPaths.COIN_SOUND, Sound.class);

    public static final AssetDescriptor<Sound> LOSE =
            new AssetDescriptor<Sound>(AssetPaths.LOSE_SOUND, Sound.class);

    public static final AssetDescriptor<Sound> TIRO =
            new AssetDescriptor<Sound>(AssetPaths.TIRO_SOUND, Sound.class);

    public static final AssetDescriptor<Sound> COLISAO =
            new AssetDescriptor<Sound>(AssetPaths.COLISAO_SOUND, Sound.class);

    public static final AssetDescriptor<Sound> BONUS =
            new AssetDescriptor<Sound>(AssetPaths.BONUS_SOUND, Sound.class);

    public static final AssetDescriptor<ParticleEffect> FIRE =
            new AssetDescriptor<ParticleEffect>(AssetPaths.FIRE, ParticleEffect.class);

    public static final AssetDescriptor<ParticleEffect> STAR =
            new AssetDescriptor<ParticleEffect>(AssetPaths.STAR, ParticleEffect.class);


    private AssetDescriptors() {
    }
}
