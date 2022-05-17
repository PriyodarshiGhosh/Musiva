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
        Contact harry1=new Contact();
        harry1.setId(2);
        harry1.setPhoneNumber("999");
        harry1.setName("harry1");
        db.addContact(harry1);
        Contact harry2=new Contact();
        harry2.setId(1);
        harry2.setPhoneNumber("999");
        harry2.setName("harry2");
        db.addContact(harry2);
        harry.setId(1);
        harry.setName("harrynew");
        harry.setPhoneNumber("0000");
        int noofaffectedrows=db.updateContact(harry);
        Log.d("dbharry1","affected rows "+noofaffectedrows);

        Log.d("dbharry1","query being run is "+harry.getPhoneNumber()+" "+harry.getId());
        db.deleteContactById(1);
        db.deleteContactById(2);
        ArrayList<String>contacts=new ArrayList<>();
        listView=findViewById(R.id.listView);
        List<Contact> allContacts=db.getAllContacts();

        for(Contact contact:allContacts){
            Log.d("dbaryan",contact.getName()+contact.getPhoneNumber()+" "+contact.getId());
            contacts.add(contact.getName()+" ("+contact.getPhoneNumber()+")");
        }
        ArrayAdapter<String>arrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,contacts);
        listView.setAdapter(arrayAdapter);
        Log.d("dbharry","you have "+db.getCount()+" data");
    }
}