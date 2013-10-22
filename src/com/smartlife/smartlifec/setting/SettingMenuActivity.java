package com.smartlife.smartlifec.setting;

import com.smartlife.smartlifec.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SettingMenuActivity extends Activity {
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting);
	}
	
	public void btnChoiceDevice(View view) {
		startActivity(new Intent(SettingMenuActivity.this, SettingDeviceTypeActivity.class));
	}
}
