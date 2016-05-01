package br.edu.insper.whatsmorse;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;


import br.edu.insper.whatsmorse.model.*;

public class NurseActivity extends AppCompatActivity {
    private Node[] nodes;
    private NodeFactory nodeFactory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dictionary);

        // PC - Criei uma list view para colocar os valores
        //      correspondentes às letras
        //      TODO: Completar esta lísta (ou montar outra estrutura de dados conforme achar necessário) utilizando a árvore para criar a "cola do ajudante"

        //  PC - Pegamos valor à valor dos chars na lista dos nós
        nodeFactory = new NodeFactory();
        nodes = nodeFactory.getNodes();

        List<String> charCodes =  new ArrayList<>();

        Stack<Node> stack = new Stack<Node>();
        Stack<Character> value = new Stack<>();

        stack.push(nodes[0]);
        value.push(' ');

        // PC - Realizamos a busca dos valores
        while (!stack.empty()) {
            Node node = stack.peek();

            if (node.getLeft() != null) {
                value.push('.');
                Node node2 = node.getLeft();
                node.setLeft(null);
                stack.push(node2);

            } else if (node.getRight() != null) {
                value.push('-');
                Node node2 = node.getRight();
                node.setRight(null);
                stack.push(node2);

            } else {

                if(node.getLetra() != 0) {
                    String charAndItsCode = node.getLetra() + ":";
                    for(char character : value) {
                        charAndItsCode += character;
                        charAndItsCode += ' ';
                    }
                    charCodes.add(charAndItsCode);
                }
                stack.pop();
                value.pop();
            }
        }




//        String[] charCodes = {"a", "b", "c"};

        ArrayAdapter<String> myAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, charCodes);

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
