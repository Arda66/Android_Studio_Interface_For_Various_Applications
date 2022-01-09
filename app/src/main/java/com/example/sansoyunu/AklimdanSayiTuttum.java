package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class AklimdanSayiTuttum extends AppCompatActivity {
    int min, max, rastgele_sayi, Tahminim;
    static int deneme_sayisi = 0;
    TextView tahminim, gizli_yazı, min_değer, max_değer, deneme_sayim;
    static ArrayList<Integer> kullanılan_rakamlar = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_aklimdan_sayi_tuttum);
    }

    public void rastgele_sayi_üret(View view) {
/*
        if((min_değer.getText().toString().equals("")) || max_değer.getText().toString().equals("")){
            gizli_yazı.setText("Lütfen önce Minimum ve maximum değerleri giriniz!");
            return;
        }
*/
        deneme_sayisi = 0;
        gizli_yazı = findViewById(R.id.gizli_yazi);
        tahminim =  findViewById(R.id.tahminim);
        deneme_sayim =  findViewById(R.id.deneme_sayisi);
        gizli_yazı.setVisibility(view.VISIBLE);
        gizli_yazı.setText("RASTGELE SAYİ ÜRETİLDİ ! TAHMİN ETMEYE BAŞLA !");
        Random random = new Random();
        min_değer =  findViewById(R.id.Min_değer);
        max_değer =  findViewById(R.id.Max_değer);
        min = Integer.parseInt(min_değer.getText().toString());
        max = Integer.parseInt(max_değer.getText().toString());
        max_değer.setKeyListener(null);
        min_değer.setKeyListener(null);
        if (min >= max) {
            gizli_yazı.setText("Minimum değer maximumdan büyük ya da eşit olamaz lütfen tekrar giriniz !");
            min_değer.setText("");
            max_değer.setText("");
            return;
        } else
            rastgele_sayi = random.nextInt(max - min + 1) + min;

    }

    public void tahmin_et(View view) throws InterruptedException {
/*
        if (min_değer.getText().toString().equals(null)   || max_değer.getText().toString().equals(null)     ){
            gizli_yazı.setVisibility(view.VISIBLE);
            gizli_yazı.setText("Lütfen önce minimum ve maximum değerleri giriniz!");
            return;
        }
*/
        Random random = new Random();
        Tahminim = Integer.parseInt(tahminim.getText().toString());
        if ((Tahminim > max) || (Tahminim < min)) {
            gizli_yazı.setText("Yazdığın değer minimum ile maximum arasında değil! Dikkat edip tekrar dene!");
            return;
        } else if (Kullanıldı(Tahminim))
            return;
        else if (rastgele_sayi != Tahminim) {
            kullanılan_rakamlar.add(Tahminim);
            gizli_yazı.setText("YANLIŞ TAHMİN TEKRAR DENEYİNİZ ! ");         // 30-40
            deneme_sayisi++;
            deneme_sayim.setText(String.valueOf(deneme_sayisi));
            if (deneme_sayisi % 5 == 0) {
                int ilk_sayi = (min + random.nextInt(rastgele_sayi - min));
                int ikinci_sayi = (max - random.nextInt(max - rastgele_sayi));
                if (ilk_sayi > ikinci_sayi)
                    gizli_yazı.setText("Hadi Sana İpucu Rastgele sayı " + ikinci_sayi + " ile " + ilk_sayi + " Arasında");
                else
                    gizli_yazı.setText("Hadi Sana İpucu Rastgele sayı " + ilk_sayi + " ile " + ikinci_sayi + " Arasında");
            }
            tahminim.setText("");
        } else {
            tahminim.setText("");
            kullanılan_rakamlar.clear();
            Intent intent = new Intent(this, TebriklerTahminDogru.class);
            startActivity(intent);
        }


    }

    public boolean Kullanıldı(Integer Tahminim) {
        for (Integer k : kullanılan_rakamlar) {
            if (k.equals(Tahminim)) {
                gizli_yazı.setText("Bu sayıyı daha önceden kullandın! Lütfen farklı bir sayı dene!");
                return true;
            }
        }
        return false;
    }

    public void bastan_basla_Butonu(View view) {
        kullanılan_rakamlar.clear();
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}

