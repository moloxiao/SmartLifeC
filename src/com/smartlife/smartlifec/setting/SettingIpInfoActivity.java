package com.smartlife.smartlifec.setting;

import com.smartlife.smartlifec.R;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class SettingIpInfoActivity extends Activity {

	private static final String PREFS_NAME = "IpInfo";
	public static final int DEFAULT_SERVER_PORT = 55555;
	
	private EditText ip;
	private EditText port;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_setting_ip);
		initView();
		initData();
	}

	private void initView() {
		ip = (EditText)findViewById(R.id.edit_ip);
		port = (EditText)findViewById(R.id.edit_port);
	}
	
	private void initData() {
		ip.setText(SettingIpInfoActivity.getIp(this));
		port.setText(""+SettingIpInfoActivity.getPort(this));
	}
	
	@Override
	protected void onStop() {
		super.onStop();
		saveIpAndPortInfo();
	}

	private void saveIpAndPortInfo() {
		SettingIpInfoActivity.saveIpAndPort(this, 
				ip.getText().toString(), 
				Integer.parseInt(port.getText().toString()) );
		
	}

	public static int getPort(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    int portInfo = settings.getInt("port", DEFAULT_SERVER_PORT);
		return portInfo;
	}

	public static String getIp(Context context) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    String ipStr = settings.getString("ip", "");
		return ipStr;
	}
	
	public static void saveIpAndPort(Context context, String ip, int port) {
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("port", port);
	    editor.putString("ip", ip);

	    editor.commit();
	}
	
}
