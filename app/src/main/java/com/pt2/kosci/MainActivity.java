package com.pt2.kosci;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button buttonRzuc;
    private Button buttonReset;
    private ImageView[] obrazyKosci;
    private TextView TextViewwynikrzutu;
    private TextView textViewWynikSumaryczny;

    private int calasuma = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        buttonReset = findViewById(R.id.button3);
        buttonRzuc = findViewById(R.id.button2);
        obrazyKosci = new ImageView[5];
        obrazyKosci[0] = findViewById(R.id.imageView);
        obrazyKosci[1] = findViewById(R.id.imageView2);
        obrazyKosci[2] = findViewById(R.id.imageView3);
        obrazyKosci[3] = findViewById(R.id.imageView4);
        obrazyKosci[4] = findViewById(R.id.imageView5);

        textViewWynikSumaryczny = findViewById(R.id.textView3);
        TextViewwynikrzutu = findViewById(R.id.textView4);

         int[] obrazki = new int[]{

                R.drawable.k1,
                R.drawable.k2,
                R.drawable.k3,
                R.drawable.k4,
                R.drawable.k5,
                R.drawable.k6,
                R.drawable.question,
        };

        buttonRzuc.setOnClickListener(

                new View.OnClickListener() {

                    @Override
                    public void onClick(View view) {
                        int[] rzuty = rzucWszystkimiKoscmi();

                        int sumaa = 0;
                        int liczba;
                        for (int i = 0; i < obrazyKosci.length; i++) {
                            obrazyKosci[i].setImageResource(obrazki[rzuty[i]]);
                            //switch (obrazki[rzuty[i]]){
                            //    case R.drawable.k1: liczba = 1;
                            //}
                        }
                        int suma = sumaKosc(rzuty);
                        calasuma += suma;
                        TextViewwynikrzutu.setText("Wynik rzutu: "+ suma);
                        textViewWynikSumaryczny.setText("Wynik gry: "+calasuma);
                    }
                }
        );
        buttonReset.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        TextViewwynikrzutu.setText("Wynik rzutu: 0");
                        textViewWynikSumaryczny.setText("Wynik gry: 0");
                        calasuma = 0;
                        for (int i = 0; i < obrazyKosci.length; i++) {
                            obrazyKosci[i].setImageResource(obrazki[6]);

                        }
                    }
                }
        );


    }
    private int[] rzucWszystkimiKoscmi(){
        int rzuty[] = new int[5];
        Random random =new Random();
        for (int i = 0; i <rzuty.length; i++){
            rzuty[i] = random.nextInt(5)+1;
        }
        return rzuty;
    }
    private int sumaKosc(int[] rzuty){
        int s = 0;
        for (int i = 0; i < rzuty.length; i++) {
            s= s+rzuty[i];
        }
        return s;
    }

}
