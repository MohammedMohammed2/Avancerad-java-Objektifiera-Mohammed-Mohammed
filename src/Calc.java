import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;
import java.util.Scanner;

public class Calc extends GUI {
    static void calco() {
        rows = 0;
        cols = 0;
        total= 0;
        try {
            File f = new File(address);
            sc = new Scanner(f);
            boolean isHeader = false;
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                if(!isHeader) {
                    cols = array.length;
                    isHeader = true;
                }
                rows++;
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
                page += line;
            }
            JsonValue jv = Json.parse(page);
            JsonArray jd = jv.asArray();
            JsonObject jo = jd.get(0).asObject();
            List<String> col = jo.names();
            cols=col.size();




    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
