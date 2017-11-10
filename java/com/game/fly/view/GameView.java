package com.game.fly.view;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class GameView extends View {

    //Game 状态
    public static final int STATUS_RUN   = 1; //运行中
    public static final int STATUS_PAUSE = 2; //暂停
    public static final int STATUS_OVER  = 3; //结束
    public int status = STATUS_OVER; //默认为结束状态

    //bitmap KEY R.ID
    public HashMap<String, Bitmap> drawableBitmap = new HashMap<String, Bitmap>();

    //精灵
    public List<Sprite> sprites = new ArrayList<Sprite>();

    //字体大小
    public int font_score_size = 12;
    public int font_draw_size  = 20;
    public int border_size      = 2;

    //绘制继续矩形画布
    public Rect continueRect = new Rect();

    //帧数
    public int frame = 0;

    //得分
    public int scor = 0;

    //画笔
    public Paint paint = null;
    public Paint fontPaint = null;

    //屏幕密度
    public int density = (int)getResources().getDisplayMetrics().density;

    //主要战机
    public PlaneSprite planeSprite = null;

    public void init(Context context)
    {
        //初始化属性
        //画笔
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);

        //字体画笔
        fontPaint = new TextPaint(Paint.ANTI_ALIAS_FLAG | Paint.FAKE_BOLD_TEXT_FLAG);
        fontPaint.setColor(0xff000000);
        font_score_size = (int)fontPaint.getTextSize();
        font_score_size *= density;
        font_draw_size  *= density;
        fontPaint.setTextSize(font_score_size);
        border_size     *= density;
    }

    public GameView(Context context)
    {
        super(context);
        init(context);
    }

    //必须提供否则会无法启动
    public GameView(Context context, AttributeSet addrs)
    {
        super(context, addrs);
        init(context);
    }

    public void run(HashMap<String, Integer> bitmapIds)
    {
        //状态 为 运行中
        status = STATUS_RUN;
        //生成 Bitmap hasMap
        Iterator iterator = bitmapIds.entrySet().iterator();
        while(iterator.hasNext())
        {
            Map.Entry entry = (Map.Entry) iterator.next();
            drawableBitmap.put(entry.getKey().toString(), BitmapFactory.decodeResource(getResources(), (int)entry.getValue()));
        }
        //生成战机对象
        planeSprite = new PlaneSprite(drawableBitmap.get("plane"), density, paint);
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

        //将战机移动到屏幕下方中间 最开始时
        if(0 == frame)
        {
            planeSprite.moveTo((canvas.getWidth() - planeSprite.width)/2, (canvas.getHeight() - planeSprite.height/2));
        }
        planeSprite.draw(canvas);
        frame++;
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
