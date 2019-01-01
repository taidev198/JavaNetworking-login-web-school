package com.company.superme198.URLs;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.nodes.TextNode;
import org.jsoup.select.Elements;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import org.jsoup.nodes.*;
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
        nameValue.remove("__VIEWSTATE" );
        nameValue.put("__VIEWSTATE", "/wEPDwUKMTkwNDg4MTQ5MQ9kFgICAQ9kFgpmD2QWCgIBDw8WAh4EVGV4dAUjSOG7jEMgVknhu4ZOIEvhu7ggVEhV4bqsVCBN4bqsVCBNw4NkZAICD2QWAmYPDxYEHwAFDcSQxINuZyBuaOG6rXAeEENhdXNlc1ZhbGlkYXRpb25oZGQCAw8QDxYGHg1EYXRhVGV4dEZpZWxkBQZreWhpZXUeDkRhdGFWYWx1ZUZpZWxkBQJJRB4LXyFEYXRhQm91bmRnZBAVAgJWTgJFThUCIEU0MzI5NkM2RjI0QzQ0MTBBODk0RjQ2RDU3RDJEM0FCIEFCQUY0NkJENjcxMjQ3QzVCNUI1Mjg4NUJCMkY5QzQ5FCsDAmdnFgFmZAIEDw8WAh4ISW1hZ2VVcmwFKC9DTUNTb2Z0LklVLldlYi5JbmZvL0ltYWdlcy9Vc2VySW5mby5naWZkZAIFD2QWBgIBDw8WAh8ABQZLaMOhY2hkZAIDDw8WAh8AZWRkAgcPDxYCHgdWaXNpYmxlaGRkAgIPZBYEAgMPD2QWAh4Gb25ibHVyBQptZDUodGhpcyk7ZAIHDw8WAh8AZWRkAgQPDxYCHwZoZGQCBg8PFgIfBmhkFgYCAQ8PZBYCHwcFCm1kNSh0aGlzKTtkAgUPD2QWAh8HBQptZDUodGhpcyk7ZAIJDw9kFgIfBwUKbWQ1KHRoaXMpO2QCCw9kFghmDw8WAh8AZWRkAgEPZBYCZg8PFgIfAWhkZAICD2QWAmYPDxYEHwAFDcSQxINuZyBuaOG6rXAfAWhkZAIDDw8WAh8ABbQFPGEgaHJlZj0iIyIgb25jbGljaz0iamF2YXNjcmlwdDp3aW5kb3cucHJpbnQoKSI+PGRpdiBzdHlsZT0iRkxPQVQ6bGVmdCI+CTxpbWcgc3JjPSIvQ01DU29mdC5JVS5XZWIuSW5mby9pbWFnZXMvcHJpbnQucG5nIiBib3JkZXI9IjAiPjwvZGl2PjxkaXYgc3R5bGU9IkZMT0FUOmxlZnQ7UEFERElORy1UT1A6NnB4Ij5JbiB0cmFuZyBuw6B5PC9kaXY+PC9hPjxhIGhyZWY9Im1haWx0bzo/c3ViamVjdD1IZSB0aG9uZyB0aG9uZyB0aW4gSVUmYW1wO2JvZHk9aHR0cDovLzExNS4xNDYuMTI3LjcyL0NNQ1NvZnQuSVUuV2ViLkluZm8vTG9naW4uYXNweCI+PGRpdiBzdHlsZT0iRkxPQVQ6bGVmdCI+PGltZyBzcmM9Ii9DTUNTb2Z0LklVLldlYi5JbmZvL2ltYWdlcy9zZW5kZW1haWwucG5nIiAgYm9yZGVyPSIwIj48L2Rpdj48ZGl2IHN0eWxlPSJGTE9BVDpsZWZ0O1BBRERJTkctVE9QOjZweCI+R+G7rWkgZW1haWwgdHJhbmcgbsOgeTwvZGl2PjwvYT48YSBocmVmPSIjIiBvbmNsaWNrPSJqYXZhc2NyaXB0OmFkZGZhdigpIj48ZGl2IHN0eWxlPSJGTE9BVDpsZWZ0Ij48aW1nIHNyYz0iL0NNQ1NvZnQuSVUuV2ViLkluZm8vaW1hZ2VzL2FkZHRvZmF2b3JpdGVzLnBuZyIgIGJvcmRlcj0iMCI+PC9kaXY+PGRpdiBzdHlsZT0iRkxPQVQ6bGVmdDtQQURESU5HLVRPUDo2cHgiPlRow6ptIHbDoG8gxrBhIHRow61jaDwvZGl2PjwvYT5kZGSNO8zl44N2nvW90EGlBOHRyNqvRHAOfnnU9hfkqJVVUQ==");
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

        Elements tableSumMark = document2.select("table#tblSumMark.tableborder table#grdResult");
        for (Element e:
            tableSumMark) {
            String value = e.select("tr td.cssListHeader").text();
            System.out.println(value);
            Elements result = e.select("tr.cssListItem");
            for (Element res:
                result ) {
                Elements r = res.select("td");
                System.out.println("size :" + r.size());
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
