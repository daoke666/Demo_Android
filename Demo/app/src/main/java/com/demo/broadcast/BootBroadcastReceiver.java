package com.demo.broadcast;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.demo.service.AppService;

public class BootBroadcastReceiver extends BroadcastReceiver {

	private static final String TAG = "servicedemo";
	
	private static Context mContext;
	
	@Override
	public void onReceive(Context context, Intent intent) {

		mContext = context;

		String action = intent.getAction();

		Log.e(TAG, "BootBroadcastReceiver action  = " + action);

		if (action == null) {
			return;
		}
		
		if (action.equals("android.intent.action.BOOT_COMPLETED")) {
			 Log.i(TAG, "BOOT_COMPLETED");
			 
	            Intent i = new Intent(context, AppService.class);
	            i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
	            context.startService(i);
		}
	}
	
}