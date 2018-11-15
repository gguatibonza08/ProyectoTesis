package co.com.gguatibonza.proyectotesis;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaScannerConnection;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.FileProvider;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.File;

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
    private FloatingActionButton camara;

    private final String CARPETA_RAIZ = "misImagenesPrueba/";
    private final String RUTA_IMAGEN = CARPETA_RAIZ + "misFotos";
    String path;

    final int COD_SELECCIONA = 10;
    final int COD_FOTO = 20;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        referenciar();
        appBar = findViewById(R.id.ApBarHome);
        setSupportActionBar(appBar);
        getSupportFragmentManager().beginTransaction().add(R.id.fragmentHome, municipioFragment).commit();

        camara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                cargarImagen();
            }
        });

        appBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                menuBottomSheet.newInstance().show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    private void referenciar() {
        realm = Realm.getDefaultInstance();
        camara = findViewById(R.id.camara);
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

    private void cargarImagen() {

        final CharSequence[] opciones = {"Tomar Foto", "Cargar Imagen", "Cancelar"};
        final AlertDialog.Builder alertOpciones = new AlertDialog.Builder(homeActivity.this);
        alertOpciones.setTitle("Seleccione una Opción");
        alertOpciones.setItems(opciones, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                if (opciones[i].equals("Tomar Foto")) {
                    tomarFotografia();
                } else {
                    if (opciones[i].equals("Cargar Imagen")) {
                        Intent intent = new Intent(Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
                        intent.setType("image/");
                        startActivityForResult(intent.createChooser(intent, "Seleccione la Aplicación"), COD_SELECCIONA);
                    } else {
                        dialogInterface.dismiss();
                    }
                }
            }
        });
        alertOpciones.show();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {

            switch (requestCode) {
                case COD_SELECCIONA:
                    Uri miPath = data.getData();
                    // imagen.setImageURI(miPath);
                    break;

                case COD_FOTO:
                    MediaScannerConnection.scanFile(this, new String[]{path}, null,
                            new MediaScannerConnection.OnScanCompletedListener() {
                                @Override
                                public void onScanCompleted(String path, Uri uri) {
                                    Log.i("Ruta de almacenamiento", "Path: " + path);
                                }
                            });

                 /*   Bitmap bitmap= BitmapFactory.decodeFile(path);
                    imagen.setImageBitmap(bitmap);*/

                    break;
            }


        }
    }



    private void tomarFotografia() {
        File fileImagen = new File(Environment.getExternalStorageDirectory(), RUTA_IMAGEN);
        boolean isCreada = fileImagen.exists();
        String nombreImagen = "";
        if (isCreada == false) {
            isCreada = fileImagen.mkdirs();
        }

        if (isCreada == true) {
            nombreImagen = (System.currentTimeMillis() / 1000) + ".jpg";
        }


        path = Environment.getExternalStorageDirectory() +
                File.separator + RUTA_IMAGEN + File.separator + nombreImagen;

        File imagen = new File(path);

        Intent intent = null;
        intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        ////
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            String authorities = getApplicationContext().getPackageName() + ".provider";
            Uri imageUri = FileProvider.getUriForFile(this, authorities, imagen);
            intent.putExtra(MediaStore.EXTRA_OUTPUT, imageUri);
        } else {
            intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(imagen));
        }
        startActivityForResult(intent, COD_FOTO);
    }
}
