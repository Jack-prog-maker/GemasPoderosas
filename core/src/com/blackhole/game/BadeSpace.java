package com.blackhole.game;

import com.blackhole.game.game.LoadingScreen;

public class BadeSpace extends GameBase {



    public BadeSpace(AdController adController) {
        super(adController);
    }

    @Override
    public void postCreate() {
        getAdController().showBanner();
        setScreen(new LoadingScreen(this));
    }

}
