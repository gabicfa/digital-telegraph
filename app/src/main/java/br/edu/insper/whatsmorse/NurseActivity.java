package br.edu.insper.whatsmorse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class NurseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        // PC - Criei uma list view para colocar os valores
        //      correspondentes às letras
        //      TODO: Completar esta lísta (ou montar outra estrutura de dados conforme achar necessário) utilizando a árvore para criar a "cola do ajudante"

        String[] charCodes = {"a", "b", "c"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, charCodes);

        ListView charList = (ListView) findViewById(R.id.listView);

        assert charList != null;
        charList.setAdapter(myAdapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_nurse, menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_user:
                startActivity(new Intent(NurseActivity.this, MainActivity.class));
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }
}
