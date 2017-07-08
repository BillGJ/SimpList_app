package com.codepath.simpletodo2;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {


    ArrayList <String> items;
    ArrayAdapter<String> itemsAdapter;
    ListView lvItems;
    private boolean hasFocus=false;

   private final int REQUEST_CODE = 20;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lvItems = (ListView) findViewById(R.id.lvItems);
        readItems();
        itemsAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1, items);
        lvItems.setAdapter(itemsAdapter);
        setupListViewListener();
        setupListViewListener1();

    }

    public void onAddItem(View v){
        EditText etNewItem=(EditText) findViewById(R.id.etNewItem);
        String itemText=etNewItem.getText().toString();
        itemsAdapter.add(itemText);
        etNewItem.setText("");
        writeItems();

    }

    private  void setupListViewListener(){
        lvItems.setOnItemLongClickListener(

                new AdapterView.OnItemLongClickListener(){
                    @Override
                    public boolean onItemLongClick(AdapterView<?> adapter, View item, int pos, long id){
                        final int position=pos;

                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {
                                //I make the "No" button as positive and the "Yes" button as negative for handling their position
                                if (!isFinishing()){
                                    new AlertDialog.Builder(MainActivity.this).setTitle("Delete Item")
                                            .setMessage("Are you sure you want to delete this item ?")
                                            .setCancelable(true)
                                            .setNegativeButton("Yes", new DialogInterface.OnClickListener() {
                                                @Override
                                                public void onClick(DialogInterface dialog, int which) {
                                                    // Whatever...
                                                    items.remove(position);
                                                    itemsAdapter.notifyDataSetChanged();
                                                    writeItems();
                                                }
                                            }).setPositiveButton("No", new DialogInterface.OnClickListener() {
                                        @Override
                                        public void onClick(DialogInterface dialog, int which) {
                                            // Whatever...

                                            dialog.dismiss();
                                        }
                                    }).show();


                                }
                            }
                        });






                        return true;

                    }
                });
    }

    private void setupListViewListener1(){
        lvItems.setOnItemClickListener(new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> adapter, View item, int pos, long id){
                        Intent i=new Intent(MainActivity.this, EditItemActivity.class);
                        i.putExtra("item",items.get(pos));
                        position=pos;
                        hasFocus=true;
                        i.putExtra("focus",hasFocus);
                        startActivityForResult(i,REQUEST_CODE);

                    }
                }
        );
    }

    private void readItems(){
        File filesDir= getFilesDir();
        File todoFile=new File(filesDir, "todo.txt");
        try{
            items =new ArrayList<>(FileUtils.readLines(todoFile));
        }catch(IOException e){
            items=new ArrayList<>();//String
        }

    }


    private void writeItems(){
        File filesDir= getFilesDir();

        File todoFile=new File(filesDir, "todo.txt");
        try{
            FileUtils.writeLines(todoFile,items);
        }catch(IOException e){
            e.printStackTrace();
        }

    }


    // ActivityOne.java, time to handle the result of the sub-activity
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // REQUEST_CODE is defined above
        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE) {
            // Extract name value from result extras
            String editText = data.getExtras().getString("editText");
            items.remove(position);

            itemsAdapter.insert(editText,position);
            writeItems();







        }
    }

}
