package com.java_parabank_demo.helpers;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
public class CredentialsAndURLS {

    private static String baseURL;
    private static String registerURL;
    private static String users;
    private static Long id;
    private static String firstName;
    private static String lastName;
    private static String address;
    private static String city;
    private static String state;
    private static String zipCode;
    private static String phone;
    private static String ssn;
    private static String username;
    private static String password;
    private static String confirmPW;

    public CredentialsAndURLS(){};

    public static void credentialsAndURLS() throws IOException, ParseException, org.json.simple.parser.ParseException {
        FileReader reader = new FileReader("/home/tunay/java_parabank_demo/src/main/java/com/java_parabank_demo/config/config.json");
        JSONParser jsonparser = new JSONParser();
        Object object = jsonparser.parse(reader);
        JSONObject configJsonObj = (JSONObject) object;

        baseURL = (String) configJsonObj.get("baseURL");
        registerURL = (String) configJsonObj.get("registerURL");

        // Store the users array in a global variable
        JSONArray usersArray = (JSONArray) configJsonObj.get("users");
        users = usersArray.toString();
        // Iterate over the users array and store the first user's data in global variables
        for (Object user : usersArray) {
            JSONObject userObj = (JSONObject) user;
            id = (Long) userObj.get("id");
            firstName = (String) userObj.get("firstName");
            lastName = (String) userObj.get("lastName");
            address = (String) userObj.get("address");
            city = (String) userObj.get("city");
            state = (String) userObj.get("state");
            zipCode = (String) userObj.get("zipCode");
            phone = (String) userObj.get("phone");
            ssn = (String) userObj.get("ssn");
            username = (String) userObj.get("username");
            password = (String) userObj.get("password");
            confirmPW = (String) userObj.get("confirmPW");
            break;
        }
    }

    public void setBaseURL(String baseURL) {
        this.baseURL = baseURL;
    }

    public static String getBaseURL() {
        return baseURL;
    }
    public void setRegisterURL(String registerURL) {
        this.registerURL = registerURL;
    }

    public static String getRegisterURL() {
        return registerURL;
    }
    public void setUsers(String users) {
        this.users = users;
    }

    public static String getUsers() {
        return users;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public static Long getId() {
        return id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public static String getFirstName() {
        return firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public static String getLastName() {
        return lastName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public static String getAddress() {
        return address;
    }
    public void setCity(String city) {
        this.city = city;
    }

    public static String getCity() {
        return city;
    }

    public void setState(String state) {
        this.state = state;
    }
    public static String getState() {
        return state;
    }
    public void setZipCode(String zipCode) {
        this.state = zipCode;
    }
    public static String getZipCode() {
        return zipCode;
    }
    public void setPhone(String phone) {
        this.phone = phone;
    }
    public static String getPhone() {
        return phone;
    }
    public void setSsn(String ssn) {
        this.ssn = ssn;
    }
    public static String getSsn() {
        return ssn;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    public static String getUsername() {
        return username;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    public static String getPassword() {
        return password;
    }
    public void setConfirmPW(String confirmPW) {
        this.confirmPW = confirmPW;
    }
    public static String getConfirmPW() {
        return confirmPW;
    }
    @Test
    public void test() throws IOException, ParseException, org.json.simple.parser.ParseException {
        credentialsAndURLS();
        System.out.println("baseURL: " + baseURL);
        System.out.println("registerURL: " + registerURL);
        System.out.println("users: " + users);
        System.out.println(id);
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
    }
}

/*


    public static void credentialsAndURLS() throws IOException, ParseException, org.json.simple.parser.ParseException {
        FileReader reader = new FileReader("/home/tunay/java_parabank_demo/src/main/java/com/java_parabank_demo/config/config.json");
        JSONParser jsonparser = new JSONParser();
        Object object = jsonparser.parse(reader);
        JSONObject configJsonObj = (JSONObject) object;



        baseURL = (String) configJsonObj.get("baseURL");
        registerURL = (String) configJsonObj.get("registerURL");
        Object user1 = configJsonObj.get("users");

        users = user1.toString(); //configJsonObj.get("users"); //TODO object type array
        firstName = (String) configJsonObj.get("name");
        lastName = (String) configJsonObj.get("lastName");
        address = (String) configJsonObj.get("address");
        state = (String) configJsonObj.get("state");
        zipCode = (String) configJsonObj.get("zipcode");
        phone = (String) configJsonObj.get("phone");
        ssn = (String) configJsonObj.get("ssn");
        username = (String) configJsonObj.get("username");
        password = (String) configJsonObj.get("password");
        confirmPW = (String) configJsonObj.get("confirmPW");
       // confirmPW = configJsonObj.get("confirmPW").toString();
    }

   */

