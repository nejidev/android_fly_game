package com.game.fly.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.game.fly.view.GameView;

public class GameActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameView = (GameView)findViewById(R.id.gameView);
        int[] bitmapIds = {
                R.drawable.plane,
                R.drawable.explosion,
                R.drawable.yellow_bullet,
                R.drawable.blue_bullet,
                R.drawable.small,
                R.drawable.middle,
                R.drawable.big,
                R.drawable.bomb_award,
                R.drawable.bullet_award,
                R.drawable.pause1,
                R.drawable.pause2,
                R.drawable.bomb
        };
        gameView.run(bitmapIds);
    }

    protected void onPause()
    {
        super.onPause();
        if(null != gameView)
        {
            gameView.pause();
        }
    }

    protected void onDestroy()
    {
        super.onDestroy();
        if(null != gameView)
        {
            gameView.destroy();
        }
        gameView = null;
    }
}
