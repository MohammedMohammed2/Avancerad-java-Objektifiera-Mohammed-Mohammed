import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calc extends GUI {
    static void calco() {
        rows = 0;
        cols = 0;
        total= 0;
        try {
            File f = new File(address);
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                rows++;
                cols = array.length;
            }
            sc.close();
            total=cols*rows;
        } catch (Exception e){
            System.out.println("error");
        }
    }

    static void calcoj(){
        try {
            File f = new File(address);
            sc = new Scanner(f);
            String page = "";
            while (sc.hasNext()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                page += line;
            }
            sc.close();
            JsonValue jv = Json.parse(page);
            JsonArray jd = jv.asArray();
            JsonObject jo = jd.get(0).asObject();
            System.out.println(jo.names().size());

            for (int i = 0; i < jd.size() - 1; i++) {
                JsonObject j = jd.get(i).asObject();
                rows++;
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
