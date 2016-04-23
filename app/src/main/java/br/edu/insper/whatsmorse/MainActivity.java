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
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.insper.whatsmorse.model.SelectedCharacter;

public class MainActivity extends AppCompatActivity {

    boolean aperto;
    public static List<Boolean> listaDeApertos = new ArrayList<Boolean>();
    private TextView mensagem;
    private String frase = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button botaoEnviar = (Button) findViewById(R.id.botaoEnviar);
        this.mensagem = (TextView) findViewById(R.id.textView);

        assert botaoEnviar != null;

        final CountDownTimer espaco = new CountDownTimer(4000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {
                frase += " ";
            }
        }.start();

        final CountDownTimer mudancaDeLetra = new CountDownTimer(2000, 1000) {
            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                System.out.println(listaDeApertos);
                SelectedCharacter selectedChar = new SelectedCharacter();
                selectedChar.setNode(listaDeApertos);

                if (listaDeApertos.size() > 0) {
                    char letra = selectedChar.getValue();
                    System.out.println(letra);
                    frase += letra;
                    System.out.println(frase);
                    mensagem.setText(frase);
                    listaDeApertos.clear();
                }
            }
        }.start();

        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aperto= false;
                if (listaDeApertos.size()<5){
                    listaDeApertos.add(aperto);
                }
                System.out.println(listaDeApertos);
                mudancaDeLetra.cancel();
                mudancaDeLetra.start();
                espaco.cancel();
                espaco.start();
            }
        });

        assert botaoEnviar != null;

        botaoEnviar.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                aperto = true;
                if (listaDeApertos.size()<5){
                    listaDeApertos.add(aperto);
                }
                System.out.println(listaDeApertos);
                mudancaDeLetra.cancel();
                mudancaDeLetra.start();
                espaco.cancel();
                espaco.start();
                return true;
            }
        });




    }
}
