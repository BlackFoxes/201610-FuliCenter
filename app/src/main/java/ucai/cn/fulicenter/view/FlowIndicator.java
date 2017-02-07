package ucai.cn.fulicenter.view;

import android.content.ContentProvider;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Point;
import android.support.annotation.Dimension;
import android.util.AttributeSet;
import android.view.View;

import ucai.cn.fulicenter.R;

/**
 * Created by BlackFox on 2017/1/19.
 */

public class FlowIndicator extends View {
    int count,norColor, fosColor,focus;
    Paint paint;
    int r;
    int space;

    public FlowIndicator(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public FlowIndicator(Context context) {
        super(context);
    }

    public FlowIndicator(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.FlowIndicator);
        count= typedArray.getInteger(R.styleable.FlowIndicator_count, 0);
        r = typedArray.getInteger(R.styleable.FlowIndicator_r, 0);
        space = typedArray.getInteger(R.styleable.FlowIndicator_space, 0);
        norColor = typedArray.getColor(R.styleable.FlowIndicator_normal_color, Color.GRAY);
        fosColor = typedArray.getColor(R.styleable.FlowIndicator_focus_color, Color.RED);
        focus = typedArray.getInteger(R.styleable.FlowIndicator_focus, 0);
        paint = new Paint();
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
    }

    public void setFocus(int a) {
        this.focus=a;
    }
    public void setCount(int b) {
        this.count=b;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for (int i=0;i<count;i++) {
            if (i == focus) {
                paint.setColor(fosColor);
            } else {
                paint.setColor(norColor);
            }
            canvas.drawCircle(r+i*(2*r+space),r,r,paint);
        }
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measureWidth = 0,measureHeight = 0;
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        if (modeWidth == MeasureSpec.EXACTLY) {
            measureWidth=sizeWidth;
        } else {
            measureWidth = 2 * r * count+ (count-1)* space + getPaddingLeft() + getPaddingRight();
        }
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (modeHeight == MeasureSpec.EXACTLY) {
            measureHeight = sizeHeight;
        } else {
            measureHeight = 2 * r + getPaddingBottom() + getPaddingTop();

        }
        setMeasuredDimension(measureWidth,measureHeight);

    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }
}
