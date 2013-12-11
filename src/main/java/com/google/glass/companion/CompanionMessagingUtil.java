package com.google.glass.companion;

import java.lang.reflect.Method;

public class CompanionMessagingUtil {

    private static final int PROTOCOL_VERSION = 131078;

    private static final Method androidUptimeMills;
    static {
        Method method = null;
        try {
            method = Class.forName("android.os.SystemClock").getMethod("uptimeMillis");
        } catch (Exception e) {
        }
        androidUptimeMills = method;
    }

    public static Proto.Envelope newEnvelope() {
        Proto.Envelope localEnvelope = new Proto.Envelope();
        localEnvelope.version = Integer.valueOf(PROTOCOL_VERSION);
        localEnvelope.timeMillis = Long.valueOf(System.currentTimeMillis());
        if (androidUptimeMills != null) {
            try {
                localEnvelope.uptimeMillis = (Long) androidUptimeMills.invoke(null, null);
            } catch (Exception e) {
                localEnvelope.uptimeMillis = Long.valueOf(System.currentTimeMillis());
            }
        } else {
            localEnvelope.uptimeMillis = Long.valueOf(System.currentTimeMillis());
        }
        return localEnvelope;
    }
}
