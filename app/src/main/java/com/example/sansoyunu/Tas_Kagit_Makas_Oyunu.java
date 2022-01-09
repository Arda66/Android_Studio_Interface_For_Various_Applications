package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class Tas_Kagit_Makas_Oyunu extends AppCompatActivity {
    TextView seçim_alanı,sonuç_alanı;
    static String kullanıcı_seçimi,bilgisayar_seçimi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_kagit_makas_oyunu);
    }

    public  void Oyun_Düzeni(){
        seçim_alanı = (TextView) findViewById(R.id.seçim_alanı);
        sonuç_alanı = (TextView) findViewById(R.id.sonuç_alanı);
        Random random = new Random();
        int rastgele_seçim = random.nextInt(3)+1;
        switch (rastgele_seçim){
            case 1: // TAŞ
                seçim_alanı.setText("TAŞ");
                bilgisayar_seçimi = "TAŞ";
                Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi);
                sonuç_alanı.setText((Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi)));
                break;
            case 2: // KAĞIT
                seçim_alanı.setText("KAĞIT");
                bilgisayar_seçimi = "KAĞIT";
                Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi);
                sonuç_alanı.setText((Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi)));
                break;
            case 3: // MAKAS
                seçim_alanı.setText("MAKAS");
                bilgisayar_seçimi = "MAKAS";
                sonuç_alanı.setText((Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi)));
                break;
        }

    }
    public String Hesaplama(String kullanıcı_seçimi, String bilgisayar_seçimi){
        switch(kullanıcı_seçimi){
            case "TAŞ":
                if(bilgisayar_seçimi == "TAŞ")
                    return "(TAŞ-TAŞ)\n    DURUM BERABERE!";
                else if(bilgisayar_seçimi == "KAĞIT")
                    return "(KAĞIT > TAŞ)\n    MALESEF KAYBETTİN!";
                else
                    return "(TAŞ > MAKAS)\n    TEBRİKLER KAZANDIN!";
            case "KAĞIT":
                if(bilgisayar_seçimi == "TAŞ")
                    return "(KAĞIT > TAŞ)\n    TEBRİKLER KAZANDIN!";
                else if(bilgisayar_seçimi == "KAĞIT")
                    return "(KAĞIT-KAĞIT)\n    DURUM BERABERE!";
                else
                    return "(MAKAS > KAĞIT)\n  MALESEF KAYBETTİN!";
            case "MAKAS":
                if(bilgisayar_seçimi == "TAŞ")
                    return "(TAŞ > MAKAS)\n    MALESEF KAYBETTİN!";
                else if(bilgisayar_seçimi == "KAĞIT")
                    return "(MAKAS > KAĞIT)\n  TEBRİKLER KAZANDIN!";
                else
                    return "(MAKAS-MAKAS)\n    DURUM BERABERE!";
        }
        return null;
    }









    public void Taş_Buton(View view) {
        kullanıcı_seçimi = "TAŞ";
        Oyun_Düzeni();
    }

    public void Makas_Buton(View view) {
        kullanıcı_seçimi = "MAKAS";
        Oyun_Düzeni();

    }

    public void Kağıt_Buton(View view) {
        kullanıcı_seçimi = "KAĞIT";
        Oyun_Düzeni();
    }

    public void Ana_menuye_don(View view) {
        Intent intent  = new Intent(this,MainActivity.class);
        startActivity(intent);
    }

    public void Baştan_Başla(View view) {
        kullanıcı_seçimi = null;
        bilgisayar_seçimi = null;
        seçim_alanı.setText("");
        sonuç_alanı.setText("");
        // herşeyi sıfırla tüm değerleri
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}