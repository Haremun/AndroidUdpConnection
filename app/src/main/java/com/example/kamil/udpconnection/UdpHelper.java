package com.example.kamil.udpconnection;

import android.app.Activity;
import android.content.Context;

public class UdpHelper {

    private String mIpAddress;
    private int mPort;
    private Activity mActivity;

    public UdpHelper(Activity activity, String ipAddress, int port){

        this.mIpAddress = ipAddress;
        this.mPort = port;
        this.mActivity = activity;
    }

    public void setIpAddress(String mIpAddress) {
        this.mIpAddress = mIpAddress;
    }

    public boolean isIpAddressSet(){
        return !mIpAddress.equals("");
    }

    public void SendPacket(String message){

        UdpPacketSenderTask udpPacketSenderTask = new UdpPacketSenderTask(mActivity, mIpAddress, mPort, 0);
        udpPacketSenderTask.execute(message);
    }
}
