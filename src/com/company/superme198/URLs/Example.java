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
import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjusters;
import java.util.*;

/**
 * Created by traig on 7:24 PM, 12/21/2018
 */

/**md5:https://www.mkyong.com/java/java-md5-hashing-example/
 * Unable to parse website after successful log in JSoup:
 * https://stackoverflow.com/questions/29183108/unable-to-parse-website-after-successful-log-in-jsoup
 *
 * https://stackoverflow.com/questions/36235797/best-way-to-compare-localdates?noredirect=1&lq=1
 * https://stackoverflow.com/questions/32904886/java-util-date-calculate-difference-in-days
 * convert string to localdate:https://www.mkyong.com/java8/java-8-how-to-convert-string-to-localdate/*/
public class Example {

    public static void main(String...args) {

//        Connection.Response loginForm = Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.Info/Login.aspx")
//                .method(Connection.Method.GET)
//                .execute();
//        Document doc = loginForm.parse();
//        Elements hiddenElems = doc.select("input[type=hidden]");
//        Map<String, String> nameValue = new HashMap<>();
//
//        for(Element elem : hiddenElems) {
//            nameValue.put(elem.attr("name"), elem.attr("value"));
//        }
//        nameValue.put("PageHeader1$drpNgonNgu", "E43296C6F24C4410A894F46D57D2D3AB");
//        loginForm =  Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.Info/Login.aspx")
//                .data("txtUserName", "CT010338")
//                .data("txtPassword", md5("03031998"))
//                .data(nameValue)
//                .data("btnSubmit", "Đăng nhập")
//                .cookies(loginForm.cookies())
//                .method(Connection.Method.POST)
//                .execute();
//       //showStudentMark(loginForm);
//
//        //showStudentTimeTable(loginForm);
//        //showDate();
////        String test = "Từ 07/01/2019 đến 27/01/2019: (1) Thứ 6 tiết 4,5,6 (LT) Từ 11/02/2019 đến 24/03/2019: (2) Thứ 6 tiết 4,5,6 (LT) Từ 25/03/2019 đến 31/03/2019: (3) Thứ 4 tiết 4,5,6 (LT) Thứ 6 tiết 4,5,6 (LT)";
////        for(String s: test.split("Từ")){
////            System.out.println(s);
////        }
//
//
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");
        //convert String to LocalDate
        LocalDate localDate2 = LocalDate.parse("27/01/2019", formatter);
        System.out.println(localDate2);
        LocalDate startDate = LocalDate.of(2019, Month.JANUARY, 7);
        LocalDate endDate= LocalDate.of(2019, Month.JANUARY, 27);
        //distance between two dates.
        //System.out.println(ChronoUnit.DAYS.between(startDate, endDate));

        //thu 2 va thu 4



      //  showDate();
//        System.out.println(binomialCoefficient(29, 20));

    }

    static boolean compareTo(LocalDate start, LocalDate end){
        return start.getDayOfMonth() <= end.getDayOfMonth() &&
                start.getMonthValue() <= end.getMonthValue();
    }

static long binomialCoefficient(int n, int k) {
    long fact =1, fact1 =1, factN =1 ;
    for(int i =2; i<=n ;i++){
        if(fact1 * fact > Long.MAX_VALUE){
            return -1;
        }
        if(i<= k){
            fact *=i;
        }
        if(i <= (n-k)){
            fact1 *= i;
        }
        factN *= i;
    }
    return (factN)/ (fact1* fact);
}



    static class Details{
        String time = "";
        String date = "";
        String details = "";
        String subjectName;
        String teacher;
        String shortenedSubjectName;
        String place;
        public Details(){}
        Details(String date, String time){
            this.date = date;
            this.time = time;
        }

        public String getPlace() {
            return place;
        }

        public void setPlace(String place) {
            this.place = place;
        }

        public String getShortenedSubjectName() {
            return shortenedSubjectName;
        }

        public void setShortenedSubjectName(String shortenedSubjectName) {
            this.shortenedSubjectName = shortenedSubjectName;
        }

        public String getSubjectName() {
            return subjectName;
        }

        public void setSubjectName(String subjectName) {
            this.subjectName = subjectName;
        }

        public String getTeacher() {
            return teacher;
        }

        public void setTeacher(String teacher) {
            this.teacher = teacher;
        }

        public String getTime() {
            return time;
        }

        public void setTime(String time) {
            this.time = time;
        }

        String getDate() {
            return date;
        }

        public void setDate(String date) {
            this.date = date;
        }

        public String getDetails() {
            return details;
        }

        public void setDetails(String details) {
            this.details = details;
        }
    }

    private static void showDate(){

        LocalDate localDate = LocalDate.of(2019, Month.JANUARY, 1);
        System.out.println(localDate.lengthOfMonth());//the length of Month.
        int lengthOfMonth = localDate.lengthOfMonth();

        Details[][] detailsOfMonday = new Details[11][6];
        Details[][] detailsOfTuesday = new Details[11][6];
        Details[][] detailsOfWednesday = new Details[11][6];
        Details[][] detailsOfThursday = new Details[11][6];
        Details[][] detailsOfFriday = new Details[11][6];

        //init Date.
        initDateToDetails(localDate, DayOfWeek.MONDAY , detailsOfMonday, lengthOfMonth);
        initDateToDetails(localDate, DayOfWeek.TUESDAY , detailsOfTuesday, lengthOfMonth);
        initDateToDetails(localDate, DayOfWeek.WEDNESDAY , detailsOfWednesday, lengthOfMonth);
        initDateToDetails(localDate, DayOfWeek.THURSDAY , detailsOfThursday, lengthOfMonth);
        initDateToDetails(localDate, DayOfWeek.FRIDAY , detailsOfFriday, lengthOfMonth);

        //init Time.
        initTimeToDetails(detailsOfMonday);
        initTimeToDetails(detailsOfTuesday);
        initTimeToDetails(detailsOfWednesday);
        initTimeToDetails(detailsOfThursday);
        initTimeToDetails(detailsOfFriday);

        System.out.println(detailsOfMonday[0][4].getDate());

//        YearMonth dateY = YearMonth.now();
//        System.out.printf("%s: %d%n", dateY, dateY.lengthOfMonth());
//        MonthDay month = MonthDay.now();
//        System.out.println("Month:" + month.getDayOfMonth());
//        Instant timestamp = new Date().toInstant();
//        LocalDateTime date = LocalDateTime.ofInstant(timestamp, ZoneId.systemDefault());
//        System.out.println(date);
//        System.out.println( date.with(TemporalAdjusters.next(DayOfWeek.MONDAY)));
    }

    private static void initDateToDetails(LocalDate localDate, DayOfWeek dayOfWeek, Details[][] details, int lengthOfMonth){
        int firstDayOfMonth = localDate.with(TemporalAdjusters.firstInMonth(dayOfWeek)).getDayOfMonth();
        int i =firstDayOfMonth % 7==0 ? 2:1;
        while ((firstDayOfMonth) <= lengthOfMonth){
            details[0][i++] = new Details( firstDayOfMonth+ "/" +localDate.getMonth().getValue(), "");
            firstDayOfMonth += 7;
        }
    }

    private static void initTimeToDetails(Details[][] details){
        details[0][0]= new Details("", "Ngay");
        details[1][0]= new Details("", "1-2");
        details[2][0]= new Details("", "3");
        details[3][0]= new Details("", "4-5");
        details[4][0]= new Details("", "6");
        details[5][0]= new Details("", "7-8");
        details[6][0]= new Details("", "9");
        details[7][0]= new Details("", "10-11");
        details[8][0]= new Details("", "12");
        details[9][0]= new Details("", "13-14");
        details[10][0] = new Details("", "15-16");
    }

    public static void showStudentTimeTable(Connection.Response loginForm) throws IOException {
        Map<String, String> cookies = loginForm.cookies();
        Document document = Jsoup.connect("http://115.146.127.72/CMCSoft.IU.Web.Info/Reports/Form/StudentTimeTable.aspx")
                .cookies(cookies)
                .get();
//        Elements titleTimeTable = document.select("table#gridRegistered tbody tr.DataGridFixedHeader");
//        for(Element e: titleTimeTable){
//            Elements result = e.select("td");
//                for (Element element : result) {
//                    System.out.print(element.text() + " ");
//                }
//                System.out.println();
//
//        }
        Elements titleTimeTable = document.select("table#gridRegistered tbody tr.cssListItem");
        for(Element e: titleTimeTable){
            Elements result = e.select("td");
            for (Element element : result) {
                System.out.print(element.text() + "+");
            }
            System.out.println();

        }

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
