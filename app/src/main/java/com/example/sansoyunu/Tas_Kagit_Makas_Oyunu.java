package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import java.util.Random;

public class Tas_Kagit_Makas_Oyunu extends AppCompatActivity {
    TextView seçim_alanı,sonuç_alanı,score_text,can_text;
    static String kullanıcı_seçimi,bilgisayar_seçimi;
    Button taş_buton,kağıt_buton,makas_buton,ana_menü_butonu;
    static int score = 0;
    static int can = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tas_kagit_makas_oyunu);
        taş_buton = (Button) findViewById(R.id.button2);
        kağıt_buton = (Button) findViewById(R.id.button4);
        makas_buton = (Button) findViewById(R.id.button3);
        ana_menü_butonu = (Button) findViewById(R.id.Ana_menü_butonu);
        can_text = (TextView) findViewById(R.id.Can_alanı);
        score_text = (TextView) findViewById(R.id.Score_text);
        seçim_alanı = (TextView) findViewById(R.id.seçim_alanı);
        sonuç_alanı = (TextView) findViewById(R.id.sonuç_alanı);
    }

    public  void Oyun_Düzeni(){
        Random random = new Random();
        int rastgele_seçim = random.nextInt(3)+1;
        switch (rastgele_seçim){
            case 1: // TAŞ
                seçim_alanı.setText("TAŞ");
                bilgisayar_seçimi = "TAŞ";
                sonuç_alanı.setText((Hesaplama(kullanıcı_seçimi,bilgisayar_seçimi)));
                break;
            case 2: // KAĞIT
                seçim_alanı.setText("KAĞIT");
                bilgisayar_seçimi = "KAĞIT";
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
                else if(bilgisayar_seçimi == "KAĞIT"){
                    can -= 1;
                    can_text.setText(String.valueOf(can));
                    if (can == 0){
                        taş_buton.setEnabled(false);
                        kağıt_buton.setEnabled(false);
                        makas_buton.setEnabled(false);
                        return "(KAĞIT > TAŞ)\n   OYUNU KAYBETTİN ! Tekrar oynamak istiyorsan Baştan Başla ! \nToplam skor : "+score+"";
                    }
                    else
                    return "(KAĞIT > TAŞ)\n    MALESEF KAYBETTİN\n(-1 CAN)!";
                }
                else{
                    score++;
                    score_text.setText(String.valueOf(score));
                    return "(TAŞ > MAKAS)\n    TEBRİKLER KAZANDIN!\n(+1 PUAN)";
                }
            case "KAĞIT":
                if(bilgisayar_seçimi == "TAŞ"){
                    score++;
                    score_text.setText(String.valueOf(score));
                    return "(KAĞIT > TAŞ)\n    TEBRİKLER KAZANDIN!\n(+1 PUAN)";
                }
                else if(bilgisayar_seçimi == "KAĞIT")
                    return "(KAĞIT-KAĞIT)\n    DURUM BERABERE!";
                else{
                    can -= 1;
                    can_text.setText(String.valueOf(can));
                    if(can == 0){
                        taş_buton.setEnabled(false);
                        kağıt_buton.setEnabled(false);
                        makas_buton.setEnabled(false);
                        return "(KAĞIT > TAŞ)\n   OYUNU KAYBETTİN ! Tekrar oynamak istiyorsan Baştan Başla ! \nToplam skor : "+score+"";
                    }
                    else
                    return "(KAĞIT > TAŞ)\n    MALESEF KAYBETTİN\n(-1 CAN)!";
                }
            case "MAKAS":
                if(bilgisayar_seçimi == "TAŞ"){
                    can -= 1;
                    can_text.setText(String.valueOf(can));
                    if(can == 0){
                        taş_buton.setEnabled(false);
                        kağıt_buton.setEnabled(false);
                        makas_buton.setEnabled(false);
                        return "(TAŞ > MAKAS)\n    OYUNU KAYBETTİN ! Tekrar oynamak istiyorsan Baştan Başla ! \nToplam skor : "+score+"";
                    }
                    else
                    return "(TAŞ > MAKAS)\n    MALESEF KAYBETTİN!\n(-1 CAN)";
                }
                else if(bilgisayar_seçimi == "KAĞIT"){
                score++;
                score_text.setText(String.valueOf(score));
                    return "(MAKAS > KAĞIT)\n  TEBRİKLER KAZANDIN!\n(+1 PUAN)";
                }
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
        can = 3;
        can_text.setText("3");
        score = 0;
        score_text.setText("0");
        kullanıcı_seçimi = null;
        bilgisayar_seçimi = null;
        seçim_alanı.setText("");
        sonuç_alanı.setText("");
        score_text.setText("");
        // herşeyi sıfırla tüm değerleri
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }
}