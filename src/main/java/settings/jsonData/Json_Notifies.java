package settings.jsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Json_Notifies {

    public static String register_success_notify;

    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/resources/Json_Notifies.json"));
            JSONObject jsonObject = (JSONObject) object;
            register_success_notify = (String) jsonObject.get("register_success_notify");


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
