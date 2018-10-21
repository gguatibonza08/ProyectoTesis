package co.com.gguatibonza.proyectotesis;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import co.com.gguatibonza.proyectotesis.fragments.acercaFragment;
import co.com.gguatibonza.proyectotesis.fragments.contactarFragment;
import co.com.gguatibonza.proyectotesis.fragments.evaluarFragment;
import co.com.gguatibonza.proyectotesis.fragments.municipioFragment;
import co.com.gguatibonza.proyectotesis.fragments.perfilFragment;
import co.com.gguatibonza.proyectotesis.fragments.rutaFragment;
import co.com.gguatibonza.proyectotesis.interfaces.enviarMenu;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import io.realm.Realm;

public class homeActivity extends AppCompatActivity
        implements enviarMenu,
        municipioFragment.OnFragmentInteractionListener,
        rutaFragment.OnFragmentInteractionListener,
        perfilFragment.OnFragmentInteractionListener,
        contactarFragment.OnFragmentInteractionListener,
        evaluarFragment.OnFragmentInteractionListener,
        acercaFragment.OnFragmentInteractionListener {

    private BottomAppBar appBar;
    private municipioFragment municipioFragment;
    private rutaFragment rutaFragment;
    private perfilFragment perfilFragment;
    private contactarFragment contactarFragment;
    private evaluarFragment evaluarFragment;
    private acercaFragment acercaFragment;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        referenciar();
        appBar = findViewById(R.id.ApBarHome);
        setSupportActionBar(appBar);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentHome, municipioFragment).commit();


        appBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBottomSheet.newInstance().show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    private void referenciar() {
        realm = Realm.getDefaultInstance();
        municipioFragment = new municipioFragment();
        rutaFragment = new rutaFragment();
        perfilFragment = new perfilFragment();
        contactarFragment = new contactarFragment();
        evaluarFragment = new evaluarFragment();
        acercaFragment = new acercaFragment();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubottomappbar, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        switch (item.getItemId()) {
            case R.id.profileBottom:
                transaction.replace(R.id.fragmentHome, perfilFragment).commit();
                break;
            case R.id.closeBottom:
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        realm.delete(auxiliar.class);
                        startActivity(new Intent(getApplicationContext(), LoginActivity.class));
                        finish();
                    }
                });

                break;


        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void enviarMenu(int i) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.setCustomAnimations(R.anim.enter_from_right, R.anim.exit_to_right, R.anim.enter_from_right, R.anim.exit_to_right);

        switch (i) {
            case R.id.municipioMenu:
                transaction.replace(R.id.fragmentHome, municipioFragment).commit();
                break;
            case R.id.rutaMenu:
                transaction.replace(R.id.fragmentHome, rutaFragment).commit();
                break;
            case R.id.perfilMenu:
                transaction.replace(R.id.fragmentHome, perfilFragment).commit();
                break;
            case R.id.contactanosMenu:
                transaction.replace(R.id.fragmentHome, contactarFragment).commit();
                break;
            case R.id.calificanosMenu:
                transaction.replace(R.id.fragmentHome, evaluarFragment).commit();
                break;
            case R.id.acercaDeMenu:
                transaction.replace(R.id.fragmentHome, acercaFragment).commit();
                break;
        }

    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
