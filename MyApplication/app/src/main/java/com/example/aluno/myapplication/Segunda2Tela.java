package com.example.aluno.myapplication;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.Locale;

public class Segunda2Tela extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener{

    TextToSpeech spk;
    Score score = new Score();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda2_tela);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);



        spk = new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if (i != TextToSpeech.ERROR) {
                    spk.setLanguage(Locale.ENGLISH);
                }
            }
        });

        onNavigationItemSelected(navigationView.getMenu().getItem(1));
        onOptionsItemSelected(navigationView.getMenu().getItem(1));
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.segunda2_tela, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        /*
        if (id == R.id.action_settings) {
            return true;
        }
        */
        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Bundle b;

        if (id == R.id.nav_home) {
            Intent intent = new Intent(this, Main2Activity.class);
            startActivity(intent);
            finish();

        } else if (id == R.id.nav_palavras) {
            segundaTelaFrag tela2 = new segundaTelaFrag();
            b = getIntent().getExtras();
            tela2.setArguments(b);
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela2).commit();
        } else if (id == R.id.nav_pontuacao) {
            scoreFrag tela3 = new scoreFrag();
            Bundle s = new Bundle();
            s.putInt("certo", score.getAcerto());
            s.putInt("erro", score.getErro());
            s.putInt("pulo", score.getPulo());
            s.putInt("vresp", score.getViuResp());

            tela3.setArguments(s);
            getSupportFragmentManager().beginTransaction().replace(R.id.conteudo_fragment, tela3).commit();

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    public void speak(String texto){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
            spk.speak(texto,TextToSpeech.QUEUE_FLUSH, null,null);
        }else{
            spk.speak(texto,TextToSpeech.QUEUE_FLUSH, null);
        }
    }

    public void arrumaScore(Integer i){

        switch(i){
            case 1:
                score.setAcerto(score.getAcerto());
                break;
            case 2:
                score.setErro(score.getErro());
                break;
            case 3:
                score.setPulo(score.getPulo());
                break;
            case 4:
                score.setViuResp(score.getViuResp());
                break;
        }
    }

}
