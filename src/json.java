import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public class json extends GUI {
    private Vector<Vector<String>> dataList = new Vector<>();
    public static Vector<String> rowsfill = new Vector<>();
    public static Vector<String> colnames = new Vector<>();

    private String page = "";

    json() {
        JFrame frame = new JFrame("tabel");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(jsonpan());
        frame.setVisible(true);
    }

    private JPanel jsonpan() {
        /*user gets to chose a file*/
        filel = new JFileChooser();

        filel.setCurrentDirectory(new File("C:\\Users\\sahar\\OneDrive\\Skrivbord\\skisser"));
        filel.showOpenDialog(null);
        try {

            /*gets the paths of said file*/
            address = filel.getSelectedFile().getPath();

        } catch (Exception x) {
        }
        JPanel panel = new JPanel(new BorderLayout());
        try {
            File f = new File(address);
            sc = new Scanner(f);
            while (sc.hasNext()) {
                String line = sc.nextLine();
                page += line;
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        sc.close();
        JsonValue jv = Json.parse(page);

        /*makes an array for said json file*/
        JsonArray ja = jv.asArray();

        JsonObject jo = ja.get(0).asObject();

        /*adds data */
        colnames.addAll(jo.names());

        /*creates a jtaabel*/
        JTable jsontable = new JTable();

        for (int i = 0; i < ja.size(); i++) {
            JsonObject record = ja.get(i).asObject();

            /*uses the size of the colnames(colums) to loop */
            for (int j = 0; j < colnames.size(); j++) {

                /*adds the data in record*/
                rowsfill.add(String.valueOf(record.get(colnames.get(j))));

            }

            /*places data in a list*/
            dataList.add(new Vector<>(rowsfill));

            /*after a full line of colums is filled left to right this clears old data and move on the next line and does the same thing over and over again*/
            rowsfill.clear();
        }
        jsontable.setAutoCreateRowSorter(true);
        DefaultTableModel model = new DefaultTableModel(dataList, colnames);
        jsontable.setEnabled(false);
        jsontable.setModel(model);
        panel.add(jsontable);

        return panel;
    }
}
