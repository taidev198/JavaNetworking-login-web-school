package com.company.superme198.URLs;

import java.net.MalformedURLException;
import java.net.URL;

public class URLSpliter {


    public static void main(String...args){

        String[] url = new String[]{"ftp://mp3:mp3@138.247.121.61:21000/c%3a/",
        "http://www.oreilly.com",
        "http://www.ibiblio.org/nywc/compositions.phtml?category=Piano",
        "http://admin@www.blackstar.com:8080/"};
        for (int i = 0; i < url.length; i++) {
            try {
                URL u = new URL(url[i]);
                System.out.println("The URL is " + u);
                System.out.println("The scheme is " + u.getProtocol());
                System.out.println("The user info is " + u.getUserInfo());
                String host = u.getHost();
                if (host != null) {
                    int atSign = host.indexOf('@');
                    if (atSign != -1) host = host.substring(atSign+1);
                    System.out.println("The host is " + host);
                } else {
                    System.out.println("The host is null.");
                }
                System.out.println("The port is " + u.getPort());
                System.out.println("The path is " + u.getPath());
                System.out.println("The ref is " + u.getRef());
                System.out.println("The query string is " + u.getQuery());
            } catch (MalformedURLException ex) {
                System.err.println(args[i] + " is not a URL I understand.");
            }
            System.out.println();
        }
    }
}
