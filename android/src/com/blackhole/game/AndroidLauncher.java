package com.blackhole.game;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;

import com.badlogic.gdx.backends.android.AndroidApplication;
import com.badlogic.gdx.backends.android.AndroidApplicationConfiguration;
import com.blackhole.game.ads.AdUnitIds;
import com.blackhole.game.ads.AdUtils;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.reward.RewardItem;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.ads.reward.RewardedVideoAdListener;




import static android.provider.UserDictionary.Words.APP_ID;




public class AndroidLauncher extends AndroidApplication implements AdController {


    private static final String ID_APP = "";
    private InterstitialAd interstitialAd;
    private AdView bannerAdView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MobileAds.initialize(this, ID_APP);
        initAds();
        initUi();
    }

    private void initAds() {
        bannerAdView = new AdView(this);
        bannerAdView.setId(R.id.adViewId);
        bannerAdView.setAdUnitId(AdUnitIds.BANNER_ID);
        bannerAdView.setAdSize(AdSize.SMART_BANNER);

        interstitialAd = new InterstitialAd(this);
        interstitialAd.setAdUnitId(AdUnitIds.INTERSTITIAL_ID);

        interstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdClosed() {
                loadInterstitial();
            }
        });

        loadInterstitial();
    }

    private void initUi() {
        AndroidApplicationConfiguration config = new AndroidApplicationConfiguration();
        View gameView = initializeForView(new BadeSpace(this), config);

        RelativeLayout layout = new RelativeLayout(this);

        // ad view params
        RelativeLayout.LayoutParams adParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.WRAP_CONTENT,
                ViewGroup.LayoutParams.WRAP_CONTENT
        );

        adParams.addRule(RelativeLayout.ALIGN_PARENT_BOTTOM);

        // game view params
        RelativeLayout.LayoutParams gameParams = new RelativeLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT,
                ViewGroup.LayoutParams.MATCH_PARENT
        );

        gameParams.addRule(RelativeLayout.ABOVE, bannerAdView.getId());

        layout.addView(bannerAdView, adParams);
        layout.addView(gameView, gameParams);

        setContentView(layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        bannerAdView.resume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        bannerAdView.pause();
    }

    @Override
    protected void onDestroy() {
        bannerAdView.destroy();
        super.onDestroy();
    }

    @Override
    public void showBanner() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                loadBanner();
            }
        });
    }

    private void loadBanner() {
        if (isNetworkConnected()) {
            bannerAdView.loadAd(AdUtils.buildRequest());
        }
    }

    @Override
    public void showInterstitial() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                showInterstitialInternal();
            }
        });
    }

    private void showInterstitialInternal() {
        if(interstitialAd.isLoaded()) {
            interstitialAd.show();
        }
    }

    private void loadInterstitial() {
        if(isNetworkConnected()) {
            interstitialAd.loadAd(AdUtils.buildRequest());
        }
    }

    @Override
    public boolean isNetworkConnected() {
        ConnectivityManager connectivityManager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
        return networkInfo != null && networkInfo.isConnected();
    }
}

