package co.com.gguatibonza.proyectotesis;

import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import co.com.gguatibonza.proyectotesis.fragments.alojamientoMunicipio;
import co.com.gguatibonza.proyectotesis.fragments.atractivosMunicipio;
import co.com.gguatibonza.proyectotesis.fragments.descripcionMunicipio;
import co.com.gguatibonza.proyectotesis.fragments.restauranteMunicipio;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import co.com.gguatibonza.proyectotesis.model.municipio;
import io.realm.Realm;


public class municipioDetail extends AppCompatActivity implements descripcionMunicipio.OnFragmentInteractionListener, View.OnClickListener, alojamientoMunicipio.OnFragmentInteractionListener, restauranteMunicipio.OnFragmentInteractionListener, atractivosMunicipio.OnFragmentInteractionListener {
    private Toolbar toolbar;
    private static final String keyMunicipio = "idMunicipio";
    private Realm realm;
    private auxiliar aux;
    private municipio lugar;
    private ImageView municipioImagen;
    private ImageView next, before;
    private static int posicion = 0;


    private descripcionMunicipio descripcionMunicipio;
    private alojamientoMunicipio alojamientoMunicipio;
    private restauranteMunicipio restauranteMunicipio;
    private atractivosMunicipio atractivosMunicipio;

    private ArrayList<String> urls = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_municipio_detail);
        realm = Realm.getDefaultInstance();
        referenciar();
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentDetail, descripcionMunicipio).commit();
        BottomNavigationView navigation = findViewById(R.id.navigationDetail);
        navigation.setItemHorizontalTranslationEnabled(true);
        navigation.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

                switch (menuItem.getItemId()) {
                    case R.id.menuDescripcion:
                        transaction.replace(R.id.fragmentDetail, descripcionMunicipio).commit();
                        break;
                    case R.id.menuAtractivo:
                        transaction.replace(R.id.fragmentDetail, atractivosMunicipio).commit();
                        break;
                    case R.id.menuRestaurante:
                        transaction.replace(R.id.fragmentDetail, restauranteMunicipio).commit();
                        break;
                    case R.id.menuHospedaje:
                        transaction.replace(R.id.fragmentDetail, alojamientoMunicipio).commit();
                        break;
                }
                return true;
            }
        });
        aux = realm.where(auxiliar.class).equalTo("id", 1).findFirst();
        lugar = realm.where(municipio.class).equalTo(keyMunicipio, aux.getIdMunicipio()).findFirst();
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle(lugar.getNombreMunicipio());
        Picasso.get().load(lugar.getFotoMunicipio()).into(municipioImagen);
    }

    private void referenciar() {
        next = findViewById(R.id.nextImagen);
        before = findViewById(R.id.beforeImagen);
        next.setOnClickListener(this);
        before.setOnClickListener(this);
        urls.add("http://cr00.epimg.net/emisora/imagenes/2017/08/18/bucaramanga/1503060677_259401_1503060877_noticia_normal.jpg");
        urls.add("http://www.ideasworldcup.com/wp-content/uploads/2016/04/bucaramanga.jpg");
        urls.add("https://www.fenixconstrucciones.com/wp-content/uploads/2017/03/shantik-casa-boutique-2017.jpg");
        urls.add("https://www.eltiempo.com/contenido/colombia/medellin/IMAGEN/IMAGEN-15780296-2.jpg");
        municipioImagen = findViewById(R.id.imagenMunicipioDetail);
        descripcionMunicipio = new descripcionMunicipio();
        alojamientoMunicipio = new alojamientoMunicipio();
        restauranteMunicipio = new restauranteMunicipio();
        atractivosMunicipio = new atractivosMunicipio();
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.nextImagen:
                Picasso.get().load(urls.get(posicion)).into(municipioImagen);
                posicion++;
                if (posicion == (urls.size())) {
                    posicion = 0;
                }
                break;
            case R.id.beforeImagen:
                Picasso.get().load(urls.get(posicion)).into(municipioImagen);
                posicion--;
                if (posicion <= 0) {
                    posicion = urls.size() - 1;
                }
                break;
        }

    }
}
