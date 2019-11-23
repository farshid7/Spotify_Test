package com.mydigipay.www.utils;

public class SpotifyAuthentication {

    private static SpotifyAuthentication Instance;

    public static synchronized SpotifyAuthentication Builder() {
        if (Instance == null) {
            Instance = new SpotifyAuthentication();
        }
        return Instance;
    }
}
