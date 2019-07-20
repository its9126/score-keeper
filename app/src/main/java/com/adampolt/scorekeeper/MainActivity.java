package com.adampolt.scorekeeper;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int score1 = 0;
    int score2 = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshView();

        Button increment1 = findViewById(R.id.increment1);
        Button increment2 = findViewById(R.id.increment2);
        Button reset = findViewById(R.id.reset);

        increment1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1++;
                refreshView();
            }
        });

        increment2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score2++;
                refreshView();
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                score1 = 0;
                score2 = 0;
                refreshView();
            }
        });
    }

    private void refreshView() {
        TextView player1ScoreView = findViewById(R.id.p1score);
        TextView player2ScoreView = findViewById(R.id.p2score);

        player1ScoreView.setText(String.valueOf(score1));
        player2ScoreView.setText(String.valueOf(score2));

        if(score1 > score2) {
            player1ScoreView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.winning));
            player2ScoreView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.losing));
        } else if(score2 > score1) {
            player2ScoreView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.winning));
            player1ScoreView.setTextColor(ContextCompat.getColor(MainActivity.this, R.color.losing));
        } else {
            player1ScoreView.setTextColor(Color.BLACK);
            player2ScoreView.setTextColor(Color.BLACK);
        }
    }
}
