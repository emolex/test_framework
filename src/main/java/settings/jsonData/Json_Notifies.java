package settings.jsonData;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class Json_Notifies {

    public static String register_success_notify;
    public static String resetpassword_wron_code;

    public static void parseJson() {
        JSONParser parser = new JSONParser();
        try {
            Object object = parser.parse(new FileReader(System.getProperty("user.dir")+"/src/resources/Json_Notifies.json"));
            JSONObject jsonObject = (JSONObject) object;
            register_success_notify = (String) jsonObject.get("register_success_notify");
            resetpassword_wron_code = (String) jsonObject.get("resetpassword_wron_code");


        } catch (ParseException | IOException e) {
            e.printStackTrace();
        }
    }
}
