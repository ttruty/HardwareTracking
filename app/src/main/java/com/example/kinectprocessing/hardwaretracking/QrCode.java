package com.example.kinectprocessing.hardwaretracking;

import java.util.ArrayList;
import java.util.List;

public class QrCode {
    List<String> qrDevices = new ArrayList<String>();                   // <--declared statement

    // ; // <--initialized statement
    static String qrCode = "";

    public void addQrCode(String code)
    {
        this.qrDevices.add(code);
    }
}
