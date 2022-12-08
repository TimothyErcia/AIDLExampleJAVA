package com.example.aidlexamplejava;

import android.app.Service;
import android.content.Intent;
import android.graphics.Color;
import android.os.IBinder;
import android.os.RemoteException;

import java.util.Random;

public class AIDLColorService extends Service {
    public AIDLColorService() {
    }

    @Override
    public void onTaskRemoved(Intent rootIntent) {
        super.onTaskRemoved(rootIntent);
        stopSelf();
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new IAIDLColorInterface.Stub() {
            @Override
            public int getColor() throws RemoteException {
                Random random = new Random();
                int color = Color.rgb(random.nextInt(256), random.nextInt(256), random.nextInt(256));
                return color;
            }
        };
    }
}