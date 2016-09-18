package com.example.rosemberg.calculadorasimples;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import java.util.regex.Pattern;

public class MainActivity extends Activity implements OnClickListener {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9;
    Button btnSum, btnSub, btnDiv, btnMult;
    Button btnEqual, btnC;

    TextView tela;

    private String display = "";
    private String currentOperator = "";
    private String result = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btn0 = (Button) findViewById(R.id.btn0);
        btn1 = (Button) findViewById(R.id.btn1);
        btn2 = (Button) findViewById(R.id.btn2);
        btn3 = (Button) findViewById(R.id.btn3);
        btn4 = (Button) findViewById(R.id.btn4);
        btn5 = (Button) findViewById(R.id.btn5);
        btn6 = (Button) findViewById(R.id.btn6);
        btn7 = (Button) findViewById(R.id.btn7);
        btn8 = (Button) findViewById(R.id.btn8);
        btn9 = (Button) findViewById(R.id.btn9);

        btn0.setOnClickListener(this);
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);
        btn4.setOnClickListener(this);
        btn5.setOnClickListener(this);
        btn6.setOnClickListener(this);
        btn7.setOnClickListener(this);
        btn8.setOnClickListener(this);
        btn9.setOnClickListener(this);

        btnSum = (Button) findViewById(R.id.btnSum);
        btnSub = (Button) findViewById(R.id.btnSub);
        btnDiv = (Button) findViewById(R.id.btnDiv);
        btnMult = (Button) findViewById(R.id.btnMult);

        btnSum.setOnClickListener(this);
        btnSub.setOnClickListener(this);
        btnDiv.setOnClickListener(this);
        btnMult.setOnClickListener(this);

        btnEqual = (Button) findViewById(R.id.btnEqual);
        btnEqual.setOnClickListener(this);

        btnC = (Button) findViewById(R.id.btnC);
        btnC.setOnClickListener(this);

        tela = (TextView) findViewById(R.id.tela);
        tela.setText(display);
    }

    @Override
    public void onClick(View view) {
        int selection = view.getId();

        switch (selection) {
            case R.id.btn0:
                display += btn0.getText();
                tela.setText(display);
                break;
            case R.id.btn1:
                display += btn1.getText();
                tela.setText(display);
                break;
            case R.id.btn2:
                display += btn2.getText();
                tela.setText(display);
                break;
            case R.id.btn3:
                display += btn3.getText();
                tela.setText(display);
                break;
            case R.id.btn4:
                display += btn4.getText();
                tela.setText(display);
                break;
            case R.id.btn5:
                display += btn5.getText();
                tela.setText(display);
                break;
            case R.id.btn6:
                display += btn6.getText();
                tela.setText(display);
                break;
            case R.id.btn7:
                display += btn7.getText();
                tela.setText(display);
                break;
            case R.id.btn8:
                display += btn8.getText();
                tela.setText(display);
                break;
            case R.id.btn9:
                display += btn9.getText();
                tela.setText(display);
                break;
            case R.id.btnSum:
                display += btnSum.getText();
                currentOperator = btnSum.getText().toString();
                tela.setText(display);
                break;
            case R.id.btnSub:
                display += btnSub.getText();
                currentOperator = btnSub.getText().toString();
                tela.setText(display);
                break;
            case R.id.btnDiv:
                display += btnDiv.getText();
                currentOperator = btnDiv.getText().toString();
                tela.setText(display);
                break;
            case R.id.btnMult:
                display += btnMult.getText();
                currentOperator = btnMult.getText().toString();
                tela.setText(display);
                break;
            case R.id.btnC:
                display = "";
                tela.setText(display);
                result = "";
                break;
            case R.id.btnEqual:
                String[] operation = display.split(Pattern.quote(currentOperator));
                if (operation.length < 2) return;

                result = String.valueOf(operate(operation[0], operation[1], currentOperator));
                tela.setText(display + "\n" +  String.valueOf(result));
                break;
        }
    }

    private double operate(String a, String b, String op){
        switch (op){
            case "+": return Double.valueOf(a) + Double.valueOf(b);
            case "-": return Double.valueOf(a) - Double.valueOf(b);
            case "x": return Double.valueOf(a) * Double.valueOf(b);
            case "/":
                try {
                    return Double.valueOf(a) / Double.valueOf(b);
                } catch (Exception e){
                    Log.e("calc", e.getMessage());
                }
            default: return -1;
        }
    }
}