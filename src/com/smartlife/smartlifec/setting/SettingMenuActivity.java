package com.smartlife.smartlifec.setting;

import com.smartlife.smartlifec.R;
import com.smartlife.smartlifec.domain.DeviceType;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class SettingMenuActivity extends Activity {
	
	private static final String PREFS_NAME = "ScreenList";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
	}
	
	public void btnChoiceDevice(View view) {
		startActivity(new Intent(SettingMenuActivity.this, SettingDeviceTypeActivity.class));
	}
	
	public void btnChangeIp(View view) {
		startActivity(new Intent(SettingMenuActivity.this, SettingIpInfoActivity.class));
	}
	
	public void btnChangeScreen(View view) {
		showChoiceScreenDialog();
	}

	private void showChoiceScreenDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		builder.setTitle("数据源选择"); 
		builder.setPositiveButton("确定", null);  
		final int deviceId = SettingDeviceTypeActivity.getCurrentStoredDeviceId(this);
		builder.setSingleChoiceItems(
				DeviceType.getScreenListsId(deviceId), 
				SettingMenuActivity.getCurrentStoredScreenId(SettingMenuActivity.this, deviceId), 
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				SettingMenuActivity.storeCurrentScreenId(SettingMenuActivity.this, which, deviceId);
			}
			
		});
		AlertDialog ad = builder.create();  
		ad.show();
		
	}

	public static void storeCurrentScreenId(
			Context context, int id, int deviceId) {
		
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("screenId", id);

	    editor.commit();
	}

	public static int getCurrentStoredScreenId(
			Context context, int deviceId) {
		int max = DeviceType.getMaxScreenSize(deviceId);
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    int id = settings.getInt("screenId", 0);
	    if(id >= max) {
			id = 0;
		}
		return id;
	}
}
