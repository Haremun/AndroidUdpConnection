package com.example.kamil.udpconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.grid_layout) GridLayout gridLayout;
    @BindView(R.id.send_1)
    EditText editSend1;
    @BindView(R.id.send_2)
    EditText editSend2;

    @BindView(R.id.accept_address)
    Button buttonChange;
    @BindView(R.id.edit_address)
    EditText editAddress;

    private UdpHelper udpHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        udpHelper = new UdpHelper(this, "192.168.1.5", 8080);
        editAddress.setHint("192.168.1.5");



    }

    @OnClick({R.id.btn_send_1, R.id.btn_send_2})
    public void btnClick(Button button){

        if(udpHelper.isIpAddressSet()){
            switch (button.getId()){
                case R.id.btn_send_1:
                    udpHelper.SendPacket(editSend1.getText().toString());
                    break;
                case R.id.btn_send_2:
                    udpHelper.SendPacket(editSend2.getText().toString());
                    break;
            }
        }
        else
            Toast.makeText(this, "Set ip address!", Toast.LENGTH_SHORT).show();

    }
    @OnClick(R.id.accept_address)
    public void setAddress(){
        udpHelper.setIpAddress(editAddress.getText().toString());

    }
}
