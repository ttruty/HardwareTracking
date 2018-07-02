package com.example.kinectprocessing.hardwaretracking;

import android.os.Parcel;
import android.os.Parcelable;

import java.io.Serializable;

class SampleInventory {

    // indiviual item variables
    private String itemid, serialnumber, itemname, macaddress;
    // model varibles
    private String modelid, modelname,vendorname, typename, subtypename;


    public String getMacaddress() {
        return macaddress;
    }

    public void setMacaddress(String macaddress) {
        this.macaddress = macaddress;
    }

    public String getModelid() {
        return modelid;
    }

    public void setModelid(String modelid) {
        this.modelid = modelid;
    }

    public String getModelname() {
        return modelname;
    }

    public void setModelname(String modelname) {
        this.modelname = modelname;
    }

    public String getVendorname() {
        return vendorname;
    }

    public void setVendorname(String vendorname) {
        this.vendorname = vendorname;
    }

    public String getTypename() {
        return typename;
    }

    public void setTypename(String typename) {
        this.typename = typename;
    }

    public String getSubtypename() {
        return subtypename;
    }

    public void setSubtypename(String subtypename) {
        this.subtypename = subtypename;
    }

    public String getItemid() {
        return itemid;
    }

    public void setItemid(String itemid) {
        this.itemid = itemid;
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    @Override
    public String toString() {
        return "SampleInventory{" +
                "itemid='" + itemid + '\'' +
                ", serialnumber='" + serialnumber + '\'' +
                ", itemname='" + itemname + '\'' +
                ", macaddress='" + macaddress + '\'' +
                ", modelid='" + modelid + '\'' +
                ", modelname='" + modelname + '\'' +
                ", vendorname='" + vendorname + '\'' +
                ", typename='" + typename + '\'' +
                ", subtypename='" + subtypename + '\'' +
                '}';
    }

}
