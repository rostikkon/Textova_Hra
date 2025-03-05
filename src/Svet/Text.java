package Svet;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Text {



    public static String precist(){
        try(BufferedReader br = new BufferedReader(new FileReader("text.txt"))) {
            String line;
            while((line = br.readLine())!=null){
                return line;
            }
        } catch (IOException e) {
            return "jejda neco se pokazilo";
        }
        return null;
    }

}
