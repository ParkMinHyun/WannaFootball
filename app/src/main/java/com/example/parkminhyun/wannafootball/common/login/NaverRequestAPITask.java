package com.example.parkminhyun.wannafootball.common.login;

import android.os.AsyncTask;

import com.example.parkminhyun.wannafootball.data.UserVO;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ParkMinHyun on 2018-02-25.
 */

public class NaverRequestAPITask extends AsyncTask<Void, Void, UserVO> {

    private String token;

    public NaverRequestAPITask(String token) {
        this.token = token;
    }

    @Override
    protected UserVO doInBackground(Void... params) {
        String header = "Bearer " + token;
        try {
            final String apiURL = "https://openapi.naver.com/v1/nid/me";
            URL url = new URL(apiURL);
            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("GET");
            con.setRequestProperty("Authorization", header);
            int responseCode = con.getResponseCode();

            BufferedReader br = new BufferedReader(new InputStreamReader(
                    responseCode == 200 ? con.getInputStream() : con.getErrorStream()));

            String inputLine;
            StringBuffer response = new StringBuffer();
            while ((inputLine = br.readLine()) != null) {
                response.append(inputLine);
            }

            br.close();

            return processAuthResult(response);

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private UserVO processAuthResult(StringBuffer response) {
        try {
            JSONObject object = new JSONObject(response.toString());
            JSONObject innerJson = new JSONObject(object.get("response").toString());

            UserVO myInfoVO = new UserVO(
                    innerJson.getString("id"),
                    innerJson.getString("name"),
                    innerJson.getString("age"),
                    innerJson.getString("profile_image"));

            return myInfoVO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}