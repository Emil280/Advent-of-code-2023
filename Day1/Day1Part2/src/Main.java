import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args){
        BufferedReader myReader;
        int sum = 0;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day1\\Day1Part2\\src\\Input.txt").toString()));
            String line;
            char character;
            String val;
            List<Character> Digits = new ArrayList<>();
            while((line = myReader.readLine()) != null){
                line = line.toLowerCase();
                int numChars = line.length();
                for (int i=0; i<numChars; i++){
                    if (Character.isDigit(character = line.charAt(i))) {
                        Digits.add(character);
                    } else {
                        switch (character){
                            case 'o':
                                if (line.startsWith("one", i)){
                                    Digits.add('1');
                                    i += 1;
                                }
                                break;
                            case 't':
                                if (line.startsWith("two", i)){
                                    Digits.add('2');
                                    i += 1;
                                } else if (line.startsWith("three", i)){
                                    Digits.add('3');
                                    i += 3;
                                }
                                break;
                            case 'f':
                                if (line.startsWith("four", i)){
                                    Digits.add('4');
                                } else if (line.startsWith("five", i)){
                                    Digits.add('5');
                                } else {
                                    i -= 2;
                                }
                                i += 2;
                                break;
                            case 's':
                                if (line.startsWith("six", i)){
                                    Digits.add('6');
                                    i += 1;
                                } else if (line.startsWith("seven", i)){
                                    Digits.add('7');
                                    i += 3;
                                }
                                break;
                            case 'e':
                                if (line.startsWith("eight", i)){
                                    Digits.add('8');
                                    i += 3;
                                }
                                break;
                            case 'n':
                                if (line.startsWith("nine", i)){
                                    Digits.add('9');
                                    i += 2;
                                }
                                break;
                            default:
                                break;
                        }
                    }
                }

                if (!Digits.isEmpty()) {
                    val = String.valueOf(Digits.get(0) + String.valueOf(Digits.get(Digits.size() - 1)));
                    sum += Integer.parseInt(val);
                    Digits.clear();
                }
            }

            System.out.println("Total: " + sum);

        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}