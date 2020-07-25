package com.nejidev.android_fly_game.view;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;

public class ExplosionSprite extends Sprite {

    public int i = 0;

    public ExplosionSprite(Bitmap bitmap, int density, Paint paint)
    {
        super(bitmap);
        //修改属性
        this.paint = paint;
        //重新修改图片的宽度 因为是 所有效果全做在同一张图上
        //高 64px 宽 896 正好是 14个 平铺的图片
        width = height;
    }

    public Rect getSrcRect()
    {
        Rect rect = super.getSrcRect();
        rect.offsetTo(i*width, 0);
        return rect;
    }

    public void draw(Canvas canvas)
    {
        if(0 == frame % 2)
        {
            i++;
        }
        if(14 <= i)
        {
            bitmap = null;
        }
        else
        {
            super.draw(canvas);
        }
    }

}
