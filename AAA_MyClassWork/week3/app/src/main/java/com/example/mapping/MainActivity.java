package com.example.mapping;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View.OnClickListener;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;
import android.widget.Button;
import org.osmdroid.config.Configuration;
import org.osmdroid.tileprovider.tilesource.TileSourceFactory;
import org.osmdroid.util.GeoPoint;
import org.osmdroid.views.MapView;
import java.util.concurrent.atomic.AtomicInteger;

public class MainActivity extends AppCompatActivity implements OnClickListener {

    MapView mv;
    double lat = 50.8982352;
    double lon = -1.400974;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Configuration.getInstance().load(this, PreferenceManager.getDefaultSharedPreferences(this));
        Button b = (Button)findViewById(R.id.btn1);
        b.setOnClickListener(this);


        mv = findViewById(R.id.map1);

        mv.setMultiTouchControls(true);
        mv.getController().setZoom(16.0);
        mv.getController().setCenter(new GeoPoint(lat, lon));


    }

    @Override
    public void onClick(View view) {
        EditText et1 = (EditText)findViewById(R.id.et1);
        EditText et2 = (EditText)findViewById(R.id.et2);
        double lat = Double.parseDouble(et1.getText().toString());
        double lon = Double.parseDouble(et2.getText().toString());
        mv.getController().setCenter(new GeoPoint(lat, lon));
    }
}
