import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class GUI {
    public static int cols,rows,total;
    public static Scanner sc;

    private ArrayList<String> dataArray = new ArrayList<>();

    GUI() {
        JFrame frame = new JFrame("tabel");
        frame.setSize(1000, 1000);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel());
        frame.setVisible(true);
    }

    private JPanel panel() {
        Calc.calco();
        JPanel panel1 = new JPanel(new GridLayout(rows,cols));
        panel1.setBorder(BorderFactory.createLineBorder(Color.black, 10));
        System.out.println(total);
        String page = "";
        for (int i = 0; i <total; i++) {
            JTextField text = new JTextField(total);
            text.setEditable(false);
            try {
                File f = new File("src/sample.csv");
                sc = new Scanner(f);
                while (sc.hasNext()) {
                    String line = sc.nextLine();
                    String[] array = line.split(",",cols);
                    dataArray.addAll(Arrays.asList(array));
                }
                sc.close();
            } catch (Exception e) {
                System.out.println("ERROR" + e.toString());
            }
            text.setText(dataArray.get(i));
            panel1.add(text);
        }
        System.out.println(page);
        return panel1;
    }
}
