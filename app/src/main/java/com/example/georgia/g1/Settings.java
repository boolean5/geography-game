package com.example.georgia.g1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.PopupMenu;
import android.widget.Toast;


public class Settings extends ActionBarActivity{


    String[] web = {
            "Identifier",
            "Difficulty Level"
    } ;

    ListView list;

    SharedPreferences.Editor editor;
    //filename from Play
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        //Back to main menu button
        menu.setDisplayHomeAsUpEnabled(true);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(Settings.this,
                android.R.layout.simple_list_item_1, android.R.id.text1, web);
        list=(ListView)findViewById(R.id.settingslist);
        list.setAdapter(adapter);
        registerForContextMenu(list);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                if (position == 0) {

                }

                openContextMenu(view);
            }
        });


    }



    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        String[] cont = {"Choose an Identifier:", "Choose a difficulty level:"};
        super.onCreateContextMenu(menu, v, menuInfo);
        AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo)menuInfo;
        menu.setHeaderTitle(cont[info.position]);
        MenuInflater inflater = getMenuInflater();
        if (info.position == 0) {
            inflater.inflate(R.menu.popup1, menu);
            someData = getSharedPreferences(Play.filename, 0);
            int option = someData.getInt("popup1OPTION", 0);
            if (option == 0)
                menu.findItem(R.id.country).setChecked(true);
            else if (option == 1)
                menu.findItem(R.id.capital).setChecked(true);
            else if (option == 2)
                menu.findItem(R.id.flag).setChecked(true);
        }
        else {
            inflater.inflate(R.menu.popup2, menu);
            someData = getSharedPreferences(Play.filename, 0);
            int option = someData.getInt("popup2OPTION", 0);
            if (option == 0)
                menu.findItem(R.id.easy).setChecked(true);
            else if (option == 1)
                menu.findItem(R.id.medium).setChecked(true);
            else if (option == 2)
                menu.findItem(R.id.hard).setChecked(true);
        }
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        //Save preferences
        editor = someData.edit();
        switch(item.getItemId()) {
            case(R.id.country):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup1OPTION", 0);
                }
                break;
            case(R.id.capital):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup1OPTION", 1);
                }
                break;
            case(R.id.flag):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup1OPTION", 2);
                }
                break;
            case(R.id.easy):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup2OPTION", 0);
                }
                break;
            case(R.id.medium):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup2OPTION", 1);
                }
                break;
            case(R.id.hard):
                if(item.isChecked()) {
                    //item.setChecked(false);
                } else {
                    item.setChecked(true);
                    editor.putInt("popup2OPTION", 2);
                }
                break;
            default:
                return super.onContextItemSelected(item);
        }
        editor.commit();
        return true;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       /* if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }


}
