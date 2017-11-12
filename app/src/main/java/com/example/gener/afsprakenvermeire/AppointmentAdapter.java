package com.example.gener.afsprakenvermeire;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;



public class AppointmentAdapter extends ArrayAdapter <Appointment> {


    public AppointmentAdapter(Context context, AppointmentDummyRepository repo) {
        super(context,-1, repo.getAppointments());
    }


    @Override
    public View getView(int pos, View convertview, ViewGroup Parent)
    {
        LayoutInflater inflater =(LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view =inflater.inflate(R.layout.appointment_list_item,null);

        //Get contact name en paste in list item
        TextView textView_name=view.findViewById(R.id.appointment_list_item_name);
        textView_name.setText(getItem(pos).getContactName());

        //Get volledige datum en paste in list item
        String FullDate=getItem(pos).getDay()+"/"+getItem(pos).getMonth()+"/"+getItem(pos).getYear();
        TextView textView_date=view.findViewById(R.id.appointment_list_item_date);
        textView_date.setText(FullDate);

        //get tijd en paste in list item
        String FullTime=getItem(pos).getHour()+":"+getItem(pos).getMinute();
        TextView textView_time=view.findViewById(R.id.appointment_list_item_time);
        textView_time.setText(FullTime);

        //get plaats en paste in list item
        TextView textView_place=view.findViewById(R.id.appointment_list_item_place);
        textView_place.setText(getItem(pos).getLocation());


        return view;
    }
}
