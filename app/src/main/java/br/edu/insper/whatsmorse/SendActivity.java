package br.edu.insper.whatsmorse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.SmsManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class SendActivity extends AppCompatActivity {
    // PC - Eviar mensagem para um telefone qualquer
    private MainActivity mainActivity = new MainActivity();
    private String frase;
    private SmsManager manager;
    private ListView contactList;
    private ArrayAdapter<String> adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);

        // PC - Criação de uma list view com  para trabalharmos
        //      com os "contatos favoritos"

        final String[] contacts = {"Pedro Cunial", "Matheus Dias", "Gabi Almeida"};

        adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, contacts);

        contactList = (ListView) findViewById(R.id.list_favorites);

        assert contactList != null;
        contactList.setAdapter(adapter);

        contactList.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent,
                                    View view, int position, long id) {
                switch (position) {
                    case 0:
                        ligar("996003399");
                        break;
                    case 1:
                        ligar("973067806");
                        break;
                    case 2:
                        ligar("976006696");
                        break;
                }
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_send, menu);
        return super.onCreateOptionsMenu(menu);
    }


    public void ligar(String phone) {
        this.frase = mainActivity.getFrase();
        if(PhoneNumberUtils.isWellFormedSmsAddress(phone)) {
            if(frase != "") {
                manager.sendTextMessage(phone, null, frase, null, null);
                Toast.makeText(SendActivity.this, "Torpedo enviado!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(SendActivity.this, "Mensagem vazia, impossível enviar", Toast.LENGTH_LONG).show();
            }
        }
        else {
            Toast.makeText(SendActivity.this, "Número inválido!", Toast.LENGTH_SHORT).show();
        }
    }
}
