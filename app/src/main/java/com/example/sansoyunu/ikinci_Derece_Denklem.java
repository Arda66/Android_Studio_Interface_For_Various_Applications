package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ikinci_Derece_Denklem extends AppCompatActivity {
    static double a,b,c,delta,kök1,kök2,kök_sayisi;
    static TextView denklem_alanı,delta_alanı,birinci_kök_alanı,ikinci_kök_alanı,kök_durum_alanı,a_alanı,b_alanı,c_alanı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ikinci_derece_denklem);
        denklem_alanı = (TextView) findViewById(R.id.denklem_yeri);
        delta_alanı = (TextView) findViewById(R.id.delta_değeri_alanı);
        birinci_kök_alanı = (TextView) findViewById(R.id.birinci_kök_alanı);
        ikinci_kök_alanı = (TextView) findViewById(R.id.ikinci_kök_alanı);
        kök_durum_alanı = (TextView) findViewById(R.id.Kök_sayisi_durumu);
        a_alanı = (TextView) findViewById(R.id.a_alanı);
        b_alanı = (TextView) findViewById(R.id.b_alanı);
        c_alanı = (TextView) findViewById(R.id.c_alanı);
    }
    public void kök_hesapla_butonu(View view) {
        String denklem = String.valueOf(denklem_alanı.getText());
        a = Integer.parseInt(denklem.substring(0,denklem.indexOf("x")));
        b = Integer.parseInt(denklem.substring(denklem.indexOf("2")+1,denklem.lastIndexOf("x")));
        c = Integer.parseInt(denklem.substring(denklem.lastIndexOf("x")+1,denklem.length()));
        a_alanı.setText("A = "+String.valueOf(a));
        b_alanı.setText("B = "+String.valueOf(b));
        c_alanı.setText("C = "+String.valueOf(c));
        Kökleri_bul();
    }
    public static boolean Kök_Varmı(){
        if(Delta_Bul()>0){
            kök_durum_alanı.setText("2 yada daha fazla kökü var (△ > 0)");
            kök_sayisi = 2;
            return  true;
        }
        else if(Delta_Bul() == 0){
            kök_durum_alanı.setText("Tek kökü var\n (△ = 0)");
            kök_sayisi = 1;
            return  true;
        }
        else {
            kök_durum_alanı.setText("Reel Kökü Yok!\n (△ < 0)");
            kök_sayisi =0;
            return  false;
        }

    }
    public static double Delta_Bul() {
        delta = (b*b)-(4*a*c);
        delta_alanı.setText(String.valueOf(delta));
        return delta;

    }
    public static void Kökleri_bul(){
        if(Kök_Varmı()){
            if(kök_sayisi == 2){
                kök1 = (((-b)+(Math.sqrt(delta)))/(2*a));
                kök2 = (((-b)-(Math.sqrt(delta)))/(2*a));
                birinci_kök_alanı.setText(String.valueOf(kök1));
                ikinci_kök_alanı.setText(String.valueOf(kök2));

            }
            else if(kök_sayisi == 1){
                kök1 = (((-b)+(Math.sqrt(delta)))/(2*a));
                birinci_kök_alanı.setText(String.valueOf(kök1));
                ikinci_kök_alanı.setText(String.valueOf("2. kök Yok!"));
            }
        }
        else {
            birinci_kök_alanı.setText(String.valueOf("Kök yok!"));
            ikinci_kök_alanı.setText(String.valueOf("Kök yok!"));
        }

    }

    public void Baştan_Başla(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

}