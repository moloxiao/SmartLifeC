package com.smartlife.smartlifec;

import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.setting.SettingDeviceTypeActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class PoolControlImplActivity extends BaseControlViewActivity {

	private TextView deviceName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_control_impl);
        initView();
    }

	private void initView() {
		deviceName = (TextView)findViewById(R.id.control_device_name);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		deviceName.setText( DeviceType.getDesc(
				SettingDeviceTypeActivity.getCurrentStoredDeviceId(this)) );
	}

	@Override
	protected void showChoiceSourceDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);  
		builder.setTitle("数据源选择"); 
		builder.setPositiveButton("确定", null);  
		final int deviceId = SettingDeviceTypeActivity.getCurrentStoredDeviceId(this);
		Log.i("MOLO_DEBUG", "deviceId=" + deviceId);
		builder.setSingleChoiceItems(
				DeviceType.getSourceListsId(deviceId), 
				BaseControlActivity.getCurrentStoredSourceId(PoolControlImplActivity.this, deviceId), 
				new DialogInterface.OnClickListener() {

			@Override
			public void onClick(DialogInterface dialog, int which) {
				Log.i("MOLO_DEBUG", "which=" + which);
				BaseControlActivity.storeCurrentSourceId(PoolControlImplActivity.this, which, deviceId);
			}
			
		});
		AlertDialog ad = builder.create();  
		ad.show();  
	}
    
}
