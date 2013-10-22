package com.smartlife.smartlifec.domain;

public enum DeviceType {

	TYPE_HM404(0, "HM404"),
    TYPE_HM406(1, "HM406"),
    TYPE_HM808(2, "HM808");

    private int id;
    private String desc;

    private DeviceType(int id, String desc) {
        this.id = id;
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    
    public static String getDesc(int state) {
    		switch(state) {
    		case 1:
    			return TYPE_HM404.getDesc();
    		case 2:
    			return TYPE_HM406.getDesc();
    		case 3:
    			return TYPE_HM808.getDesc();
    		default:
    			return "UNSUPPORT";
    		}
    }

}
