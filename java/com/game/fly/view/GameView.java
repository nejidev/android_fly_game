package com.game.fly.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.util.Log;
import android.view.View;

import java.util.HashMap;

public class GameView extends View {

    //Game 状态
    public static final int STATUS_RUN   = 1; //运行中
    public static final int STATUS_PAUSE = 2; //暂停
    public static final int STATUS_OVER  = 3; //结束
    public int status = STATUS_OVER; //默认为结束状态

    //bitmap KEY R.ID
    public HashMap<Integer, Bitmap> drawableBitmap = new HashMap<Integer, Bitmap>();

    //字体大小
    public int font_score_size = 12;

    //屏幕密度
    public int density = (int)getResources().getDisplayMetrics().density;

    public GameView(Context context) {
        super(context);
    }

    public void run(int[] bitmapIDs)
    {
        //状态 为 运行中
        status = STATUS_RUN;
        //生成 Bitmap hasMap
        for(int bitmapID : bitmapIDs)
        {
            drawableBitmap.put(bitmapID, BitmapFactory.decodeResource(getResources(), bitmapID));
        }
        //绘制UI
        postInvalidate();
    }

    protected void onDraw(Canvas canvas)
    {
        super.onDraw(canvas);
        if(STATUS_RUN == status)
        {
            drawGameRun(canvas);
        }
        else if(STATUS_PAUSE == status)
        {
            drawGamePause(canvas);
        }
        else if(STATUS_OVER == status)
        {
            drawGameOver(canvas);
        }
    }

    public void drawGameRun(Canvas canvas)
    {
        Log.d("GameView", "game draw run");
        //重绘UI
        postInvalidate();
    }

    public void drawGamePause(Canvas canvas)
    {

    }

    public void drawGameOver(Canvas canvas)
    {

    }

    public void destroy()
    {

    }

    public void pause()
    {

    }
}
