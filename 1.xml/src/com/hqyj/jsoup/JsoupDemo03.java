package com.hqyj.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Document和Element对象的功能
 */
public class JsoupDemo03 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo03.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //3.获取元素对象
        //3.1获取所有student对象
        Elements elements = document.getElementsByTag("student");
        System.out.println(elements);
        System.out.println("---------------");
        //3.2获取属性名为id的元素对象们
        Elements elements1 = document.getElementsByAttribute("id");
        System.out.println(elements1);
        System.out.println("---------------");
        //3.3获取number属性值为s001的元素对象
        Elements elements2 = document.getElementsByAttributeValue("number", "s001");
        System.out.println(elements2);
        System.out.println("---------------");
        //3.4获取id属性值的元素对象
        Element hq = document.getElementById("hq");
        System.out.println(hq);


    }
}
