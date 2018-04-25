package com.example.kamil.udpconnection;

public class UdpHelper {

    private String mIpAddress;
    private int mPort;

    public UdpHelper(String ipAddress, int port){

        this.mIpAddress = ipAddress;
        this.mPort = port;
    }

    public void setIpAddress(String mIpAddress) {
        this.mIpAddress = mIpAddress;
    }

    public boolean isIpAddressSet(){
        return !mIpAddress.equals("");
    }

    public void SendPacket(String message){

        try {
            UdpPacketSender sender = new UdpPacketSender(mIpAddress, mPort);
            sender.setMessage(message);
            sender.start();
            sender.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
