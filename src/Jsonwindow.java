import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Scanner;

public class Jsonwindow extends GUI{
    Jsonwindow(){
        JFrame frame = new JFrame("tabel");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(json());
        frame.setVisible(true);
    }
        private JPanel json() {
        Calc.calcoj();
        JPanel panel2 = new JPanel(new GridLayout());
        panel2.setBorder(BorderFactory.createLineBorder(Color.black, 10));

        try {
            File f = new File(address);
            sc = new Scanner(f);
            String page = "";
            while (sc.hasNext()) {
                String line = sc.nextLine();
                //System.out.println(line);
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
            return panel2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
