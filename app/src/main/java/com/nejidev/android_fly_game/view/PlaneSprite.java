package com.nejidev.android_fly_game.view;

import android.graphics.Bitmap;
import android.graphics.Paint;

public class PlaneSprite extends Sprite {

    public PlaneSprite(Bitmap bitmap, int density, Paint paint)
    {
        super(bitmap);
        //修改属性
        this.paint = paint;
        //玩家战机不能自己飞 手工操控
        speed = 0;
    }

}
