package br.edu.insper.whatsmorse;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import br.edu.insper.whatsmorse.model.SelectedCharacter;

public class NumberEntryActivity extends AppCompatActivity {
    private String telefone = "";
    private boolean aperto;
    private EditText editTextNumero;
    private static List<Boolean> listaDeApertos = new ArrayList<Boolean>();
    private String frase = "";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_entry);

        frase = getIntent().getStringExtra("frase");
        System.out.println("catdog " + frase);

        Button botaoEnviar = (Button) findViewById(R.id.botao_enviar_numero);
        Button botaoBackspace = (Button) findViewById(R.id.botao_backspace_numero);
        Button botaoNumero = (Button) findViewById(R.id.botao_toque_numero);
        this.editTextNumero = (EditText) findViewById(R.id.edit_text_numero);

        assert botaoEnviar != null;
        assert botaoBackspace != null;
        assert botaoNumero != null;


        final CountDownTimer mudancaDeNumero = new CountDownTimer(1500, 1000) {

            public void onTick(long millisUntilFinished) {
            }

            public void onFinish() {
                System.out.println(listaDeApertos);
                SelectedCharacter selectedChar = new SelectedCharacter();
                selectedChar.setNode(listaDeApertos);

                if (listaDeApertos.size() == 5) {
                    char numero = selectedChar.getValue();
                    System.out.println(numero);
                    telefone += numero;
                    System.out.println(telefone);
                    editTextNumero.setText(telefone);
                    editTextNumero.setSelection(editTextNumero.getText().length());
                    listaDeApertos.clear();
                }
            }
        }.start();

        botaoNumero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                aperto= false;
                if (listaDeApertos.size()<5){
                    listaDeApertos.add(aperto);
                }
                System.out.println(listaDeApertos);
                mudancaDeNumero.cancel();
                mudancaDeNumero.start();
            }
        });

        botaoNumero.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                aperto = true;
                if (listaDeApertos.size()<5){
                    listaDeApertos.add(aperto);
                }
                System.out.println(listaDeApertos);
                mudancaDeNumero.cancel();
                mudancaDeNumero.start();
                return true;
            }
        });

        botaoBackspace.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.KITKAT)
            @Override
            public void onClick(View v) {
                if (!Objects.equals(telefone, "")) {
                    telefone = telefone.substring(0, telefone.length() - 1);
                    editTextNumero.setText(telefone);
                    editTextNumero.setSelection(editTextNumero.getText().length());       // Para o cursor seguir a mensagem
                    mudancaDeNumero.cancel();
                    mudancaDeNumero.start();
                }
            }
        });

    }


}
