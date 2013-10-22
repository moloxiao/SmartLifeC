package com.smartlife.smartlifec;

import java.util.Arrays;

import com.smartlife.smartlifec.connect.ControlManager;
import com.smartlife.smartlifec.connect.ControlOrderType;
import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.setting.SettingDeviceTypeActivity;
import com.smartlife.smartlifec.setting.SettingMenuActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PoolControlImplActivity extends BaseControlViewActivity {

	private TextView deviceName;
	private TextView sourceName;
	private TextView screenName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_control_impl);
        initView();
    }

	private void initView() {
		deviceName = (TextView)findViewById(R.id.control_device_name);
		sourceName = (TextView)findViewById(R.id.control_source_id);
		screenName = (TextView)findViewById(R.id.control_screen_id);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		int deviceId = SettingDeviceTypeActivity.getCurrentStoredDeviceId(this);
		deviceName.setText( DeviceType.getDesc(deviceId));
		int sourceId = BaseControlActivity.getCurrentStoredSourceId(PoolControlImplActivity.this, deviceId) + 1;
		sourceName.setText("节目源:" + sourceId);
		changeSourceId(sourceId);
		int screenId = SettingMenuActivity.getCurrentStoredScreenId(PoolControlImplActivity.this, deviceId) + 1;
		screenName.setText("线路:" + screenId);
	}
	
	private void  changeSourceId(int sourceId) {
		byte[] setSourceOrderData = ControlManager.getControlOrder(
				ControlOrderType.getType(sourceId), 
				ControlManager.getSourceId(sourceId));
		if(setSourceOrderData != null) {
			Log.i("MOLO_DEBUG", "setSourceOrderData=[" + Arrays.toString(setSourceOrderData) + "]");
			send(setSourceOrderData);
		}else {
			Log.e("MOLO_DEBUG", "error send setSourceOrderData");
		}
	}

	@Override
	protected void showChoiceSourceDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		builder.setTitle("数据源选择"); 
		builder.setPositiveButton("确定", null);  
		final int deviceId = SettingDeviceTypeActivity.getCurrentStoredDeviceId(this);
		builder.setSingleChoiceItems(
				DeviceType.getSourceListsId(deviceId), 
				BaseControlActivity.getCurrentStoredSourceId(PoolControlImplActivity.this, deviceId), 
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				BaseControlActivity.storeCurrentSourceId(PoolControlImplActivity.this, which, deviceId);
				int sourceId = BaseControlActivity.getCurrentStoredSourceId(PoolControlImplActivity.this, deviceId) + 1;
				sourceName.setText("节目源:" + sourceId);
				changeSourceId(sourceId);
			}
			
		});
		AlertDialog ad = builder.create();  
		ad.show();  
	}
    
}
