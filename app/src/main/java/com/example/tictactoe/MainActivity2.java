package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity2 extends AppCompatActivity {
    public static final String MSG="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }
    public void playGame(View view){
        Intent intent=new Intent(this,MainActivity.class);
        EditText editText1=findViewById(R.id.editText1);
        EditText editText2=findViewById(R.id.editText2);
        String message=editText1.getText().toString();
        String message2=editText2.getText().toString();
        intent.putExtra(MSG,message);
        intent.putExtra(MSG,message2);
        startActivity(intent);

    }
}