import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;

public class Jsonwindow extends GUI {
    Jsonwindow() {
        JFrame frame = new JFrame("tabel");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(json());
        frame.setVisible(true);
    }

    private JPanel json() {
        filel = new JFileChooser();
        filel.showOpenDialog(null);
        try {
            address = filel.getSelectedFile().getPath();
        } catch (Exception x) {
        }

        /*uses the calculation in calcoj to display the json file properly*/
        Calc.calcoj();


        JPanel panel2 = new JPanel(new GridLayout(rows, 0));
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
            String[] array  = page.split("}");
            JsonValue jv = Json.parse(page);
            JsonArray jd = jv.asArray();

            JsonObject jo = jd.get(0).asObject();
            System.out.println(jo.names().size());
            for (int i = 0; i < jd.size() - 1; i++) {
                JTextField text = new JTextField(i);
                text.setEditable(false);
                JsonObject j = jd.get(i).asObject();
                text.setText(array[i]);
                panel2.add(text);
            }
            return panel2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
