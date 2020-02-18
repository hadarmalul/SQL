package com.example.sql;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Switch;

public class MainActivity extends AppCompatActivity {

    SQLiteDatabase db;
    HelperDB hlp;
    EditText etNAME, etADD, etNUM, etHNUM, etMNAME, etMNUM, etDNAME, etDNUM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNAME = (EditText) findViewById(R.id.etNAME);
        etADD = (EditText) findViewById(R.id.etADD);
        etNUM = (EditText) findViewById(R.id.etNUM);
        etHNUM = (EditText) findViewById(R.id.etHnum);
        etMNAME = (EditText) findViewById(R.id.etMNAME);
        etMNUM = (EditText) findViewById(R.id.etMNUM);
        etDNAME = (EditText) findViewById(R.id.etDNAME);
        etDNUM = (EditText) findViewById(R.id.etDNUM);

        hlp = new HelperDB(this);
        db = hlp.getWritableDatabase();
        db.close();
    }

    public void enterdata(View view) {

        String name, address, strNum, strHnum, mName, strMnum, dName, strDnum;
        int num, Hnum, Mnum, Dnum;
        name = etNAME.getText().toString();
        address = etADD.getText().toString();
        strNum = etNUM.getText().toString();
        num = Integer.parseInt(etNUM.getText().toString());
        strHnum = etHNUM.getText().toString();
        Hnum = Integer.parseInt(etHNUM.getText().toString());
        mName = etMNAME.getText().toString();
        strMnum = etMNUM.getText().toString();
        Mnum = Integer.parseInt(etMNUM.getText().toString());
        dName = etDNAME.getText().toString();
        strDnum = etDNUM.getText().toString();
        Dnum = Integer.parseInt(etDNUM.getText().toString());

        ContentValues cv = new ContentValues();
        cv.put(Users.NAME, name);
        cv.put(Users.ADDRESS, address);
        cv.put(Users.PHONE, num);
        cv.put(Users.HOME_P, Hnum);
        cv.put(Users.MOM_NAME, mName);
        cv.put(Users.MOM_NUM, Mnum);
        cv.put(Users.DAD_NAME, dName);
        cv.put(Users.DAD_NUM, Dnum);

        db = hlp.getWritableDatabase();
        db.insert(Users.TABLE_USERS, null, cv);
        db.close();
    }

    public boolean onCreateOptionsMenu (Menu menu){
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    public boolean onOptionsItemSelected (MenuItem item){
        String st = item.getTitle().toString();
        if (st.equals("Enter Data")) {
            Intent si = new Intent(this, MainActivity.class);
            startActivity(si);
        }
        if (st.equals("Info")){
            Intent si = new Intent(this, InfoActivity.class);
            startActivity(si);
        }
        if(st.equals("Grades")){
            Intent si = new Intent(this, Grades.class);
            startActivity(si);
        }
        if (st.equals("Sort")){
            Intent si = new Intent(this, SortActivity.class);
            startActivity(si);
        }
        return true;
    }
}
