package com.example.examenpractico2;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.AdapterView;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examenpractico2.db.CustomAdapter;
import com.example.examenpractico2.db.Promedio;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ShowPromedio extends AppCompatActivity {
//A eliminar

    EditText date_in;
    EditText datefinal_in;
    ListView listViewPromedio;
    List<Promedio> lst;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_promedio);
        date_in = findViewById(R.id.date_input);
        datefinal_in = findViewById(R.id.datefin_input);
        date_in.setInputType(InputType.TYPE_NULL);
        datefinal_in.setInputType(InputType.TYPE_NULL);

        listViewPromedio = findViewById(R.id.lvPromedios);

        CustomAdapter adapter = new CustomAdapter( this, GetData());
        listViewPromedio.setAdapter(adapter);
        listViewPromedio.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Promedio p = lst.get(position);

                Toast.makeText(getBaseContext(),p.titulo,Toast.LENGTH_SHORT).show();

            }
        });

        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });

        datefinal_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog2(datefinal_in);
            }
        });
    }

    private List<Promedio> GetData() {
        lst = new ArrayList<>();
        lst.add(new Promedio(1,R.mipmap.arriba,R.mipmap.cash,"","","DIESEL"));
        lst.add(new Promedio(2,R.mipmap.arriba,R.mipmap.cash,"","","PREMIUM"));
        lst.add(new Promedio(3,R.mipmap.arriba,R.mipmap.cash,"","","REGULAR"));
        return  lst;
    }

    private void showDateDialog(final EditText date_in){
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                date_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(com.example.examenpractico2.ShowPromedio.this, dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }

    private void showDateDialog2(final EditText datefinal_in){
        final Calendar calendar=Calendar.getInstance();
        DatePickerDialog.OnDateSetListener dateSetListener=new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                calendar.set(Calendar.YEAR,year);
                calendar.set(Calendar.MONTH,month);
                calendar.set(Calendar.DAY_OF_MONTH,dayOfMonth);
                SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-MM-dd");
                datefinal_in.setText(simpleDateFormat.format(calendar.getTime()));

            }
        };
        new DatePickerDialog(com.example.examenpractico2.ShowPromedio.this,dateSetListener, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
}