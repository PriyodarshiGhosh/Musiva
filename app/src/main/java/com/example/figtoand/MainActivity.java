package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        // to change status_bar color
//        Window window = this.getWindow();
//        window.setStatusBarColor(this.getResources().getColor(R.color.main_screen_bg_color));
          setContentView(R.layout.activity_main);

    }
//    ImageView imageView = (ImageView) findViewById(R.id.imageView3);
//imageView.setOnClickListener(new OnClickListener() {
//      @Override
//        public void onClick(View v) {
//            Intent intent = new Intent(this, Lyrics.class);
//            startActivity(intent);
//        }
//    });

        public void onClick(View v){
            // Intent is what you use to start another activity
            Intent intent = new Intent(this, Lyrics.class);
            startActivity(intent);
        }
    

}