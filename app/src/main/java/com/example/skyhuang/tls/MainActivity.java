package com.example.skyhuang.tls;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;

import javax.net.ssl.SSLSocket;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    private String host = "192.168.10.84";
    private static final int port = 443;
    SSLSocket sslSocket;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.build_btn).setOnClickListener(v -> {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    TLSSocketFactory tlsSocketFactory = new TLSSocketFactory();
                    try {
                        if (sslSocket == null || sslSocket.isClosed()) {
                            sslSocket = (SSLSocket) tlsSocketFactory.createSocket(host, port);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                        Log.e(TAG, "run: " + e);
                    }
                    Log.i(TAG, "run:end");
                }
            };
            thread.start();
        });

        findViewById(R.id.send_btn).setOnClickListener(v -> {
            Thread thread = new Thread() {
                @Override
                public void run() {
                    super.run();
                    Log.i(TAG, "run: sslSocket connected status =" + sslSocket.isConnected() + "host=" + host + Arrays.toString("hello61891111111".getBytes()));
                    OutputStream out = null;
                    try {
                        out = sslSocket.getOutputStream();
                        out.write("hello61891111111".getBytes());
                        Log.i(TAG, "run: write hello to service");
                        out.flush();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            };
            thread.start();

        });
    }
}
