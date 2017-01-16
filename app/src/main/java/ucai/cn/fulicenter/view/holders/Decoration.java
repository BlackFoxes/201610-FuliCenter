package ucai.cn.fulicenter.view.holders;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import ucai.cn.fulicenter.R;
import ucai.cn.fulicenter.application.I;

/**
 * Created by BlackFox on 2017/1/13.
 */

public class Decoration extends RecyclerView.ItemDecoration {
    private int dividerSpace;
    int Type;

    public Decoration(int width,int Type) {
        dividerSpace = width;
        this.Type = Type;

    }
    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
    }
    @Override
    public void onDrawOver(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDrawOver(c, parent, state);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        switch (Type) {
            case 0:
                outRect.left = dividerSpace;
                outRect.bottom=dividerSpace;
                if (parent.getChildPosition(view) % 2 == 0) {
                    outRect.left=0;

                }
                break;
            case 1:
                outRect.bottom = dividerSpace;

                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                break;
        }

    }
}
