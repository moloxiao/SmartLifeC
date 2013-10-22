package com.smartlife.smartlifec.connect;

public enum ControlOrderType {

	ORDER_F1(0, "F1", "IFBF1"),
	ORDER_F2(1, "F2", "IFBF1"),
	ORDER_F3(2, "F3", "IFBF2"),
	ORDER_F4(3, "F4", "IFBF3"),
	ORDER_F5(4, "F5", "IFBF4"),
	ORDER_F6(5, "F6", "IFBF5"),
	ORDER_F7(6, "F7", "IFBF6"),
	ORDER_F8(7, "F8", "IFBF7");
	
	private int code;
	private String desc;
	private String order;
	
	private ControlOrderType(int code, String desc, String order) {
		this.code = code;
		this.desc = desc;
		this.order = order;
	}

	public int getCode() {
		return code;
	}

	public String getDesc() {
		return desc;
	}

	public String getOrder() {
		return order;
	}
	
	public static ControlOrderType getType(int code) {
		switch(code) {
		case 0:
			return ORDER_F1;
		case 1:
			return ORDER_F2;
		case 2:
			return ORDER_F3;
		case 3:
			return ORDER_F4;
		case 4:
			return ORDER_F5;
		case 5:
			return ORDER_F6;
		case 6:
			return ORDER_F7;
		case 7:
			return ORDER_F8;
		default :
			break;	
		}
		return null;
	}
}
