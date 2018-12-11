package io.github.hidroh.materialistic;

import android.view.View;
import android.widget.EditText;

import org.junit.Test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

public class DrawActivityTest {
    DrawActivity draw=mock(DrawActivity.class);

    @Test
    public void add() {
        int a=1,b=2;
        int r=draw.add(a,b);
        assertEquals(r,3);
    }

    @Test
    public void add1() {
        int a=1,b=2;
        int r=draw.add(a,b);
        assertEquals(r,2);
    }

    @Test
    public void mySave() {
        View t=draw.findViewById(R.id.button3);
        draw.word.setText("abc");
        draw.mySave(t);
        String str="";
        str=draw.word.getText().toString().trim();
        assertEquals(str,draw.getData());
    }

    @Test
    public void mySave1() {
        View t=draw.findViewById(R.id.button3);
        /*draw.word=(EditText)draw.findViewById(R.id.drawtext);
        draw.word.setText("abc");*/
        draw.mySave(t);
        verify(draw).mySave(t);
        /*String tmp="abc";
        String str="";
        str=draw.word.getText().toString().trim();
        assertEquals(str,tmp);*/
    }



    @Test
    public void myRead() {
        View t=draw.findViewById(R.id.button3);
        draw.myRead(t);
        verify(draw).myRead(t);

    }

    @Test
    public void myRead1() {
        View t=draw.findViewById(R.id.button3);
        //draw.myRead(t);
        verify(draw).myRead(t);

    }
}