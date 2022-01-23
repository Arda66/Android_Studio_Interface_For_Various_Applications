package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void aklımdan_sayı_butonu(View view) {
        Intent intent = new Intent(this, AklimdanSayiTuttum.class);
        startActivity(intent);
    }

    public void Fitness_butonu(View view) {
        Intent intent = new Intent(this, Fitness_Danismani.class);
        startActivity(intent);
    }

    public void tas_kagıt_Butonu(View view) {
        Intent intent = new Intent(this, Tas_Kagit_Makas_Oyunu.class);
        startActivity(intent);
    }

    public void kayıt_ol_butonu(View view) {
        Intent intent = new Intent(this, KayitOl.class);
        startActivity(intent);
    }

    public void giriş_yap_butonu(View view) {
        Intent intent = new Intent(this, GirisYap.class);
        startActivity(intent);
    }

    public  void ikinci_derece_denklem(View view){
        Intent intent = new Intent(this, ikinci_Derece_Denklem.class);
        startActivity(intent);
    }

    public void Hesap_makinesi_butonu(View view) {
        Intent intent = new Intent(this, Hesap_Makinesi.class);
        startActivity(intent);
    }


}