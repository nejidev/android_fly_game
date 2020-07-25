package com.nejidev.android_fly_game.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class Sprite {

    //坐标位置
    public int x = 0;
    public int y = 0;

    //宽高
    public int width  = 0;
    public int height = 0;

    //移动种子
    public int speed = 0;

    //屏幕密度
    public int density = 1;

    //可见性
    public boolean visibility = true;

    //bitmap
    public Bitmap bitmap = null;

    //画笔
    public Paint paint = null;

    //生命
    public int life = 1;

    //当前帧数
    public int frame = 0;

    public Sprite(Bitmap bitmap)
    {
        this.bitmap = bitmap;
        width  = bitmap.getWidth();
        height = bitmap.getHeight();
    }

    //移动到显示位置
    public void moveTo(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    //移动偏移位置
    public void move(int offsetX, int offsetY)
    {
        x += offsetX;
        y += offsetY;
    }

    //原始坐标
    public Rect getSrcRect()
    {
        return new Rect(0, 0, width, height);
    }

    //目标坐标
    public Rect getDescRect()
    {
        //目标移动
        move(0, speed * density);
        return new Rect(x, y, x+width, y+height);
    }

    public void draw(Canvas canvas)
    {
        Rect canvasRecf;
        frame++;
        //如果 bitmap 没有被销毁 并且是可见状态就绘制
        if(null != bitmap && visibility)
        {
            canvas.drawBitmap(bitmap, getSrcRect(), getDescRect(), paint);
        }
        canvasRecf = new Rect(0, 0, canvas.getWidth(), canvas.getHeight());
        //检查是否有交集
        if(! Rect.intersects(canvasRecf, getDescRect()))
        {
            destroy();
        }
    }

    public void destroy()
    {
        bitmap = null;
    }
}
