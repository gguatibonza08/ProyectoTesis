package co.com.gguatibonza.proyectotesis.app;

import android.app.Application;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class myApp extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Realm.init(this);

        RealmConfiguration config = new RealmConfiguration.Builder()
                .schemaVersion(2) // Must be bumped when the schema changes
                //.migration(new MyMigration()) // Migration to run instead of throwing an exception
                .build();

        Realm.setDefaultConfiguration(config);
    }
}


