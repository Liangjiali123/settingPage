package com.example.settingpage;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.SeekBar;

import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatSeekBar;

public class SeekBarFragmen extends AppCompatSeekBar {

    private Paint seekPaint;
    private Paint bgPaint;
    private float downX;
    private float moveX;


    public SeekBarFragmen(Context context) {
        super(context);
    }

    public SeekBarFragmen(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initState();
    }

    public SeekBarFragmen(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private void initState() {
        seekPaint = new Paint();
        seekPaint.setAntiAlias(true);
        seekPaint.setStyle(Paint.Style.STROKE);
        seekPaint.setStrokeWidth(5);
        seekPaint.setColor(Color.parseColor("#C0C0C0"));

        bgPaint = new Paint();
        bgPaint.setAntiAlias(true);
        bgPaint.setStyle(Paint.Style.STROKE);
        bgPaint.setStrokeWidth(10);
        bgPaint.setColor(Color.parseColor("#2B65EC"));

    }

    @Override
    protected synchronized void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawLine(0,getHeight()/2,getWidth(),getHeight()/2,seekPaint);

        canvas.drawLine(downX,getHeight()/2,moveX,getHeight()/2,bgPaint);
        canvas.save();
        canvas.restore();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                downX = event.getX();
                break;
            case MotionEvent.ACTION_MOVE:
                moveX = event.getX();

                break;
            case MotionEvent.ACTION_UP:
                break;
            case MotionEvent.ACTION_CANCEL:
                break;
        }
        return true;
    }
}
