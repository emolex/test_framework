package Settings.JsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Json_Properties {

    public static boolean isRemote;

    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/main/resources/Jsons/Properties.json"));
            JSONObject jsonObject = (JSONObject) object;
            isRemote = (boolean) jsonObject.get("isRemote");


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }

}
