package co.com.gguatibonza.proyectotesis;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class LoginActivity extends AppCompatActivity {
    private Button registro;
    private FloatingActionButton ingresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        registro = findViewById(R.id.IrRegistroLogin);
        ingresar = findViewById(R.id.ingresarLogin);

        ingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                irHome();
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
        startActivity(new Intent(getApplicationContext(), homeActivity.class));

    }

    private void irRegistro() {
        startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
    }


}
