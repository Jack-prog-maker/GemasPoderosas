package com.blackhole.game.ads;

import com.google.android.gms.ads.AdRequest;


public class AdUtils {

    private static final String TEST_DEVICE = "99413C65A969834469611553B6A194C2";

    public static AdRequest buildRequest() {
        return new AdRequest.Builder()
                .addTestDevice(TEST_DEVICE)
                .build();
    }

    private AdUtils() {}
}
