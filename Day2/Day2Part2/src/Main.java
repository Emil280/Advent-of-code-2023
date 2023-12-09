import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        int minRed;
        int minGreen;
        int minBlue;
        int total = 0;

        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day2\\Day2Part2\\src\\Input.txt").toString()));
            String line;
            String[] lineInfo;
            String[] gameData;
            String[] cubesDrawn;
            String[] cubeData;
            while((line = myReader.readLine()) != null) {
                lineInfo = line.split(":");
                gameData = lineInfo[1].split(";");

                minRed = 0;
                minGreen = 0;
                minBlue = 0;
                for (String draw: gameData){
                    cubesDrawn = draw.split(",");
                    for (String cube: cubesDrawn){
                        cube = cube.trim();
                        cubeData = cube.split(" ");

                        switch (cubeData[1]){
                            case "red":
                                if (Integer.parseInt(cubeData[0]) > minRed){
                                    minRed = Integer.parseInt(cubeData[0]);
                                }
                                break;

                            case "green":
                                if (Integer.parseInt(cubeData[0]) > minGreen){
                                    minGreen = Integer.parseInt(cubeData[0]);
                                }
                                break;

                            case "blue":
                                if (Integer.parseInt(cubeData[0]) > minBlue){
                                    minBlue = Integer.parseInt(cubeData[0]);
                                }
                                break;
                        }
                    }
                }
                total += (minRed * minGreen * minBlue);
            }

            System.out.println("Total:" + total);
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}
