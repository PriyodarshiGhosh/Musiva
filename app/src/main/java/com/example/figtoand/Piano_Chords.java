package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

//

public class Piano_Chords extends AppCompatActivity {
    EditText edtRootNote,edtModalVariation;
    Button btnGetGChord;
    ImageView imageview;

//    public static Bitmap getBitmapFromURL(String src) {
//        try {
//            Log.e("src",src);
//            URL url = new URL(src);
//            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
//            connection.setDoInput(true);
//            connection.connect();
//            InputStream input = connection.getInputStream();
//            Bitmap myBitmap = BitmapFactory.decodeStream(input);
//            Log.e("Bitmap","returned");
//            return myBitmap;
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.e("Exception",e.getMessage());
//            return null;
//        }
//    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_piano_chords);
        imageview = findViewById(R.id.imageView2);
        edtRootNote = findViewById(R.id.edtRoot);
        edtModalVariation = findViewById(R.id.edtMode);
        btnGetGChord = findViewById(R.id.btnGetGChord);

        btnGetGChord.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Fetching Piano Chords", Toast.LENGTH_SHORT).show();
            String root = edtRootNote.getText().toString();
            String mode = edtModalVariation.getText().toString();
            String URL = "https://chordify.net/img/diagrams/piano/"+root+"_"+mode+".png";
            // String is immutable
            // therefore creating another variable
            String var = URL.replace(" ","-");
            System.out.print(var);
            new ImageLoadTask(var, imageview).execute();


        });
    }

}