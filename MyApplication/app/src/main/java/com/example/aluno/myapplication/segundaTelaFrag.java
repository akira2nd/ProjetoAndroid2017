package com.example.aluno.myapplication;


import android.graphics.Color;
import android.os.Bundle;
import android.os.StrictMode;
import android.speech.tts.TextToSpeech;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class SegundaTelaFrag extends Fragment {

    public SegundaTelaFrag() {
        // Required empty public constructor
    }

    int n = 0;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_segunda_tela, container, false);

        StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);

        Bundle b;
        b = getArguments();
        ArrayList<String> listaLivro = b.getStringArrayList("listaLivros");
        Boolean bool = b.getBoolean("aleatorio");

        BookList bookList = new BookList();

        final List<Book> listaLivros = bookList.livroSelect(listaLivro);

        final Button buttonEnviar = (Button) view.findViewById(R.id.buttonEnviar);
        final Button buttonResposta = (Button) view.findViewById(R.id.buttonResposta);
        final Button buttonPular = (Button) view.findViewById(R.id.buttonPular);
        Button buttonOuvir = (Button) view.findViewById(R.id.buttonOuvir);
        final Button buttonProximo = (Button) view.findViewById(R.id.buttonProximo);

        final EditText editText = (EditText) view.findViewById(R.id.editText);

        final TextView lesson = (TextView) view.findViewById(R.id.textViewLesson);
        final TextView palavra = (TextView) view.findViewById(R.id.textViewPalavra);
        final TextView resposta = (TextView) view.findViewById(R.id.textViewResposta);
        final TextView certo = (TextView) view.findViewById(R.id.textViewCertoErrado);

        final SegundaTelaNavig segunda = (SegundaTelaNavig) getActivity();

        if (bool){
            Collections.shuffle(listaLivros);
        }

        if (listaLivros.size() < n){

        }else{
            resposta.setVisibility(View.INVISIBLE);
            certo.setVisibility(View.INVISIBLE);
            lesson.setText("Book:"+listaLivros.get(n).getBook().toString()+" Lesson:"+listaLivros.get(n).getLesson().toString());
            palavra.setText(listaLivros.get(n).getsPortugues());
            resposta.setText(listaLivros.get(n).getsIngles());
            buttonEnviar.setEnabled(true);
            buttonPular.setEnabled(true);
            buttonResposta.setEnabled(true);
            buttonProximo.setEnabled(false);
        }

        buttonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (editText.getText().toString().toUpperCase().equals(listaLivros.get(n).getsIngles().toString().toUpperCase())){
                    resposta.setVisibility(View.INVISIBLE);

                    certo.setVisibility(View.VISIBLE);
                    certo.setText("CERTO");
                    certo.setTextColor(Color.WHITE);
                    certo.setBackgroundColor(Color.GREEN);

                    segunda.arrumaScore(1);

                    buttonEnviar.setEnabled(false);
                    buttonPular.setEnabled(false);
                    buttonResposta.setEnabled(false);
                    buttonProximo.setEnabled(true);
                }else{
                    resposta.setVisibility(View.INVISIBLE);

                    certo.setVisibility(View.VISIBLE);
                    certo.setText("ERRADO");
                    certo.setTextColor(Color.WHITE);
                    certo.setBackgroundColor(Color.RED);

                    segunda.arrumaScore(2);
                }
            }
        });

        buttonProximo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                n = (n % listaLivros.size())+1;
                lesson.setText("Book:"+listaLivros.get(n).getBook()+" Lesson:"+listaLivros.get(n).getLesson());
                palavra.setText(listaLivros.get(n).getsPortugues());
                resposta.setText(listaLivros.get(n).getsIngles());
                certo.setVisibility(View.INVISIBLE);
                resposta.setVisibility(View.INVISIBLE);
                editText.setText(null);

                buttonEnviar.setEnabled(true);
                buttonPular.setEnabled(true);
                buttonResposta.setEnabled(true);
                buttonProximo.setEnabled(false);
            }
        });

        buttonPular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resposta.setVisibility(View.INVISIBLE);
                n = (n % listaLivros.size())+1;
                lesson.setText("Book:"+listaLivros.get(n).getBook()+" Lesson:"+listaLivros.get(n).getLesson());
                palavra.setText(listaLivros.get(n).getsPortugues());
                resposta.setText(listaLivros.get(n).getsIngles());
                certo.setVisibility(View.INVISIBLE);
                resposta.setVisibility(View.INVISIBLE);

                segunda.arrumaScore(3);

            }
        });

        buttonResposta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resposta.setVisibility(View.VISIBLE);

                segunda.arrumaScore(4);

                buttonEnviar.setEnabled(false);
                buttonPular.setEnabled(false);
                buttonResposta.setEnabled(false);
                buttonProximo.setEnabled(true);
            }
        });

        buttonOuvir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segunda.speak(resposta.getText().toString());
            }
        });

        return view;
    }
}
