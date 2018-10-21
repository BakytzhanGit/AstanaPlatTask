package com.example.bakytzhan.astanaplattask;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;
import org.simpleframework.xml.Text;

@Root(name = "PostPoint", strict = false)
public class SinglePlace {

    @Element(required = false,name = "Id")
    private int id;

    @Element(required = false,name = "Name")
    private String name;

    @Element(required = false,name = "IdCity")
    private int idCity;

    @Element(required = false,name = "City")
    private String city;

    @Element(required = false,name = "Latitude")
    private Double latitude;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getIdCity() {
        return idCity;
    }

    public void setIdCity(int idCity) {
        this.idCity = idCity;
    }

    public   String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double lattitude) {
        this.latitude = lattitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHoutWork() {
        return houtWork;
    }

    public void setHoutWork(String houtWork) {
        this.houtWork = houtWork;
    }

    public int getIsCash() {
        return isCash;
    }

    public void setIsCash(int isCash) {
        this.isCash = isCash;
    }

    public int getIsCard() {
        return isCard;
    }

    public void setIsCard(int isCard) {
        this.isCard = isCard;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    @Element(required = false,name = "Longitude")
    private Double longitude;

    @Element(required = false,name = "Address")
    private String address;

    @Element(required = false,name = "HourWork")
    private String houtWork;

    @Element(required = false,name = "IsCash")
    private int isCash;

    @Element(required = false,name = "IsCard")
    private int isCard;

    @Element(required = false,name = "IdType")
    private int idType;

}