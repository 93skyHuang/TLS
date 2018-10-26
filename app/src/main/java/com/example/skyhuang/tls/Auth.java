//package com.example.skyhuang.tls;
//
//import java.security.KeyStore;
//import java.util.Properties;
//
//import javax.net.ssl.KeyManager;
//import javax.net.ssl.KeyManagerFactory;
//import javax.net.ssl.SSLContext;
//import javax.net.ssl.TrustManager;
//import javax.net.ssl.TrustManagerFactory;
//
///**
// * Created by skyHuang on 2018/10/25.
// */
//
//public class Auth {
//
//    private static SSLContext sslContext;
//
//
//
//    public static SSLContext getSSLContext() throws Exception{
//
//        Properties p = Configuration.getConfig();
//
//        String protocol = p.getProperty("protocol");
//
//        String clientTrustCerFile = p.getProperty("clientTrustCer");
//
//        String clientTrustCerPwd = p.getProperty("clientTrustCerPwd");
//
//
//
//        //Trust Key Store
//
//        KeyStore keyStore = KeyStore.getInstance("JKS");
//
//        keyStore.load(IOUtil.getInputStreamByPath(clientTrustCerFile),
//
//                clientTrustCerPwd.toCharArray());
//
//
//
//
//
//        TrustManagerFactory trustManagerFactory = TrustManagerFactory.getInstance("SunX509");
//
//        trustManagerFactory.init(keyStore);
//
//        TrustManager[] tms = trustManagerFactory.getTrustManagers();
//
//
//
//        KeyManager[] kms = null;
//
//        if(Configuration.getConfig().getProperty("authority").equals("2")){
//
//            String clientCerFile = p.getProperty("clientCer");
//
//            String clientCerPwd = p.getProperty("clientCerPwd");
//
//            String clientKeyPwd = p.getProperty("clientKeyPwd");
//
//
//
//            //Key Store
//
//            keyStore = KeyStore.getInstance("JKS");
//
//            keyStore.load(IOUtil.getInputStreamByPath(clientCerFile),
//
//                    clientCerPwd.toCharArray());
//
//
//
//            KeyManagerFactory keyManagerFactory = KeyManagerFactory.getInstance("SunX509");
//
//            keyManagerFactory.init(keyStore, clientKeyPwd.toCharArray());
//
//            kms = keyManagerFactory.getKeyManagers();
//
//        }
//
//        sslContext = SSLContext.getInstance(protocol);
//
//        sslContext.init(kms, tms, null);
//
//
//
//        return sslContext;
//
//    }
//
//}
