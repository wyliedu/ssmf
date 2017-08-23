package com.wylie.common.dto;

/**
 * Id & Description pair
 * 
 * @author Gordon Aug 30, 2016
 */
public class IdDesc {
    /**
     * define id
     */
    private String id;
    /**
     * define desc
     */
    private String desc;

    /**
     * @param code
     * @param value
     */
    public IdDesc(String id, String desc) {
	super();
	this.id = id;
	this.desc = desc;
    }

    /**
     * @return the id
     */
    public String getId() {
	return id;
    }

    /**
     * @param id
     *            the id to set
     */
    public void setId(String id) {
	this.id = id;
    }

    /**
     * @return the desc
     */
    public String getDesc() {
	return desc;
    }

    /**
     * @param desc
     *            the desc to set
     */
    public void setDesc(String desc) {
	this.desc = desc;
    }

}
