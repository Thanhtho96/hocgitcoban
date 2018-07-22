package action;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author ngockhuong
 */
public class FileAction {

    public boolean writeFile(String filePath, String text) {
        boolean check = true;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException ex) {
            }
        }
        FileWriter fw;
        BufferedWriter bw;
        try {
            fw = new FileWriter(file);
            bw = new BufferedWriter(fw);
            bw.write(text);
            bw.flush();

            bw.close();
            fw.close();
        } catch (IOException ex) {
            check = false;
        }
        return check;
    }

    public String readFile(File file) {
        StringBuilder result = new StringBuilder("");
        FileReader fr;
        BufferedReader br;
        try {
            fr = new FileReader(file);
            br = new BufferedReader(fr);
            String line;
            while ((line = br.readLine()) != null) {
                result.append(line).append("\n");
            }
            if (result.length() > 0) {
                result.delete(result.length() - 1, result.length());
            }
            br.close();
            fr.close();
        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
        return result.toString();
    }
}
