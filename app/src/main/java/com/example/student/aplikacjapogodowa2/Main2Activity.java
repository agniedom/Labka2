package com.example.student.aplikacjapogodowa2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;
import java.util.ArrayList;
import butterknife.BindView;
import butterknife.ButterKnife;


public class Main2Activity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    RecyclerView recyclerView;

    @BindView(R.id.txt_result)
    TextView txt_Result ;
    String place;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        ButterKnife.bind(this);

        Bundle dane = getIntent().getExtras();
        String tekst = dane.getString("KEY");
        txt_Result.setText(tekst);

        //Lista miejsc
        ArrayList<Place> places = new ArrayList<>();
        places.add(new Place("Katowice","Moje Miasto"));
        places.add(new Place("Poznań","Dobre naleśniki"));
        places.add(new Place("Zabrze","Mój Wydział"));
        places.add(new Place("Bieszczady","Bukowe Berdo"));

        //Tworzenie RecykerView
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);


        //catch onclick
        OnPlaceClick listener = (view, position) -> {

            place = places.get(position).getPlaceName();
            //go to mainactivity
            Intent intent = new Intent(getApplicationContext(), MainActivity.class);
            Bundle bundle = new Bundle();
            bundle.putString("Nazwa", place);
            intent.putExtras(bundle);
            startActivity(intent);
        };

        //Tworzenie Adaptera
        PlaceAdapter placeAdapter = new PlaceAdapter(places,  listener);
        recyclerView.setAdapter(placeAdapter);

    }
}
