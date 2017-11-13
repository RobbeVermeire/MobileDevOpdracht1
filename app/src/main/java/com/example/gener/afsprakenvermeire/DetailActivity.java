package com.example.gener.afsprakenvermeire;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by Gener on 13/11/2017.
 */

public class DetailActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);

        int id=getIntent().getExtras().getInt("id");
        TextView temp =(TextView)findViewById(R.id.TEMP);

    }
}
