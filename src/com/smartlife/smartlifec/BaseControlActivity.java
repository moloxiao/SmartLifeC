package com.smartlife.smartlifec;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import com.smartlife.smartlifec.domain.DeviceType;
import com.smartlife.smartlifec.domain.IControl;
import com.smartlife.smartlifec.setting.SettingIpInfoActivity;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

public abstract class BaseControlActivity extends Activity 
		implements IControl{

	private static final String PREFS_NAME = "SourceList";
	private String ip;
	private int port;
	
	@Override
	protected void onResume() {
		super.onResume();
		ip = SettingIpInfoActivity.getIp(this);
		port = SettingIpInfoActivity.getPort(this);
	}
	
	public static int getCurrentStoredSourceId(Context context, final int deviceId) {
		int max = DeviceType.getMaxSourceSize(deviceId);
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
	    int id = settings.getInt("sourceId", 0);
	    if(id >= max) {
			id = 0;
		}
		return id;
	}
	
	public static void storeCurrentSourceId(Context context, int id, final int deviceId) {
		int max = DeviceType.getMaxSourceSize(deviceId);
		if(id >= max) {
			id = 0;
		}
		SharedPreferences settings = context.getSharedPreferences(PREFS_NAME, 0);
		SharedPreferences.Editor editor = settings.edit();
	    editor.putInt("sourceId", id);

	    editor.commit();
	}
	

	@Override
	public void send(final byte[] datas) {
		new Thread(new Runnable() {
			@Override
			public void run() {
				Socket socket = null;
				try {
					if(ip != null && ip.length() > 5) {
						socket = new Socket(ip, port); //"10.0.2.2", 55555
						Log.i("MOLO_DEBUG", "success init server info");
						OutputStream out = socket.getOutputStream();
						Log.i("MOLO_DEBUG", "success init OutputStream");
						out.write(datas);
						Log.i("MOLO_DEBUG", "success write to OutputStream");
						socket.close();
						Log.i("MOLO_DEBUG", "success send data[" + datas + "]");
					}else {
						Log.e("MOLO_DEBUG", "error ip address=" + ip);
					}
					
				}catch (IOException e) {
					Log.e("MOLO_DEBUG", "send data error:" + e.getMessage());
				}
			}
		}).start();
	}

	@Override
	public void sendAndWait(final byte[] datas, final RecvDataCallBack callback) {
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				Socket socket = null;
				try {
					socket = new Socket(ip, port);
					OutputStream out = socket.getOutputStream();
					InputStream in = socket.getInputStream();
					out.write(datas);
					
					// 等待服务端数据
					
					socket.close();
					Log.i("MOLO_DEBUG", "success send(and wait) data[" + datas + "]");
				}catch (IOException e) {
					Log.e("MOLO_DEBUG", "send data error:" + e.getMessage());
				}
				
			}
		}).start();
	}

}
