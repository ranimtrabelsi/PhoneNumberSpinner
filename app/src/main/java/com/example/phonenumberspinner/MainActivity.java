package com.example.phonenumberspinner;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private EditText editTextMain ;
    private String mspinnerLabel;
    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextMain = (EditText) findViewById(R.id.editText_main);
        Spinner spinner = (Spinner) findViewById(R.id.label_spinner);
        if (spinner != null){
            spinner.setOnItemSelectedListener(this);
        }
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.labels_array, android.R.layout.simple_spinner_item);
        if (spinner != null){
            spinner.setAdapter(arrayAdapter);
        }
    }

    public void showText(View view) {
        if (editTextMain.getText() != null){
            Toast.makeText(this,editTextMain.getText().toString(),Toast.LENGTH_SHORT).show();
        }

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        mspinnerLabel = parent.getItemAtPosition(position).toString();
        showText(view);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Log.d(TAG,getString(R.string.nothing_selected));
    }
}