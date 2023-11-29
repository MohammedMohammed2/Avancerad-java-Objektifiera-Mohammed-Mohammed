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

public class GUI {
    public static int cols, rows, total;
    public static Scanner sc;
    public static JFileChooser filel;
    public static JButton button1, button2;
    public Json jparser;

    public static ArrayList<String> dataArray = new ArrayList<>();

    public static String address;

    GUI() {
        /*creates a frame for my buttons*/
        JFrame frame = new JFrame("tabel");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.add(buttons());
        frame.setVisible(true);
    }

    /*panel for buttons*/
    private JPanel buttons() {
        JPanel panel3 = new JPanel(new FlowLayout());
        JLabel label = new JLabel("what type of file do you want to read?");
        /*CSV files button*/
        button1 = new JButton("CSV");

        /*Json files button*/
        button2 = new JButton("json");

        button1.addActionListener(new ButtonListener());
        button2.addActionListener(new ButtonListener());
        panel3.add(label);
        panel3.add(button1);
        panel3.add(button2);
        return panel3;
    }
/*my action lisenter*/
    class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            JButton buttonClicked = (JButton) e.getSource();
            /*opens a new frame for the csv files*/
            if (buttonClicked.equals(button1)) {
                CSVwindow myCSV = new CSVwindow();
            }
            /*opens a new frame for json files*/
            if (buttonClicked.equals(button2)) {
                Jsonwindow myJson = new Jsonwindow();
            }
        }
    }
}
