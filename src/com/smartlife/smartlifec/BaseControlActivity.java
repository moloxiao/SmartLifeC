package com.smartlife.smartlifec;

import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.domain.IControl;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public abstract class BaseControlActivity extends Activity 
		implements IControl{

	private static final String PREFS_NAME = "SourceList";
	
	public static int getCurrentStoredSourceId(Context context, final int deviceId) {
		int max = DeviceType.getMaxSourceSize(deviceId);
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    int id = settings.getInt("sourceId", 0);
	    Log.i("MOLO_DEBUG", "native source id =" + id);
	    if(id >= max) {
			id = 0;
		}
		return id;
	}
	
	public static void storeCurrentSourceId(Context context, int id, final int deviceId) {
		int max = DeviceType.getMaxSourceSize(deviceId);
		if(id >= max) {
			id = 0;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("sourceId", id);

	    editor.commit();
	}
}
