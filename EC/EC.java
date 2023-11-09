import java.util.Arrays;
public class EC {
    static int input = 1;
    public static void main(String[] args) {
        String opCode = "3,225,1,225,6,6,1100,1,238,225,104,0,1102,72,20,224,1001,224,-1440,224,4,224,102,8,223,223,1001,224,5,224,1,224,223,223,1002,147,33,224,101,-3036,224,224,4,224,102,8,223,223,1001,224,5,224,1,224,223,223,1102,32,90,225,101,65,87,224,101,-85,224,224,4,224,1002,223,8,223,101,4,224,224,1,223,224,223,1102,33,92,225,1102,20,52,225,1101,76,89,225,1,117,122,224,101,-78,224,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,1102,54,22,225,1102,5,24,225,102,50,84,224,101,-4600,224,224,4,224,1002,223,8,223,101,3,224,224,1,223,224,223,1102,92,64,225,1101,42,83,224,101,-125,224,224,4,224,102,8,223,223,101,5,224,224,1,224,223,223,2,58,195,224,1001,224,-6840,224,4,224,102,8,223,223,101,1,224,224,1,223,224,223,1101,76,48,225,1001,92,65,224,1001,224,-154,224,4,224,1002,223,8,223,101,5,224,224,1,223,224,223,4,223,99,0,0,0,677,0,0,0,0,0,0,0,0,0,0,0,1105,0,99999,1105,227,247,1105,1,99999,1005,227,99999,1005,0,256,1105,1,99999,1106,227,99999,1106,0,265,1105,1,99999,1006,0,99999,1006,227,274,1105,1,99999,1105,1,280,1105,1,99999,1,225,225,225,1101,294,0,0,105,1,0,1105,1,99999,1106,0,300,1105,1,99999,1,225,225,225,1101,314,0,0,106,0,0,1105,1,99999,1107,677,226,224,1002,223,2,223,1005,224,329,101,1,223,223,7,677,226,224,102,2,223,223,1005,224,344,1001,223,1,223,1107,226,226,224,1002,223,2,223,1006,224,359,1001,223,1,223,8,226,226,224,1002,223,2,223,1006,224,374,101,1,223,223,108,226,226,224,102,2,223,223,1005,224,389,1001,223,1,223,1008,226,226,224,1002,223,2,223,1005,224,404,101,1,223,223,1107,226,677,224,1002,223,2,223,1006,224,419,101,1,223,223,1008,226,677,224,1002,223,2,223,1006,224,434,101,1,223,223,108,677,677,224,1002,223,2,223,1006,224,449,101,1,223,223,1108,677,226,224,102,2,223,223,1006,224,464,1001,223,1,223,107,677,677,224,102,2,223,223,1005,224,479,101,1,223,223,7,226,677,224,1002,223,2,223,1006,224,494,1001,223,1,223,7,677,677,224,102,2,223,223,1006,224,509,101,1,223,223,107,226,677,224,1002,223,2,223,1006,224,524,1001,223,1,223,1007,226,226,224,102,2,223,223,1006,224,539,1001,223,1,223,108,677,226,224,102,2,223,223,1005,224,554,101,1,223,223,1007,677,677,224,102,2,223,223,1006,224,569,101,1,223,223,8,677,226,224,102,2,223,223,1006,224,584,1001,223,1,223,1008,677,677,224,1002,223,2,223,1006,224,599,1001,223,1,223,1007,677,226,224,1002,223,2,223,1005,224,614,101,1,223,223,1108,226,677,224,1002,223,2,223,1005,224,629,101,1,223,223,1108,677,677,224,1002,223,2,223,1005,224,644,1001,223,1,223,8,226,677,224,1002,223,2,223,1006,224,659,101,1,223,223,107,226,226,224,102,2,223,223,1005,224,674,101,1,223,223,4,223,99,226";
        String[] opCodeArray = opCode.split(",");
        int[] codeArr = new int[opCodeArray.length];

        for (int j = 0; j < opCodeArray.length; j++) {
            codeArr[j] = Integer.parseInt(opCodeArray[j].trim());
        }

        int[] copy = Arrays.copyOf(codeArr, codeArr.length);
       /* outerloop:
        for (int p = 0; p < 100; p++)
            for (int t = 0; t < 100; t++) {*/
                System.arraycopy(copy, 0, codeArr, 0, copy.length);
//                codeArr[1] = p;
//                codeArr[2] = t;

                int i = 0;
                while (i < codeArr.length) {
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
                    }
                    else if (codeArr[i]%100 == 99) {
                        break;
                    } else
                        i++;
                }

//                if (codeArr[0] == 19690720) {
//                    System.out.println("Found combination: " + p + ", " + t);
//                    break outerloop;
//                }

                String newOp = "";
                for (int j = 0; j < codeArr.length - 1; j++) {
                    newOp += codeArr[j] + ",";
                }
                newOp += codeArr[codeArr.length - 1];
                System.out.println(newOp);
//            }
//
//
//        }

        newOp = "";
        for (int j = 0; j < codeArr.length - 1; j++) {
            newOp += codeArr[j] + ",";
        }
        newOp += codeArr[codeArr.length - 1];
//        System.out.println(newOp);

    }

    public static void add(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1, p2;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);

            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : codeArr[i + 1];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : codeArr[i + 2];


            codeArr[codeArr[i+3]] = p1 + p2;
        }
    }

    public static void mult(int[] codeArr, int i) {
        int hunD, thouD, tenthouD,  p1, p2;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);

            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : codeArr[i + 1];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : codeArr[i + 2];

            codeArr[codeArr[i+3]] = p1 * p2;
        }
    }

    public static void store(int[] codeArr, int i, int in) {
        int hunD;
        if(i + 1 < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            if (hunD == 0) {
                // if in position mode, retrieve the position and set the value there
                if(codeArr[i + 1] < codeArr.length) {
                    codeArr[codeArr[i+1]] = in;
                }
            } else if (hunD == 1) {
                throw new RuntimeException("Unsupported Opcode 103");
            }
        }
    }


    public static void output(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenthouD = (int) ((codeArr[i] / 10000) % 10);

        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : codeArr[i + 1];

        if(i + 1 < codeArr.length && codeArr[i+1] < codeArr.length)
            System.out.println(p1);
   }

    public static int jumpTrue(int[] codeArr, int i) {
        int hunD, thouD, tenthouD;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        if (hunD == 0)
            hunD = codeArr[codeArr[i + 1]];
        if (thouD == 0)
            thouD = codeArr[codeArr[i + 2]];

        if(hunD != 0) {
            return thouD;
        }
        return i+3;
    }

    public static int jumpFalse(int[] codeArr, int i) {
        int hunD, thouD, tenthouD;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        if (hunD == 0)
            hunD = codeArr[codeArr[i + 1]];
        if (thouD == 0)
            thouD = codeArr[codeArr[i + 2]];

        if(hunD == 0) {
            return thouD;
        }
        return i+3;
    }

    public static void lessThan(int[] codeArr, int i) {
        int hunD, thouD, tenThouD;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenThouD = (int) ((codeArr[i] / 10000) % 10);

        if (hunD == 0)
            hunD = codeArr[codeArr[i + 1]];
        if (thouD == 0)
            thouD = codeArr[codeArr[i + 2]];
        if (tenThouD == 0)
            tenThouD = codeArr[codeArr[i + 3]];

        if(hunD < thouD) {
            codeArr[i+3] = thouD;
        }
        else codeArr[i+3] = 0;
    }

    public static void equals(int[] codeArr, int i) {
        int hunD, thouD, tenThouD;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            if (hunD == 0)
                hunD = codeArr[codeArr[i + 1]];
            if (thouD == 0)
                thouD = codeArr[codeArr[i + 2]];
            if (tenThouD == 0)
                tenThouD = codeArr[codeArr[i + 3]];

            if (hunD == thouD) {
                codeArr[i + 3] = thouD;
            } else codeArr[i + 3] = 0;
        }
    }
}
