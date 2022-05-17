package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.figtoand.data.MyDbHandler;
import com.example.figtoand.model.Contact;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
          setContentView(R.layout.activity_main);


    }


    public void onClick_lyrics(View v){
            // Intent is what you use to start another activity
            Intent intent = new Intent(this, Lyrics.class);
            startActivity(intent);
        }
    public void onClick_guitar(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, Guitar_Chords.class);
        startActivity(intent);
    }
    public void onClick_piano(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, Piano_Chords.class);
        startActivity(intent);
    }
    public void onClick_reference(View v){
        // Intent is what you use to start another activity
        Intent intent = new Intent(this, Reference.class);
        startActivity(intent);
    }
    

}