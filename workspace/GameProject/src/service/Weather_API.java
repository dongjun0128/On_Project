package service;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Weather_API {
    public void start(FileWrite f) {
        try{
            //서울시청의 위도와 경도
            String lon = "126.977948";  //경도
            String lat = "37.566386";   //위도
            String weather;
            String food = null;

            //OpenAPI call하는 URL
            String urlstr = "http://api.openweathermap.org/data/2.5/weather?"
                    + "lat="+lat+"&lon="+lon
                    +"&appid=8d619a34d45cb178e39b3c3f631c447e";
            URL url = new URL(urlstr);
            BufferedReader bf;
            String line;
            String result="";

            //날씨 정보를 받아온다.
            bf = new BufferedReader(new InputStreamReader(url.openStream()));

            //버퍼에 있는 정보를 문자열로 변환.
            while((line=bf.readLine())!=null){
                result=result.concat(line);
                //System.out.println(line);
            }

            //문자열을 JSON으로 파싱
            JSONParser jsonParser = new JSONParser();
            JSONObject jsonObj = (JSONObject) jsonParser.parse(result);

            //지역 출력
            System.out.println("지역 : " + jsonObj.get("name"));

            //날씨 출력
            JSONArray weatherArray = (JSONArray) jsonObj.get("weather");
            JSONObject obj = (JSONObject) weatherArray.get(0);
            weather=(String) obj.get("main");
            System.out.println("날씨 : "+weather);

            //온도 출력(절대온도라서 변환 필요)
            JSONObject mainArray = (JSONObject) jsonObj.get("main");
            double ktemp = Double.parseDouble(mainArray.get("temp").toString());
            double temp = ktemp-273.15;
            System.out.printf("온도 : %.2f\n",temp);

            bf.close();
            
            if(weather.equals("Clear")) {
               if(temp<18) {
                  food="김밥, 유부초밥";
               }
               else if(temp<25) {
                  food="돈까스";
               }
               else {
                  food="삼계탕";
               }
            }
            
            else if(weather.equals("Clouds")) {
               if(temp<18) {
                  food="곱창전골";
               }
               else if(temp<25) {
                  food="백반(김치찌개, 된장찌개)";
               }
               else {
                  food="화채, 빙수";
               }
            }
            
            else {
               if(temp<18) {
                  food="어묵탕, 소주";
               }
               else if(temp<25) {
                  food="파전, 막걸리";
               }
               else {
                  food="치킨, 맥주";
               }
            }
			f.write("지역 : " + jsonObj.get("name")+"\n"+
            "날씨 : "+weather+"\n"+
			"온도 : " + temp + "\n"+
            "당신은 지금 "+food+"이(가) 땡긴다!\n");
            System.out.println("당신은 지금 "+food+"이(가) 땡긴다!");
            
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}