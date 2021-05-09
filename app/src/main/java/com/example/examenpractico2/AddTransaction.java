package com.example.examenpractico2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examenpractico2.db.Db_Facturas;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import cn.pedant.SweetAlert.SweetAlertDialog;
import android.graphics.Color;

public class AddTransaction extends AppCompatActivity {
    //global variables
    EditText date_in;
    Spinner opciones;
    Button btnAdd;
    EditText txtFac,txtfecha,txtMonto, txtKM;
    String spinnerValue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_add_transaction);
        //set controls objects
        txtFac = (EditText) findViewById(R.id.txtFac);
        txtfecha = (EditText) findViewById(R.id.date_input);
        txtMonto = (EditText) findViewById(R.id.txtMonto);
        txtKM = (EditText) findViewById(R.id.txtKM);
        btnAdd = (Button) findViewById(R.id.btnAgregar);
        opciones = (Spinner) findViewById(R.id.spnCombustible);
        //DateTimePicker setUp
        date_in=findViewById(R.id.date_input);
        date_in.setInputType(InputType.TYPE_NULL);
        date_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDateDialog(date_in);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Save Data, OBJ dabase created
                Db_Facturas db_facturas = new Db_Facturas(AddTransaction.this);
                //Null values validatios
                if(txtFac.getText().toString()!=""& txtfecha.getText().toString()!=""&opciones.getSelectedItemPosition()!=0& (txtMonto.getText().toString())!=""&(txtKM.getText().toString())!=""){
                    //insert Result
                    long id=db_facturas.insertFactura(Integer.parseInt(txtFac.getText().toString()), txtfecha.getText().toString(),opciones.getSelectedItem().toString(), Double.parseDouble(txtMonto.getText().toString()),Integer.parseInt(txtKM.getText().toString()));
                    //Comfirmation Dialog
                    if(id>0){

                        new SweetAlertDialog(AddTransaction.this)
                                .setTitleText("Guardado!")
                                .show();
                        limpiar();
                        Intent intent = new Intent(getApplicationContext(), Inicio.class);
                        startActivity(intent);
                    }else{
                        Toast.makeText(getApplicationContext(),"ERROR",Toast.LENGTH_SHORT).show();

                    }
                }else{
                    //empty values detected
                    Toast.makeText(getApplicationContext(),"INGRESE TODOS lOS CAMPOS",Toast.LENGTH_SHORT).show();
                }


            }
        });

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.opciones, android.R.layout.simple_spinner_item);
        opciones.setAdapter(adapter);
    }
    //DateTimePicker Funcion
    private void showDateDialog(final EditText date_in) {
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
        new DatePickerDialog(AddTransaction.this,dateSetListener,calendar.get(Calendar.YEAR),calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show();
    }
    public void limpiar(){
        txtKM.setText("");
        txtMonto.setText("");
        txtfecha.setText("");
        txtFac.setText("");
    }
}