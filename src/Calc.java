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
}
