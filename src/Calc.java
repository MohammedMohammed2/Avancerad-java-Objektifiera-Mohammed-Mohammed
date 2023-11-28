import java.io.File;
import java.util.Scanner;

public class Calc extends GUI {
    static void calco() {
        rows = 0;
        cols = 0;
        total= 0;
        try {
            File f = new File("src/sample.csv");
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                rows++;
                cols = array.length;
            }
            sc.close();
            cols++;
            total=cols*rows;
        } catch (Exception e){
            System.out.println("error");
        }
    }
      /*try {
                File x = new File("src/sample.json");
                Scanner scan = new Scanner(x);
                String page = "";
                while (scan.hasNextLine()) {
                    String line = scan.nextLine();
                    String[] array = page.split("}");
                    page += line;
                    rows++;
                    cols = array.length;
                }*/
}
