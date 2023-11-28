import java.io.File;
import java.util.Scanner;

public class Calc extends GUI {
    static void calco() {
        rows = 0;
        cols = 0;
        total= 0;
        try {
            File f = new File(address);
            sc = new Scanner(f);
            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] array = line.split(",");
                rows++;
                cols = array.length+1;
            }
            sc.close();
            total=cols*rows;
        } catch (Exception e){
            System.out.println("error");
        }
    }
}
