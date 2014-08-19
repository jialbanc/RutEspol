package com.example.rutespol;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.*;
import android.view.View;
import android.content.Intent;
import com.example.rutespol.R;

public class MainActivity extends Activity implements OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View rutas= findViewById(R.id.rutasIngreso);
        rutas.setOnClickListener(this);

        View paraderos= findViewById(R.id.buscarParadero);
        paraderos.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View arg0) {
        // TODO Auto-generated method stub
        if(arg0.getId()==findViewById(R.id.rutasIngreso).getId()){
           Intent i = new Intent(this,EscogerRuta.class);
           startActivity(i);
        }


        if(arg0.getId()==findViewById(R.id.buscarParadero).getId()){
            Intent i = new Intent(this, MapsParadero.class);
            startActivity(i);
        }

    }
}

