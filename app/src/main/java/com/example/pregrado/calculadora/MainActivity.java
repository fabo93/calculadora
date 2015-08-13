package com.example.pregrado.calculadora;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Scanner;


public class MainActivity extends Activity {

    public TextView textbox;
    public TextView labelOperacion;
    public Button n0;
    public Button n1;
    public Button n2;
    public Button n3;
    public Button n4;
    public Button n5;
    public Button n6;
    public Button n7;
    public Button n8;
    public Button n9;
    public Button sum;
    public Button res;
    public Button div;
    public Button mul;
    public Button igual;
    public Button ac;
    public Button ce;

    public StringBuilder buffer = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();


    }

    public void init(){

        View.OnClickListener listener =  new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch ( v.getId()){

                    case R.id.n0:
                        buffer.append("0");
                        textbox.setText(buffer);
                        break;
                    case R.id.n1:
                        buffer.append("1");
                        textbox.setText(buffer);
                        break;

                    case R.id.n2:
                        buffer.append("2");
                        textbox.setText(buffer);
                        break;

                    case R.id.n3:
                        buffer.append("3");
                        textbox.setText(buffer);
                        break;

                    case R.id.n4:
                        buffer.append("4");
                        textbox.setText(buffer);
                        break;

                    case R.id.n5:
                        buffer.append("5");
                        textbox.setText(buffer);
                        break;

                    case R.id.n6:
                        buffer.append("6");
                        textbox.setText(buffer);
                        break;

                    case R.id.n7:
                        buffer.append("7");
                        textbox.setText(buffer);
                        break;

                    case R.id.n8:
                        buffer.append("8");
                        textbox.setText(buffer);
                        break;

                    case R.id.n9:
                        buffer.append("9");
                        textbox.setText(buffer);
                        break;

                    case R.id.sum:
                        if ( !contieneOperacion(buffer.toString())) {
                            buffer.append("+");
                            textbox.setText(buffer);
                        }
                        break;

                    case R.id.res:
                        if ( !contieneOperacion(buffer.toString())) {
                            buffer.append("-");
                            textbox.setText(buffer);
                        }
                        break;

                    case R.id.mul:
                        if ( !contieneOperacion(buffer.toString())) {
                            buffer.append("*");
                            textbox.setText(buffer);
                        }
                        break;

                    case R.id.div:
                        if ( !contieneOperacion(buffer.toString())) {
                            buffer.append("/");
                            textbox.setText(buffer);
                        }
                        break;

                    case R.id.igual:
                        int r = (int)realizarOperacion(buffer.toString().trim());
                        if ( r < 0){
                            labelOperacion.setText("SINTAX ERROR");
                            buffer = new StringBuilder();
                            textbox.setText("0");
                        }
                        else     {
                            labelOperacion.setText(buffer.toString() + "=");
                            buffer = new StringBuilder(r + "");
                            textbox.setText(buffer);
                            }

                        break;

                    case R.id.ac:
                        labelOperacion.setText("");
                        buffer = new StringBuilder();
                        textbox.setText("0");
                        break;

                    case R.id.ce:
                        String input = buffer.toString();
                        if ( input.length() > 0) {
                            input = input.substring(0,input.length()-1);
                            if ( input.isEmpty()){
                                buffer = new StringBuilder();
                                textbox.setText("0");
                            }
                            else {
                                buffer = new StringBuilder(input);
                                textbox.setText(buffer);
                            }

                        }


                        break;


                }
            }
        };
        textbox = (TextView)findViewById(R.id.textView3);
        labelOperacion = (TextView) findViewById(R.id.textView2);
        n0 = (Button) findViewById(R.id.n0);
        n0.setOnClickListener(listener);
        n1 = (Button) findViewById(R.id.n1);
        n1.setOnClickListener(listener);
        n2 = (Button) findViewById(R.id.n2);
        n2.setOnClickListener(listener);
        n3 = (Button) findViewById(R.id.n3);
        n3.setOnClickListener(listener);
        n4 = (Button) findViewById(R.id.n4);
        n4.setOnClickListener(listener);
        n5 = (Button) findViewById(R.id.n5);
        n5.setOnClickListener(listener);
        n6 = (Button) findViewById(R.id.n6);
        n6.setOnClickListener(listener);
        n7 = (Button) findViewById(R.id.n7);
        n7.setOnClickListener(listener);
        n8 = (Button) findViewById(R.id.n8);
        n8.setOnClickListener(listener);
        n9 = (Button) findViewById(R.id.n9);
        n9.setOnClickListener(listener);
        sum = (Button) findViewById(R.id.sum);
        sum.setOnClickListener(listener);
        res = (Button) findViewById(R.id.res);
        res.setOnClickListener(listener);
        mul = (Button) findViewById(R.id.mul);
        mul.setOnClickListener(listener);
        div = (Button) findViewById(R.id.div);
        div.setOnClickListener(listener);
        igual = (Button) findViewById(R.id.igual);
        igual.setOnClickListener(listener);
        ac = (Button) findViewById(R.id.ac);
        ac.setOnClickListener(listener);
        ce = (Button) findViewById(R.id.ce);
        ce.setOnClickListener(listener);

    }

    public double realizarOperacion ( String buffer ){


        double resultado=-1;

        try {

            if (buffer.contains("+")) {
                String[] operandos = buffer.split("\\+");
                resultado = Integer.parseInt(operandos[0]) + Integer.parseInt(operandos[1]);
            } else if (buffer.contains("-")) {
                String[] operandos = buffer.split("\\-");
                resultado = Integer.parseInt(operandos[0]) - Integer.parseInt(operandos[1]);
            } else if (buffer.contains("*")) {
                String[] operandos = buffer.split("\\*");
                resultado = Integer.parseInt(operandos[0]) * Integer.parseInt(operandos[1]);
            } else if (buffer.contains("/")) {
                String[] operandos = buffer.split("\\/");
                resultado = Integer.parseInt(operandos[0]) / Integer.parseInt(operandos[1]);
            }
        }

        catch (Exception e){
            resultado = -1;
        }

        return resultado;
    }

    public boolean contieneOperacion ( String buffer){

        if ( buffer.contains("+") || buffer.contains("-") || buffer.contains("/") || buffer.contains("*")){
            return true;
        }
        return false;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
