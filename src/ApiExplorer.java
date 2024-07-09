import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;
import java.io.BufferedReader;
import java.io.IOException;

public class ApiExplorer {
    public static void main(String[] args) throws IOException {
        String serviceKey = "xVjkj6OejHpsNyP2LyreYZ/lRcLySeNLy6UGXbjGw2MhON7pLpzkGUHS2OLC6fQxP4XK5jlAz/lzIog0l2TNZw=="; // 디코딩된 인증키

        // URL 인코딩된 인증키
        String encodedServiceKey = URLEncoder.encode(serviceKey, "UTF-8");

        StringBuilder urlBuilder = new StringBuilder("http://openapi.airport.co.kr/service/rest/FlightStatusList/getFlightStatusList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + encodedServiceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("schDate","UTF-8") + "=" + URLEncoder.encode("20240719", "UTF-8")); /* 검색일자 */
        urlBuilder.append("&" + URLEncoder.encode("schDeptCityCode","UTF-8") + "=" + URLEncoder.encode("GMP", "UTF-8")); /* 출발 도시 코드 */
        urlBuilder.append("&" + URLEncoder.encode("schArrvCityCode","UTF-8") + "=" + URLEncoder.encode("PUS", "UTF-8")); /* 도착 도시 코드 */

        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());
    }
}
