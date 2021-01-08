package com.hqyj.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * Jsoup对象的功能
 */
public class JsoupDemo02 {
    public static void main(String[] args) throws IOException {
        //2.1获取path
        String path = JsoupDemo02.class.getClassLoader().getResource("student.xml").getPath();
        //2.2解析XML文档
        /*Document document = Jsoup.parse(new File(path), "utf-8");
        System.out.println(document);*/
      /*  String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" ?>\n" +
                "<students>\n" +
                "\t<student number=\"s001\">\n" +
                "\t\t<name id=\"hq\">\n" +
                "\t\t\t<xing>张</xing>\n" +
                "\t\t\t<ming>三</ming>\n" +
                "\t\t</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>male</sex>\n" +
                "\t</student>\n" +
                "\t<student number=\"s002\">\n" +
                "\t\t<name>jack</name>\n" +
                "\t\t<age>18</age>\n" +
                "\t\t<sex>female</sex>\n" +
                "\t</student>\n" +
                "</students>";
        Document document = Jsoup.parse(str);
        System.out.println(document);*/
      //网络资源路径
        URL url = new URL("https://www.baidu.com/s?tn=25017023_12_pg&ch=1&ie=UTF-8&wd=qq%E9%82%AE%E7%AE%B1");
        Document document = Jsoup.parse(url, 10000);
        System.out.println(document);
    }
}
