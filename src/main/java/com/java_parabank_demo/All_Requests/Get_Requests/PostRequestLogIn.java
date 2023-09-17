package com.java_parabank_demo.All_Requests.Get_Requests;

import com.java_parabank_demo.api.ResponseReader;
import com.java_parabank_demo.helpers.CredentialsAndURLS;
import com.java_parabank_demo.helpers.JsonParser;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;

public class PostRequestLogIn {

        private static final String loginUrl = "https://parabank.parasoft.com/parabank/index.htm";
        //private static String loginUrl;
        private static String responseCode;
        private static String responseBody;
        public static String accessToken;
        private static String authMessage;
        public static String ID;


        public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
            //String email = "a.tunay+8@gmail.com";
            //String password = "123456";

            CredentialsAndURLS credentialsAndURLS = new CredentialsAndURLS();
            credentialsAndURLS.credentialsAndURLS();


            //ReadConfig readConfig = new ReadConfig();
            //readConfig.readConfigFile();
            //loginUrl = (readConfig.getQaEnv() + "/authaccount/login");//new
            String username = credentialsAndURLS.getUsername();//new
            String password = credentialsAndURLS.getPassword();//new

            try {
                login(username, password);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
            printAccessDetails();
        }

        public static void login(String username, String password) throws IOException {
            // Build the post request
            String postBody = "{\"username\":\"" + username + "\", " + "\"password\":\"" + password + "\"}";
            HttpPost postLogin = new HttpPost(loginUrl);
            postLogin.setEntity(new StringEntity(postBody));
            postLogin.setHeader("Content-type", "application/json");
            HttpClient httpClient = HttpClientBuilder.create().build();
            // Execute the post request
            HttpResponse response = httpClient.execute(postLogin);
            responseCode = response.getStatusLine().toString();
            // Fill in the response body
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                // A Simple JSON Response Read
                InputStream instream = entity.getContent();
                responseBody = new ResponseReader().convertStreamToString(instream);
                instream.close();
            }
            // Extract and set the access token
            if (responseCode.contains("200") == true) {
                JsonParser json = new JsonParser();
                String authCode = json.getResponseCode(responseBody);
                authMessage = json.getAuthMessage(responseBody);
                if (authCode.equals("0")) {
                    accessToken = json.getAccessToken(responseBody);
                    ID = json.getID(responseBody);
                }
            }
            //AccessTokenHolder.setAccessToken(accessToken);
            System.out.println("A: " + accessToken);
            //IDHolder.setID(ID);
            System.out.println("B: " + ID);
        }

        public static String getAccessToken() {
            return accessToken;
        }

        public static String getResponseCode() {

            return responseCode;
        }

        public static String getResponseBody() {

            return responseBody;
        }

        public static String getLoginMessage() {

            return authMessage;
        }
        public static String getID(){
            return ID;
        }


        public static void printAccessDetails() {
            System.out.println("responseCode: " + responseCode);
            System.out.println("authMessage: " + authMessage);
            System.out.println("responseBody: " + responseBody);
            System.out.println("accessToken: " + accessToken);
            System.out.println("ID: " + ID);
        }
    }
