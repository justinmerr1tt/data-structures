package advent2023.day2.src;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;
import java.util.regex.Matcher;


public class Day2 {

    private static Map<Integer, String> colors;
    private static Map<Integer, Map<String, Integer>> outerMap;
    private static String in;
        public static void main(String[] args) {
            outerMap = new HashMap<>();

            colors = new HashMap<>();
            colors.put(0, "red");
            colors.put(1, "green");
            colors.put(2, "blue");

            setInt();
            //in = "Game 1: 1 green, 4 blue; 1 blue, 2 green, 1 red";
            declareInnerMap();

            int maxRed = 12;
            int maxGreen = 13;
            int maxBlue = 14;

            System.out.println(sumGames(maxRed,maxGreen,maxBlue));
            System.out.println(sumPower(maxRed,maxGreen,maxBlue));

            System.out.println(outerMap);
        }


    public static int sumPower(int maxRed, int maxGreen, int maxBlue) {

        Map<String, Integer> maxColors = new HashMap<>();
        maxColors.put("red", -1);
        maxColors.put("green", -1);
        maxColors.put("blue", -1);

        int powerSums = 0;
        int curPower =  1;
        for(int i = 1; i < outerMap.size()+1; i++) {
            for(int c = 0; c < colors.size(); c++) {
                if(outerMap.get(i).get(colors.get(c)) > maxColors.get(colors.get(c))) {
                    maxColors.put(colors.get(c), outerMap.get(i).get(colors.get(c)));
                }
                curPower = maxColors.get("red") * maxColors.get("green") * maxColors.get("blue");
            }
            maxColors.put("red", -1);
            maxColors.put("green", -1);
            maxColors.put("blue", -1);
            powerSums += curPower;
        }
        return powerSums;
    }

    public static int sumGames(int maxRed, int maxGreen, int maxBlue) {

        Map<String, Integer> maxColors = new HashMap<>();
        maxColors.put("red", maxRed);
        maxColors.put("green", maxGreen);
        maxColors.put("blue", maxBlue);

            int sumIDs = 0;
            for(int i = 1; i < outerMap.size()+1; i++) {
                for(int c = 0; c < colors.size(); c++) {
                    if(outerMap.get(i).get(colors.get(c)) > maxColors.get(colors.get(c))) {
                        System.out.println("Game " + i + " invalid");
                        sumIDs = sumIDs - i;
                        break;
                    }
                }
                sumIDs += i;
            }
            return sumIDs;
    }


    static void declareInnerMap() {
            String[] arrOfStr = in.split("\n", -1);

            for(int line = 0; line < arrOfStr.length; line++) {

                Pattern pattern = Pattern.compile("Game (\\d+):");
                Matcher matcher = pattern.matcher(arrOfStr[line]);
                int gameNumber = -1;

                if (matcher.find()) {
                    gameNumber = Integer.parseInt(matcher.group(1));
                }

                Map<String, Integer> innerMap = new HashMap<>();
                innerMap.put("red", -1);
                innerMap.put("green", -1);
                innerMap.put("blue", -1);
                outerMap.put(gameNumber, innerMap);

                //for(int curChar = 0; curChar < arrOfStr[line].length(); curChar++) {
                    for(int cC = 0; cC < colors.size(); cC++) {
                        String curColor = colors.get(cC);

                        String thisLine = arrOfStr[line];
                        //String intAndColor = "(\\d+) blue";
                        String intAndColor = "(\\d+) " + curColor;
                        //System.out.println("(\\d+) " + curColor);
                        //System.out.println("(\\d+) " + curColor);

                        Pattern regex = Pattern.compile(intAndColor);
                        Matcher match = regex.matcher(thisLine);

                        while (match.find()) {
                            String capturedNumber = match.group(1);
                            int number = Integer.parseInt(capturedNumber);
                            //System.out.println("Captured number: " + number);
                            if(innerMap.get(curColor) < number)
                                innerMap.put(curColor, number);
                        }


                        /*if(curColor.length() + curChar < arrOfStr[line].length() && arrOfStr[line].substring(curChar, curChar+curColor.length()).equals(curColor)) {
                            int curValue = (int) arrOfStr[line].charAt(curChar-2);


                        }*/
                        //colorValue = 0;
                    }


                  //  }
                    }
                }








        static void setInt() {
            in  = "Game 1: 1 green, 4 blue; 1 blue, 2 green, 1 red; 1 red, 1 green, 2 blue; 1 green, 1 red; 1 green; 1 green, 1 blue, 1 red\n" +
                    "Game 2: 2 blue, 2 red, 6 green; 1 red, 6 green, 7 blue; 10 green, 8 blue, 1 red; 2 green, 18 blue, 2 red; 14 blue, 3 green, 1 red; 8 green, 1 red, 9 blue\n" +
                    "Game 3: 6 green, 5 blue, 9 red; 4 blue, 1 green, 13 red; 9 green, 14 red, 1 blue\n" +
                    "Game 4: 14 green, 3 blue, 16 red; 20 red; 4 green, 2 red, 1 blue; 10 blue, 11 green, 18 red; 3 red, 3 blue, 6 green; 2 green, 18 red, 9 blue\n" +
                    "Game 5: 5 green, 4 blue; 1 red, 3 blue, 2 green; 4 green, 2 red, 15 blue; 11 blue, 8 green, 4 red; 4 red, 3 green; 4 red, 3 green, 7 blue\n" +
                    "Game 6: 6 blue, 10 green; 2 red, 6 green, 2 blue; 4 red, 4 blue, 1 green; 2 blue, 7 green, 2 red\n" +
                    "Game 7: 14 green, 3 red, 2 blue; 5 blue, 3 green, 2 red; 1 green, 3 blue\n" +
                    "Game 8: 7 red; 3 blue, 9 red, 1 green; 5 green, 5 blue, 7 red; 1 red, 2 blue\n" +
                    "Game 9: 3 green, 4 blue, 1 red; 3 blue, 12 green, 18 red; 7 green, 9 red, 8 blue; 2 blue, 10 red, 12 green; 4 blue, 1 red, 1 green; 4 blue, 6 green, 6 red\n" +
                    "Game 10: 2 blue, 4 green, 2 red; 7 green, 4 red; 5 red, 8 green\n" +
                    "Game 11: 1 blue, 10 green, 15 red; 1 blue, 2 green, 2 red; 5 green, 10 blue, 8 red; 13 red, 7 blue; 1 red, 9 green, 4 blue; 9 blue, 9 red, 8 green\n" +
                    "Game 12: 1 green, 10 red, 3 blue; 14 red, 1 green, 4 blue; 6 red, 3 green, 12 blue; 13 blue, 1 green, 18 red; 4 green, 14 red, 7 blue\n" +
                    "Game 13: 1 red, 3 green; 2 green, 1 red, 5 blue; 1 blue; 1 green, 7 blue, 1 red; 1 red, 2 green, 7 blue\n" +
                    "Game 14: 7 blue, 9 red, 1 green; 8 red, 2 blue; 11 red, 18 blue, 4 green; 2 blue, 3 green, 1 red; 1 green, 8 red, 9 blue; 2 blue, 8 red, 1 green\n" +
                    "Game 15: 8 blue, 3 green, 15 red; 13 red, 10 blue; 2 red\n" +
                    "Game 16: 1 green, 1 red; 1 blue, 2 green, 2 red; 1 blue, 4 red, 1 green; 3 green; 2 blue, 3 green, 4 red\n" +
                    "Game 17: 1 green, 3 red, 14 blue; 1 red, 2 blue, 2 green; 3 red\n" +
                    "Game 18: 1 red, 2 green, 8 blue; 2 blue, 14 red; 4 blue, 2 red, 2 green; 6 red\n" +
                    "Game 19: 2 red, 11 blue, 18 green; 3 red, 6 green, 3 blue; 7 green, 1 red, 10 blue\n" +
                    "Game 20: 10 red, 1 blue, 4 green; 4 green, 3 blue; 10 green, 13 red, 4 blue; 2 red, 7 green; 4 red, 3 blue, 5 green; 13 red, 1 green, 4 blue\n" +
                    "Game 21: 20 red, 4 green, 5 blue; 10 red, 11 green, 4 blue; 1 red, 8 blue, 14 green; 11 green, 8 blue, 15 red; 8 blue, 2 green, 13 red\n" +
                    "Game 22: 2 red, 11 blue, 4 green; 1 blue, 3 red, 6 green; 6 green, 1 red, 1 blue; 4 green, 7 blue, 3 red; 11 blue, 6 green, 4 red\n" +
                    "Game 23: 6 green, 3 red, 1 blue; 17 green, 11 red; 1 red, 2 blue, 13 green; 13 green, 19 red\n" +
                    "Game 24: 1 blue; 12 red, 1 blue; 1 red; 12 red, 1 green, 1 blue; 11 red, 1 blue; 12 red, 1 green\n" +
                    "Game 25: 12 blue, 6 red, 3 green; 8 green, 14 blue; 11 green, 5 blue, 6 red; 4 red, 12 blue, 8 green\n" +
                    "Game 26: 15 red, 13 green, 9 blue; 9 blue, 8 green, 7 red; 2 green, 6 red, 3 blue; 1 blue, 7 red, 3 green; 13 blue, 4 green, 18 red\n" +
                    "Game 27: 9 blue, 5 red; 15 red, 12 blue, 3 green; 12 red, 12 blue, 1 green\n" +
                    "Game 28: 18 red, 4 green; 4 green, 6 red; 1 blue, 6 green, 19 red; 9 green, 17 red; 4 green, 5 blue, 18 red\n" +
                    "Game 29: 7 green, 6 red, 6 blue; 6 blue, 19 red, 4 green; 4 green, 4 blue, 13 red; 5 blue, 15 red, 10 green; 2 green, 6 blue, 5 red; 8 red, 10 green, 6 blue\n" +
                    "Game 30: 1 green, 13 red, 12 blue; 1 red, 2 blue; 11 blue, 1 red, 1 green\n" +
                    "Game 31: 8 green, 18 blue, 17 red; 4 red, 8 green, 6 blue; 9 blue, 7 green; 3 green, 1 blue, 12 red; 5 red, 10 blue, 11 green\n" +
                    "Game 32: 17 red, 17 green, 7 blue; 18 red, 16 green; 1 blue\n" +
                    "Game 33: 16 blue, 3 red; 9 blue, 1 red, 2 green; 3 green, 7 blue; 1 green, 4 red; 3 green, 1 red, 8 blue; 5 blue\n" +
                    "Game 34: 5 blue, 8 red, 1 green; 9 red, 10 blue, 7 green; 1 green, 14 blue; 8 blue, 4 red, 10 green; 15 blue, 8 green, 7 red; 2 red, 6 green, 3 blue\n" +
                    "Game 35: 13 red, 9 blue; 7 blue, 16 red, 10 green; 4 red, 6 blue; 3 blue, 12 green, 7 red; 8 blue, 6 red; 10 blue, 3 green, 2 red\n" +
                    "Game 36: 1 blue, 9 red, 2 green; 11 red, 3 blue, 2 green; 2 green, 6 red; 8 green, 11 red, 3 blue; 4 green, 7 blue, 11 red; 9 green, 8 red, 2 blue\n" +
                    "Game 37: 8 green, 3 blue, 4 red; 14 blue, 10 green, 3 red; 19 green, 2 blue, 7 red\n" +
                    "Game 38: 2 green, 3 red, 3 blue; 3 green, 9 red; 13 blue, 8 red; 6 red, 5 green, 13 blue\n" +
                    "Game 39: 8 red, 5 blue; 4 green, 5 blue, 3 red; 18 red, 2 green, 6 blue; 2 green, 5 blue, 17 red; 1 green, 2 red; 5 green, 6 blue\n" +
                    "Game 40: 12 red, 4 blue, 1 green; 11 green, 20 blue, 4 red; 10 blue, 4 red\n" +
                    "Game 41: 2 green, 2 blue; 2 red, 2 green; 2 green, 2 blue, 10 red\n" +
                    "Game 42: 6 green, 3 blue; 2 red, 2 green, 1 blue; 3 blue, 5 green, 6 red; 6 red; 1 blue, 6 green, 12 red\n" +
                    "Game 43: 1 blue, 4 green; 1 blue; 2 blue, 8 red, 2 green; 2 blue, 1 red, 4 green; 1 blue, 4 red, 4 green; 4 green, 7 red\n" +
                    "Game 44: 8 green, 9 red; 1 red, 2 blue, 13 green; 4 blue, 8 green, 17 red; 13 red, 13 green; 1 red, 9 green; 19 red, 3 green, 3 blue\n" +
                    "Game 45: 10 blue, 2 red, 1 green; 6 green, 5 red, 8 blue; 3 blue, 1 red; 4 green, 10 blue, 4 red\n" +
                    "Game 46: 3 red, 8 blue; 6 blue, 7 green, 6 red; 6 green, 1 blue, 7 red; 8 red, 1 green, 5 blue; 9 red, 12 blue, 10 green; 7 green, 5 red, 1 blue\n" +
                    "Game 47: 5 red; 2 blue, 2 green, 5 red; 3 green, 7 red; 14 red, 3 green, 2 blue\n" +
                    "Game 48: 7 blue, 12 green, 2 red; 11 green, 10 blue, 1 red; 1 red, 13 blue, 2 green; 14 green, 2 red, 9 blue; 2 red, 12 green, 3 blue; 2 red, 7 blue\n" +
                    "Game 49: 4 green, 5 blue; 9 blue; 10 blue, 5 green, 2 red; 10 blue, 2 red, 2 green; 1 red, 1 green, 4 blue; 2 blue\n" +
                    "Game 50: 2 red, 2 blue, 7 green; 7 red, 9 green, 3 blue; 5 red, 10 green\n" +
                    "Game 51: 15 red, 9 blue, 4 green; 5 red, 2 blue, 15 green; 4 blue, 3 green, 20 red; 12 green, 1 red, 10 blue; 10 green, 5 blue, 13 red; 9 red, 10 green, 11 blue\n" +
                    "Game 52: 3 blue, 12 green, 1 red; 6 green; 1 red, 8 green; 1 blue, 1 green, 1 red\n" +
                    "Game 53: 10 green, 7 red, 12 blue; 9 blue, 6 green, 2 red; 8 green, 5 blue, 5 red; 7 blue, 16 green, 11 red; 6 red, 8 blue, 13 green\n" +
                    "Game 54: 10 green, 6 blue, 3 red; 6 green, 2 red, 8 blue; 9 blue, 11 green, 2 red; 10 green, 1 blue, 3 red\n" +
                    "Game 55: 4 blue, 1 red; 3 red, 7 blue; 12 red, 4 green, 8 blue; 3 green, 5 blue, 1 red; 13 blue, 12 red, 1 green\n" +
                    "Game 56: 12 blue, 15 green; 1 green, 7 red, 11 blue; 5 green, 9 blue, 1 red; 8 red, 5 green, 6 blue\n" +
                    "Game 57: 4 green, 11 blue, 18 red; 14 blue, 14 red, 16 green; 7 red, 15 green, 3 blue; 18 red, 20 green, 8 blue; 12 blue, 9 red, 16 green\n" +
                    "Game 58: 10 blue, 9 green, 8 red; 13 green, 6 blue, 8 red; 8 green, 4 red; 4 blue, 1 red, 18 green; 7 red, 10 green, 10 blue; 15 blue, 10 green, 3 red\n" +
                    "Game 59: 17 green, 2 blue, 2 red; 2 blue, 1 red, 8 green; 14 green, 1 red, 1 blue; 15 green, 3 blue, 2 red; 2 blue, 8 green, 1 red; 1 blue, 1 red, 8 green\n" +
                    "Game 60: 1 green, 1 blue, 1 red; 4 blue, 3 red, 2 green; 13 green; 2 blue, 2 red, 8 green; 4 red, 12 green, 4 blue; 4 green, 4 blue, 4 red\n" +
                    "Game 61: 3 blue, 7 red; 5 blue, 8 red, 1 green; 1 blue, 8 red; 10 blue, 2 red, 1 green; 1 green, 5 blue, 2 red\n" +
                    "Game 62: 10 red, 2 green; 8 blue, 7 red, 2 green; 4 green, 2 blue, 10 red\n" +
                    "Game 63: 1 green, 3 blue, 5 red; 6 green, 5 blue, 2 red; 3 blue, 7 red\n" +
                    "Game 64: 6 red, 20 blue; 4 red, 3 blue, 2 green; 3 green, 19 blue, 6 red; 2 green, 6 blue, 3 red; 13 blue, 5 green, 5 red\n" +
                    "Game 65: 6 red, 9 blue, 20 green; 6 red, 16 green, 4 blue; 12 red, 6 green, 5 blue\n" +
                    "Game 66: 2 blue, 5 red, 4 green; 13 blue, 2 green; 1 green, 6 blue\n" +
                    "Game 67: 4 green, 5 blue, 2 red; 1 red, 14 blue, 6 green; 1 green, 14 red, 5 blue; 18 red, 16 blue; 15 blue, 8 red, 18 green; 1 green, 18 red, 6 blue\n" +
                    "Game 68: 1 blue, 9 red, 7 green; 7 red, 1 blue, 6 green; 5 green, 1 blue, 8 red\n" +
                    "Game 69: 12 green, 3 blue, 4 red; 9 green, 8 red, 7 blue; 4 blue, 5 red, 10 green; 4 red, 5 green, 7 blue; 9 green, 4 red, 2 blue; 3 green, 13 blue, 1 red\n" +
                    "Game 70: 9 red, 1 green, 8 blue; 11 green, 13 blue, 12 red; 3 blue, 5 green, 8 red; 1 red, 14 blue\n" +
                    "Game 71: 10 blue; 2 green, 8 blue, 9 red; 5 red, 1 blue\n" +
                    "Game 72: 3 green, 5 blue, 5 red; 1 blue, 1 red, 2 green; 4 red, 4 blue, 1 green; 5 blue, 4 red, 1 green; 6 blue, 3 green, 5 red; 5 blue, 1 red, 4 green\n" +
                    "Game 73: 3 red, 1 green, 1 blue; 7 green, 2 red, 1 blue; 2 green, 1 blue, 3 red; 1 red, 4 green, 1 blue; 3 red, 5 green\n" +
                    "Game 74: 5 blue, 1 red, 4 green; 3 red, 2 green; 4 red, 6 blue; 2 red, 2 blue; 1 green, 4 red, 8 blue; 5 blue, 4 red\n" +
                    "Game 75: 3 red, 5 blue, 3 green; 9 green, 6 blue, 7 red; 2 green, 3 red, 12 blue; 14 green, 4 blue, 10 red\n" +
                    "Game 76: 1 blue, 7 red, 1 green; 6 red, 1 blue, 2 green; 4 red, 2 green; 3 red, 1 blue; 16 red, 1 green\n" +
                    "Game 77: 3 red, 10 blue, 1 green; 4 red, 7 blue, 3 green; 7 blue, 6 green, 7 red; 5 green, 15 blue, 7 red; 12 green, 5 red\n" +
                    "Game 78: 6 red, 10 blue, 15 green; 6 green, 11 red, 4 blue; 6 blue, 8 red; 4 blue, 7 red, 2 green; 11 green, 7 red, 11 blue; 3 blue, 14 green, 6 red\n" +
                    "Game 79: 14 red, 6 green, 4 blue; 13 red, 6 blue; 6 red, 13 green, 4 blue\n" +
                    "Game 80: 8 red, 2 blue, 8 green; 6 red, 10 green, 4 blue; 3 red, 9 green; 2 green, 8 blue, 7 red; 7 blue, 3 red, 11 green; 1 red, 12 green, 8 blue\n" +
                    "Game 81: 9 red, 4 blue, 11 green; 1 blue, 4 red, 2 green; 5 red; 3 blue, 2 red, 2 green; 14 red, 12 green\n" +
                    "Game 82: 5 green; 2 blue; 2 red; 1 blue, 2 red, 11 green; 8 green, 2 red, 1 blue\n" +
                    "Game 83: 3 green, 7 red, 6 blue; 7 red, 7 green, 11 blue; 7 blue, 13 green, 7 red; 12 blue, 10 red, 2 green; 1 green, 11 red, 7 blue; 12 blue, 9 red, 9 green\n" +
                    "Game 84: 5 blue, 1 green; 16 green, 4 blue, 8 red; 7 red, 5 blue, 16 green\n" +
                    "Game 85: 9 green, 20 blue, 7 red; 19 blue, 14 red, 2 green; 10 green, 2 red, 10 blue\n" +
                    "Game 86: 1 green, 3 red, 5 blue; 9 red, 2 blue, 6 green; 8 green, 14 red, 3 blue; 18 green, 2 blue, 7 red; 2 blue, 10 red, 14 green; 17 green, 4 blue, 12 red\n" +
                    "Game 87: 4 green, 8 red, 13 blue; 7 red, 13 blue, 4 green; 1 green, 8 blue\n" +
                    "Game 88: 9 blue, 11 red; 5 green, 7 blue, 12 red; 10 red, 2 green, 1 blue; 2 blue, 5 red, 5 green; 7 red, 6 green, 9 blue; 1 green, 10 red, 5 blue\n" +
                    "Game 89: 7 red, 2 green, 1 blue; 1 blue, 2 green; 6 red, 1 green; 7 red, 1 blue; 3 green, 3 red\n" +
                    "Game 90: 8 blue, 2 red, 3 green; 9 green, 4 blue, 3 red; 7 green, 11 blue, 2 red; 13 green, 12 blue, 8 red; 10 blue, 2 green; 5 green, 1 red, 9 blue\n" +
                    "Game 91: 2 red, 2 green, 4 blue; 5 blue, 2 red, 16 green; 11 green; 3 blue, 2 red, 8 green; 4 green, 3 blue\n" +
                    "Game 92: 8 red, 12 blue, 3 green; 11 red, 10 blue, 6 green; 14 red, 8 green, 14 blue\n" +
                    "Game 93: 3 green, 2 red, 3 blue; 3 green, 3 red, 1 blue; 2 blue, 16 red, 3 green; 2 green; 5 green, 2 blue, 2 red\n" +
                    "Game 94: 5 red, 2 green; 9 red, 3 blue; 2 green, 2 blue, 5 red; 3 blue, 8 red, 2 green; 8 red, 1 blue, 1 green\n" +
                    "Game 95: 3 blue, 4 green, 7 red; 7 red, 1 green, 15 blue; 6 blue, 2 green, 7 red\n" +
                    "Game 96: 2 blue, 1 red, 6 green; 7 blue, 8 green; 1 red, 7 green; 2 green, 14 blue, 1 red; 3 blue, 1 red, 7 green; 4 blue, 11 green\n" +
                    "Game 97: 2 red, 9 blue, 8 green; 3 green, 5 blue; 6 green, 1 red, 9 blue; 2 red, 13 green, 1 blue; 2 green, 2 red, 2 blue\n" +
                    "Game 98: 2 blue, 1 green, 1 red; 4 blue, 5 red, 1 green; 4 blue, 3 red, 2 green\n" +
                    "Game 99: 17 red, 2 blue, 4 green; 4 green, 8 red, 6 blue; 5 red\n" +
                    "Game 100: 6 red, 4 green; 3 red, 2 blue, 9 green; 1 blue, 5 green, 14 red; 1 blue, 2 red, 2 green; 9 red, 1 blue, 14 green; 2 blue, 11 green, 8 red";
        }





}
