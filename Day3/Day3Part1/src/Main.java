import java.io.*;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<String> Input = new ArrayList<>();
        BufferedReader myReader;
        try {
            String line;
            myReader = new BufferedReader(new FileReader(Path.of("Day3\\Day3Part1\\src\\Input.txt").toString()));
            while((line = myReader.readLine()) != null) {
                Input.add(line);
            }
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
        if (!Input.isEmpty()){
            int numRows = Input.size();
            // this assumes that every line has an equal number of characters.
            int numColumns = Input.get(0).length();
            String[] schematic = new String[numRows];
            Input.toArray(schematic);

            int total = 0;
            char character;

            boolean[][] uncheckedArray = new boolean[3][3];
            for (int i=0; i<3; i++){
                for (int j=0; j<3; j++){
                    uncheckedArray[i][j] = false;
                }
            }
            uncheckedArray[1][1] = true;

            boolean[][] checkedArray;

            for (int currentRow = 0; currentRow<numRows; currentRow++){
                for (int currentColumn = 0; currentColumn<numColumns; currentColumn++){
                    if (!Character.isLetterOrDigit((character = schematic[currentRow].charAt(currentColumn))) && character != '.'){
                        checkedArray = uncheckedArray;
                        if (currentRow == 0){
                            for (boolean val: checkedArray[0]){
                                val = true;
                            }
                        } else if (currentRow == numRows-1){
                            for (boolean val: checkedArray[2]){
                                val = true;
                            }
                        }
                        if (currentColumn == 0){
                            for (int i=0; i<checkedArray.length; i++){
                                checkedArray[i][0] = true;
                            }
                        } else if (currentColumn == numColumns-1){
                            for (int i=0; i<checkedArray.length; i++){
                                checkedArray[i][checkedArray[i].length-1] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
