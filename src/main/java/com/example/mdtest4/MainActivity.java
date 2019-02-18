package com.example.mdtest4;

import java.util.ArrayList;
import java.util.List;

import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.RecyclerView.Adapter;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.RelativeLayout.LayoutParams;

public class MainActivity extends AppCompatActivity {

	private RecyclerView recyclerview;
	private ImageButton fab;
	private Toolbar toolbar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		recyclerview = (RecyclerView)findViewById(R.id.recyclerview);
		fab = (ImageButton)findViewById(R.id.fab);

		toolbar = (Toolbar)findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
		setTitle("标题");
		recyclerview.setLayoutManager(new LinearLayoutManager(this));
		List<String> list = new ArrayList<>();
		for (int i = 0; i < 60; i++) {
			list.add("Item"+i);
		}
		Adapter adapter = new FabRecyclerAdapter(list );
		recyclerview.setAdapter(adapter );

	}

	public void rotate(View v){
		Snackbar.make(v, "倩倩该吃药了！", Snackbar.LENGTH_SHORT)
				.setAction("确定", new OnClickListener() {

					@Override
					public void onClick(View v) {
						Toast.makeText(getApplicationContext(), "吃过啦", 0).show();
					}
				})
				.show();
	}
}