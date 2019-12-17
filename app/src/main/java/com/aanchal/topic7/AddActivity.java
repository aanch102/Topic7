package com.aanchal.topic7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.IOException;
import java.io.PrintStream;

public class AddActivity extends AppCompatActivity {
    EditText etadd,etmeaning;
    Button btnadd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        etadd=findViewById(R.id.etadd);
        etmeaning=findViewById(R.id.etmeaning);
        btnadd=findViewById(R.id.btnadd);

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });
    }

    private void save(){
        try{
            PrintStream printStream=new PrintStream(openFileOutput("words.txt",MODE_PRIVATE|MODE_APPEND));
            printStream.println(etadd.getText().toString()+" -> "+etmeaning.getText().toString());
            Toast.makeText(this,"save to"+getFilesDir(),Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Log.d("Dictionary app","error:"+e.toString());
        }
    }
}
