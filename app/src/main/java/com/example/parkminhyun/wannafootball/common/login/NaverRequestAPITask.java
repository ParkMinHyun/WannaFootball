package com.example.parkminhyun.wannafootball.common.login;

import android.os.AsyncTask;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by ParkMinHyun on 2018-02-25.
 */

public class NaverRequestAPITask extends AsyncTask<Void,Void,StringBuffer> {

    private String token;

    public NaverRequestAPITask(String token) {
        this.token = token;
    }

    @Override
    protected void onPostExecute(StringBuffer result) {
        super.onPostExecute(result);
        // 로그인 처리가 완료되면 수행할 로직 작성
        processAuthResult(result);
    }

    @Override
    protected StringBuffer doInBackground(Void... params) {
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
            return response;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    private void processAuthResult(StringBuffer response) {
        try {
            // response는 json encoded된 상태이기 때문에 json 형식으로 decode 해줘야 한다.
            JSONObject object = new JSONObject(response.toString());
            JSONObject innerJson = new JSONObject(object.get("response").toString());

            // 만약 이메일이 필요한데 사용자가 이메일 제공을 거부하면
            // JSON 데이터에는 email이라는 키가 없고, 이걸로 제공 여부를 판단한다.\
            String nickname = innerJson.getString("nickname");
            String profileImgUrl = innerJson.getString("profile_image");
            // 원하는 모든 과정이 처리가 되면 해당 멤버 데이터를 가지고 다음 로직을 수행한다.
            // checkMember(account, nickname, profileImgUrl.replaceAll("\\\\", ""));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}