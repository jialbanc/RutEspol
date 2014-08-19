package com.example.rutespol;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.SparseArray;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ExpandableListView;

import com.example.rutespol.R;

public class EscogerRuta extends Activity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_escoger_ruta);
        View norte1= findViewById(R.id.norte1);
        norte1.setOnClickListener(this);
        View norte2= findViewById(R.id.norte2);
        norte2.setOnClickListener(this);
        View norte3= findViewById(R.id.norte3);
        norte3.setOnClickListener(this);
        View perimetral= findViewById(R.id.perimetral);
        perimetral.setOnClickListener(this);
        View centro= findViewById(R.id.albanborja);
        centro.setOnClickListener(this);
        View acacias= findViewById(R.id.acacias);
        acacias.setOnClickListener(this);
        View perimetral2= findViewById(R.id.perimetral2);
        perimetral2.setOnClickListener(this);
        View portete= findViewById(R.id.portete);
        portete.setOnClickListener(this);
        View perimetral3= findViewById(R.id.perimetral3);
        perimetral3.setOnClickListener(this);
        View avPrincial= findViewById(R.id.avprincipal);
        avPrincial.setOnClickListener(this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.escoger_ruta, menu);
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
    public void onClick(View v) {
        Bundle b=new Bundle();
        String name;
       if(v.getId()==findViewById(R.id.norte1).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","norte1");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.norte2).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","norte2");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.norte3).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","norte3");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.perimetral).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","perimetral");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.albanborja).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","centro");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.acacias).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","acacias");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.perimetral2).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","perimetral");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.portete).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","portete");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.perimetral3).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","perimetral");
            startActivity(i);
        }
        if(v.getId()==findViewById(R.id.avprincipal).getId()){
            Intent i = new Intent(this,MapsActivity.class);
            i.putExtra("name","avPrincipal");
            startActivity(i);
        }


    }
}
