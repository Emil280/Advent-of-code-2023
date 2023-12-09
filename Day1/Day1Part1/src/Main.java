import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BufferedReader myReader;
        int sum = 0;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day1\\Day1Part1\\src\\Input.txt").toString()));
            String line;
            char character;
            String val;
            List<Character> Digits = new ArrayList<>();
            while((line = myReader.readLine()) != null){
                int numChars = line.length();
                for (int i=0; i<numChars; i++){
                    if (Character.isDigit(character = line.charAt(i))) {
                        Digits.add(character);
                    }
                }

                val = String.valueOf(Digits.get(0) + String.valueOf(Digits.get(Digits.size()-1)));
                sum += Integer.parseInt(val);
                Digits.clear();
            }

            System.out.println("Total: " + sum);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}