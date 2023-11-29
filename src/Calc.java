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

    /*static void calcoj(){
        try {
            File f = new File(address);
            sc = new Scanner(f);
            String page = "";
            while (sc.hasNext()) {
                String line = sc.nextLine();
                System.out.println(line);
                page += line;
                System.out.println(line.length());
            }
            sc.close();

            JsonValue jv = Json.parse(page);
            JsonArray ja = jv.asArray();

            JsonObject jo = ja.get(0).asObject();
            System.out.println(jo.names().size());
            for (int i = 0; i < ja.size() - 1; i++) {
                JsonObject j = ja.get(i).asObject();
                System.out.println(j.get("A:"));
                System.out.println(j.get("B:"));
                System.out.println(j.get("C:"));
            }

    } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/
}
