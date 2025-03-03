package network01;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.ArrayList;

public class MockApi {
    private static String API_URL = "https://67c0a40fb9d02a9f224a81fb.mockapi.io";

    public static void main( String[] arg) {
        try {
            java.net.URL url = new java.net.URL(API_URL +"/users");
            java.net.HttpURLConnection con = (java.net.HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");

            con.setConnectTimeout(1000);
            con.setReadTimeout(20000);

            int status = con.getResponseCode();

            if (status != 200) {
                System.err.println("Status: " + status);
                throw new Exception("Status: " + status);
            }
            // 40x
            // 50x

            java.io.BufferedReader in = new java.io.BufferedReader(new java.io.InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuffer boby = new StringBuffer();
            while ((inputLine = in.readLine()) != null) {
                boby.append(inputLine);
            }
            in.close();
            con.disconnect();

            System.out.println("Response Code: " + status);
            System.out.println("Response Body: " + boby.toString());

            ObjectMapper objectMapper = new ObjectMapper();
            ArrayList<UserMockApiModel> users = objectMapper.readValue(boby.toString(),
                    new TypeReference<ArrayList<UserMockApiModel>>() {});

            for (UserMockApiModel user: users) {
                System.out.println(user);
            }

            // System.out.println("Response Body: " + users);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
