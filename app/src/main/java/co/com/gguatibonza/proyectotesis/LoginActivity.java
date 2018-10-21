package co.com.gguatibonza.proyectotesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import co.com.gguatibonza.proyectotesis.model.Usuario;
import co.com.gguatibonza.proyectotesis.model.auxiliar;
import co.com.gguatibonza.proyectotesis.model.municipio;
import io.realm.Realm;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {
    private Button registro;
    private FloatingActionButton ingresar;
    private TextInputEditText correo, contrasena;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        realm = Realm.getDefaultInstance();
        ayuda();
        referenciar();
        int tamaño = realm.where(auxiliar.class).findAll().size();

        if (tamaño > 0) {
            Log.e("prueba", "onCreate: " + realm.where(auxiliar.class).findFirst().getId());
            Intent i = new Intent(getApplicationContext(), homeActivity.class);
            startActivity(i);
            finish();
        }

    }

    private void referenciar() {
        registro = findViewById(R.id.IrRegistroLogin);
        ingresar = findViewById(R.id.ingresarLogin);
        correo = findViewById(R.id.correoLogin);
        contrasena = findViewById(R.id.contrasenaLogin);
        ingresar.setOnClickListener(this);
        registro.setOnClickListener(this);
    }

    private void irHome() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.delete(auxiliar.class);
                Usuario person = new Usuario();
                person.setIdUsuario((int) Math.random() * 100 + 1);
                person.setNombreUsuario("Gian");
                person.setApellidoUsuario("Guatibonza");
                person.setApodoUsuario("gguatibonza");
                person.setContrasenaUsuario("1234");
                person.setCorreoUsuario("gguatibonza08@gmail.com");
                person.setFotoUsuario("https//:i.imgur.com/EYadhi1.png");
                person.setTelefonoUsuario("3174146021");
                realm.insertOrUpdate(person);

                auxiliar aux = realm.createObject(auxiliar.class, 1);
                aux.setIdUsuario(person.getIdUsuario());
                aux.setIdMunicipio(0);
                aux.setLogueado(true);
               /* SharedPreferences preferences = getSharedPreferences("Tesis", MODE_PRIVATE);
                String correo = person.getCorreo();
                SharedPreferences.Editor editor = preferences.edit();
                editor.putString("correo", correo);
                editor.putBoolean("log", true);
                editor.commit();*/
                Intent i = new Intent(getApplicationContext(), homeActivity.class);
                startActivity(i);
                finish();
            }
        });

    }

    private void ayuda() {
        final municipio mun1 = new municipio(1, "Bucaramanga", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "1", "https://files.rcnradio.com/public/migration/212.jpg");
        final municipio mun2 = new municipio(2, "El Playón", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "2", "https://files.rcnradio.com/public/migration/playon.jpg");
        final municipio mun3 = new municipio(3, "Veléz", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "3", "https://i.ytimg.com/vi/Q1VLPaEDcUs/maxresdefault.jpg");
        final municipio mun4 = new municipio(4, "Barichara", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "4", "https://photo980x880.mnstatic.com/b1c6dee81de57c3058243eb226cfc9ab/barichara_572610.jpg");
        final municipio mun5 = new municipio(5, "Guane", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "5", "https://i.ytimg.com/vi/Hfbg2GQElRQ/maxresdefault.jpg");
        final municipio mun6 = new municipio(6, "Chárala", 10, 10, getString(R.string.descripcionMunicipio), getString(R.string.descripcionMunicipio), "6", "https://www.fotopaises.com/Fotos-Paises/t/2006/4/21/359_1145756033.jpg");

        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                realm.insertOrUpdate(mun1);
                realm.insertOrUpdate(mun2);
                realm.insertOrUpdate(mun3);
                realm.insertOrUpdate(mun4);
                realm.insertOrUpdate(mun5);
                realm.insertOrUpdate(mun6);
            }
        });
    }

    private void irRegistro() {
        startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.ingresarLogin:
                irHome();
                break;
            case R.id.IrRegistroLogin:
                irRegistro();
                break;
        }

    }
}
