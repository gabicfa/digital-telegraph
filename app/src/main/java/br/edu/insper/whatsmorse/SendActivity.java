package br.edu.insper.whatsmorse;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class SendActivity extends AppCompatActivity {
    // PC - Eviar mensagem para um telefone qualquer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_send, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
