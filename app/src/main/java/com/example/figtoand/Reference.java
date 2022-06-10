package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ArrayAdapter;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import java.util.ArrayList;

public class Reference extends AppCompatActivity {
    EditText edtMusicTerm;
    Button btnGetMusic;
    WebView wbvMusic;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reference);
        edtMusicTerm = findViewById(R.id.edtMusicTerm);
        btnGetMusic = findViewById(R.id.btnGetMusic);
        wbvMusic = (WebView) findViewById(R.id.wbvMusic);


        btnGetMusic.setOnClickListener(v -> {
            Toast.makeText(getApplicationContext(), "This Button is Tapped", Toast.LENGTH_SHORT).show();
            wbvMusic.setWebViewClient(new WebViewClient());
            wbvMusic.loadUrl("http://en.m.wikipedia.org/wiki/"+edtMusicTerm.getText().toString());
        });
    }
}