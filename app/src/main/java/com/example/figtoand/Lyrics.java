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
//
public class Lyrics extends AppCompatActivity {
    EditText edtArtistName,edtSongName;
    Button btnGetLyrics;
    TextView txtLyrics;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        edtArtistName = findViewById(R.id.edtArtistName);
        edtSongName = findViewById(R.id.edtSongName);
        btnGetLyrics = findViewById(R.id.btnGetLyrics);
        txtLyrics = findViewById(R.id.txtLyrics);

        btnGetLyrics.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "This Button is Tapped", Toast.LENGTH_SHORT).show();
            String url = "https://api.lyrics.ovh/v1/" + edtArtistName.getText().toString() + "/" +edtSongName.getText().toString();
            url.replace(" ","20%");
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