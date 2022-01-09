package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Scanner;

public class Fitness_Danismani extends AppCompatActivity {
    Scanner input = new Scanner(System.in);
    float kilo,boy,index;

    TextView kilo_alanı,boy_alanı,yazi_alanı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fitness_danismani);
    }


    public void Kütle_index_butonu(View view) {
        kilo_alanı = (TextView) findViewById(R.id.kilo_text_alanı);
        boy_alanı = (TextView) findViewById(R.id.boy_text_alanı);
        yazi_alanı = (TextView) findViewById(R.id.Yazi_alani);
        kilo =  Float.parseFloat(kilo_alanı.getText().toString());
        boy =  Float.parseFloat(boy_alanı.getText().toString());
        index = kilo/(boy*boy);
        String sağlık_durumu = null;
        if(index < 18.5){
            sağlık_durumu = "Zayıf";
        }
        else if(index < 24.9 && index > 18.5){
            sağlık_durumu = "Normal Kilolu";
        }
        else if(index < 29.9 && index > 25){
            sağlık_durumu = "Fazla Kilolu";
        }
        else if(index < 39.9 && index > 30){
            sağlık_durumu = "Obez";
        }
        else if(index > 40){
            sağlık_durumu = "İleri Derece Obez";
        }
        
        yazi_alanı.setText("Vücut Kütle İndexi = "+String.valueOf(index)+"\n\nSonuç : "+sağlık_durumu);

    }

    public void Restart(View view) {
        kilo = 0;
        boy = 0;
        index = 0;
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void Ana_menü_dön(View view) {
        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}