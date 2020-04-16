//package com.atguigu.springcloud.service.Impl;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import org.openqa.selenium.JavascriptExecutor;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
//
//
//import javax.xml.transform.Source;
//import java.io.*;
//import java.util.ArrayList;
//import java.util.HashSet;
//import java.util.List;
//import java.util.Set;
//
///**
// * @Author:hejr
// * @Description:
// * @Date: 2019/3/20 14:26
// */
//
//public class ScrapyDemo {
//    public static void main(String[] args) throws IOException {
//        String data = "G://test.txt";
//        File file = new File(data);
//        FileReader reader = new FileReader(file);
//        BufferedReader bufferedReader = new BufferedReader(reader);
//        String line = null;
//        StringBuilder builder = new StringBuilder();
//        while ((line = bufferedReader.readLine()) != null) {
//            builder.append(line);
//        }
//        JSONObject jsonObject = JSONObject.parseObject(builder.toString());
//        JSONArray array = jsonObject.getJSONObject("data").getJSONArray("comments");
//        System.out.println(array.size());
//        System.out.println(array.getJSONObject(0));
//    }
//
//
//    public static void main3(String[] args) {
//        String url = "https://www.toutiao.com/api/comment/list/?group_id=6650967291171176967&item_id=6650967291171176967&offset=0&count=5";
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get(url);
//        String data = webDriver.getPageSource();
//        System.out.println(data);
//    }
//    public static void main2(String[] args) throws IOException {
//
//
//
//
//        String file = "F://data.txt";
//        String saveFile = "F://out.data";
//
//        BufferedReader reader = new BufferedReader(new FileReader(file));
//        StringBuilder builder = new StringBuilder();
//        String line = null;
//        while ((line = reader.readLine()) != null) {
//            builder.append(line);
//        }
//
//        System.out.println(builder.toString());
//        JSONObject dataJSON = JSONObject.parseObject(builder.toString());
//        reader.close();
//
//        System.out.println(dataJSON);
//        if (dataJSON.containsKey("data")) {
//            JSONArray array = dataJSON.getJSONArray("data");
//            int urlCOunt = 0;
//            int emp = 0;
//            int title = 0;
//            System.out.println(array.size());
//            ArrayList<List<String>> urlList = new ArrayList<List<String>>();
//            for (int i = 0; i < array.size(); i++) {
//                JSONObject thisObj = array.getJSONObject(i);
//                System.out.println();
//                System.out.println(thisObj);
//
//
//                if (thisObj.containsKey("article_url") && thisObj.getJSONObject("emphasized").containsKey("title")) {
//                    urlCOunt += 1;
//                    emp += 1;
//                    title += 1;
//                    List<String> urlToTitle = new ArrayList<String>();
//                    urlToTitle.add(0, thisObj.getString("article_url"));
//                    urlToTitle.add(1, thisObj.getJSONObject("emphasized").getString("title"));
//                    urlList.add(urlToTitle);
//                }
//
//            }
//            System.out.printf("urlCount %d \n", urlCOunt);
//            System.out.printf("emp: %d \ntitles %d", emp, title);
//            System.out.println();
//            System.out.println(urlList.size());
//            builder = new StringBuilder();
//            for (List<String> s : urlList) {
//                System.out.println(s.get(0));
//                System.out.println(s.get(1));
//                builder.append(s.get(0)).append(" ").append(s.get(1)).append("\n");
//                System.out.println();
//            }
//            ScrapyDemo.save_url_title(saveFile, builder.toString()).close();
//        } else {
//            System.out.println("data error!");
//        }
//    }
//
//
//    public static void main1(String[] args) throws Exception {
//        WebDriver webDriver = new ChromeDriver();
//        webDriver.get("http://www.baidu.com");
//        String title = webDriver.getTitle();
//        System.out.println(title);
//
//        ((JavascriptExecutor) webDriver).executeScript("window.open()");
//        Set<String> set = webDriver.getWindowHandles(); // 获取窗口句柄
//        System.out.println();
//        for (String i : set) {
//            System.out.println(i);
//        }
//        System.out.println();
//        webDriver.switchTo().window((String) set.toArray()[1]);
//        webDriver.get("https://www.taobao.com");
//        Thread.sleep(1000 * 5);
//        webDriver.switchTo().window((String) set.toArray()[0]);
//        webDriver.get("https://www.zhihu.com");
//
//
//        Thread.sleep(1000 * 5);
//        webDriver.close();
//    }
//
//    public static BufferedWriter save_url_title(String fileIn, String content) throws IOException {
//        File file = new File(fileIn);
//        if (!file.exists()) {
//            file.createNewFile();
//        }
//
//        FileWriter writer = new FileWriter(file);
//        BufferedWriter bufferedWriter = new BufferedWriter(writer);
//        bufferedWriter.write(content);
//        bufferedWriter.flush();
//        return bufferedWriter;
//    }
//}
