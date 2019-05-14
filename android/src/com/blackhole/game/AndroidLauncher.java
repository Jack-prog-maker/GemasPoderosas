package com.blackhole.game;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;

import static android.provider.UserDictionary.Words.APP_ID;


public class AndroidLauncher extends AndroidApplication implements AdService {

    private static final String AD_UNIT_ID_INTERSTITIAL = "ca-app-pub-2180899685318678/4651076471";
    private static final String ID_APP = "ca-app-pub-2180899685318678~8753015152";
    private InterstitialAd interstitialAd;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        RelativeLayout layout = new RelativeLayout(this);
        MobileAds.initialize(this, ID_APP);
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        View gameView=initializeForView(new Abismo((AdService) this), config);
        layout.addView(gameView);
        setContentView(layout);
        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(AD_UNIT_ID_INTERSTITIAL);


        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
            }

            @Override
            public void onAdClosed() {
                loadIntersitialAd();
            }


        });

        loadIntersitialAd();
    }


    private void loadIntersitialAd() {

        AdRequest interstitialRequest = new AdRequest.Builder().build();
        interstitialAd.loadAd(interstitialRequest);
    }


    @Override
    public void showOrLoadInterstitial() {

        runOnUiThread(new Runnable() {
            public void run() {
                if (interstitialAd.isLoaded())
                    interstitialAd.show();
                else
                    loadIntersitialAd();
            }
        });
    }

}
