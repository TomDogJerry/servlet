package com.hqyj.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * Element对象功能
 */
public class JsoupDemo04 {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo04.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        /**
         * 1. 获取子元素对象
         * 				* getElementById​(String id)：根据id属性值获取唯一的element对象
         * 				* getElementsByTag​(String tagName)：根据标签名称获取元素对象集合
         * 				* getElementsByAttribute​(String key)：根据属性名称获取元素对象集合
         * 				* getElementsByAttributeValue​(String key, String value)：根据对应的属性名和属性值获取元素对象集合
         *
         * 			2. 获取属性值
         * 				* String attr(String key)：根据属性名称获取属性值
         * 			3. 获取文本内容
         * 				* String text():获取文本内容
         * 				* String html():获取标签体的所有内容(包括子标签的字符串内容)
         */
        Elements elements = document.getElementsByTag("name");
        System.out.println(elements.size());
        Element element_stu = document.getElementsByTag("student").get(0);
        Elements ele_name = element_stu.getElementsByTag("name");
        System.out.println(ele_name.size());

        //获取student对象的属性值
        String number = element_stu.attr("number");
        System.out.println(number);
        System.out.println("----------");
        //获取文本内容
        String text = ele_name.text();
        String html = ele_name.html();
        System.out.println(text);
        System.out.println(html);



    }
}
