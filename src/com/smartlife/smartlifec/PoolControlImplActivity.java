package com.smartlife.smartlifec;

import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.setting.SettingDeviceTypeActivity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.TextView;

public class PoolControlImplActivity extends BaseControlViewActivity {

	private TextView deviceName;
	private TextView sourceName;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_control_impl);
        initView();
    }

	private void initView() {
		deviceName = (TextView)findViewById(R.id.control_device_name);
		sourceName = (TextView)findViewById(R.id.control_source_id);
	}
	
	@Override
	protected void onResume() {
		super.onResume();
		int deviceId = SettingDeviceTypeActivity.getCurrentStoredDeviceId(this);
		deviceName.setText( DeviceType.getDesc(deviceId));
		int sourceId = BaseControlActivity.getCurrentStoredSourceId(PoolControlImplActivity.this, deviceId) + 1;
		sourceName.setText("屏幕:" + sourceId);
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
				sourceName.setText("屏幕:" + sourceId);
			}
			
		});
		AlertDialog ad = builder.create();  
		ad.show();  
	}
    
}
