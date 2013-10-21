package com.smartlife.smartlifec;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class PoolControlImplActivity extends BaseControlActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_control_impl);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.pool_control_impl, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
    		switch(item.getItemId()) {
    		case R.id.action_choice_source:
    			// TODO : 添加源切换处理
    			Toast.makeText(this, "源切换", Toast.LENGTH_LONG).show();
    			return true;
    		case R.id.action_settings:
    			// TODO : 进入设置界面
    			Toast.makeText(this, "设置", Toast.LENGTH_LONG).show();
    			return true;
    		}
    	return super.onOptionsItemSelected(item);
    }
    
}
