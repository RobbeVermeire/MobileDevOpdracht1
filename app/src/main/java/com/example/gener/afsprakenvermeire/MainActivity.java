package com.example.gener.afsprakenvermeire;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridLayout;
import android.widget.ListView;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         final AppointmentDummyRepository repository=new AppointmentDummyRepository();
         final ListView AppointementList = (ListView)findViewById(R.id.appointment_list);

        AppointmentAdapter myAppointmentAdapter=new AppointmentAdapter(this,repository);
        AppointementList.setAdapter(myAppointmentAdapter);


        Appointment nextAppointment=myAppointmentAdapter.getItem(0);
        TextView textView_highlight =(TextView) findViewById(R.id.next_appointment);
        textView_highlight.setText(getText(R.string.highlight_begin)+" " +nextAppointment.getContactName()+" at "+
                nextAppointment.getDay() +"/"+nextAppointment.getMonth()+" "+nextAppointment.getHour()+":"+
                nextAppointment.getMinute()+".");


        //TODO: Nieuwe activity openen en info meegeven
        AppointementList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Object clicktItem=AppointementList.getItemAtPosition(position);
                int id=0;
                for(Appointment appointment: repository.getAppointments()){
                    if(appointment.getId()==position)
                       id=appointment.getId();
                }

                OpenDetailActivity(id);
            }
        });













    }
    public void OpenDetailActivity(int id){
        Intent myIntent= new Intent(MainActivity.this,DetailActivity.class);
        myIntent.putExtra("id",id);
        startActivity(myIntent);
        }

}
