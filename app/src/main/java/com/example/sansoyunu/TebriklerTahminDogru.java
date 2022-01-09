package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class TebriklerTahminDogru extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tebrikler_tahmin_dogru);
        TextView yazı_alanı = (TextView) findViewById(R.id.yazı_alani);
        yazı_alanı.setText(String.valueOf("Tebrikler "+(AklimdanSayiTuttum.deneme_sayisi+1)+". Denemede Buldun!"));
          AklimdanSayiTuttum.deneme_sayisi = 0;
    }

    public void ana_menuye_don(View view) {
        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
    }
}