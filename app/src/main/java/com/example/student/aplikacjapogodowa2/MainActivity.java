package com.example.student.aplikacjapogodowa2;

import android.app.ActionBar;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import butterknife.BindView;
import butterknife.OnClick;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.txt_edittext)
    EditText Edit_WpiszMiasto ;

    @BindView(R.id.btn_zmien_miejsce)
    Button btn_zmienMiejsce ;

    @BindView(R.id.btn_pokaz_liste_dostepnych_miejsc)
    Button btn_lista ;

    @BindView(R.id.txt_miasto)
    TextView txt_NazwaMiasta ;

    @BindView(R.id.obrazek)
    ImageView obrazek;

    @OnClick(R.id.btn_zmien_miejsce)
    void onClick(View view){

        String nowe = Edit_WpiszMiasto.getText().toString();
        txt_NazwaMiasta.setText(nowe);
    }
    @OnClick(R.id.btn_pokaz_liste_dostepnych_miejsc)
    void onClick2(View view){

        Intent intent = new Intent( MainActivity.this, Main2Activity.class);
        Bundle bundle = new Bundle();
        String wpisanyTekst = Edit_WpiszMiasto.getText().toString();
        bundle.putString("KEY", wpisanyTekst);
        intent.putExtras(bundle);
        startActivity(intent);

    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        Glide.with(this)
                .load("https://www.krak-wit.pl/userdata/gfx/45c1f236531e5a40bafa43ff1903312e.jpg")
                .into(obrazek);




        Intent getData = getIntent();
        Bundle bundle = getIntent().getExtras();


        if (bundle != null) {
            String place = bundle.getString("Nazwa");
            txt_NazwaMiasta.setText(place);
        }




    }

}
