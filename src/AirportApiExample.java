import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AirportApiExample {
    public static void main(String[] args) {
        // API 엔드포인트와 요청 파라미터
        String endpoint = "http://openapi.airport.co.kr/service/rest/FlightStatusList/getFlightStatusList";
        String serviceKey = "xVjkj6OejHpsNyP2LyreYZ/lRcLySeNLy6UGXbjGw2MhON7pLpzkGUHS2OLC6fQxP4XK5jlAz/lzIog0l2TNZw==";  // 디코딩된 인증키
        String schDate = "20230709";  // 검색일자 (예시: 20230709)
        String schDeptCityCode = "GMP";  // 출발 도시 코드
        String schArrvCityCode = "PUS";  // 도착 도시 코드
        String schAirLine = "AB";  // 항공편 코드 (선택 사항)
        String schFlightNum = "1";  // 항공편 번호 (선택 사항)

        // URL 생성
        String urlStr = String.format("%s?schDate=%s&schDeptCityCode=%s&schArrvCityCode=%s&schAirLine=%s&schFlightNum=%s&serviceKey=%s",
                endpoint, schDate, schDeptCityCode, schArrvCityCode, schAirLine, schFlightNum, serviceKey);

        try {
            // URL 객체 생성
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");

            // 응답 코드 확인
            int responseCode = conn.getResponseCode();
            System.out.println("Response Code: " + responseCode);

            // 응답이 성공인 경우 응답 내용 읽기
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String inputLine;
                StringBuilder response = new StringBuilder();

                while ((inputLine = in.readLine()) != null) {
                    response.append(inputLine);
                }
                in.close();

                // 응답 출력
                System.out.println(response.toString());
            } else {
                System.out.println("GET request failed");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
