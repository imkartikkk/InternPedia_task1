package com.example.task1unitconversionapp;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    EditText input;
    Spinner unit;
    TextView km, m, cm, mm, macro, nm, mile, yard, foot, inch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initializing views
        input = findViewById(R.id.input);
        unit = findViewById(R.id.unit);

        km = findViewById(R.id.km);
        m = findViewById(R.id.m);
        cm = findViewById(R.id.cm);
        mm = findViewById(R.id.mm);
        macro = findViewById(R.id.mac);
        nm = findViewById(R.id.nan);
        mile = findViewById(R.id.mile);
        yard = findViewById(R.id.yard);
        foot = findViewById(R.id.foot);
        inch = findViewById(R.id.inch);

        // Setting up the Spinner
        String[] arr = {"km", "m", "cm", "mm", "macro", "nm", "mile", "yard", "foot", "inch"};
        unit.setAdapter(new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, arr));
        unit.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                update();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        // Adding a TextWatcher to input EditText
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                update();
            }
        });
    }

    // Method to update the conversion
    public void update() {
        String inputText = input.getText().toString();

        // Checking if input is not empty and a unit is selected
        if (!inputText.isEmpty() && unit.getSelectedItem() != null) {
            double in = Double.parseDouble(inputText);

            switch (unit.getSelectedItem().toString()) {
                case "km":
                    setkm(in);
                    break;
                case "m":
                    setkm(in / 1000);
                    break;
                case "cm":
                    setkm(in / 100000);
                    break;
                case "mm":
                    setkm(in / 1000000);
                    break;
                case "macro":
                    setkm(in / 1000000000);
                    break;
                case "nm":
                    double d = 1000000 * 1000000;
                    setkm(in / d);
                    break;
                case "mile":
                    setkm(in * 1.609);
                    break;
                case "yard":
                    setkm(in / 1094);
                    break;
                case "foot":
                    setkm(in / 3281);
                    break;
                case "inch":
                    setkm(in / 39370);
                    break;
            }
        }
    }

    // Method to set the converted values
    public void setkm(double km_in) {
        km.setText(String.valueOf(km_in));
        m.setText(String.valueOf(km_in * 1000));
        cm.setText(String.valueOf(km_in * 100000));
        mm.setText(String.valueOf(km_in * 1000000));
        macro.setText(String.valueOf(km_in * 1000000000));
        nm.setText(String.valueOf(km_in * 1000000 * 1000000));
        mile.setText(String.valueOf(km_in / 1.609));
        yard.setText(String.valueOf(km_in * 1094));
        foot.setText(String.valueOf(km_in * 3281));
        inch.setText(String.valueOf(km_in * 39370));
    }
}
