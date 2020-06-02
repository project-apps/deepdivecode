package com.app.entity.dto;

import java.io.Serializable;

public class PincodeDto implements Serializable {

	private static final long serialVersionUID = -5497074390399558229L;
	
	private String id;
	private String officename;
	private String pincode;
	private String officeType;
	private String Deliverystatus;
	private String divisionname;
	private String regionname;
	private String circlename;
	private String taluk;
	private String districtname;
	private String statename;
	private String telephone;
	private String relatedSuboffice;
	private String relatedHeadoffice;
	private String longitude;
	private String latitude;
	
	private String dataView;
	
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getOfficename() {
		return officename;
	}
	public void setOfficename(String officename) {
		this.officename = officename;
	}
	public String getPincode() {
		return pincode;
	}
	public void setPincode(String pincode) {
		this.pincode = pincode;
	}
	public String getOfficeType() {
		return officeType;
	}
	public void setOfficeType(String officeType) {
		this.officeType = officeType;
	}
	public String getDeliverystatus() {
		return Deliverystatus;
	}
	public void setDeliverystatus(String deliverystatus) {
		Deliverystatus = deliverystatus;
	}
	public String getDivisionname() {
		return divisionname;
	}
	public void setDivisionname(String divisionname) {
		this.divisionname = divisionname;
	}
	public String getRegionname() {
		return regionname;
	}
	public void setRegionname(String regionname) {
		this.regionname = regionname;
	}
	public String getCirclename() {
		return circlename;
	}
	public void setCirclename(String circlename) {
		this.circlename = circlename;
	}
	public String getTaluk() {
		return taluk;
	}
	public void setTaluk(String taluk) {
		this.taluk = taluk;
	}
	public String getDistrictname() {
		return districtname;
	}
	public void setDistrictname(String districtname) {
		this.districtname = districtname;
	}
	public String getStatename() {
		return statename;
	}
	public void setStatename(String statename) {
		this.statename = statename;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getRelatedSuboffice() {
		return relatedSuboffice;
	}
	public void setRelatedSuboffice(String relatedSuboffice) {
		this.relatedSuboffice = relatedSuboffice;
	}
	public String getRelatedHeadoffice() {
		return relatedHeadoffice;
	}
	public void setRelatedHeadoffice(String relatedHeadoffice) {
		this.relatedHeadoffice = relatedHeadoffice;
	}
	public String getLongitude() {
		return longitude;
	}
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	public String getLatitude() {
		return latitude;
	}
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	public String getDataView() {
		return dataView;
	}
	public void setDataView(String dataView) {
		this.dataView = dataView;
	}
	
}
