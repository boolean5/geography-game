package com.example.georgia.g1;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.view.View;
import android.widget.AdapterView;
import android.content.Intent;


public class MainActivity extends ActionBarActivity {

    ListView list;


    String[] web = {
            "Play",
            "Settings",
            "Highscores",
            "Help",
            "About"
    } ;


    Integer[] imageId = {
            R.drawable.play,
            R.drawable.set,
            R.drawable.highscores,
            R.drawable.help,
            R.drawable.info

    };

    String[] classNames = {
            "Play",
            "Settings",
            "Highscores",
            "Help",
            "About"
    } ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        MainMenu adapter = new
                MainMenu(MainActivity.this, web, imageId);
        list=(ListView)findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                //Open new Activities
                //Toast.makeText(MainActivity.this, "You Clicked at " +web[+ position], Toast.LENGTH_SHORT).show();
                //super.onItemClick(parent, view, position, id);//FIXME
                String openClass = classNames[position];
                try{
                    Class selected = Class.forName("com.example.georgia.g1."+ openClass);
                    Intent selectedIntent = new Intent(MainActivity.this, selected); //FIXME
                    startActivity(selectedIntent);

                }catch (ClassNotFoundException e){
                    e.printStackTrace();
                }

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
