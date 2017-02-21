package xyz.gregoirejoncour.merdouille2;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by gregoire on 20/02/2017.
 */

public class ViewPerso extends View {

    //pinceau
    private Paint p = new Paint();
    private Bitmap logo = null;
    private float xOri = 0, yOri = 0;
    int largImage, hautImage;

    private float deltaX = 0, deltaY = 0;
    boolean move = false;

    public ViewPerso(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);

        BitmapDrawable d = (BitmapDrawable) getResources().getDrawable(R.drawable.sncf);
        logo = d.getBitmap();
        largImage = logo.getWidth();
        hautImage = logo.getHeight();
    }

    public void onDraw(Canvas canvas) {

        //rectangle noir
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);

        canvas.drawRect(0, 0, getWidth(), getHeight(), p);

        canvas.drawBitmap(logo, xOri, yOri, p);

        // texte blanc
        p.setColor(Color.WHITE);
        int sizeFont = getResources().getDimensionPixelSize(R.dimen.font_size_default);
        p.setTextSize(sizeFont);
        p.setTextAlign(Paint.Align.CENTER);

        String texte = getResources().getString(R.string.app_name);
        canvas.drawText(texte, getWidth() / 2, getHeight() / 2, p);
    }

    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                deltaX = event.getX() - xOri;
                deltaY = event.getY() - yOri;

                if (deltaX >= 0 && deltaX <= largImage
                        && deltaY >= 0 && deltaY <= hautImage) {
                    move = true;
                }
                break;
            case MotionEvent.ACTION_MOVE:
                if (move) {
                    xOri = event.getX() - deltaX;
                    yOri = event.getY() - deltaY;
                }
                break;
            case MotionEvent.ACTION_UP:
                move = false;
                break;
        }
        invalidate();
        return true;
    }
}
