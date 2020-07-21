package com.example.servicio;

import android.app.Activity;
import android.app.AlarmManager;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends Activity {
	private EditText segundos;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        segundos = (EditText) findViewById(R.id.segundos);

        createNotificationChannel();
    }
    
    public void iniciaServicio(View view) {
    	Intent intent = new Intent(this, GetWeatherService.class);
    	startService(intent);
    }
    
    public void creaAlarma(View view) {
    	AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
    	Intent intent = new Intent(this, AlarmReceiver.class);
    	PendingIntent alarmPendingIntent = PendingIntent.getBroadcast(this, 0, intent, PendingIntent.FLAG_ONE_SHOT);

    	int milisegs = Integer.parseInt(segundos.getText().toString()) * 1000;
    	
    	alarmManager.set(AlarmManager.ELAPSED_REALTIME_WAKEUP, SystemClock.elapsedRealtime() + milisegs, alarmPendingIntent);    	
    	
    }

    private void createNotificationChannel() {
        NotificationChannel channel = new NotificationChannel("IdPrueba", "CanalPrueba", NotificationManager.IMPORTANCE_DEFAULT);
        channel.setDescription("Canal de pruebas");
        NotificationManager notificationManager = getSystemService(NotificationManager.class);
        notificationManager.createNotificationChannel(channel);
    }
}
