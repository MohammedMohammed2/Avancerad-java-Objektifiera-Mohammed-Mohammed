import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class CSVwindow extends GUI {
    CSVwindow(){
        JFrame frame = new JFrame("tabel");
        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(panel());
        frame.setVisible(true);

    }
    public static JPanel panel() {
        filel= new JFileChooser();
        filel.showOpenDialog(null);
        try {
            address=filel.getSelectedFile().getPath();
        }catch (Exception x){}
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
}
