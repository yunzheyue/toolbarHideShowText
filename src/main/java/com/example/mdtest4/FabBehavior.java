package com.example.mdtest4;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.view.ViewCompat;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;

public class FabBehavior extends CoordinatorLayout.Behavior {
	private boolean visible = true;//是否可见

	public FabBehavior(Context context,AttributeSet attrs) {
		super();
	}

    @Override
    public boolean onStartNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View directTargetChild, @NonNull View target, int axes, int type) {
		// 当观察的View（RecyclerView）发生滑动的开始的时候回调的
		//nestedScrollAxes:滑动关联轴， 我们现在只关心垂直的滑动。
        return axes==ViewCompat.SCROLL_AXIS_VERTICAL||super.onStartNestedScroll(coordinatorLayout, child, directTargetChild, target, axes, type);
    }

    @Override
    public void onNestedScroll(@NonNull CoordinatorLayout coordinatorLayout, @NonNull View child, @NonNull View target, int dxConsumed, int dyConsumed, int dxUnconsumed, int dyUnconsumed, int type) {
        super.onNestedScroll(coordinatorLayout, child, target, dxConsumed, dyConsumed, dxUnconsumed, dyUnconsumed, type);
//		// 当观察的view滑动的时候回调的
//		//根据情况执行动画
        if(child instanceof FloatingActionButton){
            if(dyConsumed>0&&visible){
                //show
                visible = false;
                onHide((FloatingActionButton)child);
            }else if(dyConsumed<0){
                //hide
                visible = true;
                onShow((FloatingActionButton)child);
            }
        }
    }

	public void onHide(FloatingActionButton fab) {
		// 隐藏动画--属性动画
//		toolbar.animate().translationY(-toolbar.getHeight()).setInterpolator(new AccelerateInterpolator(3));
		MarginLayoutParams layoutParams = (MarginLayoutParams) fab.getLayoutParams();

//		fab.animate().translationY(fab.getHeight()+layoutParams.bottomMargin).setInterpolator(new AccelerateInterpolator(3));
		ViewCompat.animate(fab).scaleX(0f).scaleY(0f).start();
	}

	public void onShow(FloatingActionButton fab) {
		// 显示动画--属性动画
//		toolbar.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));

		MarginLayoutParams layoutParams = (MarginLayoutParams)  fab.getLayoutParams();
//		fab.animate().translationY(0).setInterpolator(new DecelerateInterpolator(3));
		ViewCompat.animate(fab).scaleX(1f).scaleY(1f).start();
	}

}