package com.example.rutespol;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View.*;
import android.view.View;
import android.content.Intent;
import android.widget.TextView;

public class MainMenu extends Activity implements OnClickListener{

    private Dialog startMenuDialog;

    private Dialog chooseRouteDialog;

    private Dialog chooseNorthADialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mainmenu_layout);

        createStartMenuDialog();
        createChooseRouteDialog();
        createChooseNorthADialog();
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);

        startMenuDialog.show();
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
    }

    public void createStartMenuDialog(){
        startMenuDialog = new Dialog(MainMenu.this,R.style.Menu);
        startMenuDialog.setContentView(R.layout.menu_dialog);
        setStartButtonAction();
    }

    private void setStartButtonAction(){
        startMenuDialog.findViewById(R.id.rutasIngreso).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                chooseRouteDialog.show();
                startMenuDialog.dismiss();
            }
        });
        startMenuDialog.findViewById(R.id.buscarParadero).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsParadero.class);
                startActivity(i);
                startMenuDialog.dismiss();
            }
        });
    }

    public void createChooseRouteDialog(){
        chooseRouteDialog = new Dialog(MainMenu.this,R.style.Menu);
        chooseRouteDialog.setContentView(R.layout.choose_rout_dialog);
        setChooseRouteDialog();
    }

    private void setChooseRouteDialog() {
        chooseRouteDialog.findViewById(R.id.ruta_norte_a).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                chooseNorthADialog.show();
                chooseRouteDialog.dismiss();
            }
        });
        chooseRouteDialog.findViewById(R.id.ruta_norte_b).setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this, MapsActivity.class);
                i.putExtra("name", "perimetral");
                startActivity(i);
                chooseRouteDialog.dismiss();
            }
        });
        chooseRouteDialog.findViewById(R.id.ruta_sur_este).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","acacias");
                startActivity(i);
                chooseRouteDialog.dismiss();
            }
        });
        chooseRouteDialog.findViewById(R.id.ruta_sur_oeste).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","portete");
                startActivity(i);
                chooseRouteDialog.dismiss();
            }
        });
        chooseRouteDialog.findViewById(R.id.ruta_centro).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","centro");
                startActivity(i);
                chooseRouteDialog.dismiss();
            }
        });
        chooseRouteDialog.findViewById(R.id.ruta_duran).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","avPrincipal");
                startActivity(i);
                chooseRouteDialog.dismiss();
            }
        });
    }

    private void createChooseNorthADialog() {
        chooseNorthADialog = new Dialog(MainMenu.this,R.style.Menu);
        chooseNorthADialog.setContentView(R.layout.choose_nortea_dialog);
        setChooseNorthADialog();
    }

    private void setChooseNorthADialog() {
        chooseNorthADialog.findViewById(R.id.ruta_norte_1).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","norte1");
                startActivity(i);
                chooseNorthADialog.dismiss();
            }
        });
        chooseNorthADialog.findViewById(R.id.ruta_norte_2).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","norte2");
                startActivity(i);
                chooseNorthADialog.dismiss();
            }
        });
        chooseNorthADialog.findViewById(R.id.ruta_norte_3).setOnClickListener(new OnClickListener(){
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainMenu.this,MapsActivity.class);
                i.putExtra("name","norte3");
                startActivity(i);
                chooseNorthADialog.dismiss();
            }
        });
    }

    @Override
    public void finish() {
        super.finish();
    }
}

