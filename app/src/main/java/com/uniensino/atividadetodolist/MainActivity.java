package com.uniensino.atividadetodolist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<String> listaTarefas = new ArrayList<>();

    private ArrayAdapter<String> adapter;

    private EditText tarefa;
    private FloatingActionButton adicionaTarefa;
    private ListView tarefasLista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tarefa = findViewById(R.id.editTextTarefa);
        adicionaTarefa = findViewById(R.id.fabAdicionaTarefa);
        tarefasLista = findViewById(R.id.listaDeTarefas);

        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, listaTarefas);

        tarefasLista.setAdapter(adapter);
        adicionaTarefa.setOnClickListener(v -> {
            salvarTarefa();
        });
    }

    private void salvarTarefa(){
        String novaTarefa = tarefa.getText().toString();
        if(!novaTarefa.isEmpty())
        {
            listaTarefas.add(novaTarefa);
            tarefa.setText("");
            adapter.notifyDataSetChanged();
        } else {
            Toast.makeText(getApplicationContext(), "Digite algo para salvar uma tarefa", Toast.LENGTH_SHORT).show();
        }

    }
}