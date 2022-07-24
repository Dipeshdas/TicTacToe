package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent=getIntent();
        String message=intent.getStringExtra(MainActivity2.MSG);

        TextView textView=findViewById(R.id.status);
        textView.setText(message);
    }
    boolean gameActive =true;
    //0-0
    //1-x
    int activePlayer=0;
    int []gameState={2,2,2,2,2,2,2,2,2};
    //0-X
    //1-O
    //2-null
    int [][] winPositions={{0,1,2},{3,4,5},{6,7,8},
                          {0,3,6},{1,4,7},{2,5,8},
                          {0,4,8},{2,4,6}};
    public void playerTap(View view){
        ImageView img=(ImageView) view;
        int tappedimage=Integer.parseInt(img.getTag().toString());
//        if(!gameActive){
//            gameRestart(view);
//        }
        if(gameState[tappedimage]==2){
            gameState[tappedimage]=activePlayer;
            img.setTranslationY(-1000f);
            if(activePlayer==0){
                img.setImageResource(R.drawable.croosss);
                activePlayer=1;
                TextView status =findViewById(R.id.status);
                status.setText("O's Turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.oo);
                activePlayer=0;
                TextView status =findViewById(R.id.status);
                status.setText("X's Turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(400);
        }
        //check if any player has won
        for(int []  winPosition: winPositions){
            if(gameState[winPosition[0]]==gameState[winPosition[1]]&&
                    gameState[winPosition[1]]==gameState[winPosition[2]]&&
                    gameState[winPosition[0]]!=2){
                //Find who wons
                String winner;
                gameActive=false;
                if(gameState[winPosition[0]]==0){
                    winner="X has won - tap to restart";
                }
                else{
                    winner="O has won -tap to restart";
                }
                TextView status =findViewById(R.id.status);
                status.setText(winner);
            }
        }
    }
    public void gameRestart(View view){
        gameActive=true;
        activePlayer=0;
        for(int i=0;i<gameState.length;i++){
            gameState[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView0)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView1)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView5)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView6)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView7)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        TextView status =findViewById(R.id.status);
        status.setText("X's Turn - Tap to play");
    }

}