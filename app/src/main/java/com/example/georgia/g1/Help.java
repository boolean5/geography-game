package com.example.georgia.g1;

import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;


public class Help extends ActionBarActivity {

    WebView myWebView2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        //Back to main menu button
        menu.setDisplayHomeAsUpEnabled(true);

        myWebView2 = (WebView) findViewById(R.id.webview2);
        myWebView2.setBackgroundColor(Color.parseColor("#add8e6"));
        String text = "<html><body>"
                + "<p align=\"justify\">"
                +"<b>"+"<font size=\"5\">General Instructions</font>"+"</b>"
                +"<br><br>"
                + "<i>"+"Geography Game"+"</i>"+" is a knowledge challenge that aims to improve your geography skills."
                + " You will be shown the political map of a continent, with no other information but the borders of it's countries. Once you start playing, a country-specific piece of information (country name, capital name or flag) will appear at the top right corner of the screen. All you have to do is touch the area of the corresponding country on the map. If the association you have made is correct the country will be colored in green. You will notice a timer, displayed at the top left corner of the screen. Challenge yourself or your friends and make new highscores!"
                + "<br><br>"+"<b>"+"<font size=\"5\">Game Settings</font>"+"</b>"
                + "<br><br>"
                + "<b><font size=\"3\">1. Identifiers</font></b>"
                + "<br><br>"
                +"Through the <i>Settings</i> option of the main menu you can select your preferred identifier type. You can choose among <i>country names</i>, <i>capital names</i> and <i>flags</i>."
                + "<br><br>"
                + "<b><font size=\"3\">2. Difficulty Levels</font></b>"
                + "<br><br>"
                + "There are 3 difficulty levels to choose from, accessible through the <i>Settings</i> option of the main menu. In the <i>Easy</i> level you are allowed to make any number of mistakes. However, in the <i>Medium</i> difficulty level you are only allowed 3 and in the <i>Hard</i> level none. In the Medium level the number of mistakes you are allowed to make at each moment is displayed at the bottom right corner of the screen."
                + "</p> "
                + "</body></html>";

        myWebView2.loadData(text, "text/html", "utf-8");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_help, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        /*//noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }*/

        return super.onOptionsItemSelected(item);
    }
}
