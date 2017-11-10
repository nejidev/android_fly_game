package com.game.fly.view;

import android.graphics.Bitmap;
import android.graphics.Paint;

public class BossSprite extends Sprite {

    public BossSprite(Bitmap bitmap, int density, Paint paint)
    {
        super(bitmap);
        //修改属性
        this.paint = paint;
        speed = 1;
    }

}
