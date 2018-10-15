package co.com.gguatibonza.proyectotesis;

import android.os.Bundle;
import android.support.design.bottomappbar.BottomAppBar;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.widget.Toast;

public class homeActivity extends AppCompatActivity implements enviarMenu {
    private BottomAppBar appBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        appBar = findViewById(R.id.ApBarHome);
        setSupportActionBar(appBar);
        appBar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ItemListDialogFragment.newInstance(30).show(getSupportFragmentManager(), "dialog");
                menuBottomSheet.newInstance().show(getSupportFragmentManager(), "dialog");
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menubottomappbar, menu);
        return true;
    }


    @Override
    public void enviarMenu(int i) {
        Toast.makeText(getApplicationContext(), "" + i, Toast.LENGTH_SHORT).show();
    }
}
