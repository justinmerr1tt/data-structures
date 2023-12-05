import java.util.Arrays;
import java.util.HashMap;
public class EC {
    static int input = 1;
    static int relBase = 0;
    public static void main(String[] args) {
        String opCode = "109,1,204,-1,1001,100,1,100,1008,100,16,101,1006,101,0,99";
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
                int count = 0;
                while (i < codeArr.length) {
                    System.out.print("\n Count: " + count + "; Array: ");
                    count++;
                    for(int p = 0; p<codeArr.length; p++)  {
                        System.out.print(codeArr[p] + ", ");
                    }
                    // ensuring that any relative mode calls will not be out of bounds
                    if(codeArr[i+3]+1+relBase > codeArr.length) {
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

                    //my self-coded debugger:
                    //System.out.println("test");
                }

//                if (codeArr[0] == 19690720) {
//                    System.out.println("Found combination: " + p + ", " + t);
//                    break outerloop;
//                }
System.out.println(codeArr[0]);
    }

    public static void add(int[] codeArr, int i) {
        // determining numerical value for each parameter's mode
        int hunD, thouD, tenThouD, p1, p2, p3;
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            // setting value of parameter based on mode
            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

            if(tenThouD == 1)
                throw new RuntimeException("no immediate mode for add 3");
            p3 = (tenThouD == 0) ? codeArr[i + 3] : codeArr[i+relBase];

            codeArr[p3] = p1 + p2;
    }

    public static void mult(int[] codeArr, int i) {
        // determining numerical value for each parameter's mode
        int hunD, thouD, tenThouD,  p1, p2, p3;
        if (i + 3 < codeArr.length && codeArr[i + 3] < codeArr.length) {
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            // setting value of parameter based on mode
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
        // determining numerical value for each parameter's mode
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
        // determining numerical value for each parameter's mode
        int hunD, thouD, tenthouD, p1;
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenthouD = (int) ((codeArr[i] / 10000) % 10);

        // setting parameter to correct value based on mode
        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (thouD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];

        System.out.println(p1);
   }

    public static int jumpTrue(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1, p2;
        // determining numerical value for each parameter's mode
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        // setting parameters based on their mode
        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

        if(p1 != 0) {
            return p2;
        }
        return i+3;
    }

    public static int jumpFalse(int[] codeArr, int i) {
        int hunD, thouD, tenthouD, p1, p2;
        // determining numerical value for each parameter's mode
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);

        // setting parameters based on their mode
        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];

        if(p1 == 0) {
            return p2;
        }
        return i+3;
    }

    public static void lessThan(int[] codeArr, int i) {
        int hunD, thouD, tenThouD, p1, p2, p3;
        // determining numerical value for each parameter's mode
        hunD = (int) ((codeArr[i] / 100) % 10);
        thouD = (int) ((codeArr[i] / 1000) % 10);
        tenThouD = (int) ((codeArr[i] / 10000) % 10);

        // setting parameters based on their mode
        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];
        p3 = (tenThouD == 0) ? codeArr[codeArr[i + 3]] : (tenThouD == 1) ? codeArr[i + 3] : codeArr[codeArr[i+3]+relBase];

        // prevents index out of bounds when accesing codeArr[p3]
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
        // determining numerical value for each parameter's mode
            hunD = (int) ((codeArr[i] / 100) % 10);
            thouD = (int) ((codeArr[i] / 1000) % 10);
            tenThouD = (int) ((codeArr[i] / 10000) % 10);

            // setting parameters based on mode
            p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
            p2 = (thouD == 0) ? codeArr[codeArr[i + 2]] : (thouD == 1) ? codeArr[i + 2] : codeArr[codeArr[i+2]+relBase];
            p3 = (tenThouD == 0) ? codeArr[codeArr[i + 3]] : (tenThouD == 1) ? codeArr[i + 3] : codeArr[codeArr[i+3]+relBase];

            if (p1 == p2) {
                codeArr[p3] = 1;
            } else codeArr[p3] = 0;
    }

    public static void relBaseM(int[] codeArr, int i) {
        int hunD, p1;
        // determining numerical value for parameters mode
        hunD = (int) ((codeArr[i] / 100) % 10);

        // setting parameter based on mode
        p1 = (hunD == 0) ? codeArr[codeArr[i + 1]] : (hunD == 1) ? codeArr[i + 1] : codeArr[codeArr[i+1]+relBase];
        relBase += p1;
    }
}
