package br.edu.insper.whatsmorse;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        Log.i("MainActivity", "VAPE NATION Y'ALL!");

        final EditText campo = (EditText) findViewById(R.id.campo);
        Button botaoEnviar = (Button) findViewById(R.id.botaoEnviar);

        assert botaoEnviar != null;
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                assert campo != null;
//                Log.i("MainActivity", campo.getText().toString());
                Toast.makeText(MainActivity.this, campo.getText().toString(), Toast.LENGTH_LONG).show();
                campo.setText("");
                campo.setHint("Digite outro algo, seu burro");

            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        assert fab != null;
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }
}
