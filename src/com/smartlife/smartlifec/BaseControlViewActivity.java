package com.smartlife.smartlifec;

import com.smartlife.smartlifec.setting.SettingMenuActivity;

import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class BaseControlViewActivity extends BaseControlActivity {
	
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
    			startActivity(new Intent(BaseControlViewActivity.this, SettingMenuActivity.class));
    			return true;
    		}
    		return super.onOptionsItemSelected(item);
    }
    
    public void btnPowerClick(View view) {
    		// TODO : 处理点击事件
    }
    
    public void btnMuteClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btnUpClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btnLeftClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btnOkClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btnRightClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btnDownClick(View view) {
		// TODO : 处理点击事件
    }
    
    public void btn1Click(View view ) {
    		// TODO : 处理点击事件
    }
    
    public void btn2Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn3Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn4Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn5Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn6Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn7Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn8Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn9Click(View view ) {
		// TODO : 处理点击事件
    }
    
    public void btn0Click(View view ) {
		// TODO : 处理点击事件
    }
    
}
