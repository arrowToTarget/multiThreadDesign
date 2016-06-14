package com.lewis.compare.vo;

import java.util.List;

public class Boss3ResRelationVo {

	private List<Integer> resId;
	private List<Integer> relateResId;
	private int resType;
	private int relateResType;
	private int relateMode;
	private int relateSubType;
	private int start;
	private int limit;
	public List<Integer> getResId() {
		return resId;
	}
	public void setResId(List<Integer> resId) {
		this.resId = resId;
	}
	public List<Integer> getRelateResId() {
		return relateResId;
	}
	public void setRelateResId(List<Integer> relateResId) {
		this.relateResId = relateResId;
	}
	public int getResType() {
		return resType;
	}
	public void setResType(int resType) {
		this.resType = resType;
	}
	public int getRelateResType() {
		return relateResType;
	}
	public void setRelateResType(int relateResType) {
		this.relateResType = relateResType;
	}
	public int getRelateMode() {
		return relateMode;
	}
	public void setRelateMode(int relateMode) {
		this.relateMode = relateMode;
	}
	public int getRelateSubType() {
		return relateSubType;
	}
	public void setRelateSubType(int relateSubType) {
		this.relateSubType = relateSubType;
	}
	public int getStart() {
		return start;
	}
	public void setStart(int start) {
		this.start = start;
	}
	public int getLimit() {
		return limit;
	}
	public void setLimit(int limit) {
		this.limit = limit;
	}
}
