package com.smartlife.smartlifec.setting;

import com.smartlife.smartlifec.R;
import com.smartlife.smartlifec.domain.DeviceType;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.RadioGroup;

public class SettingDeviceTypeActivity extends Activity {

	private static final String PREFS_NAME = "DeviceType";
	private RadioGroup radioGroup;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_device_type);
		initView();
	}

	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_id);
		if(radioGroup != null) {
			radioGroup.check(getCurrentStoredDeviceId(this));
		}
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		int id = getCurrentChoicedId();
		storeCurrentId(this, id);
	}

	private int getCurrentChoicedId() {
		int rbid = radioGroup.getCheckedRadioButtonId();
		switch(rbid) {
		case R.id.radiogroup_hm404:
			return DeviceType.TYPE_HM404.getId();
		case R.id.radiogroup_hm406:
			return DeviceType.TYPE_HM406.getId();
		case R.id.radiogroup_hm808:
			return DeviceType.TYPE_HM808.getId();
		}
		return DeviceType.TYPE_UNDEFINE.getId();
	}

	public static int getCurrentStoredDeviceId(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    int id = settings.getInt("type", DeviceType.TYPE_UNDEFINE.getId());
		return id;
	}
	
	public static void storeCurrentId(Context context, int id) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("type", id);

	    editor.commit();
	}
}
