import java.util.Arrays;
public class EC {
    public static void main(String[] args) {
        String opCode = "1,0,0,3,1,1,2,3,1,3,4,3,1,5,0,3,2,1,10,19,1,19,5,23,2,23,9,27,1,5,27,31,1,9,31,35,1,35,10,39,2,13,39,43,1,43,9,47,1,47,9,51,1,6,51,55,1,13,55,59,1,59,13,63,1,13,63,67,1,6,67,71,1,71,13,75,2,10,75,79,1,13,79,83,1,83,10,87,2,9,87,91,1,6,91,95,1,9,95,99,2,99,10,103,1,103,5,107,2,6,107,111,1,111,6,115,1,9,115,119,1,9,119,123,2,10,123,127,1,127,5,131,2,6,131,135,1,135,5,139,1,9,139,143,2,143,13,147,1,9,147,151,1,151,2,155,1,9,155,0,99,2,0,14,0";
        String[] opCodeArray = opCode.split(",");
        int[] codeArr = new int[opCodeArray.length];

        for (int j = 0; j < opCodeArray.length; j++) {
            codeArr[j] = Integer.parseInt(opCodeArray[j].trim());
        }

        int[] copy = Arrays.copyOf(codeArr, codeArr.length);
        outerloop:
            for (int p = 0; p < 100; p++) {
                for (int t = 0; t < 100; t++) {
                    System.arraycopy(copy, 0, codeArr, 0, copy.length);
                    codeArr[1] = p;
                    codeArr[2] = t;

                    int i = 0;
                    while (i < codeArr.length) {
                        if (codeArr[i] == 1) {
                            add(codeArr, i);
                            i += 4;
                        } else if (codeArr[i] == 2) {
                            mult(codeArr, i);
                            i += 4;
                        } else if (codeArr[i] == 99) {
                            break;
                        } else
                            i++;
                    }

                    if (codeArr[0] == 19690720) {
                        System.out.println("Found combination: " + p + ", " + t);
                        break outerloop;
                    }

                    String newOp = "";
                    for (int j = 0; j < codeArr.length - 1; j++) {
                        newOp += codeArr[j] + ",";
                    }
                    newOp += codeArr[codeArr.length - 1];
                    System.out.println(newOp);
                }


            }

        String newOp = "";
        for (int j = 0; j < codeArr.length - 1; j++) {
            newOp += codeArr[j] + ",";
        }
        newOp += codeArr[codeArr.length - 1];
        System.out.println(newOp);

    }

        public static void add ( int[] codeArr, int i){
            if (i + 3 < codeArr.length && codeArr[i+3] < codeArr.length)
            codeArr[codeArr[i + 3]] = codeArr[codeArr[i + 1]] + codeArr[codeArr[i + 2]];
        }

        public static void mult ( int[] codeArr, int i){
            if (i + 3 < codeArr.length && codeArr[i+3] < codeArr.length) {
                codeArr[codeArr[i + 3]] = codeArr[codeArr[i + 1]] * codeArr[codeArr[i + 2]];
            }
        }

    }
