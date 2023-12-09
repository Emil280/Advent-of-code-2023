import java.io.*;
import java.nio.file.*;

public class Main {
    public static void main(String[] args) {
        int maxRed = 12;
        int maxGreen = 13;
        int maxBlue = 14;

        BufferedReader myReader;
        try {
            myReader = new BufferedReader(new FileReader(Path.of("Day2\\Day2Part1\\src\\Input.txt").toString()));
            String line;
            String[] lineInfo = new String[2];
            String[] gameData;
            String[] cubesDrawn;
            String[] cubeData;
            boolean impossible;
            int total = 0;
            while((line = myReader.readLine()) != null) {
                lineInfo = line.split(":");
                gameData = lineInfo[1].split(";");
                impossible = false;
                for (String draw: gameData){
                    cubesDrawn = draw.split(",");
                    for (String cube: cubesDrawn){
                        cube = cube.trim();
                        cubeData = cube.split(" ");

                        switch (cubeData[1]){
                            case "red":
                                if (Integer.parseInt(cubeData[0]) > maxRed){
                                    impossible = true;
                                }
                                break;

                            case "green":
                                if (Integer.parseInt(cubeData[0]) > maxGreen){
                                    impossible = true;
                                }
                                break;

                            case "blue":
                                if (Integer.parseInt(cubeData[0]) > maxBlue){
                                    impossible = true;
                                }
                                break;
                        }
                    }
                    if (impossible){
                        break;
                    }
                }
                if (!impossible){
                    total += Integer.parseInt(lineInfo[0].substring(4).trim());
                }
            }
            System.out.println("Total:" + total);
        } catch (IOException e){
            System.out.println("There was an IO exception, the input file likely doesn't exist.");
            System.out.println(e.getMessage());
        }
    }
}
