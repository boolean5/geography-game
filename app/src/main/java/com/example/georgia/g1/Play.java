package com.example.georgia.g1;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.preference.PreferenceManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.Bitmap;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.TextView;

import java.util.Random;


public class Play extends ActionBarActivity implements View.OnTouchListener{


    String countries [] = {
            "Colombia", "Venezuela", "Guyana", "Suriname", "French Guiana", "Brazil",
            "Ecuador", "Peru", "Chile", "Argentina", "Bolivia", "Paraguay", "Uruguay"
    };

    String capitals [] = {
            "Bogotá", "Caracas", "Georgetown", "Paramaribo", "Cayenne", "Brasilia",
            "Quito", "Lima", "Santiago", "Buenos Aires", "La Paz", "Asunción", "Montevideo"
    };

    Integer[] flags = {
        R.drawable.colombiaflag, R.drawable.venezuelaflag, R.drawable.guyanaflag, R.drawable.surinameflag,
            R.drawable.frenchguianaflag, R.drawable.brazilflag, R.drawable.ecuadorflag, R.drawable.peruflag,
            R.drawable.chileflag, R.drawable.argentinaflag, R.drawable.boliviaflag, R.drawable.paraguayflag,
            R.drawable.uruguayflag
    };

    Integer[] countriesFound = {
            0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0
    };

   Integer[] colors = {
            0xffff0000, 0xffff00ff, 0xff0000ff, 0xff00ffff, 0xff00ff00, 0xffffff00, 0xff7f0000,
            0xff999999, 0xff125000, 0xffffbd00, 0xffff99ff, 0xff000000, 0xff33cc33

    };

   int [] imageViewId;

    int [] drawableCorrect;

    int countryNumber, numberOfFound = 0;

    int randomNumber(){
        Random r = new Random();
        int randint = Math.abs(r.nextInt())%13;
        while ((countriesFound[randint] == 1)&&(numberOfFound != 13))
            randint = Math.abs(r.nextInt())%13;
        return randint;
    }

    private int time, currentScore, numberoferrors = 0, difficultyLevel;
    private TextView textTimer;
    private Handler handler;
    private boolean Running = true;
    String highscorer;

    String level = "";

    SharedPreferences.Editor editor;

    String name1 = null, name2 = null, name3 = null, name4 = null, name5 = null;
    int place = 0;

    //Saving Preferences
    public static String filename = "MySharedString";
    SharedPreferences someData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        android.support.v7.app.ActionBar menu = getSupportActionBar();
        menu.setDisplayShowHomeEnabled(true);
        menu.setLogo(R.drawable.appicon1smaller);
        menu.setDisplayUseLogoEnabled(true);

        //Back to main menu button
        menu.setDisplayHomeAsUpEnabled(true);
        //Touch listener on the top-layer image
        ImageView iv = (ImageView) findViewById(R.id.colombia);
        if (iv != null)
            iv.setOnTouchListener(this);

        countryNumber = randomNumber();

        TextView textView = (TextView) findViewById(R.id.country);
        textView.setTextColor(0xffff0000);
        textView.setTextSize(18);
        // show Country or Capital name or Flag
        someData = getSharedPreferences(filename, 0);
        difficultyLevel = someData.getInt("popup2OPTION", 0);

        int identifier = someData.getInt("popup1OPTION", 0);
        if (identifier == 0)
            textView.setText(countries[countryNumber] + "           ");
        else if (identifier == 1)
            textView.setText(capitals[countryNumber] + "           ");
        else if (identifier == 2){
            ImageView flag = (ImageView) findViewById(R.id.flag);
            flag.setImageResource(flags[countryNumber]);
            flag.setTag(flags[countryNumber]);

        }

        if (difficultyLevel == 1){
            ImageView lives = (ImageView) findViewById(R.id.lives);
            lives.setImageResource(R.drawable.the3lives);
            lives.setTag(R.drawable.the3lives);
        }else if (difficultyLevel == 2) {
            ImageView lives = (ImageView) findViewById(R.id.lives);
            lives.setImageResource(R.drawable.the0lives);
            lives.setTag(R.drawable.the0lives);
        }


        imageViewId = new int[13];
        imageViewId[0] = R.id.colombia; imageViewId[1] = R.id.venezuela; imageViewId[2] = R.id.guyana; imageViewId[3] = R.id.suriname;
        imageViewId[4] = R.id.frenchguiana; imageViewId[5] = R.id.brazil; imageViewId[6] = R.id.ecuador; imageViewId[7] = R.id.peru;
        imageViewId[8] = R.id.chile; imageViewId[9] = R.id.argentina; imageViewId[10] = R.id.bolivia; imageViewId[11] = R.id.paraguay;
        imageViewId[12] = R.id.uruguay;

        drawableCorrect = new int[13];
        drawableCorrect[0] = R.drawable.colombiacorrect; drawableCorrect[1] = R.drawable.venezuelacorrect; drawableCorrect[2] = R.drawable.guyanacorrect;
        drawableCorrect[3] = R.drawable.surinamecorrect; drawableCorrect[4] = R.drawable.frenchguianacorrect; drawableCorrect[5] = R.drawable.brazilcorrect;
        drawableCorrect[6] = R.drawable.ecuadorcorrect; drawableCorrect[7] = R.drawable.perucorrect; drawableCorrect[8] = R.drawable.chilecorrect;
        drawableCorrect[9] = R.drawable.argentinacorrect; drawableCorrect[10] = R.drawable.boliviacorrect; drawableCorrect[11] = R.drawable.paraguaycorrect;
        drawableCorrect[12] = R.drawable.uruguaycorrect;


        final TextView textTimer = (TextView) findViewById(R.id.timer);
        textTimer.setTextColor(0xff000000);
        textTimer.setTextSize(18);
        handler = new Handler();
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (Running){
                    try{
                        Thread.sleep(1000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    handler.post(new Runnable(){
                        @Override
                        public void run(){
                            time++;
                            if (numberOfFound == 13)
                                textTimer.setText("   "+String.valueOf(time-1) + " sec");
                            else
                                textTimer.setText("   "+String.valueOf(time) + " sec");
                        }
                    });
                }



            }
        };
        new Thread(runnable).start();

        //load default values the first time

        //Saving Preferences
        someData  = getSharedPreferences(filename, 0);
        //someData = PreferenceManager.setDefaultValues(this, R.xml.preferences, false);
    }

    public boolean onTouch(View v, MotionEvent ev){
        final int action = ev.getAction();
        int touchColor;
        ImageView imageView;
        //Toast.makeText(context, text, duration);
        //toast.show();

        int nextImage = -1;

        final int evX = (int) ev.getX();
        final int evY = (int) ev.getY();



        switch (action){
            case MotionEvent.ACTION_DOWN:
                break;
            case MotionEvent.ACTION_UP:
                touchColor = getHotspotColor (R.id.southcolored, evX, evY);
                //The correct country was touched
                if ( colors[countryNumber] == touchColor) {
                    nextImage = drawableCorrect[countryNumber];

                    Toast.makeText(Play.this, "Correct!", Toast.LENGTH_SHORT).show();

                    imageView = (ImageView) findViewById(imageViewId[countryNumber]);
                    imageView.setImageResource (nextImage);
                    imageView.setTag(nextImage);

                    numberOfFound ++;

                    //erase this country from the list
                    countriesFound[countryNumber] = 1;
                    //Next Country
                    if (numberOfFound != 13) {
                        countryNumber = randomNumber();
                        TextView textView = (TextView) findViewById(R.id.country);
                        // show Country or Capital name or Flag
                        someData = getSharedPreferences(filename, 0);
                        int identifier = someData.getInt("popup1OPTION", 0);
                        if (identifier == 0)
                            textView.setText(countries[countryNumber] + "           ");
                        else if (identifier == 1)
                            textView.setText(capitals[countryNumber] + "           ");
                        else if (identifier == 2){
                            ImageView flag = (ImageView) findViewById(R.id.flag);
                            flag.setImageResource(flags[countryNumber]);
                            flag.setTag(flags[countryNumber]);
                        }
                    }
                    else {
                        //stop the timer
                        Running = false;
                        Toast.makeText(Play.this, "Congratulations! Map completed...", Toast.LENGTH_SHORT).show();
                        ImageView flag = (ImageView) findViewById(R.id.flag);
                        flag.setImageResource(R.drawable.noflag);
                        flag.setTag(R.drawable.noflag);
                        TextView textView = (TextView) findViewById(R.id.country);
                        textView.setText("Map completed           ");

                        //SAVE HIGHSCORE
                        //Highscore check
                        //Load previous highscores from preferences

                        if (difficultyLevel == 1)
                            level = "medium";
                        else if (difficultyLevel == 2)
                            level = "hard";

                        int score1, score2, score3, score4, score5;

                        boolean newHighscore = false;
                        someData = getSharedPreferences(filename, 0);
                        score1 = someData.getInt("score1"+level, Integer.MAX_VALUE);
                        score2 = someData.getInt("score2"+level, Integer.MAX_VALUE);
                        score3 = someData.getInt("score3"+level, Integer.MAX_VALUE);
                        score4 = someData.getInt("score4"+level, Integer.MAX_VALUE);
                        score5 = someData.getInt("score5"+level, Integer.MAX_VALUE);

                        name1 = someData.getString("name1"+level, "");
                        name2 = someData.getString("name2"+level, "");
                        name3 = someData.getString("name3"+level, "");
                        name4 = someData.getString("name4"+level, "");
                        name5 = someData.getString("name5"+level, "");


                        // Save highscore in shared preferences
                        editor = someData.edit();
                        //FIXME move the names as well
                        if (time < score1) {
                            newHighscore = true;
                            place = 1;
                            editor.putInt("score5"+level, score4);
                            editor.putInt("score4"+level, score3);
                            editor.putInt("score3"+level, score2);
                            editor.putInt("score2"+level, score1);
                            editor.putInt("score1"+level, time);
                            editor.commit();
                        }
                        else if (time < score2){
                            newHighscore = true;
                            place = 2;
                            editor.putInt("score5"+level, score4);
                            editor.putInt("score4"+level, score3);
                            editor.putInt("score3"+level, score2);
                            editor.putInt("score2"+level, time);
                            editor.commit();
                        }
                        else if (time < score3){
                            place = 3;
                            newHighscore = true;
                            editor.putInt("score5"+level, score4);
                            editor.putInt("score4"+level, score3);
                            editor.putInt("score3"+level, time);
                            editor.commit();
                        }
                        else if (time < score4){
                            newHighscore = true;
                            place = 4;
                            editor.putInt("score5"+level, score4);
                            editor.putInt("score4"+level, time);
                            editor.commit();
                        }
                        else if (time < score5){
                            newHighscore = true;
                            place = 5;
                            editor.putInt("score5"+level, time);
                            editor.commit();
                        }

                        //Prompt the highscorer to give their username
                        if (newHighscore){

                            AlertDialog.Builder alert = new AlertDialog.Builder(this);

                            alert.setTitle("New highscore!");
                            alert.setMessage("Please, enter your name:");

                            // Set an EditText view to get user input
                            final EditText input = new EditText(this);
                            alert.setView(input);

                            alert.setPositiveButton("Done", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    highscorer = input.getText().toString();
                                    // Do something with value!
                                    //change the positions of the names on the scoreboard
                                    someData = getSharedPreferences(filename, 0);
                                    editor = someData.edit();
                                    if (place == 1){
                                        editor.putString("name5"+level, name4);
                                        editor.putString("name4"+level, name3);
                                        editor.putString("name3"+level, name2);
                                        editor.putString("name2"+level, name1);
                                        editor.putString("name1"+level, highscorer);
                                        editor.commit();
                                    }else if (place == 2){
                                        editor.putString("name5"+level, name4);
                                        editor.putString("name4"+level, name3);
                                        editor.putString("name3"+level, name2);
                                        editor.putString("name2"+level, highscorer);
                                        editor.commit();
                                    }else if (place == 3){
                                        editor.putString("name5"+level, name4);
                                        editor.putString("name4"+level, name3);
                                        editor.putString("name3"+level, highscorer);
                                        editor.commit();
                                    }else if (place == 4){
                                        editor.putString("name5"+level, name4);
                                        editor.putString("name4"+level, highscorer);
                                        editor.commit();
                                    } else if (place == 5){
                                        editor.putString("name5"+level, highscorer);
                                        editor.commit();
                                    }

                                    //Open the Highscores Activity
                                    try{
                                        Class selected = Class.forName("com.example.georgia.g1.Highscores");
                                        Intent selectedIntent = new Intent(Play.this, selected); //FIXME
                                        startActivity(selectedIntent);

                                    }catch (ClassNotFoundException e){
                                        e.printStackTrace();
                                    }

                                }
                            });

                           /* alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int whichButton) {
                                    // Canceled.
                                }
                            });*/

                            alert.show();


                        }
                    }
                }
                else{
                    if (numberOfFound != 13)
                        numberoferrors++;

                        if ((difficultyLevel == 1)&&(numberoferrors == 4)) {

                            showGameOverAlert();
                        }
                        else if (difficultyLevel == 2) {
                            showGameOverAlert();
                        }
                        else {
                            if (difficultyLevel == 0)
                                Toast.makeText(Play.this, "Wrong!", Toast.LENGTH_SHORT).show();
                            else if ((difficultyLevel == 1)&&(numberoferrors == 3)) {
                                ImageView lives = (ImageView) findViewById(R.id.lives);
                                lives.setImageResource(R.drawable.the0lives);
                                lives.setTag(R.drawable.the0lives);
                                Toast.makeText(Play.this, "                Wrong!\nNo more mistakes allowed...", Toast.LENGTH_SHORT).show();
                            }
                            else if ((difficultyLevel == 1)&&(numberoferrors == 2)) {
                                ImageView lives = (ImageView) findViewById(R.id.lives);
                                lives.setImageResource(R.drawable.the1lives);
                                lives.setTag(R.drawable.the1lives);
                                Toast.makeText(Play.this, "                Wrong!\n1 more mistake allowed...", Toast.LENGTH_SHORT).show();
                            }
                            else if ((difficultyLevel == 1)&&(numberoferrors == 1)) {
                                ImageView lives = (ImageView) findViewById(R.id.lives);
                                lives.setImageResource(R.drawable.the2lives);
                                lives.setTag(R.drawable.the2lives);
                                Toast.makeText(Play.this, "                Wrong!\n2 more mistakes allowed...", Toast.LENGTH_SHORT).show();
                            }
                        }
                }
                break;

        }
        /*if (nextImage > 0){
            ImageView imageView = (ImageView) findViewById(R.id.colombia);
            imageView.setImageResource (nextImage);
            imageView.setTag (nextImage);
        }*/

        return true;

    }

    public int getHotspotColor(int hotspotId, int x, int y){

        ImageView img = (ImageView) findViewById(hotspotId);
        img.setDrawingCacheEnabled(true);
        Bitmap hotspots = Bitmap.createBitmap(img.getDrawingCache());
        img.setDrawingCacheEnabled(false);
        return hotspots.getPixel(x,y);
        //return 0xffff0000;
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
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

    void showGameOverAlert(){
        new AlertDialog.Builder(this)
                .setTitle("Game Over!")
                .setMessage("Please, tap OK to return to the main menu.")
                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        try {
                            Class selected = Class.forName("com.example.georgia.g1.MainActivity");
                            Intent selectedIntent = new Intent(Play.this, selected); //FIXME
                            startActivity(selectedIntent);
                        }
                        catch (ClassNotFoundException e){
                        e.printStackTrace();
                    }
                    }
                })
                /*.setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        // do nothing
                    }
                })*/
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
}
