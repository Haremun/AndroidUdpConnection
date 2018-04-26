package com.example.kamil.udpconnection;

import android.app.Activity;

public class UdpHelper {

    private String mIpAddress;
    private int mPort;
    private Activity mActivity;

    UdpHelper(Activity activity, String ipAddress, int port){

        this.mIpAddress = ipAddress;
        this.mPort = port;
        this.mActivity = activity;
    }

    public void setIpAddress(String mIpAddress) {
        this.mIpAddress = mIpAddress;
    }

    public void setPort(int mPort) {
        this.mPort = mPort;
    }

    public boolean isIpAddressSet(){
        return !mIpAddress.equals("");
    }

    public void SendPacket(String message, int viewId){

        UdpPacketSenderTask udpPacketSenderTask = new UdpPacketSenderTask(mActivity, mIpAddress, mPort, viewId);
        udpPacketSenderTask.execute(message);
    }
}
