package com.example.ankurjangra.be_project;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {
    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button _btnsign,view;
    EditText fname,lname,phone,email,username,password,dob,addr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        openHelper=new DatabaseHelper(this);
        _btnsign=(Button)findViewById(R.id.button_sign);
        fname=(EditText)findViewById(R.id.etfirst);
        lname=(EditText)findViewById(R.id.etlast);
        phone=(EditText)findViewById(R.id.etno);
        email=(EditText)findViewById(R.id.eteid);
        username=(EditText)findViewById(R.id.etuser);
        password=(EditText)findViewById(R.id.etpas);
        dob=(EditText)findViewById(R.id.etdob);
        addr=(EditText)findViewById(R.id.etaddress);
        _btnsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                db=openHelper.getWritableDatabase();
                String fn=fname.getText().toString();
                String ln=lname.getText().toString();
                String ph=phone.getText().toString();
                String em=email.getText().toString();
                String usr=username.getText().toString();
                String pwd=password.getText().toString();
                String d=dob.getText().toString();
                String ad=addr.getText().toString();

                insertdata(fn,ln,ph,em,usr,pwd,d,ad);
                Toast.makeText(getApplicationContext(),"Registered Successfully",Toast.LENGTH_LONG).show();


                Intent intent=new Intent(Signup.this,Menu.class);
                startActivity(intent);
            }
        });
    }



    public void insertdata(String fn, String ln,String ph, String em, String usr,String pwd,String d,String ad){

        ContentValues contentValues=new ContentValues();
        contentValues.put(DatabaseHelper.COL_1,fn);
        contentValues.put(DatabaseHelper.COL_2,ln);
        contentValues.put(DatabaseHelper.COL_3,ph);
        contentValues.put(DatabaseHelper.COL_4,em);
        contentValues.put(DatabaseHelper.COL_5,usr);
        contentValues.put(DatabaseHelper.COL_6,pwd);
        contentValues.put(DatabaseHelper.COL_7,d);
        contentValues.put(DatabaseHelper.COL_8,ad);

        long id= db.insert(DatabaseHelper.TABLE_NAME,null,contentValues);
    }
    }

