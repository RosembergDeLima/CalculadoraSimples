package com.example.rosemberg.calculadorasimples;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener{

    private EditText box1,box2;
    private TextView box3;
    private Button somar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        somar = (Button) findViewById(R.id.buttonSoma);

        somar.setOnClickListener(MainActivity.this);

        box1 = (EditText) findViewById(R.id.box1);
        box2 = (EditText) findViewById(R.id.box2);
        box3 = (TextView) findViewById(R.id.box3);
    }

    @Override
    public void onClick(View view) {
        String n1 = box1.getText().toString();
        String n2 = box2.getText().toString();
        int v1 = Integer.parseInt(n1);
        int v2 = Integer.parseInt(n2);
        int soma = v1+v2;
        String result = String.valueOf(soma);
        box3.setText(result);
    }
}
