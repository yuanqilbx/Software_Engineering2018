package io.github.hidroh.materialistic;

import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.accounts.Account;
import android.accounts.AccountManager;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.content.Intent;
import android.widget.Toast;
import android.graphics.Bitmap;
import android.widget.ImageView;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;
import java.io.IOException;




public class DayActivity extends AppCompatActivity {

    ImageView imgFavorite;
    int having;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_day);
        having=0;
        imgFavorite = (ImageView)findViewById(R.id.imageView2);
        imgFavorite.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                open();
            }
        });
        try{
            FileInputStream in=openFileInput("day.txt");
            byte [] buffer=new byte[in.available()];
            in.read(buffer);
            String tmp=buffer.toString();
            having=Integer.parseInt(tmp);
            in.close();
        }catch(Exception e)
        {
            e.printStackTrace();;
        }

    }

    public void myBackClick(View view){
        Intent intent=new Intent(this, DrawerActivity.class);
        startActivity(intent);
    }

    public void open()
    {   if(having!=0)
        {
            String str="已签到！";
            Toast t=Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT);
            t.show();

        }else
        {
            Intent intent=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            startActivityForResult(intent,0);
            String str="签到成功！";
            Toast t=Toast.makeText(getApplicationContext(),str,Toast.LENGTH_SHORT);
            t.show();
        }
        having=1;
        String saveText=String.valueOf(having);
        FileOutputStream out;
        try {
            out = openFileOutput("day.txt", MODE_PRIVATE);
            out.write(saveText.getBytes());
            out.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        // TODO Auto-generated method stub
        super.onActivityResult(requestCode, resultCode, data);
        Bitmap bp = (Bitmap) data.getExtras().get("data");
        imgFavorite.setImageBitmap(bp);
    }




}
