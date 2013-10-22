package com.smartlife.smartlifec.domain;

import com.smartlife.smartlifec.R;

public enum DeviceType {

	TYPE_UNDEFINE(0, "UNDEFINE", R.array.hm404_source, 0),
	TYPE_HM404(1, "HM404", R.array.hm404_source, 4),
    TYPE_HM406(2, "HM406", R.array.hm406_source, 6),
    TYPE_HM808(3, "HM808", R.array.hm808_source, 8);

    private int id;
    private String desc;
    private int sourceListsId;
    private int maxSourceSize;

    private DeviceType(int id, String desc, int sourceListsId, int maxSourceSize) {
        this.id = id;
        this.desc = desc;
        this.sourceListsId = sourceListsId;
        this.maxSourceSize = maxSourceSize;
    }
    
    public int getMaxSourceSize() {
    		return maxSourceSize;
    }
    
    public int getSourceListsId(){
    		return sourceListsId;
    }

    public int getId() {
        return id;
    }

    public String getDesc() {
        return desc;
    }

    public static int getSourceListsId(int id) {
		switch(id) {
		case 1:
			return TYPE_HM404.getSourceListsId();
		case 2:
			return TYPE_HM406.getSourceListsId();
		case 3:
			return TYPE_HM808.getSourceListsId();
		default:
			return TYPE_UNDEFINE.getSourceListsId();
		}
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
    
    public static int getMaxSourceSize(int id) {
		switch(id) {
		case 1:
			return TYPE_HM404.getMaxSourceSize();
		case 2:
			return TYPE_HM406.getMaxSourceSize();
		case 3:
			return TYPE_HM808.getMaxSourceSize();
		default:
			return TYPE_UNDEFINE.getMaxSourceSize();
		}
}

}
