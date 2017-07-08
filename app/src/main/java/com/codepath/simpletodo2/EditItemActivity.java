package com.codepath.simpletodo2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class EditItemActivity extends AppCompatActivity {
    String item;
    boolean focus;
    EditText editText;
    boolean hasFocus;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_item);
        item = getIntent().getStringExtra("item");
        focus=getIntent().getBooleanExtra("focus",hasFocus);
        editText =(EditText)findViewById(R.id.editText);
        editText.setText(item);

        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View editText, boolean hasFocus) {
                if(hasFocus){
                    ((EditText) editText).setSelection(((EditText) editText).getText().length());
                }
            }
        });
        //Intent data = new Intent();
        //setResult(RESULT_OK,data);
        //finish();


    }

    // ActivityNamePrompt.java -- launched for a result
    public void onSubmit(View v) {
        EditText editText = (EditText) findViewById(R.id.editText);
        // Prepare data intent
        Intent data = new Intent();
        // Pass relevant data back as a result
        data.putExtra("editText", editText.getText().toString());
        // Activity finished ok, return the data
        setResult(RESULT_OK, data); // set result code and bundle data for response
        finish(); // closes the activity, pass data to parent
    }


}
