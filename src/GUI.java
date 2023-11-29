import com.eclipsesource.json.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.spi.FileTypeDetector;
import java.util.*;

public class GUI{
    private String filename;
    private String extension;
    public static int cols, rows, total;
    public static Scanner sc;
    public static JFileChooser filel;
    public static JButton button1,button2;
    private Json jparser;


    private ArrayList<String> dataArray = new ArrayList<>();

    public static String address;

    GUI() {
        JFrame frame = new JFrame("tabel");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel());
        //frame.add(json());
        frame.setVisible(true);
    }


    private JPanel panel() {
        filel= new JFileChooser();
        filel.showOpenDialog(null);
        try {
            address=filel.getSelectedFile().getPath();
        }catch (Exception e){}
        Calc.calco();
        JPanel panel1 = new JPanel(new GridLayout(rows, cols));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        for (int i = 0; i < total; i++) {
            JTextField text = new JTextField(total);
            text.setEditable(false);
            Set<People> people = new TreeSet<>();
            try {
                File f = new File(address);
                sc = new Scanner(f);
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    String[] array = line.split(",", cols);
                    people.add(new People(array[0]));
                    dataArray.addAll(Arrays.asList(array));

                }
                sc.close();
            } catch (Exception e) {
                System.out.println("ERROR" + e.toString());
            }
            text.setText(dataArray.get(i));
            panel1.add(text,BorderLayout.CENTER);
        }
        return panel1;
    }

    /*private JPanel json() {
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
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }*/
}
