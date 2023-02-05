package com.example.stolice;

import android.content.Intent;
import android.content.res.ColorStateList;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class activity_quiz_azja extends AppCompatActivity {

    private TextView Pytanie, Wynik, NrPytania, tTimer;
    private RadioGroup radioGroup;
    private RadioButton rb1, rb2, rb3, rb4;
    private Button NastepnePytanie;

    int SumaPytan;
    int LicznikPytan = 0;
    int wynik2=0;



    ColorStateList dfRbColor;
    boolean wybranaOdp;

    CountDownTimer countDownTimer;

    private ModelPytan obecnePytanie;


    private List<ModelPytan> listapytan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz_azja);

        listapytan = new ArrayList<>();
        Pytanie = findViewById(R.id.PytanieTekst);
        Wynik = findViewById(R.id.WynikText);
        NrPytania = findViewById(R.id.NrPytniatext);
        tTimer = findViewById(R.id.TimerText);

        radioGroup = findViewById(R.id.radioGroup);
        rb1 = findViewById(R.id.rb1);
        rb2 = findViewById(R.id.rb2);
        rb3 = findViewById(R.id.rb3);
        rb4 = findViewById(R.id.rb4);
        NastepnePytanie = findViewById(R.id.NastepnePytanie);

        dfRbColor = rb1.getTextColors();

        dodajpytanie();
        SumaPytan = listapytan.size();
        pokazNastepnePytanie();

        NastepnePytanie.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (wybranaOdp == false) {
                    if (rb1.isChecked() || rb2.isChecked() || rb3.isChecked() || rb4.isChecked()) {
                        sprawdzOdp();
                        countDownTimer.cancel();
                    } else {
                        Toast.makeText(activity_quiz_azja.this, "Wybierz odpowiedź", Toast.LENGTH_SHORT).show();
                    }
                }else{
                    pokazNastepnePytanie();

                }
            }
        });
    }

    private void sprawdzOdp() {
        wybranaOdp = true;
        RadioButton rbSelected = findViewById(radioGroup.getCheckedRadioButtonId());
        int NrOdpowiedzi = radioGroup.indexOfChild(rbSelected) + 1;
        if (NrOdpowiedzi == obecnePytanie.getPoprawnaOdpowiedz()) {
            wynik2++;
            Wynik.setText("Wynik: "+wynik2);
        }
        rb1.setTextColor(Color.RED);
        rb2.setTextColor(Color.RED);
        rb3.setTextColor(Color.RED);
        rb4.setTextColor(Color.RED);
        switch (obecnePytanie.getPoprawnaOdpowiedz()){
            case 1:
                rb1.setTextColor(Color.GREEN);
                break;
            case 2:
                rb2.setTextColor(Color.GREEN);
                break;
            case 3:
                rb3.setTextColor(Color.GREEN);
                break;
            case 4:
                rb4.setTextColor(Color.GREEN);
                break;
        }
        if (LicznikPytan < SumaPytan) {
            NastepnePytanie.setText("Następne");
        } else {
            NastepnePytanie.setText("Sprawdź wynik");
        }
    }

    private void pokazNastepnePytanie() {

        radioGroup.clearCheck();
        rb1.setTextColor(dfRbColor);
        rb2.setTextColor(dfRbColor);
        rb3.setTextColor(dfRbColor);
        rb4.setTextColor(dfRbColor);

        if (LicznikPytan < SumaPytan) {
            Timer();
            obecnePytanie = listapytan.get(LicznikPytan);
            Pytanie.setText(obecnePytanie.getPytanie());
            rb1.setText(obecnePytanie.getOpcja1());
            rb2.setText(obecnePytanie.getOpcja2());
            rb3.setText(obecnePytanie.getOpcja3());
            rb4.setText(obecnePytanie.getOpcja4());

            LicznikPytan++;
            NastepnePytanie.setText("Potwierdź");
            NrPytania.setText("Pytanie: "+LicznikPytan+"/"+SumaPytan);
            wybranaOdp = false;
        } else {
            Intent intent = new Intent(activity_quiz_azja.this, wynik_quizu.class);
            intent.putExtra("wynik2", wynik2);
            startActivity(intent);
        }
    }

    private void Timer() {
        countDownTimer = new CountDownTimer(20000, 1000) {
            @Override
            public void onTick(long l) {
                tTimer.setText("00:" + String.format("%02d", l/1000));
            }

            @Override
            public void onFinish() {
                pokazNastepnePytanie();

            }
        }.start();
    }

    private void dodajpytanie() {
        listapytan.add(new ModelPytan( "Jaka jest stolica Chin?","Naypyidaw" ,"Pekin", "Manama", "Bagdad",2));
        listapytan.add(new ModelPytan( "Co jest stolicą Bangladeszu?","Erywań" ,"Nikozja", "Dhaka", "Nur-Sułtan",3));
        listapytan.add(new ModelPytan( "Jakie miasto jest stolicą Korei Północnej?","Pjongjang" ,"Seul", " Damaszek", "Aszchabad",1));
        listapytan.add(new ModelPytan( "Co jest stolicą Mongolii?","Malé" ,"Muskat", "Singapur", "Ułan Bator",4));
        listapytan.add(new ModelPytan( "Jaka jest stolica Turcji?","Ankara" ,"Biszkek", "Pjongjang", "Manama",1));
        listapytan.add(new ModelPytan( "Jakie miasto jest stolicą Nepalu?","Sarajewo" ,"Kuwejt", "Katmandu", "Erywań",3));
        listapytan.add(new ModelPytan( "Co jest stolicą Uzbekistanu?","Hanoi" ,"Damaszek", "Taszkent", "Muskat",3));
        listapytan.add(new ModelPytan( "Jakie miasto jest stolicą Tajlandii?","Dili" ,"Bangkok", "Biszkek", "Bagdad",2));
        listapytan.add(new ModelPytan( "Co jest stolicą Iraku?","Bagdad" ,"Teheran", "Manama", "Pekin",1));
        listapytan.add(new ModelPytan( "Jaka jest stolica Japonii?","Ad-Dauha" ,"Pekin", "Amman", "Tokio",4));
    }
}