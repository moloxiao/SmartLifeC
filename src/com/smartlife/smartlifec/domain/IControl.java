package com.smartlife.smartlifec.domain;

/**
 * 控制器接口
 * @author molo
 * @since 2013-10-21
 */
public interface IControl {

	void send(byte[] datas);
	void sendAndWait(byte[] datas, RecvDataCallBack callback);
	
	public interface RecvDataCallBack {
		void onRecv(byte[] data);
	}
}
