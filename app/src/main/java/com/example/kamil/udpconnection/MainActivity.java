package com.example.kamil.udpconnection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.grid_layout) GridLayout gridLayout;
    @BindView(R.id.send_1)
    EditText editSend1;
    @BindView(R.id.send_2)
    EditText editSend2;
    @BindView(R.id.send_3)
    EditText editSend3;
    @BindView(R.id.send_4)
    EditText editSend4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_send_1, R.id.btn_send_2, R.id.btn_send_3, R.id.btn_send_4})
    public void btnClick(Button button){

        switch (button.getId()){
            case R.id.btn_send_1:
                break;
            case R.id.btn_send_2:
                break;
            case R.id.btn_send_3:
                break;
            case R.id.btn_send_4:
                break;
        }
    }
}
