package com.example.gener.afsprakenvermeire;

import android.content.Context;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Simpele Adapter gemaakt, TODO: Uitbreiden zodat alle data op het scherm gezet wordt.
 */

public class AppointmentAdapter extends ArrayAdapter <Appointment> {


    public AppointmentAdapter(Context context, AppointmentDummyRepository repo) {
        super(context,-1, repo.getAppointments());
    }

    //TODO: Andere manier vinden om alle views met 1 getview te exporteren.
    @Override
    public View getView(int pos, View convertview, ViewGroup Parent)
    {
        TextView view=new TextView(getContext());
        TextView view1= new TextView(getContext());
        view1.setText(getItem(pos).getContactName());
        view.setText(getItem(pos).getReason());

        return view;
    }
}
