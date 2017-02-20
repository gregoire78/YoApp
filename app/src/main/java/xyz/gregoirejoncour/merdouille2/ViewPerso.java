package xyz.gregoirejoncour.merdouille2;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by gregoire on 20/02/2017.
 */

public class ViewPerso extends View {

    //pinceau
    private Paint p = new Paint();

    public ViewPerso(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void onDraw(Canvas canvas) {

        //rectangle noir
        p.setColor(Color.BLACK);
        p.setStyle(Paint.Style.FILL);

        canvas.drawRect(0,0, getWidth(), getHeight(), p);

        // texte blanc
        p.setColor(Color.WHITE);
        int sizeFont = getResources().getDimensionPixelSize(R.dimen.font_size_default);
        p.setTextSize(sizeFont);
        p.setTextAlign(Paint.Align.CENTER);

        String texte = getResources().getString(R.string.app_name);
        canvas.drawText(texte, getWidth()/2, getHeight()/2, p);
    }
}
