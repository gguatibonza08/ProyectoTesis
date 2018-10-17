package co.com.gguatibonza.proyectotesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import co.com.gguatibonza.proyectotesis.model.Usuario;
import io.realm.Realm;

public class LoginActivity extends AppCompatActivity {
    private Button registro;
    private FloatingActionButton ingresar;
    private TextInputEditText correo, contrasena;
    private Realm realm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Realm.deleteRealm(Realm.getDefaultConfiguration());
        realm = Realm.getDefaultInstance();
        registro = findViewById(R.id.IrRegistroLogin);
        ingresar = findViewById(R.id.ingresarLogin);
        correo = findViewById(R.id.correoLogin);
        contrasena = findViewById(R.id.contrasenaLogin);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
                realm.executeTransaction(new Realm.Transaction() {
                    @Override
                    public void execute(Realm realm) {
                        Usuario person = realm.createObject(Usuario.class, correo.getText().toString());
                        person.setCorreo(correo.getText().toString());
                        person.setContrasena(contrasena.getText().toString());
                    }
                });
            }
        });
        registro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irRegistro();
            }
        });


    }

    private void irHome() {
        realm.executeTransaction(new Realm.Transaction() {
            @Override
            public void execute(Realm realm) {
                Usuario user = new Usuario();
            }
        });

        startActivity(new Intent(getApplicationContext(), homeActivity.class));

    }

    private void irRegistro() {
        startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
    }


}
