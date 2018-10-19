import java.io.*;
import java.util.ArrayList;


public class Reader {

    public static void main(String[] args) {
        ArrayList text = new ArrayList();
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
        int symbolsWithOutSpase = countSymbolsWithOutSpase(myText);
        int symbolsWithSpase = countSymbolsWithSpase(myText);
        int word = counterWords(myText);
        System.out.printf("Количество символов c пробелами %d , количество символов без пробов %d , количество слов %d   ",symbolsWithSpase, symbolsWithOutSpase,  word);
    }

    private static int countSymbolsWithOutSpase(String[] myText) {
        int counter = 0;
        for (String string : myText) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != ' ') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int countSymbolsWithSpase(String[] myText) {
        int counter = 0;
        for (String string : myText) {
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != '|') {
                    counter++;
                }
            }
        }
        return counter;
    }

    private static int counterWords(String[] myText) {
        int count = 0;
        for (String string : myText) {
            for (String retval : string.split(" ")) {
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
