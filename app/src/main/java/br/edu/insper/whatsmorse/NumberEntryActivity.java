package br.edu.insper.whatsmorse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class NumberEntryActivity extends AppCompatActivity {
    private String numero;
    private EditText editTextNumero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_entry);

        Button botaoEnviar = (Button) findViewById(R.id.botao_enviar_numero);
        Button botaoBackspace = (Button) findViewById(R.id.botao_backspace_numero);
        Button botaoNumero = (Button) findViewById(R.id.botao_toque_numero);
        this.editTextNumero = (EditText) findViewById(R.id.edit_text_numero);


    }
}
