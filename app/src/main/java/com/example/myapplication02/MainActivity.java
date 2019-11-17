package com.example.myapplication02;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.jar.Attributes;

import static android.widget.Toast.LENGTH_LONG;

public class MainActivity extends AppCompatActivity {
    EditText Name, phoneNo, EmailId;
    Button Insert, Delete, Update, View;
    FirebaseDatabase database;
    DatabaseReference myRef;
    private String string;
    private String name;
    private String phoneno;
    private String emailId;
    Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //FirebaseDatabase database = FirebaseDatabase.getInstance();
        //DatabaseReference myRef = database.getReference("message");

        Name = (EditText) findViewById(R.id.et1);
        phoneNo = (EditText) findViewById(R.id.et2);
        EmailId = (EditText) findViewById(R.id.et3);
        Insert = (Button) findViewById(R.id.btn1);
        Delete = (Button) findViewById(R.id.btn2);
        Update = (Button) findViewById(R.id.btn3);
        View = (Button) findViewById(R.id.btn4);
        Insertdata();
    }

    private void Insertdata() {
        database = FirebaseDatabase.getInstance();
        myRef = database.getReference("Data");

        Insert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {
                final String name = Name.getText().toString();
                final String emailid = EmailId.getText().toString();
                final String phoneno = phoneNo.getText().toString();
                final User user = new User(name, emailId, phoneno);
                myRef.child("Data").setValue(user).addOnSuccessListener(new OnSuccessListener <Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        Toast.makeText(getApplicationContext(), "Success", Toast.LENGTH_SHORT).show();
                    }

                }).addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {
                        Toast.makeText(getApplicationContext(), "Fail", LENGTH_LONG).show();
                    }
                });
                Delete.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(android.view.View v) {
                        deleteDatabase(name);
                    }
                });
            }

            private void deleteinformation(String Name, String phoneNo, String EmailId) {
                DatabaseReference user=FirebaseDatabase.getInstance().getReference("user").child(name);
                DatabaseReference phoneno=FirebaseDatabase.getInstance().getReference("phoneno").child(phoneNo);
                DatabaseReference emailid=FirebaseDatabase.getInstance().getReference("emailid").child(emailId);
                user.removeValue();
                phoneno.removeValue();
                emailid.removeValue();
                Toast.makeText(MainActivity.this,"Information deleted", LENGTH_LONG).show();

            }

            private boolean update(String name, String phoneno, String emailid) {
                DatabaseReference databaseReference=FirebaseDatabase.getInstance().getReference("user").child(name);
                User user=new User(name,phoneno,emailid);
                databaseReference.setValue(user);
                Toast.makeText(MainActivity.this,"Information Updated Successfully", LENGTH_LONG).show();
                return true;
            }


                });
        View.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(android.view.View v) {

                Intent i=new Intent(context,View.class);
                startActivity(i);
            }
        });
            }


    }



