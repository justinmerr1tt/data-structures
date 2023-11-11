import java.util.Arrays;
public class EC {
    static int input = 1;
    static int relBase = 0;
    public static void main(String[] args) {
        String opCode = "1102,34463338,34463338,63,1007,63,34463338,63,1005,63,53,1102,1,3,1000,109,988,209,12,9,1000,209,6,209,3,203,0,1008,1000,1,63,1005,63,65,1008,1000,2,63,1005,63,904,1008,1000,0,63,1005,63,58,4,25,104,0,99,4,0,104,0,99,4,17,104,0,99,0,0,1102,1,21,1004,1101,28,0,1016,1101,0,27,1010,1102,36,1,1008,1102,33,1,1013,1101,0,22,1012,1101,0,37,1011,1102,34,1,1017,1102,466,1,1027,1102,1,484,1029,1102,1,699,1024,1102,1,1,1021,1101,0,0,1020,1102,1,24,1015,1101,0,473,1026,1101,653,0,1022,1102,26,1,1007,1102,25,1,1006,1101,0,39,1014,1102,646,1,1023,1101,690,0,1025,1102,1,29,1019,1101,32,0,1018,1101,30,0,1002,1101,0,20,1001,1102,1,38,1005,1102,1,23,1003,1101,0,31,1000,1101,35,0,1009,1101,0,493,1028,109,5,1208,0,37,63,1005,63,201,1001,64,1,64,1106,0,203,4,187,1002,64,2,64,109,-4,2107,36,8,63,1005,63,223,1001,64,1,64,1105,1,225,4,209,1002,64,2,64,109,18,21107,40,41,-9,1005,1010,243,4,231,1105,1,247,1001,64,1,64,1002,64,2,64,109,6,21107,41,40,-9,1005,1016,267,1001,64,1,64,1106,0,269,4,253,1002,64,2,64,109,-19,21102,42,1,5,1008,1011,42,63,1005,63,291,4,275,1105,1,295,1001,64,1,64,1002,64,2,64,109,15,1205,0,309,4,301,1105,1,313,1001,64,1,64,1002,64,2,64,109,-27,2101,0,9,63,1008,63,20,63,1005,63,333,1106,0,339,4,319,1001,64,1,64,1002,64,2,64,109,19,21102,43,1,6,1008,1019,45,63,1005,63,363,1001,64,1,64,1105,1,365,4,345,1002,64,2,64,109,1,21108,44,47,-3,1005,1011,385,1001,64,1,64,1106,0,387,4,371,1002,64,2,64,109,-22,1201,9,0,63,1008,63,21,63,1005,63,411,1001,64,1,64,1106,0,413,4,393,1002,64,2,64,109,9,1207,0,19,63,1005,63,433,1001,64,1,64,1106,0,435,4,419,1002,64,2,64,109,-9,2107,30,8,63,1005,63,453,4,441,1105,1,457,1001,64,1,64,1002,64,2,64,109,25,2106,0,10,1001,64,1,64,1106,0,475,4,463,1002,64,2,64,109,11,2106,0,0,4,481,1001,64,1,64,1105,1,493,1002,64,2,64,109,-18,2108,21,-6,63,1005,63,511,4,499,1106,0,515,1001,64,1,64,1002,64,2,64,109,-12,2108,18,6,63,1005,63,535,1001,64,1,64,1106,0,537,4,521,1002,64,2,64,109,19,21101,45,0,-7,1008,1010,45,63,1005,63,563,4,543,1001,64,1,64,1105,1,563,1002,64,2,64,109,-10,1207,-5,31,63,1005,63,581,4,569,1106,0,585,1001,64,1,64,1002,64,2,64,109,-8,2102,1,5,63,1008,63,21,63,1005,63,611,4,591,1001,64,1,64,1105,1,611,1002,64,2,64,109,5,1201,0,0,63,1008,63,21,63,1005,63,633,4,617,1106,0,637,1001,64,1,64,1002,64,2,64,109,13,2105,1,6,1001,64,1,64,1106,0,655,4,643,1002,64,2,64,109,-7,1202,-3,1,63,1008,63,26,63,1005,63,681,4,661,1001,64,1,64,1106,0,681,1002,64,2,64,109,12,2105,1,2,4,687,1001,64,1,64,1105,1,699,1002,64,2,64,109,-28,1208,8,30,63,1005,63,717,4,705,1106,0,721,1001,64,1,64,1002,64,2,64,109,10,1202,1,1,63,1008,63,40,63,1005,63,745,1001,64,1,64,1105,1,747,4,727,1002,64,2,64,109,10,21108,46,46,-2,1005,1012,765,4,753,1105,1,769,1001,64,1,64,1002,64,2,64,109,-2,1205,8,781,1106,0,787,4,775,1001,64,1,64,1002,64,2,64,109,-9,2101,0,0,63,1008,63,23,63,1005,63,809,4,793,1105,1,813,1001,64,1,64,1002,64,2,64,109,9,1206,8,831,4,819,1001,64,1,64,1106,0,831,1002,64,2,64,109,-9,2102,1,-2,63,1008,63,22,63,1005,63,855,1001,64,1,64,1106,0,857,4,837,1002,64,2,64,109,4,21101,47,0,10,1008,1017,50,63,1005,63,877,1105,1,883,4,863,1001,64,1,64,1002,64,2,64,109,18,1206,-4,895,1105,1,901,4,889,1001,64,1,64,4,64,99,21101,0,27,1,21102,915,1,0,1106,0,922,21201,1,56639,1,204,1,99,109,3,1207,-2,3,63,1005,63,964,21201,-2,-1,1,21102,1,942,0,1106,0,922,22102,1,1,-1,21201,-2,-3,1,21101,0,957,0,1106,0,922,22201,1,-1,-2,1106,0,968,22102,1,-2,-2,109,-3,2106,0,0";
        String[] opCodeArray = opCode.split(",");
        int[] codeArr = new int[opCodeArray.length];

        for (int j = 0; j < opCodeArray.length; j++) {
            codeArr[j] = Integer.parseInt(opCodeArray[j].trim());
        }
        //int[] copy = Arrays.copyOf(codeArr, codeArr.length);
       /* outerloop:
        for (int p = 0; p < 100; p++)
            for (int t = 0; t < 100; t++) {*/
                //System.arraycopy(copy, 0, codeArr, 0, copy.length);
                //codeArr[1] = 12;
                //codeArr[2] = 2;

                int i = 0;
                while (i < codeArr.length) {

                    if(i+4+relBase > codeArr.length) {
                        int[]newCodeArr = new int[codeArr.length + i+4+relBase];

                        System.arraycopy(codeArr, 0, newCodeArr, 0, codeArr.length);
                        codeArr = newCodeArr;
                    }

                    if (codeArr[i]%100 == 1) {
                        add(codeArr, i);
                        i += 4;
                    } else if (codeArr[i]%100 == 2) {
                        mult(codeArr, i);
                        i += 4;
                    } else if (codeArr[i]%100 == 3) {
                        store(codeArr, i, input);
                        i += 2;
                    } else if (codeArr[i]%100 == 4) {
                        output(codeArr, i);
                        i += 2;
                    } else if(codeArr[i]%100 == 5) {
                        i = jumpTrue(codeArr, i);
                    } else if(codeArr[i]%100 == 6) {
                        i = jumpFalse(codeArr, i);
                    } else if (codeArr[i]%100 == 7) {
                        lessThan(codeArr, i);
                        i += 4;
                    } else if(codeArr[i]%100 == 8) {
                        equals(codeArr, i);
                        i += 4;
                    } else if(codeArr[i]%100 == 9) {
                        relBaseM(codeArr, i);
                        i += 2;
                    }
                    else if (codeArr[i]%100 == 99) {
                        break;
                    } else
                        i++;

                    //System.out.println("test");
                }

//                if (codeArr[0] == 19690720) {
//                    System.out.println("Found combination: " + p + ", " + t);
//                    break outerloop;
//                }
System.out.println(codeArr[0]);
    }

    public static void add(int[] codeArr, int i) {
        int hunD, thouD, tenThouD, p1, p2, p3;
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

            if(tenThouD == 1)
                throw new RuntimeException("no immediate mode for add 3");
            p3 = (tenThouD == 0) ? codeArr[i + 3] : codeArr[i+relBase];

            codeArr[p3] = p1 + p2;
    }

    public static void mult(int[] codeArr, int i) {
        int hunD, thouD, tenThouD,  p1, p2, p3;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

            if(tenThouD == 1)
                throw new RuntimeException("no immediate mode for mult 3");
            p3 = (tenThouD == 0) ? codeArr[i + 3] : codeArr[i+relBase];

            codeArr[p3] = p1 * p2;
        }
    }

    public static void store(int[] codeArr, int i, int in) {
        int hunD;
            hunD = (int) ((codeArr[i] / 100) % 10);
            if (hunD == 0) {
                // if in position mode, retrieve the position and set the value there
                codeArr[codeArr[i+1]] = in;
            } if(hunD == 2) {
                codeArr[codeArr[i+1]+relBase] = in;
            } else if (hunD == 1) {
                throw new RuntimeException("Unsupported Opcode 103");
            }
    }


    public static void output(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenthouD = (int) ((codeArr[i] / 10000) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (thouD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];

        System.out.println(p1);
   }

    public static int jumpTrue(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1, p2;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

        if(p1 != 0) {
            return p2;
        }
        return i+3;
    }

    public static int jumpFalse(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1, p2;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

        if(p1 == 0) {
            return p2;
        }
        return i+3;
    }

    public static void lessThan(int[] codeArr, int i) {
        int hunD, thouD, tenThouD, p1, p2, p3;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenThouD = (int) ((codeArr[i] / 10000) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];
        p3 = (tenThouD == 0) ? codeArr[codeArr[i + 3]] : (tenThouD == 1) ? codeArr[i + 3] : codeArr[codeArr[i+3]+relBase];

        if(codeArr.length < p3) {
            int[]newCodeArr = new int[codeArr.length + p3];

            System.arraycopy(codeArr, 0, newCodeArr, 0, codeArr.length);
            codeArr = newCodeArr;
        }

        if(p1 < p2) {
            codeArr[p3] = 1;
        }
        else codeArr[p3] = 0;
    }

    public static void equals(int[] codeArr, int i) {
        int hunD, thouD, tenThouD, p1, p2, p3;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];
            p3 = (tenThouD == 0) ? codeArr[codeArr[i + 3]] : (tenThouD == 1) ? codeArr[i + 3] : codeArr[codeArr[i+3]+relBase];

            if (p1 == p2) {
                codeArr[p3] = 1;
            } else codeArr[p3] = 0;
        }
    }

    public static void relBaseM(int[] codeArr, int i) {
        int hunD, p1;
        hunD = (int) ((codeArr[i] / 100) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        relBase += p1;
    }
}
