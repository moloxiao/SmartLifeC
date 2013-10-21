package com.smartlife.smartlifec;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;

public class PoolControlImplActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pool_control_impl);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.pool_control_impl, menu);
        return true;
    }
    
}
