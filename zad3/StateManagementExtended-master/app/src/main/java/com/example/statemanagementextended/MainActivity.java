package com.example.statemanagementextended;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.graphics.Color;
import android.widget.CompoundButton;
import androidx.lifecycle.ViewModelProvider;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Switch;


public class MainActivity extends AppCompatActivity {
    private static final String KEY_COUNT = "count";
    private TextView textViewCount;
    private int count =0;
    private Switch switcher;
    private TextView textViewOpcjaZaznaczona;
    private CheckBox checkbox;
    private LinearLayout main;
    private EditText input;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        textViewCount=findViewById(R.id.text);
        Button buttonIncrement = findViewById(R.id.button);
        if(savedInstanceState !=null){
            count = savedInstanceState.getInt(KEY_COUNT);
        }
        updateCountText();

        buttonIncrement.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                count++;
                updateCountText();
            }

        });


        switcher = findViewById(R.id.switcher);
        main = findViewById(R.id.main_layout);
        input = findViewById(R.id.input);
        switcher.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                main.setBackgroundColor(Color.BLACK);
                textViewCount.setTextColor(Color.WHITE);
                textViewOpcjaZaznaczona.setTextColor(Color.WHITE);
                checkbox.setTextColor(Color.WHITE);
                switcher.setTextColor(Color.WHITE);
                input.setTextColor(Color.WHITE);
            } else {
                main.setBackgroundColor(Color.WHITE);
                textViewCount.setTextColor(Color.BLACK);
                textViewOpcjaZaznaczona.setTextColor(Color.BLACK);
                checkbox.setTextColor(Color.BLACK);
                switcher.setTextColor(Color.BLACK);
                input.setTextColor(Color.BLACK);
            }
        });

        checkbox = findViewById(R.id.check);
        textViewOpcjaZaznaczona = findViewById(R.id.inform);


        checkbox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    // Jeśli zaznaczony, pokaż TextView
                    textViewOpcjaZaznaczona.setVisibility(View.VISIBLE);
                } else {
                    // Jeśli odznaczony, ukryj TextView
                    textViewOpcjaZaznaczona.setVisibility(View.GONE);
                }
            }
        });

    }
    @Override
    protected  void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putInt(KEY_COUNT, count);
    }
    protected void updateCountText(){
        textViewCount.setText("Licznik: "+ count);
    }

}
