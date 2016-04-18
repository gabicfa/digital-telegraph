package br.edu.insper.whatsmorse;

import android.content.ClipData;
import android.os.Bundle;
import android.os.CountDownTimer;
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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    boolean aperto;
    public static List<Boolean> listaDeApertos = new ArrayList<Boolean>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button botaoEnviar = (Button) findViewById(R.id.botaoEnviar);

        assert botaoEnviar != null;

        final CountDownTimer remainingTimeCounter = new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                Toast.makeText(MainActivity.this, "Parabéns, você fez um espaco", Toast.LENGTH_LONG).show();

                for(int i = listaDeApertos.size(); i < 5; ++i){
                    listaDeApertos.add(null);
                }

                System.out.println(listaDeApertos);
                listaDeApertos.clear();
                }
        }.start();

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Parabéns, você fez um ponto", Toast.LENGTH_LONG).show();
                aperto= false;
                listaDeApertos.add(aperto);
                System.out.println(listaDeApertos);
                remainingTimeCounter.cancel();
                remainingTimeCounter.start();
            }
        });

        assert botaoEnviar != null;

        botaoEnviar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(MainActivity.this, "Parabéns, você fez um traço", Toast.LENGTH_LONG).show();
                aperto = true;
                listaDeApertos.add(aperto);
                System.out.println(listaDeApertos);
                remainingTimeCounter.cancel();
                remainingTimeCounter.start();
                return true;
            }
        });



    }
}
