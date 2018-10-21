package co.com.gguatibonza.proyectotesis;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import co.com.gguatibonza.proyectotesis.model.auxiliar;
import co.com.gguatibonza.proyectotesis.model.municipio;
import io.realm.Realm;


public class municipioDetail extends AppCompatActivity {
    private Toolbar toolbar;
    private static final String keyMunicipio = "idMunicipio";
    private Realm realm;
    private auxiliar aux;
    private municipio lugar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_detail);

        realm = Realm.getDefaultInstance();
        aux = realm.where(auxiliar.class).equalTo("id", 1).findFirst();
        lugar = realm.where(municipio.class).equalTo(keyMunicipio, aux.getIdMunicipio()).findFirst();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(lugar.getNombreMunicipio());
        setSupportActionBar(toolbar);
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


    }
}
