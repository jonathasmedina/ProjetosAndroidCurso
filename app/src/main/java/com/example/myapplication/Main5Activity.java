package com.example.myapplication;

import android.app.AlertDialog;
import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Main5Activity extends ListActivity {

    private static final String[] ITENS = new String[]{"OPÇÃO 1", "OPÇÃO 2", "OPÇÃO 3", "OPÇÃO 4"};
    private ArrayAdapter<String> mAdaptador;
    private Intent intent;
    private String string1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main5);

        mAdaptador = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, ITENS);

        setListAdapter(mAdaptador);

    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        if (position==0) {
            Toast.makeText(this, "Usuário selecionou opção 1", Toast.LENGTH_SHORT).show();
        }
        if(position==1){
            intent = new Intent(Main5Activity.this, Main4Activity.class);
            string1 = "Texto da tela 1";

            intent.putExtra("string1", string1);

            startActivity(intent);
            //finish();
        }
        if (position == 2) {
            AlertDialog.Builder janelaDialogo;
            janelaDialogo = new AlertDialog.Builder(Main5Activity.this);

            janelaDialogo.setTitle("Janela de Diálogo");
            janelaDialogo.setMessage("Você clicou na Opção 3");
            janelaDialogo.setNeutralButton("Ok", null);

            janelaDialogo.show();
        }
        if (position == 3) {
            Intent intent = new Intent(Main5Activity.this, Main6Activity.class);
            startActivity(intent);

        }

    }
}
