package com.example.timestable;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText numb = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);
        final ListView listView = findViewById(R.id.listView);

        final ArrayList<String> table = new ArrayList<>();
        final ArrayAdapter<String> adapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,table);
        listView.setAdapter(adapter);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                table.clear();
                String number = numb.getText().toString();
                for (int i = 1; i<=10; i++){
                    int value = Integer.parseInt(number) * i;
                    table.add(Integer.toString(value));
                }
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                table.remove(i);
                adapter.notifyDataSetChanged();
            }
        });
    }
}
