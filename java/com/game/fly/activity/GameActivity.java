package com.game.fly.activity;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.game.fly.view.GameView;

import java.util.HashMap;

public class GameActivity extends Activity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        gameView = (GameView)findViewById(R.id.gameView);

        HashMap<String, Integer> bitmapIds = new HashMap<String, Integer>();
        bitmapIds.put("plane", R.drawable.plane);
        bitmapIds.put("explosion", R.drawable.explosion);
        bitmapIds.put("yellow_bullet", R.drawable.yellow_bullet);
        bitmapIds.put("blue_bullet", R.drawable.blue_bullet);
        bitmapIds.put("small", R.drawable.small);
        bitmapIds.put("big", R.drawable.big);
        bitmapIds.put("bomb_award", R.drawable.bomb_award);
        bitmapIds.put("bullet_award", R.drawable.bullet_award);
        bitmapIds.put("pause1", R.drawable.pause1);
        bitmapIds.put("pause2", R.drawable.pause2);
        bitmapIds.put("bomb", R.drawable.bomb);
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
