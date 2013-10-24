package com.smartlife.smartlifec.setting;

import com.smartlife.smartlifec.PoolControlImplActivity;
import com.smartlife.smartlifec.R;
import com.smartlife.smartlifec.domain.DeviceType;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioGroup;

public class SettingInitActivity extends Activity {

	private RadioGroup radioGroup;
	private EditText ip;
	private EditText port;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_init);
		initView();
	}
	
	private void initView() {
		radioGroup = (RadioGroup) findViewById(R.id.radiogroup_id);
		if(radioGroup != null) {
			radioGroup.check(SettingDeviceTypeActivity.getCurrentStoredDeviceId(this));
		}
		
		ip = (EditText)findViewById(R.id.edit_ip);
		port = (EditText)findViewById(R.id.edit_port);
		ip.setText(SettingIpInfoActivity.getIp(this));
		port.setText(""+SettingIpInfoActivity.getPort(this));
	}
	
	private void storeInfo() {
		saveDeviceInfo();
		saveIpAndPortInfo();
	}
	
	private void saveDeviceInfo() {
		int id = getCurrentChoicedId();
		SettingDeviceTypeActivity.storeCurrentId(this, id);
	}
	
	private void saveIpAndPortInfo() {
		SettingIpInfoActivity.saveIpAndPort(this, 
				ip.getText().toString(), 
				Integer.parseInt(port.getText().toString()) );
		
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
	
	public void btnConture(View view) {
		// TODO : 还需要检查数据有效性
		view.setEnabled(false);
		storeInfo();
		startActivity(new Intent(SettingInitActivity.this, PoolControlImplActivity.class));
		finish();
	}
}
