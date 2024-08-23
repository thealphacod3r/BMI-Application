package com.thealphacod3r.bmiapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import kotlin.io.LineReader;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        TextView txt;
        EditText editWeight, editHeightft, editHeightIn;
        Button btnCalculate;
        LinearLayout main;

        editWeight = findViewById(R.id.editWeight);
        editHeightft = findViewById(R.id.editHeight);
        editHeightIn = findViewById(R.id.editAge);
        btnCalculate = findViewById(R.id.btnCalculate);
        txt = findViewById(R.id.txtResult);
        main = findViewById(R.id.main);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int weight = Integer.parseInt(editWeight.getText().toString());
                int ft = Integer.parseInt(editHeightft.getText().toString());
                int in = Integer.parseInt(editHeightIn.getText().toString());

                int totalIn = (ft * 12) + in;
                double totalCm = totalIn * 2.53;
                double totalM = totalCm / 100;

                double BMI = weight / (totalM * totalM);

                if(BMI > 25){
                    txt.setText("You are Overweight");
                    main.setBackgroundColor(getResources().getColor(R.color.red));
                } else if(BMI < 18){
                    txt.setText("You are Underweight");
                    main.setBackgroundColor(getResources().getColor(R.color.red));
                } else {
                    txt.setText("You are Healthy");
                    main.setBackgroundColor(getResources().getColor(R.color.green));
                }
            }
        });
    }
}