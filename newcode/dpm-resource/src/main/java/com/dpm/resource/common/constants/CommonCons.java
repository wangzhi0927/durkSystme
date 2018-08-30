package com.dpm.resource.common.constants;

public class CommonCons {
	public static class UploadPathPrefix{
		public static final String RECORD = "record";
		public static final String DDD = "3d";
		public static final String FLASH = "flash";
		public static final String IMAGE = "image";
		public static final String TNM = "tnm";
	}
	
	public enum DictType{
		SEX("01"),HOCUS("02"),RELATION("03");
		
		private String value;
		 
	    private DictType(String value) {
	        this.value = value;
	    }
	 
	    public String getValue() {
	        return value;
	    }
	}
	
	public enum DictCode{
		ME("0301"),CHILDREN("0302"),PARENT("0303"),RELATIVES("0304"),OTHER("0305"),
		MAN("0101","男"),WOMEN("0102","女");
		private String value;
		private String desc;
		 
	    private DictCode(String value) {
	        this.value = value;
	    }
	    
	    private DictCode(String value, String desc) {
	        this.value = value;
	        this.desc = desc;
	    }
	 
	    public String getValue() {
	        return value;
	    }
	    
	    public String getDesc() {
	        return desc;
	    }
	}
}
