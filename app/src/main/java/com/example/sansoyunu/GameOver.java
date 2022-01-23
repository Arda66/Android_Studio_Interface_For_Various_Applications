package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class GameOver extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
        TextView highest_score = (TextView) findViewById(R.id.highest_score);
        int final_score = islemler.score;
        if(final_score > Hesap_Makinesi.highest_score)
            Hesap_Makinesi.highest_score = final_score;
        highest_score.setText(String.valueOf(Hesap_Makinesi.highest_score));
        TextView final_Score = (TextView) findViewById(R.id.final_score);
        final_Score.setText(String.valueOf(final_score));
    }
    public void Go_back_To_Main_menu(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}