package com.company.superme198.InternetAddress;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class DNS {

    public static void main(String...args){
        try {
            InetAddress[] address = InetAddress.getAllByName("www.oreilly.com");
            System.out.println(InetAddress.getLocalHost());
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }
}
