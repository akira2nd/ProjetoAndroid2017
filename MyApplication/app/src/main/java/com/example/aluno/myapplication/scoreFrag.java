package com.example.aluno.myapplication;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class ScoreFrag extends Fragment {

    private Integer certo;
    private Integer erro;
    private Integer pulo;
    private Integer vresp;

    public ScoreFrag() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_score, container, false);

        TextView correto = (TextView) view.findViewById(R.id.textViewCorreto);
        TextView errado = (TextView) view.findViewById(R.id.textViewErro);
        TextView pulou = (TextView) view.findViewById(R.id.textViewPulou);
        TextView resp = (TextView) view.findViewById(R.id.textViewVResp);

        Bundle s;
        s = getArguments();
        certo = s.getInt("certo");
        erro = s.getInt("erro");
        pulo = s.getInt("pulo");
        vresp = s.getInt("vresp");

        correto.setText("Correto: "+certo.toString());
        errado.setText("Errou: "+erro.toString());
        pulou.setText("Pulou: "+pulo.toString());
        resp.setText("Viu Resposta: "+vresp.toString());

        return view;

    }
}
