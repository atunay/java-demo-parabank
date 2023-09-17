package com.java_parabank_demo.helpers;

public class JsonParser {
    public static void main(String[] args) {
    }

    public static String getAccessToken(String in) {
        String[] json = in.split(",");
        String data = json[5];
        data = data.replace("}", "");
        String[] key = data.split(":");
        String value = key[1];
        String accessToken = value.replace("\"", "");
        return accessToken;
    }

    public static String getResponseCode(String in) {
        String[] json = in.split(",");
        String data = json[0];
        data = data.replace("{", "");
        String[] key = data.split(":");
        String value = key[1];
        String code = value.replace("\"", "");
        return code;
    }

    public static String getAuthMessage(String in) {
        String[] json = in.split(",");
        String data = json[0];
        data = data.replace("{", "");
        String[] key = data.split(":");
        String value = key[1];
        String message = value.replace("\"", "");
        return message;
    }
    public static String getID (String in) {
        String[] json = in.split(",");
        String data = json[2];
        data = data.replace("}", "");
        String[] key = data.split(":");
        String value = key[2];
        String ID = value.replace("\"", "");
        return ID;
    }
}
