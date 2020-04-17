package com.example.guessthelogo.activities;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.guessthelogo.R;
import com.example.guessthelogo.util.Player;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class PlayActivity extends AppCompatActivity {
    // UI
    private ImageView imageView;
    private EditText editText;
    private TextView chances;
    private TextView score;

    // IMAGES
    private String[] nameLogo;
    private TypedArray arrayIcon;
    private List<Integer> usedImage;
    private String correctAnswear;

    // PLAYER
    private Player player = Player.getInstance();
    private int chance = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_play);

        this.imageView = (ImageView) findViewById(R.id.imageView);
        this.editText = (EditText) findViewById(R.id.editText);
        this.chances = (TextView) findViewById(R.id.textView2);
        this.score = (TextView) findViewById(R.id.textView);

        this.nameLogo = getResources().getStringArray(R.array.file_name);
        this.arrayIcon = getResources().obtainTypedArray(R.array.image);

        usedImage = new LinkedList<>();
        correctAnswear = "";

        this.chances.setText(String.valueOf(this.chance));
        this.score.setText("SCORE: " + this.player.getScore());
        chancesColor();
    }

    private void chooseRandomImage(){
        int c = new Random().nextInt(this.arrayIcon.length());

        int resource = this.arrayIcon.getResourceId(c, -1);

        if(this.usedImage.size() < this.arrayIcon.length()){
            while(this.usedImage.contains(resource)){
                c = new Random().nextInt(this.arrayIcon.length());
                resource = this.arrayIcon.getResourceId(c, -1);
            }

            Bitmap bitmap = BitmapFactory.decodeResource(getResources(), resource);
            this.imageView.setImageBitmap(bitmap);

            System.out.println("C: " + c);
            this.usedImage.add(resource);
            this.correctAnswear = this.nameLogo[c];
        } else {
            alerta();
        }
    }

    public void guess(View view){
        Player.updateChance();
        this.chance--;

        if(this.correctAnswear.equals(this.editText.getText().toString())){
            Player.updateScore();
            this.chance = 3;
            this.chances.setText(String.valueOf(this.chance));
            this.score.setText("SCORE: " + this.player.getScore());
            this.editText.setText("");
            chooseRandomImage();
        } else {
            if(this.chance == 0){
                alerta();
            } else {
                this.chances.setText(new String(String.valueOf(this.chance)));
            }
        }
        chancesColor();
    }

    private void endGame(){
        startActivity(new Intent(this, EndGameActivity.class));
        finish();
    }

    public void goHome(View view){
        Player.resetPlayer();
        startActivity(new Intent(this, EndGameActivity.class));
        finish();
    }

    private void chancesColor(){
        if(this.chance == 3){
            this.chances.setTextColor(Color.GREEN);
        } else if(this.chance == 2){
            this.chances.setTextColor(Color.YELLOW);
        } else if(this.chance == 1){
            this.chances.setTextColor(Color.RED);
        }
    }

    public void alerta() {
        AlertDialog alertDialog = new AlertDialog.Builder(PlayActivity.this).create();
        alertDialog.setTitle("Game over");
        alertDialog.setMessage(this.correctAnswear);
        alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                        endGame();
                    }
                });
        alertDialog.show();
    }

    @Override
    protected void onStart(){
        super.onStart();
        chooseRandomImage();
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
