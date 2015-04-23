/**
 * Created by developer on 4/14/2015.
 */

import java.io.*;

public class DriverForIO{
    public static void main(String [] args) {
        try {
            String holder = "";
            String string2 = "\nadditional Data to write";
            String string3 = "\nnow to close the file";
            byte[] bytes;
            byte[] bytes2;
            byte[] bytes3;
            String path = "C:\\testFolder\\test\\test.txt";
            String path1 = "C:\\testFolder\\test.txt";
            String path2 = "C:\\testFolder\\test\\appendFile.txt";
            InputStream input = new FileInputStream(path);
            OutputStream f = new BufferedOutputStream(new FileOutputStream(path1));

            BufferedWriter bw = new BufferedWriter(new FileWriter(path2, true));

            int end = input.read();
            char aChar;

            while(end != -1){
                aChar = (char) end;
                holder = holder + aChar;
                end = input.read();
            }

            bytes3 = string3.getBytes();
            bytes2 = string2.getBytes();
            bytes = holder.getBytes();

            f.write(bytes);
            f.write(bytes2);
            f.write(bytes3);
            bw.write("String one for the first append line");
            bw.newLine();
            bw.write("String two for the append line.");
            bw.newLine();
            bw.write("Closing the file");
            bw.newLine();
            bw.close();
            f.close();
            input.close();

        } catch (FileNotFoundException e) {
            System.out.print("FileNotFoundException Thrown");
        } catch (IOException e) {
            System.out.println("IOException Thrown");
        }
    }
}
