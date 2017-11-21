package com.example.georgia.g1;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class Highscores extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_highscores);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        //Back to main menu button
        menu.setDisplayHomeAsUpEnabled(true);

        //Load Highscores from preferences
        String filename = Play.filename;
        SharedPreferences someData;
        int score1, score2, score3, score4, score5;
        String score1String = null, score2String = null, score3String = null, score4String = null, score5String = null;
        String name1 = null, name2 = null, name3 = null, name4 = null, name5 = null;
        someData = getSharedPreferences(filename, 0);

        //Easy

        score1 = someData.getInt("score1", Integer.MAX_VALUE);
        score2 = someData.getInt("score2", Integer.MAX_VALUE);
        score3 = someData.getInt("score3", Integer.MAX_VALUE);
        score4 = someData.getInt("score4", Integer.MAX_VALUE);
        score5 = someData.getInt("score5", Integer.MAX_VALUE);

        name1 = someData.getString("name1", "");
        name2 = someData.getString("name2", "");
        name3 = someData.getString("name3", "");
        name4 = someData.getString("name4", "");
        name5 = someData.getString("name5", "");

        if (score1 != Integer.MAX_VALUE) {
            name1 = "   1. "+name1+"         ";
            TextView textView = (TextView) findViewById(R.id.name1);
            textView.setText(name1);
            score1String =  Integer.toString(score1) + " sec ";
            textView = (TextView) findViewById(R.id.score1);
            textView.setText(score1String);
        }
        if (score2 != Integer.MAX_VALUE) {
            name2 = "   2. "+name2+"         ";
            TextView textView = (TextView) findViewById(R.id.name2);
            textView.setText(name2);
            score2String = Integer.toString(score2) + " sec ";
            textView = (TextView) findViewById(R.id.score2);
            textView.setText(score2String);
        }
        if (score3 != Integer.MAX_VALUE) {
            name3 = "   3. "+name3+"         ";
            TextView textView = (TextView) findViewById(R.id.name3);
            textView.setText(name3);
            score3String = Integer.toString(score3) + " sec ";
            textView = (TextView) findViewById(R.id.score3);
            textView.setText(score3String);
        }
        if (score4 != Integer.MAX_VALUE) {
            name4 = "   4. "+name4+"         ";
            TextView textView = (TextView) findViewById(R.id.name4);
            textView.setText(name4);
            score4String = Integer.toString(score4) + " sec ";
            textView = (TextView) findViewById(R.id.score4);
            textView.setText(score4String);
        }
        if (score5 != Integer.MAX_VALUE) {
            name5 = "   5. "+name5+"         ";
            TextView textView = (TextView) findViewById(R.id.name5);
            textView.setText(name5);
            score5String = Integer.toString(score5) + " sec ";
            textView = (TextView) findViewById(R.id.score5);
            textView.setText(score5String);
        }

        //Medium

        score1 = someData.getInt("score1medium", Integer.MAX_VALUE);
        score2 = someData.getInt("score2medium", Integer.MAX_VALUE);
        score3 = someData.getInt("score3medium", Integer.MAX_VALUE);
        score4 = someData.getInt("score4medium", Integer.MAX_VALUE);
        score5 = someData.getInt("score5medium", Integer.MAX_VALUE);

        name1 = someData.getString("name1medium", "");
        name2 = someData.getString("name2medium", "");
        name3 = someData.getString("name3medium", "");
        name4 = someData.getString("name4medium", "");
        name5 = someData.getString("name5medium", "");

        if (score1 != Integer.MAX_VALUE) {
            name1 = "   1. "+name1+"         ";
            TextView textView = (TextView) findViewById(R.id.name1medium);
            textView.setText(name1);
            score1String =  Integer.toString(score1) + " sec ";
            textView = (TextView) findViewById(R.id.score1medium);
            textView.setText(score1String);
        }
        if (score2 != Integer.MAX_VALUE) {
            name2 = "   2. "+name2+"         ";
            TextView textView = (TextView) findViewById(R.id.name2medium);
            textView.setText(name2);
            score2String = Integer.toString(score2) + " sec ";
            textView = (TextView) findViewById(R.id.score2medium);
            textView.setText(score2String);
        }
        if (score3 != Integer.MAX_VALUE) {
            name3 = "   3. "+name3+"         ";
            TextView textView = (TextView) findViewById(R.id.name3medium);
            textView.setText(name3);
            score3String = Integer.toString(score3) + " sec ";
            textView = (TextView) findViewById(R.id.score3medium);
            textView.setText(score3String);
        }
        if (score4 != Integer.MAX_VALUE) {
            name4 = "   4. "+name4+"         ";
            TextView textView = (TextView) findViewById(R.id.name4medium);
            textView.setText(name4);
            score4String = Integer.toString(score4) + " sec ";
            textView = (TextView) findViewById(R.id.score4medium);
            textView.setText(score4String);
        }
        if (score5 != Integer.MAX_VALUE) {
            name5 = "   5. "+name5+"         ";
            TextView textView = (TextView) findViewById(R.id.name5medium);
            textView.setText(name5);
            score5String = Integer.toString(score5) + " sec ";
            textView = (TextView) findViewById(R.id.score5medium);
            textView.setText(score5String);
        }


        //Hard

        score1 = someData.getInt("score1hard", Integer.MAX_VALUE);
        score2 = someData.getInt("score2hard", Integer.MAX_VALUE);
        score3 = someData.getInt("score3hard", Integer.MAX_VALUE);
        score4 = someData.getInt("score4hard", Integer.MAX_VALUE);
        score5 = someData.getInt("score5hard", Integer.MAX_VALUE);

        name1 = someData.getString("name1hard", "");
        name2 = someData.getString("name2hard", "");
        name3 = someData.getString("name3hard", "");
        name4 = someData.getString("name4hard", "");
        name5 = someData.getString("name5hard", "");

        if (score1 != Integer.MAX_VALUE) {
            name1 = "   1. "+name1+"         ";
            TextView textView = (TextView) findViewById(R.id.name1hard);
            textView.setText(name1);
            score1String =  Integer.toString(score1) + " sec ";
            textView = (TextView) findViewById(R.id.score1hard);
            textView.setText(score1String);
        }
        if (score2 != Integer.MAX_VALUE) {
            name2 = "   2. "+name2+"         ";
            TextView textView = (TextView) findViewById(R.id.name2hard);
            textView.setText(name2);
            score2String = Integer.toString(score2) + " sec ";
            textView = (TextView) findViewById(R.id.score2hard);
            textView.setText(score2String);
        }
        if (score3 != Integer.MAX_VALUE) {
            name3 = "   3. "+name3+"         ";
            TextView textView = (TextView) findViewById(R.id.name3hard);
            textView.setText(name3);
            score3String = Integer.toString(score3) + " sec ";
            textView = (TextView) findViewById(R.id.score3hard);
            textView.setText(score3String);
        }
        if (score4 != Integer.MAX_VALUE) {
            name4 = "   4. "+name4+"         ";
            TextView textView = (TextView) findViewById(R.id.name4hard);
            textView.setText(name4);
            score4String = Integer.toString(score4) + " sec ";
            textView = (TextView) findViewById(R.id.score4hard);
            textView.setText(score4String);
        }
        if (score5 != Integer.MAX_VALUE) {
            name5 = "   5. "+name5+"         ";
            TextView textView = (TextView) findViewById(R.id.name5hard);
            textView.setText(name5);
            score5String = Integer.toString(score5) + " sec ";
            textView = (TextView) findViewById(R.id.score5hard);
            textView.setText(score5String);
        }



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_highscores, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }
}
