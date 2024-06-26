package com.example.exno1;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // Defining the Views
    EditText Num1;
    EditText Num2;
    Button Add;
    Button Sub;
    Button Mul;
    Button Div;
    Button Sin;
    Button Cos;
    Button Tan;
    Button Sqrt;
    Button Log;
    TextView Result;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referring the Views
        Num1 = findViewById(R.id.editText1);
        Num2 = findViewById(R.id.editText2);
        Add = findViewById(R.id.Add);
        Sub = findViewById(R.id.Sub);
        Mul = findViewById(R.id.Mul);
        Div = findViewById(R.id.Div);
        Sin = findViewById(R.id.Sin);
        Cos = findViewById(R.id.Cos);
        Tan = findViewById(R.id.Tan);
        Sqrt = findViewById(R.id.Sqrt);
        Log = findViewById(R.id.Log);
        Result = findViewById(R.id.textView);

        // Set click listeners
        Add.setOnClickListener(this);
        Sub.setOnClickListener(this);
        Mul.setOnClickListener(this);
        Div.setOnClickListener(this);
        Sin.setOnClickListener(this);
        Cos.setOnClickListener(this);
        Tan.setOnClickListener(this);
        Sqrt.setOnClickListener(this);
        Log.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        float num1, num2, result;
        String oper = "";

        // Check if the fields are empty
        if (TextUtils.isEmpty(Num1.getText().toString()) || TextUtils.isEmpty(Num2.getText().toString()))
            return;

        // Read EditText and fill variables with numbers
        num1 = Float.parseFloat(Num1.getText().toString());
        num2 = Float.parseFloat(Num2.getText().toString());

        // Defines the button that has been clicked and performs the corresponding operation
        // Write operation into oper, we will use it later for output
        if (v.getId() == R.id.Add) {
            oper = "+";
            result = num1 + num2;
        } else if (v.getId() == R.id.Sub) {
            oper = "-";
            result = num1 - num2;
        } else if (v.getId() == R.id.Mul) {
            oper = "*";
            result = num1 * num2;
        } else if (v.getId() == R.id.Div) {
            oper = "/";
            if (num2 != 0)
                result = num1 / num2;
            else {
                Result.setText("Cannot divide by zero");
                return;
            }
        }else if (v.getId() == R.id.Sin) {
            oper = "Sin";
            result = (float) Math.sin(num1);
        }
        else if (v.getId() == R.id.Cos) {
            oper = "Cos";
            result = (float) Math.cos(num1);
        }
        else if (v.getId() == R.id.Tan) {
            oper = "Tan";
            result = (float) Math.tan(num1);
        }
        else if (v.getId() == R.id.Sqrt) {
            oper = "Sqrt";
            result = (float) Math.sqrt(num1);
        }
        else if (v.getId() == R.id.Log) {
            oper = "Log";
            result = (float) Math.log(num1);
        }
            else {
            return;
        }

        // Form the output line
        Result.setText(oper + " " + num1 + " = " + result);
    }
}
