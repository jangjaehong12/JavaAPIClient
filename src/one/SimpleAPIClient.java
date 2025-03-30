package one;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class SimpleAPIClient {
    public static void main(String[] args) throws Exception {
        String apiUrl = "https://jsonplaceholder.typicode.com/todos/4";
        //끝에 각각 1,2,3,4,5를 넣으면 주소에서 데이터값을 불러오기에 다른 결과값을 볼 수 있음
        
        URL url = new URL(apiUrl);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");

        BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String inputLine;
        StringBuffer content = new StringBuffer();

        while ((inputLine = in.readLine()) != null) {
            content.append(inputLine);
        }

        in.close();
        conn.disconnect();

        System.out.println("\n=== API 응답 결과 ==");
        System.out.println(content.toString());
    }
}
