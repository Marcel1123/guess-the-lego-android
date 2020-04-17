package com.example.guessthelogo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.TextView;

import com.example.guessthelogo.R;
import com.example.guessthelogo.util.Player;

public class EndGameActivity extends AppCompatActivity {
    private TextView score;
    private TextView chance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_end_game);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.score = (TextView) findViewById(R.id.textView4);
        this.chance = (TextView) findViewById(R.id.textView6);

        prepareData();
    }

    public void goHome(View view){
        Player.resetPlayer();
        startActivity(new Intent(this, MainActivity.class));
        finish();
    }

    private void prepareData(){
        Player p = Player.getInstance();

        String text = " " + p.getScore() + "/" + getResources().getStringArray(R.array.file_name).length;

        this.score.setText(text);
        this.chance.setText(String.valueOf(p.getChanceUsed()));
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }
}
