//package com.atguigu.springcloud.service.Impl;
//
//import com.alibaba.fastjson.JSONArray;
//import com.alibaba.fastjson.JSONObject;
//import com.atguigu.springcloud.entities.Comment;
//
//import java.io.*;
//
///**
// * @Author:hejr
// * @Description:
// * @Date: 2019/3/22 13:42
// */
//
//public class ParseXinLangData {
//
//    public static void main1(String[] args) {
//        String data = "jsonp_1553238278662(daijitao is ok";
//        int len = data.indexOf("(");
//        System.out.println(len);
//
//        System.out.println(data.substring(len+1));
//    }
//
//    public static void main(String[] args) throws Exception{
//        String dataPath = "F:/scrapy/xinlang/data1/page";
//        String dataName = null;
//        for (int i = 0; i < 10; i++) {
//            dataName = dataPath + i + ".txt";
//            System.out.println(dataName);
//            parseData(dataName);
//        }
//
//    }
//
//    public static void parseData(String dataPath) throws Exception {
//
//        String data = ParseXinLangData.getData(dataPath);
//        int strtIndex = data.indexOf("(");
//        int len = data.length();
//        System.out.println("总长度： " + len);
//        String js = data.substring(strtIndex+1, len-1);
//        JSONObject resultJSONObj = JSONObject.parseObject(js).getJSONObject("result");
//        JSONArray array = resultJSONObj.getJSONArray("cmntlist");
//        System.out.println("评论列表：" + array.size());
//
//        String savePath = "F:\\scrapy\\xinlangOutData\\data1\\";
//        String fileName = "news1_data1.txt";
//        String file = savePath + fileName;
//        createFile(savePath, fileName);
//        for (int i = 0; i < array.size(); i ++) {
//            JSONObject tmp = array.getJSONObject(i);
//            String rank = tmp.getString("rank");
//            String loc = tmp.getString("area");
//            String content = tmp.getString("content");
//            String nick = tmp.getString("nick");
//            String parent_uid = tmp.getString("parent_uid");
//            String time = tmp.getString("time");
//            String newsId = tmp.getString("newsid");
//            String uid = tmp.getString("uid");
//
//            Comment comment = new Comment();
//            if (parent_uid.equals("0")) {
//                comment.setIsNew("0"); // 0代表原创
//            } else {
//                comment.setIsNew("1"); //1 代表回复
//            }
//            StringBuilder stringBuilder = new StringBuilder();
//            stringBuilder.append("line:").append(" ").append(uid).append(" ").append(newsId).append(" ").append("(").append(time).append(")").append(" ").append(loc)
//                    .append(" ").append(content).append(" ").append(comment.getIsNew()).append("\n");
//
//            SaveData(file, stringBuilder.toString());
//        }
//    }
//
//    /**
//     * 创建文件
//     * @param
//     * @return
//     */
//    public static boolean createFile(String filePath, String name)throws Exception{
//        File fileDir = new File(filePath);
//        if (!fileDir.exists()) {
//            fileDir.mkdir();
//        }
//
//        File fileName = new File(filePath + name);
//
//        try{
//            if(!fileName.exists()){
//                fileName.createNewFile();
//            }
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return true;
//    }
//
//    /**
//     * 写入TXT，追加写入
//     * @param filePath
//     * @param content
//     */
//    public static void SaveData(String filePath, String content) {
//        try {
//            //构造函数中的第二个参数true表示以追加形式写文件
//            FileWriter fw = new FileWriter(filePath,true);
//            fw.write(content);
//            fw.close();
//        } catch (IOException e) {
//            System.out.println("文件写入失败！" + e);
//        }
//    }
//
//    /**
//     * 读取数据
//     * @param filePath
//     * @return
//     * @throws IOException
//     */
//    public static String getData(String filePath) throws IOException {
//        FileReader fileReader = new FileReader(new File(filePath));
//        BufferedReader bffReader = new BufferedReader(fileReader);
//        StringBuilder stringBuilder = new StringBuilder();
//        String line = null;
//        while ((line = bffReader.readLine()) != null) {
//            stringBuilder.append(line);
//        }
//        bffReader.close();
//        return stringBuilder.toString();
//    }
//}
