package com.example.tot.mi;

import android.bluetooth.BluetoothDevice;
import android.bluetooth.le.ScanCallback;
import android.bluetooth.le.ScanResult;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.zhaoxiaodan.miband.*;

import java.util.logging.Logger;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MiBand miband =  new MiBand(getApplicationContext());

// scan nearby devices
        final ScanCallback scanCallback =  new  ScanCallback ()
        {
            @Override
            public  void onScanResult ( int callbackType, ScanResult result)
            {
                BluetoothDevice device = result.getDevice();
                Log.d("MiBand","Find the nearby Bluetooth device : name : " + device.getName() + ", uuid : "
                        + device.getUuids().toString() + ", add : "
                        + device.getAddress() + ", type : "
                        + device.getType () + ", BondState : "
                        + device.getBondState () + ", rssi : " + result.getRssi ());
                // show according to the situation
            }
        };
        MiBand .startScan (scanCallback);

// stop scanning
        MiBand . stopScan (scanCallback);
    }
}
