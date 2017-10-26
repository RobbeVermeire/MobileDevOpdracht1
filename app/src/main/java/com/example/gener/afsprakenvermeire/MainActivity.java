package com.example.gener.afsprakenvermeire;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppointmentDummyRepository repository=new AppointmentDummyRepository();
        ListView AppointementList = (ListView)findViewById(R.id.appointment_list);
        AppointementList.setAdapter(new AppointmentAdapter(this,repository));
    }
}
