package br.edu.insper.whatsmorse;

import android.Manifest;
import android.annotation.TargetApi;
import android.app.ActionBar;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import android.support.v7.app.AppCompatActivity;

import br.edu.insper.whatsmorse.model.SelectedCharacter;

public class MainActivity extends AppCompatActivity {
    // PC - Precisamos mudar a frase para ser tratada como um atributo
    //      (só falta isso para enviar para lista de contatos

    boolean aperto;
    public static List<Boolean> listaDeApertos = new ArrayList<Boolean>();
    private EditText mensagem;
    private String frase = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Button botaoToque = (Button) findViewById(R.id.botaoToque);
        Button botaoBack = (Button) findViewById(R.id.botaoBackSpace);
        Button botaoEnviar = (Button) findViewById(R.id.botaoEnviar);
        this.mensagem = (EditText) findViewById(R.id.editText);

        assert botaoToque != null;
        assert botaoBack != null;

        final CountDownTimer espaco = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onFinish() {

                if (!Objects.equals(frase, "")){
                    frase += " ";
                    mensagem.setText(frase);
                    mensagem.setSelection(mensagem.getText().length());
                }

            }

        }.start();

        final CountDownTimer mudancaDeLetra = new CountDownTimer(1500, 1000) {

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
                    mensagem.setSelection(mensagem.getText().length());
                    listaDeApertos.clear();
                }
            }
        }.start();

        botaoToque.setOnClickListener(new View.OnClickListener() {
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

        assert botaoToque != null;

        botaoToque.setOnLongClickListener(new View.OnLongClickListener() {
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

        botaoBack.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (!Objects.equals(frase, "")) {
                    frase = frase.substring(0, frase.length() - 1);
                    mensagem.setText(frase);
                    mensagem.setSelection(mensagem.getText().length());       // Para o cursor seguir a mensagem
                    mudancaDeLetra.cancel();
                    mudancaDeLetra.start();
                    espaco.cancel();
                    espaco.start();
                }
            }
        });

        assert botaoEnviar != null;
        botaoEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // PC - Precisamos enviar o valor de "frase" e depois zerá-lo
                //      para quando o usuário voltar não ter mais mensagem no campo
                //      TODO: Fazer com que o campo não "reset" somente ao clicar em enviar e sim ao tentar enviar uma mensagem à um contato ou telefone por conta de possíveis erros

                startActivity(new Intent(MainActivity.this, SendActivity.class).putExtra("frase",frase));
                // PC - TODO: Provavelmente a solução do TODO anterior está ligada com o envio pelo "putExtra"

                frase = "";
                mensagem.setText(frase);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_nurse:
                startActivity(new Intent(MainActivity.this, NurseActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
