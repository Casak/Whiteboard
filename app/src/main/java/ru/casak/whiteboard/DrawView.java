package ru.casak.whiteboard;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

public class DrawView extends View {
    public static final int THIN = 10;
    public static final int MEDIUM_THIN = 20;
    public static final int MEDIUM = 30;
    public static final int BOLD = 40;

    public static final int RED = Color.RED;
    public static final int GREEN = Color.GREEN;
    public static final int BLUE = Color.BLUE;
    public static final int BLACK = Color.BLACK;

    private final static Paint paint = new Paint(Paint.DITHER_FLAG);
    private final static Path path = new Path();

    private Bitmap canvasBitmap;
    private static Canvas canvasDraw;

    private static DrawView instance;

    public DrawView(Context context) {
        super(context);
        init();
    }

    public DrawView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        canvasBitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        canvasDraw = new Canvas(canvasBitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.drawBitmap(canvasBitmap, 0, 0, paint);
        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final float touchX = event.getX();
        final float touchY = event.getY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_MOVE:
                path.lineTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_DOWN:
                path.moveTo(touchX, touchY);
                break;
            case MotionEvent.ACTION_UP:
                canvasDraw.drawPath(path, paint);
                path.reset();
                break;
            default:
                return false;
        }

        invalidate();
        return true;
    }

    public static Paint setWidth(int width) {
        paint.setStrokeWidth(width);
        return paint;
    }

    public static Paint setColor(int color) {
        paint.setColor(color);
        return paint;
    }

    public static void clear() {
        if (canvasDraw != null)
            canvasDraw.drawRGB(255, 255, 255);
        if (instance != null)
            instance.invalidate();
    }

    private void init() {
        instance = this;
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeJoin(Paint.Join.ROUND);
        paint.setStrokeCap(Paint.Cap.ROUND);
        paint.setAntiAlias(true);
        setWidth(THIN);
        setColor(BLACK);
        clear();
    }
}