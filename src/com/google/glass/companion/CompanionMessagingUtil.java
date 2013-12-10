package com.google.glass.companion;

import android.os.SystemClock;

public class CompanionMessagingUtil {

    private static final int PROTOCOL_VERSION = 131078;

    public static Proto.Envelope newEnvelope() {
        Proto.Envelope localEnvelope = new Proto.Envelope();
        localEnvelope.version = Integer.valueOf(PROTOCOL_VERSION);
        localEnvelope.timeMillis = Long.valueOf(System.currentTimeMillis());
        localEnvelope.uptimeMillis = Long.valueOf(SystemClock.uptimeMillis());
        return localEnvelope;
    }

}
