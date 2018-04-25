package com.example.kamil.udpconnection;

import android.app.Activity;
import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UdpPacketSender extends Thread {

    private String mIpAddress;
    private int mPort;
    private String mMessage;

    public UdpPacketSender(String ipAddress, int port){

        this.mIpAddress = ipAddress;
        this.mPort = port;
        this.mMessage = "Empty message";
    }

    public void setMessage(String mMessage) {
        this.mMessage = mMessage;
    }

    @Override
    public void run() {
        super.run();
        try {

            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.1.6");

            byte[] sendData = mMessage.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, mPort);
            clientSocket.send(sendPacket);

            clientSocket.close();

        } catch (IOException e) {
            e.printStackTrace();
            Log.i("Udp", "Sending error!");
        }


    }
}
