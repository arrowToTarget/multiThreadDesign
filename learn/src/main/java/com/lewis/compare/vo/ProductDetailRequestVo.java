/**
 * 项目名：boh-intf
 * 包名：com.tuniu.ngsp.boh.common.vo	
 * 文件名：ProductDetailRequestVo.java *
 * 日期：2014-1-7 下午6:14:03
 * Copyright 途牛科技有限公司 2014
 * 版权所有
 */
package com.lewis.compare.vo;

import java.util.List;

/**
 * 此类描述的是：
 * 
 * @author xujinfei
 */

public class ProductDetailRequestVo extends RequestBaseVo{
    // 产品类型
    private int productType;
    // 产品id
    private int productId;
    // 零售平台id
    private int containerId;
    //出发城市编码
    private int departCityCode;
    
    private int holidayId;
    
    private int scenicId;
    
    private List<Integer> businessTypes;
    //请求渠道
    private int marketChannelCode = 100;
    //请求来源 1电话 2网站 3无线
    private int requestSourceCode;
    
    private int hotelId;
    private int agencyId;
    //是否返回包含前台不呈现的产品，1是0否(门票)
    private int showAll;
	
	private String departDate;
    //预订城市(可选，用于处理周边当地游大类、品类)
    private int bookCityCode;
    private List<String> productChannel;
    private int option;

	public int getOption() {
		return option;
	}

	public void setOption(int option) {
		this.option = option;
	}

	public List<String> getProductChannel() {
		return productChannel;
	}

	public void setProductChannel(List<String> productChannel) {
		this.productChannel = productChannel;
	}

	/**
     * productType
     * 
     * @return the productType
     */

    public int getProductType() {
        return productType;
    }

    /**
     * @param productType
     *            the productType to set
     */

    public void setProductType(int productType) {
        this.productType = productType;
    }

    /**
     * productId
     * 
     * @return the productId
     */

    public int getProductId() {
        return productId;
    }

    /**
     * @param productId
     *            the productId to set
     */

    public void setProductId(int productId) {
        this.productId = productId;
    }
    public int getDepartCityCode() {
		return departCityCode;
	}

	public void setDepartCityCode(int departCityCode) {
		this.departCityCode = departCityCode;
	}

    public int getHolidayId() {
        return holidayId;
    }

    public void setHolidayId(int holidayId) {
        this.holidayId = holidayId;
    }

    public List<Integer> getBusinessTypes() {
        return businessTypes;
    }

    public void setBusinessTypes(List<Integer> businessTypes) {
        this.businessTypes = businessTypes;
    }

    public int getMarketChannelCode() {
        return marketChannelCode;
    }

    public void setMarketChannelCode(int marketChannelCode) {
        this.marketChannelCode = marketChannelCode;
    }

    public int getRequestSourceCode() {
        return requestSourceCode;
    }

    public void setRequestSourceCode(int requestSourceCode) {
        this.requestSourceCode = requestSourceCode;
    }

	public int getContainerId() {
		return containerId;
	}

	public void setContainerId(int containerId) {
		this.containerId = containerId;
	}

	public int getScenicId() {
		return scenicId;
	}

	public void setScenicId(int scenicId) {
		this.scenicId = scenicId;
	}

	public int getHotelId() {
		return hotelId;
	}

	public void setHotelId(int hotelId) {
		this.hotelId = hotelId;
	}

	public int getShowAll() {
		return showAll;
	}

	public void setShowAll(int showAll) {
		this.showAll = showAll;
	}

	public int getAgencyId() {
		return agencyId;
	}

	public void setAgencyId(int agencyId) {
		this.agencyId = agencyId;
	}

    public String getDepartDate() {
        return departDate;
    }

    public void setDepartDate(String departDate) {
        this.departDate = departDate;
    }
	
    public int getBookCityCode() {
        return bookCityCode;
    }

    public void setBookCityCode(int bookCityCode) {
        this.bookCityCode = bookCityCode;
    }
	

}
