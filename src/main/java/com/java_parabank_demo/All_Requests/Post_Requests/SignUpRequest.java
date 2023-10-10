package com.java_parabank_demo.All_Requests.Post_Requests;

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

public class SignUpRequest {
    //private static final String SignUpURL = "https://parabank.parasoft.com/parabank/register.htm";
    private static String SignUpURL;
    private static String responseCode;
    private static String responseBody;
    private static String accessToken;
    private static String authMessage;
    public static void main (String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {

    /*
        String firstName = Tunay;
        String lastName = Amishev;
        String address =  Beli brezi;
        String city = Sofia;
        String state = BG;
        String zipCode = 1111;
        String phone = 088112233;
        String ssn = 12345;
        String username = tuni;
        String password = test123;
        String confirmPW = test123;
    */
        CredentialsAndURLS credentialsAndURLS = new CredentialsAndURLS();
        credentialsAndURLS.credentialsAndURLS();

        String firstName = credentialsAndURLS.getFirstName();
        String lastName = credentialsAndURLS.getLastName();
        String address =  credentialsAndURLS.getAddress();
        String city = credentialsAndURLS.getCity();
        String state = credentialsAndURLS.getState();
        String zipCode = credentialsAndURLS.getZipCode();
        String phone = credentialsAndURLS.getPhone();
        String ssn = credentialsAndURLS.getSsn();
        String username = credentialsAndURLS.getUsername();
        String password = credentialsAndURLS.getPassword();
        String confirmPW = credentialsAndURLS.getConfirmPW();
        SignUpURL = credentialsAndURLS.getRegisterURL(); //ако е локална променлива,.теста не минава. Адреса е null???

        System.out.println("registerURL: " + SignUpURL);
        System.out.println("firstName: " + firstName);
        System.out.println("lastName: " + lastName);
        System.out.println("address: " + address);
        System.out.println("city: " + city);
        System.out.println("state: " + state);
        System.out.println("zipCode: " + zipCode);
        System.out.println("phone: " + phone);
        System.out.println("ssn: " + ssn);
        System.out.println("username: " + username);
        System.out.println("password: " + password);
        System.out.println("confirmPW: " + confirmPW);

        try {
            signUp(firstName, lastName, address, city, state, zipCode, phone, ssn, username, password, confirmPW);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        printAccessToken();
    }
    public static void signUp(String firstName, String lastName, String address, String city, String state, String zipCode, String phone, String ssn, String username, String password, String confirmPW) throws IOException {
        // Build the post request
        String postBody = "{\"firstName\":\"" + firstName + "\", " + "\"lastName\":\"" + lastName + "\", " + "\"address\":\"" + address + "\", " + "\"city\":\"" + city + "\", " + "\"state\":\"" + state + "\", " + "\"zipCode\":\"" + zipCode + "\", " + "\"phone\":\"" + phone + "\", " + "\"ssn\":\"" + ssn + "\", " + "\"username\":\"" + username + "\", " + "\"password\":\"" + password + "\"confirmPW\":\"" + confirmPW + "\"}";
        HttpPost postSignUp = new HttpPost(SignUpURL);
        postSignUp.setEntity(new StringEntity(postBody));
        postSignUp.setHeader("Content-type", "application/json");
        HttpClient httpClient = HttpClientBuilder.create().build();
        // Execute the post request
        HttpResponse response = httpClient.execute(postSignUp);
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
            }
        }
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
    public static void printAccessToken() {
        System.out.println(responseCode);
        System.out.println(authMessage);
        System.out.println(responseBody);
        System.out.println(accessToken);
    }
}
