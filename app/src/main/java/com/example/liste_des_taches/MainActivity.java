package com.example.liste_des_taches;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<String> items;
    private ArrayAdapter<String> itemsAdapter;
    private ListView lvItems;
    ArrayAdapter myAdapter;
    EditText inputText1;
    Integer indexVal;
    Button  btnUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Message pour l'utilisateur
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Info");
        builder.setMessage("Click long sur une tache pour la supprimer ");
        builder.setCancelable(true);
        builder.setNegativeButton("OK", (DialogInterface.OnClickListener) (dialog, which) -> {
            // If user click ok then dialog box is canceled.
            dialog.cancel();
        });

        lvItems = (ListView) findViewById(R.id.lvItems);
        items = new ArrayList<String>();
        itemsAdapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        // Initialiser avec deux taches
        items.add("First Item");
        items.add("Second Item");
    }

    public void onAddItem(View v) {
        EditText etNewItem = (EditText) findViewById(R.id.etNewItem);
        String itemText = etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
    }

    // update items
        btnUpdate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {

            String val = inputText1.getText().toString();
            items.set(indexVal, val);

            if (!val.isEmpty()) {
                myAdapter.notifyDataSetChanged();
                Toast.makeText(MainActivity.this, "tache modifier", Toast.LENGTH_SHORT).show();
            }
        }
    });

    // Attaches a long click listener to the listview
    private void setupListViewListener() {
        lvItems.setOnItemLongClickListener(
                new AdapterView.OnItemLongClickListener() {
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter,
                                                   View item, int pos, long id) {
                        // Remove the item within array at position
                        items.remove(pos);
                        // Refresh the adapter
                        itemsAdapter.notifyDataSetChanged();
                        // Return true consumes the long click event (marks it handled)
                        return true;
                    }

                });
    }
}