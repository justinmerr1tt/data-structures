package advent2023.day6;
import java.util.ArrayList;
public class Day6 {
    private String in = "Time:        60     94     78     82 Distance:   475   2138   1015   1650";
    private static long num = 1;
    public static void main(String[] args) {
        long[][] log = new long[1][];

        // time, record distance
        /*log[0] = new int[]{60, 475};

        log[1] = new int[]{94, 2138};

        log[2] = new int[]{78, 1015};

        log[3] = new int[]{82, 1650};*/
        log[0] = new long[]{60947882, 475213810151650L};

        for(int logIndex = 0; logIndex < log.length; logIndex++) {
            int numWin = 0;
            long dur = log[logIndex][0];
            long dist = log[logIndex][1];
            for(long t = 1; t < dur; t++) {
                if(t*(dur-t) > dist)
                    numWin++;
            }
            num *= numWin;
        }
        System.out.println(num);
    }
}
