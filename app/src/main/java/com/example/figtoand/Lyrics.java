package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;

import java.net.URL;

//
public class Lyrics extends AppCompatActivity {
    EditText edtArtistName,edtSongName;
    Button btnGetLyrics;
    TextView txtLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getSupportActionBar().hide();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        edtArtistName = findViewById(R.id.edtArtistName);
        edtSongName = findViewById(R.id.edtSongName);
        btnGetLyrics = findViewById(R.id.btnGetLyrics);
        txtLyrics = findViewById(R.id.txtLyrics);

        btnGetLyrics.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "Fetching Lyrics in a sec", Toast.LENGTH_SHORT).show();
            String url = "https://musiva.herokuapp.com/lyrics/?artist=" + edtArtistName.getText().toString() + "&song=" + edtSongName.getText().toString();
            // String is immutable
            // therefore creating another variable
            String var = url.replace(" ","");
            System.out.print(var);
            RequestQueue requestQueue = Volley.newRequestQueue(Lyrics.this);

            JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, response -> {
                try{
                    txtLyrics.setText(response.getString("lyrics"));

                }catch (JSONException e){
                    e.printStackTrace();
                }
            },
                    error -> {

                    });

            requestQueue.add(jsonObjectRequest);
        });
    }

}