package com.example.week8;

import android.content.Context;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import java.io.*;
import android.content.Context;
import android.preference.PreferenceManager;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    public static final String DEFAULT_FILENAME = "textedit.txt";
    private String fileName = DEFAULT_FILENAME;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override

    public void onStart() {
        super.onStart();
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(getApplicationContext());
        fileName = prefs.getString("filename", DEFAULT_FILENAME);

    }

    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item)
    {
        if(item.getItemId() == R.id.save)
        {
            EditText et = (EditText)findViewById(R.id.et1);
            try
            {
                 PrintWriter pw = new PrintWriter( new FileWriter("data.txt"));

               pw.println(et);
                pw.close(); // close the file to ensure data is flushed to file
                return true;
            }
            catch(IOException e)
            {
                new AlertDialog.Builder(this).setPositiveButton("OK", null).
                        setMessage("ERROR: " + e).show();
            }

        }
        else if(item.getItemId() == R.id.load){

    }
        return false;
    }

}
