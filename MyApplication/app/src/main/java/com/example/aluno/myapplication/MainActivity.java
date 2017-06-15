package com.example.aluno.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<String> livros = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        Button button3 = (Button) findViewById(R.id.button3);
        Button button4 = (Button) findViewById(R.id.button4);
        Button button5 = (Button) findViewById(R.id.button5);
        Button button6 = (Button) findViewById(R.id.button6);
        Button button7 = (Button) findViewById(R.id.button7);
        Button button8 = (Button) findViewById(R.id.button8);
        Button button9 = (Button) findViewById(R.id.button9);
        Button button10 = (Button) findViewById(R.id.button10);

        Button iniciar = (Button) findViewById(R.id.buttonIniciar);

        final CheckBox checkBox = (CheckBox) findViewById(R.id.checkBox);



        final TextView textView = (TextView) findViewById(R.id.textView);
/***
        View.OnClickListener myHandler = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                switch(view.getId()){
                    case R.id.button1:
                        if(livros.contains(1)){
                            livros.remove(1);
                        }else{
                            livros.add(1);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button2:
                        if(livros.contains(2)){
                            livros.remove(2);
                        }else{
                            livros.add(2);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button3:
                        if(livros.contains(3)){
                            livros.remove(3);
                        }else{
                            livros.add(3);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button4:
                        if(livros.contains(4)){
                            livros.remove(4);
                        }else{
                            livros.add(4);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button5:
                        if(livros.contains(5)){
                            livros.remove(5);
                        }else{
                            livros.add(5);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button6:
                        if(livros.contains(6)){
                            livros.remove(6);
                        }else{
                            livros.add(6);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button7:
                        if(livros.contains(7)){
                            livros.remove(7);
                        }else{
                            livros.add(7);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button8:
                        if(livros.contains(8)){
                            livros.remove(8);
                        }else{
                            livros.add(8);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button9:
                        if(livros.contains(9)){
                            livros.remove(9);
                        }else{
                            livros.add(9);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.button10:
                        if(livros.contains(10)){
                            livros.remove(10);
                        }else{
                            livros.add(10);
                        }
                        textView.setText((CharSequence) livros);
                        break;
                    case R.id.buttonIniciar:
                        iniciar(radioButton.isChecked());
                        break;
                }

            }
        };
***/


        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("1")){
                    livros.remove("1");
                }else{
                    livros.add("1");
                }
                textView.setText(livros.toString());

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("2")){
                    livros.remove("2");
                }else{
                    livros.add("2");
                }
                textView.setText(livros.toString());

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("3")){
                    livros.remove("3");
                }else{
                    livros.add("3");
                }
                textView.setText(livros.toString());

            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("4")){
                    livros.remove("4");
                }else{
                    livros.add("4");
                }
                textView.setText(livros.toString());

            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("5")){
                    livros.remove("5");
                }else{
                    livros.add("5");
                }
                textView.setText(livros.toString());

            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("6")){
                    livros.remove("6");
                }else{
                    livros.add("6");
                }
                textView.setText(livros.toString());

            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("7")){
                    livros.remove("7");
                }else{
                    livros.add("7");
                }
                textView.setText(livros.toString());

            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("8")){
                    livros.remove("8");
                }else{
                    livros.add("8");
                }
                textView.setText(livros.toString());

            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("9")){
                    livros.remove("9");
                }else{
                    livros.add("9");
                }
                textView.setText(livros.toString());
            }
        });

        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(livros.contains("10")){
                    livros.remove("10");
                }else{
                    livros.add("10");
                }
                textView.setText(livros.toString());
            }
        });

        iniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iniciar(checkBox.isChecked());
            }
        });
    }




    private void iniciar(Boolean chk){
        Intent intent = new Intent(this, SegundaTelaNavig.class);
        intent.putStringArrayListExtra("listaLivros",  livros);
        intent.putExtra("aleatorio", chk);
        startActivity(intent);
        finish();
    }
}
