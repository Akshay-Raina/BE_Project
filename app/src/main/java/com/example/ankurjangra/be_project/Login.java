package com.example.ankurjangra.be_project;

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

public class Login extends AppCompatActivity {

    SQLiteDatabase db;
    SQLiteOpenHelper openHelper;
    Button bt;
    EditText _etpas,_etusr;
    Cursor cursor;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        openHelper=new DatabaseHelper(this);
        db=openHelper.getReadableDatabase();
        bt=(Button)findViewById(R.id.button_signin);
        _etpas=(EditText)findViewById(R.id.etpass);
        _etusr=(EditText)findViewById(R.id.etuser);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user= _etpas.getText().toString();
                String pass= _etpas.getText().toString();
                cursor=db.rawQuery("SELECT * FROM "+ DatabaseHelper.TABLE_NAME +" WHERE "+ DatabaseHelper.COL_5 +"=? AND "+ DatabaseHelper.COL_6 + "=?",new String[]{user,pass});
                if(cursor!= null)
                {
                    if(cursor.getCount()>0){
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(),"login Successfull",Toast.LENGTH_LONG).show();
                        Intent intent=new Intent(Login.this,Menu.class);
                        startActivity(intent);
                    }else {
                        Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_LONG).show();
                    }
                }

            }
        });
    }
}
