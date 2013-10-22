package com.smartlife.smartlifec;

import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.setting.SettingDeviceTypeActivity;

import android.os.Bundle;
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
				SettingDeviceTypeActivity.getCurrentStoreId(this)) );
	}
    
}
