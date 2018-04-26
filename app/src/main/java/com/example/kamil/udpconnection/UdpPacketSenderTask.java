package com.example.kamil.udpconnection;

import android.app.Activity;
import android.graphics.Color;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.TextView;

import java.io.IOException;
import java.lang.ref.WeakReference;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.concurrent.TimeoutException;

public class UdpPacketSenderTask extends AsyncTask<String, String, String> {

    private String mIpAddress;
    private int mPort;
    private int mId;
    private WeakReference<Activity> activityWeakReference;

    public UdpPacketSenderTask(Activity activity, String ipAddress, int port, int id) {
        this.mIpAddress = ipAddress;
        this.mPort = port;
        this.mId = id;
        this.activityWeakReference = new WeakReference<>(activity);
    }

    @Override
    protected String doInBackground(String... strings) {
        String serverResponse = "No response";
        try {

            DatagramSocket clientSocket = new DatagramSocket();
            InetAddress IPAddress = InetAddress.getByName("192.168.1.5");

            StringBuilder allMessages = new StringBuilder();
            for (String message :
                    strings) {
                String temp = message + "\n";
                allMessages.append(temp);
            }
            byte[] sendData = "Test".getBytes();
            byte[] receiveData = new byte[1024];

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress, mPort);
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);

            clientSocket.setSoTimeout(3000);
            try {
                clientSocket.send(sendPacket);
                clientSocket.receive(receivePacket);
                serverResponse = new String(receivePacket.getData());
            } catch (SocketTimeoutException e) {
                e.printStackTrace();
                Log.i("Udp", "Timeout!");
            }




            clientSocket.close();
            Log.i("Udp", "No error!");

        } catch (IOException e) {
            e.printStackTrace();
            Log.i("Udp", "Sending error!");
        }
        return !serverResponse.equals("") ? serverResponse : "No response";
    }

    @Override
    protected void onPostExecute(String s) {
        Activity activity = activityWeakReference.get();
        if (activity != null) {
            TextView textView = activity.findViewById(R.id.text_resp_1);
            textView.setText(s);
            textView.setTextColor(Color.GREEN);
        }

    }
}
