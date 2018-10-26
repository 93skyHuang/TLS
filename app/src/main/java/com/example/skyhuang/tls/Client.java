//package com.example.skyhuang.tls;
//
//import android.util.Log;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.InetSocketAddress;
//import java.net.SocketAddress;
//import java.util.Properties;
//
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.SSLSocket;
//import javax.net.ssl.SSLSocketFactory;
//
///**
// * Created by skyHuang on 2018/10/25.
// */
//
//public class Client {
//    private static final String TAG = "Client";
//
//    private SSLContext sslContext;
//
//    private String host = "127.0.0.1";
//
//    private SSLSocket socket;
//
//    private Properties p;
//
//
//    public Client() {
//
//        try {
//
//            p = Configuration.getConfig();
//
//            Integer port = Integer.valueOf(p.getProperty("serverListenPort"));
//
//            sslContext = Auth.getSSLContext();
//
//            SSLSocketFactory factory = (SSLSocketFactory) sslContext.getSocketFactory();
//
//            socket = (SSLSocket) factory.createSocket();
//
//            String[] pwdsuits = socket.getSupportedCipherSuites();
//
//            //socket可以使用所有支持的加密套件
//
//            socket.setEnabledCipherSuites(pwdsuits);
//
//            //默认就是true
//
//            socket.setUseClientMode(true);
//
//
//            SocketAddress address = new InetSocketAddress(host, port);
//
//            socket.connect(address, 0);
//
//
//            MyHandshakeCompletedListener listener = new MyHandshakeCompletedListener();
//
//            socket.addHandshakeCompletedListener(listener);
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//
//            Log.e(TAG, "Client: socket establish failed!");
//        }
//
//    }
//
//
//    public void request() {
//
//        try {
//
//            String encoding = p.getProperty("socketStreamEncoding");
//
//
//            DataOutputStream output = SocketIO.getDataOutput(socket);
//
//            String user = "name";
//
//            byte[] bytes = user.getBytes(encoding);
//
//            int length = bytes.length;
//
//            int pwd = 123;
//
//
//            output.write(length);
//
//            output.write(bytes);
//
//            output.write(pwd);
//
//            Log.i(TAG, "request:length :" + length);
//            Log.i(TAG, "request: user :" + user);
//            Log.i(TAG, "request:  pwd :" + pwd);
//
//            Log.i(TAG, "request: bytes:" + new String(bytes, encoding));
//
//
//            DataInputStream input = SocketIO.getDataInput(socket);
//
//            length = input.readShort();
//
//            bytes = new byte[length];
//
//            input.read(bytes);
//
//
//            Log.i(TAG, "request result:" + new String(bytes, encoding));
//
//        } catch (Exception e) {
//
//            e.printStackTrace();
//            Log.e(TAG, "request: error");
//
//        } finally {
//
//            try {
//
//                socket.close();
//
//            } catch (IOException e) {
//
//                e.printStackTrace();
//
//            }
//
//        }
//
//    }
//}
