package com.example.georgia.g1;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.graphics.Color;


public class About extends ActionBarActivity {

    WebView myWebView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        //Back to main menu button
        menu.setDisplayHomeAsUpEnabled(true);

        myWebView = (WebView) findViewById(R.id.webview);
        myWebView.setBackgroundColor(Color.parseColor("#add8e6"));
        String text = "<html><body>"
                       + "<p align=\"justify\">"
                        + "<i>"+"Geography Game"+"</i>"+" is a knowledge challenge that aims to improve your geography skills."+" It was designed and implemented by boolean5 in May 2015. It has been created for educational purposes, as a project for the course "+"<i>"+"Interaction and Interface Design "+"</i>"+"at the "+"<i>"+"Faculty of Informatics of Barcelona (FIB)"+"</i>"+"."
                       + "<br><br>"+"The source code of this application is free to use for non-commercial purposes."+"</i>"
                        + "</p> "
                        + "</body></html>";
        
                myWebView.loadData(text, "text/html", "utf-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_about, menu);
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
