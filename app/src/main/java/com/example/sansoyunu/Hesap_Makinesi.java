package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Hesap_Makinesi extends AppCompatActivity {
    public static int highest_score = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hesap_makinesi);
    }
    public void toplama_butonu(View view) {
        islemler.score = 0;
        islemler.işlem_num = 1;
        Intent intent = new Intent(this,islemler.class);
        startActivity(intent);
    }
    public void bölme_butonu(View view) {
        islemler.score = 0;
        islemler.işlem_num = 4;
        Intent intent = new Intent(this,islemler.class);
        startActivity(intent);
    }
    public void çarpma_butonu(View view) {
        islemler.score = 0;
        islemler.işlem_num = 3;
        Intent intent = new Intent(this,islemler.class);
        startActivity(intent);
    }
    public void çıkarma_butonu(View view) {
        islemler.score = 0;
        islemler.işlem_num = 2;
        Intent intent = new Intent(this,islemler.class);
        startActivity(intent);
    }

    public void Üs_alma(View view) {
        islemler.score = 0;
        islemler.işlem_num = 5;
        Intent intent = new Intent(this,islemler.class);
        startActivity(intent);
    }

    public void Ana_Menu_button(View view) {
        Intent intent = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}