package com.smartlife.smartlifec.connect;

public class ControlManager {

	public static byte[] getControlOrder(ControlOrderType type, String sourceId) {
		switch(type) {
		case ORDER_F1:
			return (ControlOrderType.ORDER_F1.getOrder() + sourceId + "P").getBytes();
		case ORDER_F2:
			return (ControlOrderType.ORDER_F2.getOrder() + sourceId + "P").getBytes();
		case ORDER_F3:
			return (ControlOrderType.ORDER_F3.getOrder() + sourceId + "P").getBytes();
		case ORDER_F4:
			return (ControlOrderType.ORDER_F4.getOrder() + sourceId + "P").getBytes();
		case ORDER_F5:
			return (ControlOrderType.ORDER_F5.getOrder() + sourceId + "P").getBytes();
		case ORDER_F6:
			return (ControlOrderType.ORDER_F6.getOrder() + sourceId + "P").getBytes();
		case ORDER_F7:
			return (ControlOrderType.ORDER_F7.getOrder() + sourceId + "P").getBytes();
		case ORDER_F8:
			return (ControlOrderType.ORDER_F8.getOrder() + sourceId + "P").getBytes();
		default:
			break;
		}
		return null;
	}
	
	public static String getSourceId(int sourceId) {
		return "0" + sourceId;
	}
	
}
