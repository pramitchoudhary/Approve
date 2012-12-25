package com.approve.android;

import java.io.InputStream;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Movie;
import android.view.View;

public class MyGIFView extends View {

	Movie movie, movie1;
	InputStream is = null, is1 = null;
	long moviestart;

	public MyGIFView(Context context) {
		super(context);

		// Provide your own gif animation file

		is = context.getResources().openRawResource(R.drawable.digits);
		movie = Movie.decodeStream(is);

		// TODO work on parsing JSON response
		// TODO work on multiple images
		// TODO work on displaying simple ID and date
	}

	@Override
	protected void onDraw(Canvas canvas) {

		canvas.drawColor(Color.WHITE);
		super.onDraw(canvas);
		long now = android.os.SystemClock.uptimeMillis();
		System.out.println("now=" + now);
		if (moviestart == 0) { // first time
			moviestart = now;

		}
		System.out.println("\tmoviestart=" + moviestart);
		int relTime = (int) ((now - moviestart) % movie.duration());
		System.out.println("time=" + relTime + "\treltime=" + movie.duration());
		movie.setTime(relTime);
		movie.draw(canvas, this.getWidth() / 2 - 20, this.getHeight() / 2 - 40);
		this.invalidate();
	}
}