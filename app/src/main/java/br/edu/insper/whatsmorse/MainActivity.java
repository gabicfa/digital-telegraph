package br.edu.insper.whatsmorse;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import br.edu.insper.whatsmorse.model.SelectedCharacter;

public class MainActivity extends AppCompatActivity {

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

        // Código básico para utilizar o novo modelo de permissões do Android.
        int permission = ContextCompat.checkSelfPermission(this, Manifest.permission.SEND_SMS);
        if(permission != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.SEND_SMS}, 0);
        }

        assert botaoToque != null;
        assert botaoBack != null;


        final CountDownTimer espaco = new CountDownTimer(3000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }

            @Override
            public void onFinish() {

                if (frase != ""){
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
            @Override
            public void onClick(View v) {
                if (frase != "") {
                    frase = frase.substring(0, frase.length() - 1);
                    mensagem.setText(frase);
                    mensagem.setSelection(mensagem.getText().length());
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
                // Código básico para utilizar envio de torpedos internamente.
                SmsManager manager = SmsManager.getDefault();
                String phone = "996003399";
                if(PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
                    if(frase != "") {
                        manager.sendTextMessage(phone, null, frase, null, null);
                        Toast.makeText(MainActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(MainActivity.this, "Mensagem vazia, impossível enviar", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(MainActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
                }
            }
        });


    }
}
