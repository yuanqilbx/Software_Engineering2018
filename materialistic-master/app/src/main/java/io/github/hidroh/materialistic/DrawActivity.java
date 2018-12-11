package io.github.hidroh.materialistic;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.view.View;
import android.content.Intent;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import io.github.hidroh.materialistic.accounts.UserServices;

public class DrawActivity extends AppCompatActivity {

    //String[] arr={"A","二","3","four"};
    public EditText word;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_draw);
        word=(EditText)findViewById(R.id.drawtext);

    }

    public int add(int a,int b)
    {
        return a+b;
    }

    public void goBack(View view){
        Intent intent=new Intent(this, DrawerActivity.class);
        startActivity(intent);
    }


    public String toData()
    {
        String saveText=word.getText().toString().trim();
        FileOutputStream out;
        try {
            out = openFileOutput("data.txt", MODE_PRIVATE);
            out.write(saveText.getBytes());
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
        return saveText;
    }

    public String getData()
    {
        String content="";
        try{
            FileInputStream in=openFileInput("data.txt");
            byte [] buffer=new byte[in.available()];
            in.read(buffer);
            content=new String(buffer);
            in.close();
        }catch(Exception e)
        {
            e.printStackTrace();;
        }
        return content;
    }

    public void mySave(View view){

        /*
        String saveText=word.getText().toString().trim();
        FileOutputStream out;
        try {
            out = openFileOutput("data.txt", MODE_PRIVATE);
            out.write(saveText.getBytes());
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }*/
        toData();
        Toast.makeText(DrawActivity.this,"数据保存成功",Toast.LENGTH_SHORT).show();

    }

    public void myRead(View view)
    {
        /*String content="";
        try{
            FileInputStream in=openFileInput("data.txt");
            byte [] buffer=new byte[in.available()];
            in.read(buffer);
            content=new String(buffer);
            in.close();
        }catch(Exception e)
        {
            e.printStackTrace();;
        }*/
        String content=getData();
        Toast.makeText(DrawActivity.this,content,Toast.LENGTH_SHORT).show();
        word.setText(content);

    }
}
