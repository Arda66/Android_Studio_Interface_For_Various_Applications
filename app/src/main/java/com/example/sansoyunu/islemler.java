package com.example.sansoyunu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class islemler extends AppCompatActivity {
    int rastgele_sayi1, rastgele_sayi2, toplam, fark, çarpım, bölüm, cevap;
    static int score;
    int can = 3;
    static int işlem_num;
    boolean doğru_cevap = false;
    TextView Score, Can_alanı;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_islemler);
        İşlem();
    }

    public void İşlem() {
        Score = (TextView) findViewById(R.id.Score);
        Can_alanı = (TextView) findViewById(R.id.can_text_alanı);
        TextView operator = (TextView) findViewById(R.id.operator_işlemi);
        Random random = new Random();
        TextView birinci_sayi = (TextView) findViewById(R.id.birinci_Sayi);
        TextView ikinci_sayi = (TextView) findViewById(R.id.ikinci_sayi);
        int temp_sayi1 = random.nextInt(1000) + 1;
        int temp_sayi2 = random.nextInt(1000) + 1;
        if (temp_sayi1 >= temp_sayi2) {
            rastgele_sayi1 = temp_sayi1;
            rastgele_sayi2 = temp_sayi2;
        } else {
            rastgele_sayi1 = temp_sayi2;
            rastgele_sayi2 = temp_sayi1;
        }
        birinci_sayi.setText((String.valueOf(rastgele_sayi1)));
        ikinci_sayi.setText(String.valueOf(rastgele_sayi2));
        switch (işlem_num) {
            case 1:
                operator.setText("+");
                cevap = rastgele_sayi1 + rastgele_sayi2;
                break;
            case 2:
                operator.setText("-");
                cevap = rastgele_sayi1 - rastgele_sayi2;
                break;
            case 3:
                operator.setText("×");
                cevap = rastgele_sayi1 * rastgele_sayi2;
                break;
            case 4:
                operator.setText("÷");
                cevap = rastgele_sayi1 / rastgele_sayi2;
                break;
            case 5:
                rastgele_sayi1 = random.nextInt(20) + 1;
                rastgele_sayi2 = random.nextInt(5) + 1;
                birinci_sayi.setText(String.valueOf(rastgele_sayi1));
                ikinci_sayi.setText(String.valueOf(rastgele_sayi2));
                operator.setText("üzeri");
                cevap = (int) Math.pow(rastgele_sayi1, rastgele_sayi2);
                break;
        }
    }

    public void Cevap_Butonu(View view) {
        EditText cevabım = (EditText) findViewById(R.id.Cevap_alanı);
        if (cevabım.getText().toString().equals(String.valueOf(cevap)))
             doğru_cevap = true;
         else
             doğru_cevap = false;

        if (doğru_cevap) {
            score++;
            if (score % 5 == 0) {
                can++;
                cevabım.setText("");
                Score.setText(String.valueOf(score));
                Can_alanı.setText(String.valueOf(can));
            }
            else{
                cevabım.setText("");
                Score.setText(String.valueOf(score));
            }
            İşlem();
        }
        else {
            cevabım.setText("");
            can--;
            if (can == 0) {
                Intent intent = new Intent(this, GameOver.class);
                startActivity(intent);
            } else {
                Can_alanı.setText(String.valueOf(can));
            }
        }
    }
}