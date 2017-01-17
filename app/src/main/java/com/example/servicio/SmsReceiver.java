package com.example.servicio;

import java.util.Date;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.provider.Telephony;
import android.telephony.SmsMessage;
import android.util.Log;

public class SmsReceiver extends BroadcastReceiver {

	@Override
	public void onReceive(Context context, Intent intent) {
		if (intent.getAction().equals("android.provider.Telephony.SMS_RECEIVED")) {
			SmsMessage[] pdus = Telephony.Sms.Intents.getMessagesFromIntent(intent);
			Log.d("SmsReceiver", "pdus.length: " + String.valueOf(pdus.length));
            for (SmsMessage sms : pdus) {
            	Log.d("SmsReceiver", "from: " + sms.getOriginatingAddress());
            	Log.d("SmsReceiver", "date: " + (new Date(sms.getTimestampMillis())).toString());
            	Log.d("SmsReceiver", "body: " + sms.getMessageBody());
            }
		}
	}

}
