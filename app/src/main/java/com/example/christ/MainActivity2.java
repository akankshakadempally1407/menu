package com.example.christ;

import androidx.appcompat.app.AppCompatActivity;

import android.bluetooth.BluetoothAdapter;
import android.content.Context;
import android.content.Intent;
import android.net.wifi.WifiManager;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;

public class MainActivity2 extends AppCompatActivity {
    private Switch wifiSwitch;
    private Switch blthSwitch;
    private WifiManager wifiManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        wifiManager = (WifiManager) getApplicationContext().getSystemService(Context.WIFI_SERVICE);

        wifiSwitch = (Switch) findViewById(R.id.wifi);
        blthSwitch = (Switch) findViewById(R.id.blth);

        wifiManager.setWifiEnabled(false);
        wifiSwitch.setChecked(false);
        wifiSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    wifiManager.setWifiEnabled(true);
                }else{
                    wifiManager.setWifiEnabled(false);
                }
            }
        });

        BluetoothAdapter adapter = BluetoothAdapter.getDefaultAdapter();
        adapter.disable();
        blthSwitch.setChecked(false);
        blthSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    adapter.enable();
                } else {
                    adapter.disable();
                }
            }

            public void NEXT(View view) {

                Intent intent = new Intent(MainActivity2.this, MainActivity.class);
                startActivity(intent);
                finish();
            }


        });

    }
}