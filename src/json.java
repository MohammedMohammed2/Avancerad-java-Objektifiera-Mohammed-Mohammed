import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
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
        filel = new JFileChooser();
        filel.setCurrentDirectory(new File("C:\\Users\\sahar\\OneDrive\\Skrivbord\\skisser"));
        filel.showOpenDialog(null);
        try {

            /*gets the paths of said file*/
            address = filel.getSelectedFile().getPath();

        } catch (Exception x) {
        }
        JPanel panel = new JPanel(new BorderLayout());
        JTable jsontable = new JTable();
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
        JsonArray ja = jv.asArray();
        JsonObject jo = ja.get(0).asObject();
        colnames.addAll(jo.names());
        for (int i = 0; i < ja.size(); i++) {
            JsonObject record = ja.get(i).asObject();
            for (int j = 0; j < colnames.size(); j++) {

                rowsfill.add(String.valueOf(record.get(colnames.get(j))));

            }

            dataList.add(new Vector<>(rowsfill));
            rowsfill.clear();

        }
        System.out.println(dataList);

        DefaultTableModel model = new DefaultTableModel(dataList, colnames);
        TableRowSorter sort = new TableRowSorter<>(model);
        jsontable.setRowSorter(sort);
        jsontable.setEnabled(false);
        jsontable.setModel(model);
        panel.add(jsontable);
        return panel;
    }
}
