package com.monlong.slog.utils;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xml.sax.InputSource;

import java.io.StringReader;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

/**
 * @ClassName: Utils
 * @Description: 日志打印
 * @Author: monlong
 * @Date: 2016/1/12 22:12
 * @Version: 1.0.0
 */
public class Utils {

    /**
     * 判断字符串是否是JSON格式
     *
     * @param json
     * @return
     */
    public static boolean isJson(String json) {
        try {
            new JSONObject(json);
            return true;
        } catch (JSONException e) {
        }

        try {
            new JSONArray(json);
            return true;
        } catch (JSONException e) {
        }
        return false;
    }


    /**
     * 判断字符串是否是XML类型
     *
     * @param xml
     * @return
     */
    public static boolean isXml(String xml) {
        try {
            StringReader sr = new StringReader(xml);
            InputSource is = new InputSource(sr);
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            builder.parse(is);
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
