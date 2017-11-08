package com.example.aaron.tip_calculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    //double tip;
    double mealCost;
    double totalCost;
    double tipChoice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText cost = (EditText)findViewById(R.id.editText2);
        final Spinner group =(Spinner)findViewById(R.id.spinner);
        Button charges = (Button)findViewById(R.id.button);
            charges.setOnClickListener(new View.OnClickListener() {
                final TextView result = ((TextView)findViewById(R.id.textView2));
                @Override
                public void onClick(View view) {


                    mealCost = Integer.parseInt(cost.getText().toString());
                    DecimalFormat currency = new DecimalFormat("$###,###.##");

                    switch (group.getSelectedItem().toString()) {
                        case "5%":
                            tipChoice = .05;
                            break;
                        case "10%":
                            tipChoice = .10;
                            break;
                        case "15%":
                            tipChoice = .15;
                            break;
                        case "20%":
                            tipChoice = .20;
                            break;
                        case "25":
                            tipChoice = .25;
                            break;

                    }

                    totalCost = (mealCost * tipChoice) + mealCost;
                    //tipChoice = group.getSelectedItem().toString();
                    result.setText("Your meal costs "+ mealCost +"you chose to tip " + tipChoice + "%, your total is " + currency.format(totalCost));
                }
            });

    }
}
