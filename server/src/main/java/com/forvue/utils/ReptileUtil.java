package com.forvue.utils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.Socket;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * java爬虫类
 * Created by gqc on 2018/12/13.
 */
public class ReptileUtil {

    /**
     *
     * 爬取天气信息 返回天气文本
     * @return weatherText
     * @throws IOException
     */
    public  String getWeatherText() throws IOException {
     //   URL url = new URL("http://www.tianqi.com/qingdao/15/");

   //     BufferedReader bufIn = new BufferedReader(new InputStreamReader(url.openStream()));

        //从一个网站获取和解析一个HTML文档，并查找其中的相关数据，可以使用 Jsoup.connect(String url)方法。
        Document doc = Jsoup.connect("http://www.tianqi.com/qingdao/")
                    .userAgent("Mozilla").get();

        Elements contents = doc.getElementsByClass("weather");

        String weatherText="";

        for(Element weather:contents){
            weatherText=   weather.text();
        }

        return weatherText;

//        String mail_regex = "[a-zA-Z]+@[a-zA-Z0-9]+(\\.[a-zA-Z]{1,3})+";
//
//        List<String> list = new ArrayList<String>();
//        Pattern p = Pattern.compile(mail_regex);
//
//        String line = null;
//        while ((line = bufIn.readLine()) != null) {
//            Matcher m = p.matcher(line);
//            while (m.find()) {
//                list.add(m.group());
//            }
//
//        }
//        return list;

    }

}