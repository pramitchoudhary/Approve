package com.approve.android;

import android.app.Activity;
import android.os.Bundle;

public class ApproveActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MyGIFView view = new MyGIFView(this);
		setContentView(view);
	}
}