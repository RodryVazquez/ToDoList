package com.example.rodrigo.simpletodolist;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ActionBarActivity {

    private ListView lstItems;
    private Button btnAddItem;
    private EditText edtInputItem;
    private ArrayList<String> data;
    private ArrayAdapter<String>stringArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Obtenemos la referencia del layout
        lstItems = (ListView)findViewById(R.id.lstItems);
        btnAddItem = (Button)findViewById(R.id.btnAddItem);
        edtInputItem = (EditText)findViewById(R.id.edtInputItem);
        //Inicializamos el arraylist, adapter y setamos le adapter al listView
        data = new ArrayList<>();
        stringArrayAdapter = new ArrayAdapter<String>(MainActivity.this,android.R.layout.simple_list_item_1,data);
        lstItems.setAdapter(stringArrayAdapter);

        //Agregamos un nuevo elemento en la lista
        btnAddItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String newItem = edtInputItem.getText().toString();
                if (newItem.length() > 0){
                    data.add(newItem);
                    stringArrayAdapter.notifyDataSetChanged();
                    edtInputItem.setText("");
                }
            }
        });

        //Borramos el elemento de la lista
        lstItems.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {

                data.remove(position);
                stringArrayAdapter.notifyDataSetChanged();
                return true;
            }
        });
    }
}
