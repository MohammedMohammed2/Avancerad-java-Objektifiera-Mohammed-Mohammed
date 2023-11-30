import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.List;
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
        filel.setCurrentDirectory(new File("C:\\Users\\sahar\\OneDrive\\Skrivbord\\skisser"));
        filel.showOpenDialog(null);
        try {
            address = filel.getSelectedFile().getPath();
        } catch (Exception x) {
        }
        System.out.println(address);

        /*uses the calculation in calcoj to display the json file properly*/
        Calc.calcoj();


        JPanel panel2 = new JPanel(new GridLayout(rows, cols));
        panel2.setBorder(BorderFactory.createLineBorder(Color.black, 10));

        try {
            File f = new File(address);
            sc = new Scanner(f);
            String page = "";
            while (sc.hasNext()) {
               String line = sc.nextLine();
                //System.out.println(line);
                page += line;
            }
            sc.close();
            String[] array = page.split("\\{|}|\\[",cols);
            JsonValue jv = Json.parse(page);
            JsonArray jd = jv.asArray();

            JsonObject jo = jd.get(0).asObject();
            List<String> col = jo.names();

            /*for (String s:
            col) {
                //System.out.println("headers:  "+s);
                //System.out.println(jo.get(s));

            }*/

            for (int i = 0; i < rows; i++) {
                JTextField text = new JTextField(i);
                text.setEditable(false);

                for (String s:col) {

                    //text.setText(array[i]);
                    //System.out.println("headers:  "+s);
                   // System.out.println(s);
                   // System.out.println(jo.get(s));

                   // System.out.println(jd.get(i).asObject().get(s).asString());
                    text.setText(jd.get(i).asObject().get(s).asString());

                            panel2.add(text);

                    //dataArray.add(String.valueOf(jd.get(i).asObject().get(s)));
                }


                //text.setText(jd.get(i).asObject().get(col));
               // text.setText(jd.get(i).asObject().get("A").asString());


            }
            return panel2;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
