package com.company.superme198.URLs;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by traig on 7:24 PM, 12/21/2018
 */

/**md5:https://www.mkyong.com/java/java-md5-hashing-example/
 * Unable to parse website after successful log in JSoup:
 * https://stackoverflow.com/questions/29183108/unable-to-parse-website-after-successful-log-in-jsoup*/
public class Example {

    public static void main(String...args) throws IOException, NoSuchAlgorithmException {

        Connection.Response loginForm = Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.Info/Login.aspx")
                .method(Connection.Method.GET)
                .execute();
        Document doc = loginForm.parse();
        Elements hiddenElems = doc.select("input[type=hidden]");
        Map<String, String> nameValue = new HashMap<>();

        for(Element elem : hiddenElems) {
            nameValue.put(elem.attr("name"), elem.attr("value"));
        }
        nameValue.put("PageHeader1$drpNgonNgu", "E43296C6F24C4410A894F46D57D2D3AB");
        loginForm =  Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.Info/Login.aspx")
                .data("txtUserName", "CT010338")
                .data("txtPassword", md5("03031998"))
                .data(nameValue)
                .data("btnSubmit", "Đăng nhập")
                .cookies(loginForm.cookies())
                .method(Connection.Method.POST)
                .execute();
       showStudentMark(loginForm);
    }

    public static void showStudentMarkWithTerm(Connection.Response loginForm) throws IOException {
        Map<String, String> cookies = loginForm.cookies();
        Document document2 = Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.info/StudentMark.aspx")
                .cookies(cookies)
                .get();
        Elements hiddenElems = document2.select("input[type=hidden]");
        Map<String, String> nameValue = new HashMap<>();

        for(Element elem : hiddenElems) {
            nameValue.put(elem.attr("name"), elem.attr("value"));
        }
        nameValue.put("PageHeader1$drpNgonNgu", "E43296C6F24C4410A894F46D57D2D3AB");
        nameValue.remove("__EVENTTARGET");
        nameValue.put("__EVENTTARGET", "drpHK");
        nameValue.put("drpHK", "2017_2018_1");
    }

    public static void showStudentMark(Connection.Response loginForm) throws IOException {
        Map<String, String> cookies = loginForm.cookies();
        Document document2 = Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.info/StudentMark.aspx")
                .cookies(cookies)
                .get();
        Elements container = document2.select("div.container");
//        for (Element e:
//            container) {
//            String studentid = e.select("span#lblStudentCode.form-control-lable-value").text();
//            System.out.println(studentid);
//            String namedtudent = e.select("span#lblStudentName.form-control-lable-value").text();
//            System.out.println(namedtudent);
//            String status = e.select("span#lblstudentstatus.form-control-lable-value").text();
//            System.out.println(status);
//            String session = e.select("span#lblAy.form-control-lable-value").text();
//            System.out.println(session);
//            String specialty = e.select("select#drpField.form-control").text();
//            System.out.println(specialty);
//            String semester = e.select("select#drpHK.form-control").text();
//            System.out.println(semester);
//
//        }

//        Elements tableSumMark = document2.select("table#tblSumMark.tableborder table#grdResult");
//        for (Element e:
//            tableSumMark) {
//            String value = e.select("tr td.cssListHeader").text();
//            System.out.println(value);
//            Elements result = e.select("tr.cssListItem");
//            for (Element res:
//                result ) {
//                Elements r = res.select("td");
//                System.out.println("size :" + r.size());
//                for (Element element : r) {
//                    System.out.print(element.text() + " ");
//                }
//                System.out.println();
//
//            }
//    }

        Elements tableSumMark = document2.select("table#tblSumMark.tableborder table#grdResult tbody");
        for (Element e:
            tableSumMark) {
            Elements result = e.select("tr");
            for (Element res:
                result ) {
                Elements r = res.select("td");
                for (Element element : r) {
                    System.out.print(element.text() + " ");
                }
                System.out.println();

            }
        }

        Elements tableSumMarkDetails = document2.select("table#tblStudentMark tbody");
        for (Element e:
                tableSumMarkDetails) {
            Elements result = e.select("tr");
            for (Element res:
                    result ) {
                Elements r = res.select("td");
                for (Element element : r) {
                    System.out.print(element.text() + " ");
                }
                System.out.println();

            }
        }


    }

    public static void login() throws IOException {
        Connection.Response loginForm = Jsoup.connect("https://id.zing.vn/v2/login/")
                .method(Connection.Method.GET)
                .execute();
        Document doc = loginForm.parse();
        System.out.println(doc.head());
        Elements hiddenElems = doc.select("input[type=hidden]");
        Map<String, String> nameValue = new HashMap<>();

        for(Element elem : hiddenElems) {
            if (!elem.attr("name").equals(""))
            nameValue.put(elem.attr("name"), elem.attr("value"));
        }
       // System.out.println(nameValue);
        loginForm =  Jsoup.connect("https://id.zing.vn/v2/login/")
                .data("login_account", "taidev198")
                .data("login_pwd", "5agGuxSWLWerQYs")
                .cookies(loginForm.cookies())
                .method(Connection.Method.POST)
                .execute();
        System.out.println(loginForm.parse().html());
    }

    public static String md5(String input) throws NoSuchAlgorithmException {
        byte[] bytesOfMessage = input.getBytes(StandardCharsets.UTF_8);
        MessageDigest md = MessageDigest.getInstance("MD5");
        byte[] thedigest = md.digest(bytesOfMessage);
        StringBuilder sb = new StringBuilder();
        for (byte b : thedigest) {
            sb.append(String.format("%02x", b));
        }
        System.out.println(sb.toString());
        return sb.toString();
    }
}
