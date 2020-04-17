package com.example.guessthelogo.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import com.example.guessthelogo.R;
import com.example.guessthelogo.util.Player;

public class PrepareGameActivity extends AppCompatActivity {
    private EditText palyerName;
    private TextView error;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_prepare_game);
        this.palyerName = (EditText) findViewById(R.id.playerName);
        this.error = (TextView) findViewById(R.id.error);
    }

    public void startGame(View view){
        if(this.palyerName.getText() == null || this.palyerName.getText().toString().equals("")){
            this.error.setVisibility(View.VISIBLE);
        } else {
            this.error.setVisibility(View.INVISIBLE);
            Player.updateName(this.palyerName.getText().toString());
            startActivity(new Intent(this, PlayActivity.class));
            finish();
        }
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
