package com.example.jingtao.autoimport;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import java.io.FileReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class AutoImport {
    public static List<Map<String, String>> fun(String username, String password) {
        Map<String, String> bkjsw_cookies = null;
        Map<String, String> pass_cookies = null;
        String url_bkjws = "http://bkjws.sdu.edu.cn/";
        String url_pass = "http://pass.sdu.edu.cn/cas/login?service=http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry";
//        String username = "201900301184";
//        String password = "";
        String lt = null;
        String rsa = null;
        Connection connect = Jsoup.connect(url_bkjws);
        try {
            Connection.Response response_url_bkjws = connect.header("Connection", "keep-alive").execute();
            bkjsw_cookies = response_url_bkjws.cookies();
            System.out.println("bkjsw_cookies=" + bkjsw_cookies);

            //pass_cookies = Jsoup.connect(url_pass).execute().cookies();
            pass_cookies = Jsoup.connect(url_pass).header("Connection", "keep-alive").execute().cookies();
            System.out.println("pass_cookies=" + pass_cookies);

            lt = Jsoup.connect("http://pass.sdu.edu.cn/cas/login?service=http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry").get().getElementById("lt").val();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//创建一个脚本引擎管理器
        ScriptEngineManager manager = new ScriptEngineManager();
        //获取一个指定的名称的脚本引擎
        ScriptEngine engine = manager.getEngineByName("js");
        try {

            //获取当前类的所在目录的路径
            //String path = ExecuteScript.class.getResource("").getPath();
            //String path = "E:\\源码\\微信小程序开发\\java后台\\src\\main\\java\\com\\example\\jingtao\\autoimport\\";
            String basePath = null;
            try {
                basePath = URLDecoder.decode(Thread.currentThread().getContextClassLoader().getResource("").getPath(), "UTF-8");
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            //String path = Class.class.getClass().getResource("/").getPath();
            // FileReader的参数为所要执行的js文件的路径
            engine.eval(new FileReader(basePath + "des.js"));
            if (engine instanceof Invocable) {
                Invocable invocable = (Invocable) engine;
                //从脚本引擎中返回一个给定接口的实现
                JS js = invocable.getInterface(JS.class);
                //执行指定的js方法
                //System.out.println(js.strEnc("20192216128620011011ke" + lt, "1", "2", "3"));//
                rsa = js.strEnc(username + password + lt, "1", "2", "3");

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//+++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++

        Connection connect_login = Jsoup.connect("http://pass.sdu.edu.cn/cas/login?service=http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry");
        connect_login.header("(Request-Line)", "POST /cas/login?service=http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry HTTP/1.1");
        connect_login.header("Accept", "text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
        connect_login.header("Accept-Encoding", "gzip, deflate");
        connect_login.header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
        connect_login.header("Connection", "keep-alive");
        connect_login.header("Content-Type", "application/x-www-form-urlencoded");
        connect_login.header("Cookie", "JSESSIONID=" + pass_cookies.get("JSESSIONID") + "; Language=zh_CN");
        connect_login.header("Host", "pass.sdu.edu.cn");
        connect_login.header("Referer", "http://pass.sdu.edu.cn/cas/login?service=http://bkjws.sdu.edu.cn/f/j_spring_security_thauth_roaming_entry");
        connect_login.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0");


        connect_login.data("_eventId", "submit");
        connect_login.data("execution", "e1s1");
        connect_login.data("lt", lt);
        connect_login.data("pl", String.valueOf(password.length()));
        connect_login.data("rsa", rsa);
        connect_login.data("ul", String.valueOf(username.length()));
        Document doc = null;
        try {
            Connection.Response response_login = connect_login.followRedirects(false).execute();
            doc = response_login.parse();
            Connection connect2 = Jsoup.connect(response_login.header("Location")).followRedirects(false);
            connect2.header("Cookie", "JSESSIONID=" + bkjsw_cookies.get("JSESSIONID"));
            Connection.Response response2 = connect2.execute();
            Connection connection3 = Jsoup.connect(response2.header("Location")).followRedirects(false);
            connection3.header("Cookie", "JSESSIONID=" + bkjsw_cookies.get("JSESSIONID"));
            Connection.Response response3 = connection3.execute();
            Connection.Response response = Jsoup.connect(response3.header("Location")).followRedirects(false).header("Cookie", "JSESSIONID=" + bkjsw_cookies.get("JSESSIONID")).execute();

        } catch (IOException e) {
            e.printStackTrace();
        }
//
        Connection connection_course = Jsoup.connect("http://bkjws.sdu.edu.cn/f/xk/xs/bxqkb");
        //System.out.println(bkjsw_cookies.get("JSESSIONID"));
        connection_course.header("Cookie", "JSESSIONID=" + bkjsw_cookies.get("JSESSIONID"));
        // System.out.println(bkjsw_cookies.get("JSESSIONID"));
        connection_course.header("(Request-Line)", "POST /f/xk/xs/bxqkb HTTP/1.1");
        connection_course.header("Accept", "*/*");
        connection_course.header("Accept-Encoding", "gzip, deflate");
        connection_course.header("Accept-Language", "zh-cn,zh;q=0.8,en-us;q=0.5,en;q=0.3");
        connection_course.header("Connection", "keep-alive");
        connection_course.header("Content-Length", "0");
        connection_course.header("Host", "bkjws.sdu.edu.cn");
        connection_course.header("Pragma", "no-cache");
        connection_course.header("Referer", "http://bkjws.sdu.edu.cn/f/common/main");
        connection_course.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0");
        connection_course.header("X-Requested-With", "XMLHttpRequest");
        //connection_course.header("User-Agent", "Mozilla/5.0 (Windows NT 10.0; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0");
        Document doc_course = null;
        try {
            doc_course = connection_course.post();

        } catch (IOException e) {
            e.printStackTrace();
        }
        // System.out.println(doc_course.getElementById("ysjddDataTableId"));
        //Elements courses = doc_course.getElementById("ysjddDataTableId").getElementsByClass("tr");
        Elements trs = doc_course.getElementById("ysjddDataTableId").select("tr");
        List<Map<String, String>> list = new ArrayList<>();
        for (int i = 0; i < trs.size(); i++) {
            //每一行 一个课程
            list.add(new HashMap<>());
            Elements tds = trs.get(i).select("td");
            for (int j = 0; j < tds.size(); j++) {
//                if (j == (tds.size() - 1)) {
//                    System.out.println(tds.get(j).text());
//                } else {
//                    System.out.print(tds.get(j).text() + "   ");
//                }
                switch (j) {
                    case 2:
                        list.get(i).put("courseName", tds.get(j).text());
                        break;
                    case 7:
                        list.get(i).put("teacher", tds.get(j).text());
                        break;
                    case 8:
                        list.get(i).put("weeks", tds.get(j).text());
                        break;
                    case 9:
                        list.get(i).put("day", tds.get(j).text());
                        break;
                    case 10:
                        list.get(i).put("jieshu", tds.get(j).text());
                        break;
                    case 11:
                        list.get(i).put("classroom", tds.get(j).text());
                        break;
                }
            }
        }
        list.remove(0);
        System.out.println(list);
        System.out.println(list.size());
        return list;
    }
}
