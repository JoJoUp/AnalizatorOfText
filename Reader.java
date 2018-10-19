import java.io.*;
import java.util.ArrayList;


public class Reader {

    public static void main(String[] args) {
        int counter = 0;
        ArrayList text = new ArrayList();
        int symbolsWithOutSpase = 0;
        int symbolsWithSpase = 0;
        int word = 0;
        String[] array = new String[10];
        try {
            FileInputStream fstream = new FileInputStream("E:\\_CommonRedist\\12.txt");
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String strLine;
            while ((strLine = br.readLine()) != null) {
                text.add(strLine);


            }
        } catch (IOException e) {
            System.out.println("Ошибка ");
        }
        String[] myText = transfer(text);
        symbolsWithOutSpase = countSymbolsWithOutSpase(myText);
        symbolsWithSpase = countSymbolsWithSpase(myText);
        word = counterWords(myText);
        System.out.printf(" %d , %d , %d   ",symbolsWithSpase, symbolsWithOutSpase,  word);
    }

    private static int countSymbolsWithOutSpase(String[] myText) {
        int counter = 0;
        for (String f : myText) {
            for (int i = 0; i < f.length(); i++) {
                if (f.charAt(i) != ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int countSymbolsWithSpase(String[] myText) {
        int counter = 0;
        for (String f : myText) {
            for (int i = 0; i < f.length(); i++) {
                if (f.charAt(i) != '|') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int counterWords(String[] myText) {
        int count = 0;
        for (String f : myText) {
            for (String retval : f.split(" ")) {
                count++;
            }
        }
        return count;
    }
    private static String[] transfer(ArrayList text){
        String[] myText = {};
        int y = text.size();
        myText = (String[]) text.toArray(new String[y]);
        return myText;
    }
}
