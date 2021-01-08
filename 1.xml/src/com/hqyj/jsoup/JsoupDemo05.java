package com.hqyj.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

public class JsoupDemo05 {
    public static void main(String[] args) throws IOException {
        /**
         * selector:选择器
         *
         *   * 使用的方法：Elements	select​(String cssQuery)
         *       * 语法：参考Selector类中定义的语法
         */
        String path = JsoupDemo05.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        //查询name标签
        Elements elements = document.select("name");
        System.out.println(elements);
        System.out.println("----------------");
        //查询id值为hq的元素
        Elements elements1 = document.select("#hq");
        System.out.println(elements1);
        System.out.println("----------------");
        //获取student标签并且number属性值为s001的age子标签
        //1.获取student标签并且number属性值为s001
        Elements elements2 = document.select("student[number=\"s001\"]");
        System.out.println(elements2);
        System.out.println("----------------");
        //2.获取student标签并且number属性值为s001的age子标签
        Elements elements3 = document.select("student[number=\"s001\"]>age");
        System.out.println(elements3);

    }
}
