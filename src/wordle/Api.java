package wordle;

import java.net.HttpURLConnection;

import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Map.Entry;

import org.json.simple.*;
import org.json.simple.parser.JSONParser;

public class Api {
  
  String word;

  public Api(String word) {
    this.word = word;
  }



public static void getApi(String word) throws Exception {
  try {
      URL url = new URL("https://api.dictionaryapi.dev/api/v2/entries/en/"+word);

      HttpURLConnection conn = (HttpURLConnection) url.openConnection();
      conn.setRequestMethod("GET");
      conn.connect();

      int responseCode = conn.getResponseCode();

      if(responseCode != 200){
        throw new RuntimeException("HttpResponseCode: " + responseCode);
      } else {
        StringBuilder informationString = new StringBuilder();
        Scanner scanner = new Scanner(url.openStream());

        while (scanner.hasNext()) {
          informationString.append(scanner.nextLine());
        }
        scanner.close();
        JSONParser parse = new JSONParser();
        JSONArray dataObject = (JSONArray) parse.parse(String.valueOf(informationString));

        JSONObject wordInfo = (JSONObject) dataObject.get(0);

        JSONArray meanings = (JSONArray) wordInfo.get("meanings");

        JSONObject definitions = (JSONObject) meanings.get(0);

        JSONArray definition = (JSONArray) definitions.get("definitions");

        Iterator itr = definition.iterator();
        
        while (itr.hasNext())
        {
          itr = ((Map) itr.next()).entrySet().iterator();
          while(itr.hasNext()){
            Map.Entry pair = (Entry) itr.next();
            System.out.println(pair.getKey() + " : " + pair.getValue());
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
}




}
