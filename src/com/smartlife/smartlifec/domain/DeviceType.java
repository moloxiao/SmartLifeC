package com.smartlife.smartlifec.domain;

public enum DeviceType {

	TYPE_UNDEFINE(0, "UNDEFINE"),
	TYPE_HM404(1, "HM404"),
    TYPE_HM406(2, "HM406"),
    TYPE_HM808(3, "HM808");

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

    
    public static String getDesc(int id) {
    		switch(id) {
    		case 1:
    			return TYPE_HM404.getDesc();
    		case 2:
    			return TYPE_HM406.getDesc();
    		case 3:
    			return TYPE_HM808.getDesc();
    		default:
    			return TYPE_UNDEFINE.getDesc();
    		}
    }

}
