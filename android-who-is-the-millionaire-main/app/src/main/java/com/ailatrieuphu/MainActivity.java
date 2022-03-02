package com.ailatrieuphu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button bnt_start_now,cancelEventClick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        bindId();
    }

    public void bindId (){
        cancelEventClick = findViewById(R.id.gone_clearEnventClick);
        bnt_start_now = findViewById(R.id.bnt_start_now);

        cancelEventClick.setVisibility(View.GONE);

    }

    public void onStartNow(View view) {
        cancelEventClick.setVisibility(View.VISIBLE);
        Intent i = new Intent(this, PlayGameActivity.class);
        startActivity(i);
        cancelEventClick.setVisibility(View.INVISIBLE);
    }

    public void onTutorialPlayGame(View view){
        cancelEventClick.setVisibility(View.VISIBLE);
        Intent i = new Intent(this, TutorialPlayGames.class);
        startActivity(i);
        cancelEventClick.setVisibility(View.INVISIBLE);
    }

    public void onContributeQuestions(View view) {
        cancelEventClick.setVisibility(View.VISIBLE);
        Intent i = new Intent(this, ContributeQuestionsActivity.class);
        startActivity(i);
        cancelEventClick.setVisibility(View.INVISIBLE);
    }
}