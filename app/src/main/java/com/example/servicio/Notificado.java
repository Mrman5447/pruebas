package com.example.servicio;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class Notificado extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		
		String clima = getIntent().getStringExtra("clima");
		TextView tv = new TextView(this);
		tv.setText(new String(clima));
		tv.setTextColor(Color.BLUE);
		setContentView(tv);

	}

}
