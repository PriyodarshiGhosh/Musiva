package com.example.figtoand;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.figtoand.data.MyDbHandler;
import com.example.figtoand.model.Contact;

import java.util.ArrayList;
import java.util.List;

public class Lyrics extends AppCompatActivity {
    ListView listView;
    String[] refarr = {"circle_of_fifths","power of A4","dynamics & harmonics"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lyrics);
        MyDbHandler db=new MyDbHandler(Lyrics.this);
        Contact harry=new Contact();
        harry.setId(1);
        harry.setPhoneNumber("999");
        harry.setName("harry");
        db.addContact(harry);

        int noofaffectedrows=db.updateContact(harry);
        Log.d("dbharry1","affected rows "+noofaffectedrows);

        Log.d("dbharry1","query being run is "+harry.getPhoneNumber()+" "+harry.getId());
        db.deleteContactById(1);
        db.deleteContactById(2);
        ArrayList<String>contacts=new ArrayList<String>();
        listView=findViewById(R.id.listView);
        List<Contact> allContacts=db.getAllContacts();

        for(Contact contact:allContacts){
            Log.d("dbaryan",contact.getName()+contact.getPhoneNumber()+" "+contact.getId());
            contacts.add(contact.getName()+" ("+contact.getPhoneNumber()+")");
        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,refarr);
        listView.setAdapter(arrayAdapter);
        Log.d("dbharry","you have "+db.getCount()+" data");
    }
}