package co.com.gguatibonza.proyectotesis.app;

import android.app.Application;

import io.realm.Realm;

public class myApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);
    }
}
