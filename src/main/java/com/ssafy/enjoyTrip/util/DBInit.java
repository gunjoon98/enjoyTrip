package com.ssafy.enjoyTrip.util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class DBInit {

    public void InitDB() {
        String url = "https://apis.data.go.kr/B551011/KorService1/searchStay1?" +
                "MobileOS=ETC&MobileApp=da&_type=json&areaCode=1&serviceKey=JAlgt9596NgHBUTJdMKh4iCCJiMtD2Cy6WjTtvBUM3x%2F70PZGRjKgrmvnK9zucqprvCZGWfRUHCkwgHrR0Snrg%3D%3D";
        try {
            URL obj = new URL(url);
            HttpURLConnection con = (HttpURLConnection) obj.openConnection();
            con.setRequestMethod("GET");
            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            String inputLine;
            StringBuilder response = new StringBuilder();

            while ((inputLine = in.readLine()) != null) {
                response.append(inputLine);
            }
            in.close();
            System.out.println(response);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
