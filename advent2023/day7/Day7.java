package advent2023.day7;
import java.util.ArrayList;
public class Day7 {
    private static String in;
    private static String[] arrOfStr;
    static ArrayList<ArrayList<Integer>> grandArray = new ArrayList<>();

    public static void main(String[] args) {
        in();
        /*in =    "32T3K 765\n" +
                "T55J5 684\n" +
                "KK677 28\n" +
                "KTJJT 220\n" +
                "QQQJA 483";*/

        /*in =    "32T3K 765\n" +
                "QQQJA 483\n" +
                "KTJJT 220";*/

        /*in =    "T55J5 684\n" +
                "QQQJA 483";*/

        /*in =    "KK677 28\n" +
                "KTJJT 220";*/

        /*in = "A9KK9 799\n" +
                "QTQ88 920\n" +
                "9T9KT 777\n" +
                "T63J9 159\n" +
                "6JJ36 898\n" +
                "229T2 17\n" +
                "J9QJ5 250\n" +
                "8K3Q6 42\n" +
                "QQ6Q3 252\n" +
                "K8JK7 320\n" +
                "32523 510\n" +
                "TQ33J 507\n" +
                "J227J 913\n" +
                "835JJ 169\n" +
                "TJT22 354\n" +
                "QQQ79 870\n" +
                "77776 333\n" +
                "78TQ2 466\n" +
                "27J27 229";*/

        in = "AAAAA 2\n" +
                "22222 3\n" +
                "AAAAK 5\n" +
                "22223 7\n" +
                "AAAKK 11\n" +
                "22233 13\n" +
                "AAAKQ 17\n" +
                "22234 19\n" +
                "AAKKQ 23\n" +
                "22334 29\n" +
                "AAKQJ 31\n" +
                "22345 37\n" +
                "AKQJT 41\n" +
                "23456 43";

        arrOfStr = in.split("\n", -1);

        for(int line = 0; line < arrOfStr.length; line++) {
            int bid = Integer.parseInt(arrOfStr[line].substring(6));


            boolean foundSpot = false;
            int count = 0;
            if(grandArray.size() == 0) {
                System.out.println("you should only see me once");
                ArrayList<Integer> innerList = new ArrayList<>();
                innerList.add(0, line);
                innerList.add(1, bid);
                grandArray.add(0, innerList);
            }
            else {
                    System.out.println("count: " + count + "gAsize: " + grandArray.size());
                    while (count < grandArray.size() && compareValues(grandArray.get(count).get(0), line) == 1) {
                        System.out.println("condition met, " + "p1: " + grandArray.get(count).get(0) + " p2 " + line);
                        count++;
                    }
                    ArrayList<Integer> innerList = new ArrayList<>();
                    innerList.add(0, line);
                    innerList.add(1, bid);

                    System.out.println("grandArrayadd count:" + count + " innerList:" + innerList);
                    grandArray.add(count, innerList);
                    count = 0;
            }
        }
        //System.out.println("TEST: " + compareValues(4, 2));
        int answer = 0;
        for(int i = 0; i < grandArray.size(); i++) {

            System.out.print(answer + " += " + (arrOfStr.length-(i)) + "*" + grandArray.get(i).get(1) + " = ");
            answer += (arrOfStr.length-(i)) * grandArray.get(i).get(1);
            System.out.println(answer);
        }
        System.out.println(answer);
        //System.out.println(compareValues(3,4));
        //System.out.println(answer);
    }

    private static int compareValues(int checkCase, int curLine) {
        // if curLine < checkCase return 1
        System.out.println("jd" + checkCase);

        int curLineCount = 0;
        int checkCaseCount = 0;
        int maxCurLineCount = 0;
        int maxCheckCaseCount = 0;

        ArrayList<Integer> checkCaseHand = new ArrayList<Integer>();
        int temp = -1;
        if (!Character.isDigit(arrOfStr[checkCase].charAt(0))) {
            if (arrOfStr[checkCase].charAt(0) == 'A')
                temp = 14;
            if (arrOfStr[checkCase].charAt(0) == 'K')
                temp = 13;
            if (arrOfStr[checkCase].charAt(0) == 'Q')
                temp = 12;
            if (arrOfStr[checkCase].charAt(0) == 'J')
                temp = 11;
            if (arrOfStr[checkCase].charAt(0) == 'T')
                temp = 10;
        } else
            temp = Integer.parseInt(String.valueOf(arrOfStr[checkCase].charAt(0)));

        checkCaseHand.add(0, temp);
        for (int i = 1; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < checkCaseHand.size(); j++) {
                if (checkCaseHand.get(j) == convertCharToInt(arrOfStr[checkCase].charAt(i)))
                    count++;
            }
            if (count == 0) {

                temp = -1;
                if (!Character.isDigit(arrOfStr[checkCase].charAt(i))) {
                    if (arrOfStr[checkCase].charAt(i) == 'A')
                        temp = 14;
                    if (arrOfStr[checkCase].charAt(i) == 'K')
                        temp = 13;
                    if (arrOfStr[checkCase].charAt(i) == 'Q')
                        temp = 12;
                    if (arrOfStr[checkCase].charAt(i) == 'J')
                        temp = 11;
                    if (arrOfStr[checkCase].charAt(i) == 'T')
                        temp = 10;
                } else {
                    temp = Integer.parseInt(String.valueOf(arrOfStr[checkCase].charAt(i)));
                    //System.out.println(arrOfStr[checkCase].charAt(i));
                }

                checkCaseHand.add((int) temp);
            }

        }


        // same but curCards


        ArrayList<Integer> curLineHand = new ArrayList<Integer>();
        temp = -1;
        if (!Character.isDigit(arrOfStr[curLine].charAt(0))) {
            if (arrOfStr[curLine].charAt(0) == 'A')
                temp = 14;
            if (arrOfStr[curLine].charAt(0) == 'K')
                temp = 13;
            if (arrOfStr[curLine].charAt(0) == 'Q')
                temp = 12;
            if (arrOfStr[curLine].charAt(0) == 'J')
                temp = 11;
            if (arrOfStr[curLine].charAt(0) == 'T')
                temp = 10;
        } else
            temp = Integer.parseInt(String.valueOf(arrOfStr[curLine].charAt(0)));

        curLineHand.add(0, temp);
        for (int i = 1; i < 5; i++) {
            int count = 0;
            for (int j = 0; j < curLineHand.size(); j++) {
                if (curLineHand.get(j) == convertCharToInt(arrOfStr[curLine].charAt(i))) {
                    count++;
                    //System.out.println("count++");
                }
            }
            if (count == 0) {

            temp = -1;
            if (!Character.isDigit(arrOfStr[curLine].charAt(i))) {
                if (arrOfStr[curLine].charAt(i) == 'A')
                    temp = 14;
                if (arrOfStr[curLine].charAt(i) == 'K')
                    temp = 13;
                if (arrOfStr[curLine].charAt(i) == 'Q')
                    temp = 12;
                if (arrOfStr[curLine].charAt(i) == 'J')
                    temp = 11;
                if (arrOfStr[curLine].charAt(i) == 'T')
                    temp = 10;
            } else {
                temp = Integer.parseInt(String.valueOf(arrOfStr[curLine].charAt(i)));
                //System.out.println(arrOfStr[curLine].charAt(i));
            }

            curLineHand.add((int) temp);
        }
    }

        if (curLineHand.size() > checkCaseHand.size()) {
            System.out.println("return 1");
            return 1;
        }
        else if(curLineHand.size() < checkCaseHand.size()) {
            System.out.println("return -1");
            return -1;
        }
        else {


            for(int i=0; i < 5; i++) {
                int temp1 = 1;
                for(int j=i+1; j<5; j++) {
                    if(arrOfStr[checkCase].charAt(i) == arrOfStr[checkCase].charAt(j)) {
                        temp1++;
                    }
                }
                if(temp1 > checkCaseCount)
                    checkCaseCount = temp1;
            }


            for(int i=0; i < 5; i++) {
                int temp1 = 1;
                for(int j=i+1; j<5; j++) {
                    if(arrOfStr[curLine].charAt(i) == arrOfStr[curLine].charAt(j)) {
                        temp1++;
                    }
                }
                if(temp1 > curLineCount)
                    curLineCount = temp1;
            }

            if(curLineCount < checkCaseCount) {
                System.out.println("count check return 1");
                return 1;
            }
            else if(curLineCount > checkCaseCount) {
                System.out.println("count check return -1");
                return -1;
            }






            for(int i = 0; i < curLineHand.size(); i++) {

                int curLineCur = -1;
                if (!Character.isDigit(arrOfStr[curLine].charAt(i))) {
                    if (arrOfStr[curLine].charAt(i) == 'A')
                        curLineCur = 14;
                    if (arrOfStr[curLine].charAt(i) == 'K')
                        curLineCur = 13;
                    if (arrOfStr[curLine].charAt(i) == 'Q')
                        curLineCur = 12;
                    if (arrOfStr[curLine].charAt(i) == 'J')
                        curLineCur = 11;
                    if (arrOfStr[curLine].charAt(i) == 'T')
                        curLineCur = 10;
                } else {
                    curLineCur = Integer.parseInt(String.valueOf(arrOfStr[curLine].charAt(i)));
                    //System.out.println(arrOfStr[curLine].charAt(i));
                }

                int intCheckCaseCur = -1;
                if (!Character.isDigit(arrOfStr[checkCase].charAt(i))) {
                    if (arrOfStr[checkCase].charAt(i) == 'A')
                        intCheckCaseCur = 14;
                    if (arrOfStr[checkCase].charAt(i) == 'K')
                        intCheckCaseCur = 13;
                    if (arrOfStr[checkCase].charAt(i) == 'Q')
                        intCheckCaseCur = 12;
                    if (arrOfStr[checkCase].charAt(i) == 'J')
                        intCheckCaseCur = 11;
                    if (arrOfStr[checkCase].charAt(i) == 'T')
                        intCheckCaseCur = 10;
                } else {
                    intCheckCaseCur = Integer.parseInt(String.valueOf(arrOfStr[checkCase].charAt(i)));
                    //System.out.println(arrOfStr[checkCase].charAt(i));
                }

                if(curLineHand.size() == checkCaseHand.size() && curLineCur < intCheckCaseCur) {
                    System.out.println("i returned 1");
                    return 1;
                }
                else if(curLineHand.size() == checkCaseHand.size() && curLineCur > intCheckCaseCur) {
                    System.out.println("i returned -1");
                    return -1;
                }
            }
        }
        /*System.out.println("negative 1!");
        return -1;*/
        return -100000000;

    }

    private static int convertCharToInt(char ch) {
        if (Character.isDigit(ch)) {
            return Character.getNumericValue(ch);
        } else {
            switch (ch) {
                case 'A':
                    return 14;
                case 'K':
                    return 13;
                case 'Q':
                    return 12;
                case 'J':
                    return 11;
                case 'T':
                    return 10;
                default:
                    return -1; // Or handle this case as you see fit
            }
        }
    }

    static void in() {
        in = "424KT 464\n" +
                "3J4QA 723\n" +
                "94Q85 210\n" +
                "25722 304\n" +
                "Q4QQQ 176\n" +
                "3J777 548\n" +
                "37687 944\n" +
                "8J6TK 274\n" +
                "99TQA 623\n" +
                "58389 577\n" +
                "AAAQA 346\n" +
                "33A66 773\n" +
                "2K2K7 626\n" +
                "37776 242\n" +
                "ATAA5 750\n" +
                "T46KA 551\n" +
                "99J9T 916\n" +
                "Q4Q7Q 307\n" +
                "9JA4A 90\n" +
                "TT2KQ 19\n" +
                "TTAT8 483\n" +
                "28J28 915\n" +
                "55222 995\n" +
                "67666 766\n" +
                "99933 783\n" +
                "6T6J6 823\n" +
                "KKK9K 175\n" +
                "A9KK9 799\n" +
                "QTQ88 920\n" +
                "9T9KT 777\n" +
                "T63J9 159\n" +
                "6JJ36 898\n" +
                "229T2 17\n" +
                "J9QJ5 250\n" +
                "8K3Q6 42\n" +
                "QQ6Q3 252\n" +
                "K8JK7 320\n" +
                "32523 510\n" +
                "TQ33J 507\n" +
                "J227J 913\n" +
                "835JJ 169\n" +
                "TJT22 354\n" +
                "QQQ79 870\n" +
                "77776 333\n" +
                "78TQ2 466\n" +
                "27J27 229\n" +
                "A5A5A 987\n" +
                "88444 135\n" +
                "T7TTT 908\n" +
                "AKTKK 297\n" +
                "3678J 496\n" +
                "Q6JQQ 742\n" +
                "644T6 877\n" +
                "59699 653\n" +
                "A98J8 656\n" +
                "48466 815\n" +
                "66J85 316\n" +
                "KK45K 94\n" +
                "88777 968\n" +
                "28565 895\n" +
                "T24T6 367\n" +
                "77K84 557\n" +
                "5A32T 714\n" +
                "QQQ28 998\n" +
                "A333A 1\n" +
                "373J3 144\n" +
                "JQJK4 439\n" +
                "9K44K 262\n" +
                "KJKKJ 641\n" +
                "Q6AAA 862\n" +
                "492A9 18\n" +
                "8Q69Q 829\n" +
                "6K6KT 192\n" +
                "QK5K5 865\n" +
                "JA254 907\n" +
                "JTK99 406\n" +
                "87888 705\n" +
                "553Q6 655\n" +
                "95577 731\n" +
                "77775 88\n" +
                "A223A 369\n" +
                "7J7J8 455\n" +
                "48TA5 352\n" +
                "3TJ5A 451\n" +
                "6669Q 685\n" +
                "6T6TJ 275\n" +
                "77969 505\n" +
                "66966 616\n" +
                "55985 124\n" +
                "8TTT2 337\n" +
                "97777 272\n" +
                "6A8T5 502\n" +
                "353AT 622\n" +
                "K47A2 966\n" +
                "22A22 418\n" +
                "675J4 665\n" +
                "7A3A3 919\n" +
                "6J5A2 734\n" +
                "22227 707\n" +
                "Q7AQA 79\n" +
                "23T42 825\n" +
                "6K58Q 843\n" +
                "K5J69 68\n" +
                "JKT4K 683\n" +
                "T5T9T 628\n" +
                "4J434 53\n" +
                "KKAQA 982\n" +
                "TTTAT 861\n" +
                "T2722 757\n" +
                "3A8J3 16\n" +
                "K53T3 375\n" +
                "T47T9 668\n" +
                "73269 806\n" +
                "J6AK8 443\n" +
                "44544 189\n" +
                "A83A8 914\n" +
                "T264Q 253\n" +
                "33732 539\n" +
                "6K544 223\n" +
                "J8TTT 933\n" +
                "QQKK5 725\n" +
                "AJ98T 767\n" +
                "A847T 35\n" +
                "J646K 98\n" +
                "98999 630\n" +
                "AA9JA 582\n" +
                "6K3TJ 196\n" +
                "77JT7 151\n" +
                "K594J 125\n" +
                "53K33 290\n" +
                "664AA 572\n" +
                "JT7AA 621\n" +
                "Q8886 433\n" +
                "K9599 857\n" +
                "33J3T 292\n" +
                "5555J 66\n" +
                "AA456 69\n" +
                "887AA 934\n" +
                "7T5TT 639\n" +
                "QQAKK 254\n" +
                "98995 593\n" +
                "88987 108\n" +
                "T5T5T 118\n" +
                "7TA2J 737\n" +
                "QQ58J 996\n" +
                "6T66T 972\n" +
                "T88QT 314\n" +
                "3T33Q 535\n" +
                "9K2K7 428\n" +
                "2T884 956\n" +
                "33535 231\n" +
                "868AK 185\n" +
                "QQQQ7 47\n" +
                "22TA2 924\n" +
                "KT842 48\n" +
                "65932 652\n" +
                "KT276 21\n" +
                "54554 434\n" +
                "7A7A6 818\n" +
                "TTJTQ 833\n" +
                "J7A98 850\n" +
                "AJ67Q 637\n" +
                "A8A88 564\n" +
                "9955J 10\n" +
                "TTT4T 740\n" +
                "36662 204\n" +
                "2222J 15\n" +
                "J8998 437\n" +
                "T6T62 457\n" +
                "A24J3 249\n" +
                "AAAA2 474\n" +
                "36566 796\n" +
                "2T27T 602\n" +
                "KAKTA 597\n" +
                "84JQ3 592\n" +
                "QTQ2T 215\n" +
                "66J66 423\n" +
                "T3Q47 62\n" +
                "A6AAA 533\n" +
                "T99TJ 868\n" +
                "888TJ 485\n" +
                "6J5Q2 821\n" +
                "J9499 610\n" +
                "39KKK 606\n" +
                "QAQQA 436\n" +
                "75775 584\n" +
                "884AT 157\n" +
                "3T636 162\n" +
                "97666 509\n" +
                "J5T5T 270\n" +
                "332T9 246\n" +
                "J4KKK 257\n" +
                "96T69 900\n" +
                "QQQ38 411\n" +
                "74A74 309\n" +
                "JJJJJ 835\n" +
                "AA3A2 372\n" +
                "2JA99 860\n" +
                "29KK2 642\n" +
                "4T4JQ 981\n" +
                "944J9 604\n" +
                "TQT66 939\n" +
                "25295 673\n" +
                "59J45 603\n" +
                "62846 356\n" +
                "444K4 869\n" +
                "8QJQQ 371\n" +
                "33Q43 416\n" +
                "KK333 567\n" +
                "TQQ96 46\n" +
                "2A2A9 478\n" +
                "4J574 784\n" +
                "6A6AA 13\n" +
                "4A646 385\n" +
                "33575 70\n" +
                "9A989 407\n" +
                "42549 576\n" +
                "AAA88 154\n" +
                "A5AAJ 7\n" +
                "J842K 99\n" +
                "J99A9 305\n" +
                "56J9A 357\n" +
                "JT574 758\n" +
                "55545 199\n" +
                "55525 884\n" +
                "A3KA3 497\n" +
                "4J828 180\n" +
                "33QJ3 804\n" +
                "5QQQA 105\n" +
                "Q9JJQ 452\n" +
                "8256J 635\n" +
                "6Q4TQ 774\n" +
                "Q5AA5 549\n" +
                "J8TKA 84\n" +
                "75557 928\n" +
                "KA2Q3 67\n" +
                "44944 339\n" +
                "46ATJ 697\n" +
                "A8A9T 657\n" +
                "3Q33A 197\n" +
                "8Q88Q 454\n" +
                "24433 334\n" +
                "23333 531\n" +
                "57Q6T 198\n" +
                "KT46J 736\n" +
                "84T36 554\n" +
                "99333 241\n" +
                "K5K97 31\n" +
                "QQQ76 321\n" +
                "339J6 57\n" +
                "22522 993\n" +
                "24KKJ 643\n" +
                "6K888 413\n" +
                "4Q44Q 873\n" +
                "2K222 400\n" +
                "83494 239\n" +
                "TJ5KA 238\n" +
                "T6J5K 579\n" +
                "JQTQQ 283\n" +
                "A5J52 461\n" +
                "J75K6 575\n" +
                "KT7KK 885\n" +
                "7KJ7K 200\n" +
                "J2KA2 985\n" +
                "33343 167\n" +
                "29999 3\n" +
                "88882 618\n" +
                "2K666 552\n" +
                "7777T 724\n" +
                "99966 792\n" +
                "443JT 284\n" +
                "K2KJQ 494\n" +
                "K4T36 392\n" +
                "7JQQJ 787\n" +
                "555KJ 528\n" +
                "7K5Q8 834\n" +
                "23743 589\n" +
                "KKAKA 482\n" +
                "J9J29 600\n" +
                "5TT55 205\n" +
                "345KT 178\n" +
                "5TQ28 820\n" +
                "J7T6J 888\n" +
                "39TJ7 710\n" +
                "6QJ92 546\n" +
                "A28JK 782\n" +
                "44482 703\n" +
                "AJ2K5 743\n" +
                "94944 310\n" +
                "J29A4 340\n" +
                "T7932 948\n" +
                "7A468 131\n" +
                "ATK5T 145\n" +
                "QQQJJ 287\n" +
                "598JA 319\n" +
                "52242 216\n" +
                "J6J66 222\n" +
                "KTJT2 540\n" +
                "55885 511\n" +
                "TTTT2 132\n" +
                "3A757 947\n" +
                "2A322 38\n" +
                "858AJ 863\n" +
                "55557 293\n" +
                "AQ8J9 220\n" +
                "3675Q 695\n" +
                "7KQJ8 306\n" +
                "85A7Q 460\n" +
                "3J3J3 143\n" +
                "6A6AJ 594\n" +
                "84383 715\n" +
                "83388 847\n" +
                "6666K 104\n" +
                "5728A 952\n" +
                "J555J 763\n" +
                "7TQQQ 515\n" +
                "6TTT6 844\n" +
                "Q739Q 961\n" +
                "58TT7 276\n" +
                "66JK6 812\n" +
                "779Q9 384\n" +
                "AJAJA 165\n" +
                "88J39 838\n" +
                "K25QA 991\n" +
                "442J4 727\n" +
                "9K8K9 149\n" +
                "AAAA7 335\n" +
                "638J6 207\n" +
                "888JK 25\n" +
                "444T4 129\n" +
                "Q4A5K 527\n" +
                "9A9A9 671\n" +
                "TT5K8 570\n" +
                "9999T 795\n" +
                "A8A8J 692\n" +
                "J9993 345\n" +
                "867A9 684\n" +
                "J7Q8A 359\n" +
                "J37TT 932\n" +
                "77297 12\n" +
                "29QT4 964\n" +
                "7Q767 976\n" +
                "TTTJ4 689\n" +
                "59555 415\n" +
                "4J44J 896\n" +
                "69J87 649\n" +
                "99495 826\n" +
                "5QT5J 86\n" +
                "Q7QK6 713\n" +
                "2JJ25 296\n" +
                "8Q686 393\n" +
                "QQ966 619\n" +
                "JJTTT 537\n" +
                "K9253 563\n" +
                "59AQ3 702\n" +
                "53482 364\n" +
                "2KKK2 807\n" +
                "8J6AJ 232\n" +
                "48TT9 161\n" +
                "Q64Q8 615\n" +
                "AAAJ6 122\n" +
                "2J72Q 74\n" +
                "493K2 585\n" +
                "4TJ86 793\n" +
                "32K2K 526\n" +
                "65565 659\n" +
                "989JK 404\n" +
                "T235K 880\n" +
                "27AQ2 568\n" +
                "354T7 738\n" +
                "K777J 646\n" +
                "8JJJJ 303\n" +
                "27329 620\n" +
                "69892 596\n" +
                "3797J 687\n" +
                "5977A 588\n" +
                "T58K9 566\n" +
                "TTTJT 897\n" +
                "75Q46 456\n" +
                "9Q999 890\n" +
                "85J2A 130\n" +
                "33368 744\n" +
                "K7KKK 45\n" +
                "T5459 285\n" +
                "888J5 690\n" +
                "6676Q 251\n" +
                "56QJT 11\n" +
                "TKQJK 722\n" +
                "9QT3T 803\n" +
                "55KKJ 645\n" +
                "3357J 814\n" +
                "KK685 308\n" +
                "K4TKK 332\n" +
                "33296 343\n" +
                "2T4K7 836\n" +
                "32232 629\n" +
                "2K8A5 164\n" +
                "J2Q98 578\n" +
                "2T22T 810\n" +
                "3Q3QJ 607\n" +
                "Q393K 927\n" +
                "3AAAA 440\n" +
                "9J374 341\n" +
                "7A777 484\n" +
                "3J355 711\n" +
                "9TTT6 752\n" +
                "T6Q5T 121\n" +
                "Q287Q 648\n" +
                "8988T 472\n" +
                "3KQ52 957\n" +
                "7TTT7 226\n" +
                "AJKK7 177\n" +
                "AA555 295\n" +
                "Q2QJQ 396\n" +
                "68868 498\n" +
                "9Q34Q 941\n" +
                "588K8 946\n" +
                "47J53 386\n" +
                "QJ44A 348\n" +
                "37977 217\n" +
                "88JJ8 855\n" +
                "36663 808\n" +
                "T69A8 174\n" +
                "47AA4 883\n" +
                "36444 504\n" +
                "2K22K 943\n" +
                "565TJ 431\n" +
                "33Q33 571\n" +
                "J28JK 414\n" +
                "38Q4Q 609\n" +
                "T777T 662\n" +
                "QKQTQ 54\n" +
                "3327J 492\n" +
                "2T4A9 59\n" +
                "6A7K4 60\n" +
                "99889 6\n" +
                "K2QA8 425\n" +
                "76467 141\n" +
                "5JJA5 102\n" +
                "QJKQ9 909\n" +
                "QQQ8Q 936\n" +
                "96J63 832\n" +
                "624J7 36\n" +
                "86666 109\n" +
                "A44AA 854\n" +
                "T2987 892\n" +
                "64A65 230\n" +
                "Q677T 841\n" +
                "T476T 458\n" +
                "JA6TQ 315\n" +
                "KKJKK 959\n" +
                "33363 631\n" +
                "6Q6Q8 675\n" +
                "77474 398\n" +
                "J623J 134\n" +
                "Q3JTT 953\n" +
                "55787 779\n" +
                "AAAQQ 770\n" +
                "52342 247\n" +
                "779T7 625\n" +
                "J22J2 77\n" +
                "3J3Q5 699\n" +
                "9KKJK 412\n" +
                "4QJ42 273\n" +
                "666Q6 355\n" +
                "4Q4K8 101\n" +
                "T4236 183\n" +
                "QJ9Q8 476\n" +
                "99995 716\n" +
                "28283 327\n" +
                "4Q9T8 910\n" +
                "968T2 983\n" +
                "24444 647\n" +
                "846K5 765\n" +
                "37KTJ 453\n" +
                "J7888 904\n" +
                "K6T73 358\n" +
                "TKKTT 681\n" +
                "59939 116\n" +
                "62222 840\n" +
                "73757 382\n" +
                "44677 34\n" +
                "KKQJK 311\n" +
                "K4AJ2 856\n" +
                "7J3J7 513\n" +
                "A69K5 347\n" +
                "2A2JJ 388\n" +
                "T34AQ 781\n" +
                "3KKJ9 50\n" +
                "78447 63\n" +
                "72727 617\n" +
                "KK535 73\n" +
                "25562 184\n" +
                "3Q855 227\n" +
                "Q46K8 245\n" +
                "9QQ99 87\n" +
                "T2A47 387\n" +
                "47499 544\n" +
                "J4279 22\n" +
                "2QQ2Q 935\n" +
                "4484T 331\n" +
                "666J5 450\n" +
                "6QQ67 491\n" +
                "76KT4 940\n" +
                "357Q8 160\n" +
                "7KK2Q 764\n" +
                "2J662 323\n" +
                "5A858 444\n" +
                "955TJ 830\n" +
                "K927Q 595\n" +
                "8JQAT 64\n" +
                "8A3QJ 138\n" +
                "JA3K5 302\n" +
                "55Q55 644\n" +
                "48888 71\n" +
                "923J2 432\n" +
                "Q6Q5K 182\n" +
                "29929 403\n" +
                "29466 612\n" +
                "TQQQQ 58\n" +
                "99J82 467\n" +
                "K84A2 363\n" +
                "93493 420\n" +
                "55J46 106\n" +
                "449J4 886\n" +
                "K3332 871\n" +
                "JJ83K 350\n" +
                "6J4T6 72\n" +
                "6T655 163\n" +
                "39877 424\n" +
                "73AA7 613\n" +
                "K6664 173\n" +
                "44T93 994\n" +
                "Q937K 136\n" +
                "J2J4T 694\n" +
                "56AQ9 517\n" +
                "Q4TJQ 419\n" +
                "7K774 789\n" +
                "6672J 218\n" +
                "J585A 894\n" +
                "85J87 2\n" +
                "6A3KJ 827\n" +
                "45559 103\n" +
                "25J44 828\n" +
                "6K6K5 225\n" +
                "37737 790\n" +
                "78887 447\n" +
                "J363K 963\n" +
                "533TT 442\n" +
                "497TK 81\n" +
                "22992 902\n" +
                "48864 80\n" +
                "Q5AK6 661\n" +
                "KKQKK 115\n" +
                "58Q9T 771\n" +
                "J4444 717\n" +
                "3QQ3A 256\n" +
                "23622 366\n" +
                "6A497 373\n" +
                "7777J 732\n" +
                "92A86 719\n" +
                "929Q2 899\n" +
                "3JA3A 536\n" +
                "TJ38J 459\n" +
                "93654 967\n" +
                "29K3A 353\n" +
                "K48JA 864\n" +
                "44Q3Q 556\n" +
                "J4A39 728\n" +
                "76A77 522\n" +
                "52959 374\n" +
                "675Q6 922\n" +
                "J55T8 819\n" +
                "22392 95\n" +
                "33223 514\n" +
                "K494J 876\n" +
                "82JTQ 166\n" +
                "A9J77 410\n" +
                "6J8Q7 221\n" +
                "KKK44 801\n" +
                "22A34 322\n" +
                "8JAQQ 561\n" +
                "9899J 543\n" +
                "Q9K99 524\n" +
                "2JTQ9 51\n" +
                "62642 465\n" +
                "QJ55A 317\n" +
                "63QA4 172\n" +
                "99Q8Q 965\n" +
                "4444Q 678\n" +
                "QQ2J3 427\n" +
                "22828 234\n" +
                "3A858 788\n" +
                "KQKTK 918\n" +
                "A4939 96\n" +
                "76J34 521\n" +
                "227J5 219\n" +
                "2AQ78 525\n" +
                "74J4T 906\n" +
                "3T33T 168\n" +
                "JTT98 917\n" +
                "9J749 878\n" +
                "96999 590\n" +
                "654K7 640\n" +
                "35AJ8 1000\n" +
                "72934 837\n" +
                "7Q6J7 718\n" +
                "77859 265\n" +
                "2AJKQ 508\n" +
                "2J322 282\n" +
                "JJ665 569\n" +
                "92222 762\n" +
                "5222T 435\n" +
                "T9JTA 786\n" +
                "AA853 848\n" +
                "8AAAJ 555\n" +
                "3J29A 760\n" +
                "4A5AJ 75\n" +
                "5874Q 313\n" +
                "49T44 542\n" +
                "T8TQ4 636\n" +
                "99955 140\n" +
                "8QQ8A 500\n" +
                "727J7 676\n" +
                "48884 119\n" +
                "6KA66 409\n" +
                "66566 748\n" +
                "Q6QJ4 611\n" +
                "4A87J 78\n" +
                "TT888 376\n" +
                "28Q89 344\n" +
                "28777 805\n" +
                "35543 797\n" +
                "4T522 278\n" +
                "636AA 233\n" +
                "26K5A 228\n" +
                "2A9Q7 506\n" +
                "23299 194\n" +
                "J3AAJ 29\n" +
                "66466 286\n" +
                "AT878 43\n" +
                "Q46J6 324\n" +
                "63J66 721\n" +
                "TK9JQ 741\n" +
                "95Q5Q 960\n" +
                "22T22 686\n" +
                "5KK7K 381\n" +
                "Q85QQ 852\n" +
                "39799 701\n" +
                "T38TK 730\n" +
                "QQK22 28\n" +
                "69QAT 633\n" +
                "23663 545\n" +
                "QQ6AQ 261\n" +
                "A7KA7 845\n" +
                "TJ7JT 351\n" +
                "T5888 37\n" +
                "KKK86 867\n" +
                "66JJ2 581\n" +
                "6686J 632\n" +
                "A93AJ 243\n" +
                "J23K5 739\n" +
                "5599K 955\n" +
                "TT323 477\n" +
                "KTK9K 390\n" +
                "Q757Q 258\n" +
                "6699J 530\n" +
                "65QQT 745\n" +
                "9K2AA 520\n" +
                "46J3T 441\n" +
                "3828J 9\n" +
                "TT3T8 733\n" +
                "56A92 712\n" +
                "AAJ7A 389\n" +
                "22749 401\n" +
                "55237 925\n" +
                "46JJ3 471\n" +
                "97K65 945\n" +
                "Q8K8J 658\n" +
                "QJ2QA 990\n" +
                "99AAJ 408\n" +
                "6Q665 181\n" +
                "75AAA 362\n" +
                "65J84 746\n" +
                "76667 391\n" +
                "3735K 421\n" +
                "7QQ99 235\n" +
                "K3333 139\n" +
                "44844 759\n" +
                "Q8955 395\n" +
                "97972 291\n" +
                "6T68T 794\n" +
                "24A42 56\n" +
                "8262J 706\n" +
                "64442 754\n" +
                "QQKJQ 289\n" +
                "7J62J 394\n" +
                "5T555 288\n" +
                "4K669 997\n" +
                "J5Q9K 378\n" +
                "66663 729\n" +
                "Q2233 921\n" +
                "JJ557 780\n" +
                "3T43T 809\n" +
                "6K866 937\n" +
                "52527 264\n" +
                "AAKJK 516\n" +
                "KKKK3 978\n" +
                "92J2T 541\n" +
                "T4248 753\n" +
                "J746Q 726\n" +
                "JJ36K 969\n" +
                "2QTA4 49\n" +
                "J3JKK 558\n" +
                "A6J7T 405\n" +
                "AAT7T 693\n" +
                "J8886 688\n" +
                "Q49Q4 370\n" +
                "5258J 187\n" +
                "4A49J 4\n" +
                "KKK5K 992\n" +
                "7555K 110\n" +
                "289K6 638\n" +
                "76J7J 853\n" +
                "4JTKJ 775\n" +
                "KK2QQ 958\n" +
                "224Q3 41\n" +
                "QAJ6A 469\n" +
                "3KJJJ 866\n" +
                "6666T 128\n" +
                "34944 426\n" +
                "55675 137\n" +
                "85888 846\n" +
                "J8888 462\n" +
                "K6A5J 23\n" +
                "KKTKK 30\n" +
                "9T853 111\n" +
                "77479 749\n" +
                "86565 487\n" +
                "6K3JK 82\n" +
                "37333 156\n" +
                "572AK 336\n" +
                "33388 8\n" +
                "6T6K6 747\n" +
                "22K26 133\n" +
                "K2K7K 281\n" +
                "J999K 429\n" +
                "Q7474 202\n" +
                "AAAA8 650\n" +
                "TT3TT 171\n" +
                "55855 560\n" +
                "TKKJT 495\n" +
                "J4TA8 881\n" +
                "Q2J58 203\n" +
                "27767 123\n" +
                "4J8QJ 499\n" +
                "42KKK 709\n" +
                "29T9Q 32\n" +
                "J2KKT 224\n" +
                "77778 587\n" +
                "4K26Q 147\n" +
                "6A4A4 212\n" +
                "43JTQ 887\n" +
                "53559 704\n" +
                "4ATT4 605\n" +
                "5T77Q 113\n" +
                "KTTK6 33\n" +
                "A6A32 380\n" +
                "333J3 260\n" +
                "99J9J 931\n" +
                "A786K 114\n" +
                "74J25 667\n" +
                "98889 973\n" +
                "999J9 529\n" +
                "52KK6 858\n" +
                "55959 720\n" +
                "AA2JA 999\n" +
                "Q84AT 550\n" +
                "AAAQJ 660\n" +
                "99T59 266\n" +
                "K58K7 445\n" +
                "J2525 532\n" +
                "999A9 672\n" +
                "2225J 926\n" +
                "QKJQJ 438\n" +
                "JKTQ7 24\n" +
                "JQ929 468\n" +
                "989Q9 97\n" +
                "3JQQQ 942\n" +
                "4TT34 271\n" +
                "J8QQ8 475\n" +
                "8666T 989\n" +
                "2T83Q 422\n" +
                "J8J62 397\n" +
                "4369A 831\n" +
                "ATAJT 680\n" +
                "J3338 493\n" +
                "86668 813\n" +
                "36JAT 874\n" +
                "KAK3K 923\n" +
                "QKKA6 580\n" +
                "3J339 624\n" +
                "99676 152\n" +
                "42K84 155\n" +
                "KAA7K 682\n" +
                "QAQQQ 486\n" +
                "75747 669\n" +
                "A37T7 851\n" +
                "K6Q6K 20\n" +
                "T792A 61\n" +
                "33654 879\n" +
                "555J2 417\n" +
                "AA9A5 209\n" +
                "TK65K 368\n" +
                "42222 951\n" +
                "QQ666 970\n" +
                "6444J 44\n" +
                "6JJA5 190\n" +
                "4K4KT 489\n" +
                "2T2TT 27\n" +
                "6A666 986\n" +
                "35J55 962\n" +
                "AA277 817\n" +
                "5K4J5 55\n" +
                "93AJ9 237\n" +
                "8888Q 824\n" +
                "57355 39\n" +
                "22QA4 150\n" +
                "3572A 361\n" +
                "295A8 889\n" +
                "A63K7 842\n" +
                "8AJ8T 244\n" +
                "A8778 538\n" +
                "A77A7 83\n" +
                "T8559 89\n" +
                "TT999 480\n" +
                "K7JKK 562\n" +
                "3A3A8 677\n" +
                "9J6J6 523\n" +
                "T2684 470\n" +
                "8J6Q4 698\n" +
                "83T5Q 761\n" +
                "88AJ7 26\n" +
                "54J43 383\n" +
                "86J68 301\n" +
                "TQ443 107\n" +
                "8AAKA 255\n" +
                "QJK7K 670\n" +
                "2QQ9J 201\n" +
                "34674 839\n" +
                "3232J 905\n" +
                "8A82A 5\n" +
                "89K88 519\n" +
                "83666 338\n" +
                "A2382 772\n" +
                "858J5 583\n" +
                "8AK92 651\n" +
                "K58T7 930\n" +
                "55AJ5 170\n" +
                "77288 891\n" +
                "KA57T 14\n" +
                "JQ8QJ 329\n" +
                "QQ88Q 929\n" +
                "48573 279\n" +
                "4K4KJ 980\n" +
                "46Q7A 601\n" +
                "79J89 267\n" +
                "9T994 402\n" +
                "27T9K 800\n" +
                "36363 822\n" +
                "83486 769\n" +
                "723QT 112\n" +
                "84794 236\n" +
                "2Q22Q 691\n" +
                "98888 213\n" +
                "AKKA9 872\n" +
                "A57K5 365\n" +
                "27K34 100\n" +
                "555QQ 565\n" +
                "5KK55 299\n" +
                "6Q345 360\n" +
                "7JQAA 512\n" +
                "A8434 211\n" +
                "TKA93 503\n" +
                "93333 463\n" +
                "AJAAA 146\n" +
                "996Q6 263\n" +
                "88838 501\n" +
                "KK56K 971\n" +
                "K24T2 330\n" +
                "J3888 473\n" +
                "KA968 127\n" +
                "5466J 700\n" +
                "A9893 268\n" +
                "K7J78 666\n" +
                "44Q54 312\n" +
                "K3QTQ 984\n" +
                "6JQA6 778\n" +
                "Q2764 938\n" +
                "A99AK 481\n" +
                "A77JA 802\n" +
                "38868 679\n" +
                "4KK34 300\n" +
                "66KK6 318\n" +
                "AA626 674\n" +
                "7738J 449\n" +
                "JTJTJ 859\n" +
                "T8TJ8 93\n" +
                "96K99 574\n" +
                "77339 349\n" +
                "T7QAQ 534\n" +
                "95384 342\n" +
                "62226 950\n" +
                "3JQA3 298\n" +
                "9A9A7 488\n" +
                "87JT7 559\n" +
                "88688 518\n" +
                "526KQ 188\n" +
                "8K8K8 756\n" +
                "7JJ77 490\n" +
                "J3KAK 785\n" +
                "J4733 153\n" +
                "42T24 977\n" +
                "2QQ5Q 280\n" +
                "Q49A3 768\n" +
                "98JT6 911\n" +
                "T3333 193\n" +
                "ATKTT 91\n" +
                "2785Q 949\n" +
                "QQQJQ 811\n" +
                "T8K4Q 547\n" +
                "K66KK 446\n" +
                "22JK9 634\n" +
                "224J2 776\n" +
                "5QQQ4 614\n" +
                "2T2KJ 755\n" +
                "4Q7T9 979\n" +
                "J3T77 974\n" +
                "7J259 206\n" +
                "A458K 627\n" +
                "A89AJ 248\n" +
                "JJJ99 893\n" +
                "A3862 377\n" +
                "4J4AJ 40\n" +
                "TA7T7 663\n" +
                "4K4T6 664\n" +
                "TT6TT 988\n" +
                "J6583 126\n" +
                "TA4TT 791\n" +
                "44457 696\n" +
                "T72JJ 269\n" +
                "A22A2 553\n" +
                "J7JJ7 654\n" +
                "2J7J7 903\n" +
                "795KA 191\n" +
                "2445T 912\n" +
                "9553Q 195\n" +
                "KK74J 328\n" +
                "55335 399\n" +
                "A5Q2J 430\n" +
                "9QJJ6 85\n" +
                "5QTK7 954\n" +
                "Q539J 92\n" +
                "4JT6T 798\n" +
                "TKJT9 608\n" +
                "72722 735\n" +
                "84438 186\n" +
                "3J3K3 179\n" +
                "3Q3Q3 882\n" +
                "JQQKK 975\n" +
                "66AA5 158\n" +
                "72J57 849\n" +
                "25KAA 751\n" +
                "88T88 599\n" +
                "J293K 120\n" +
                "85KA8 294\n" +
                "J8948 598\n" +
                "8679Q 52\n" +
                "A639K 591\n" +
                "J679T 326\n" +
                "T4774 816\n" +
                "7QQ4J 208\n" +
                "2JQ22 76\n" +
                "QA6A6 379\n" +
                "Q5JA8 708\n" +
                "KJ693 479\n" +
                "9K25A 148\n" +
                "A4A72 277\n" +
                "T2QQQ 573\n" +
                "72777 214\n" +
                "J222K 448\n" +
                "T2T6J 259\n" +
                "57A83 117\n" +
                "JJ8K8 325\n" +
                "JT92A 65\n" +
                "53288 142\n" +
                "A22AA 240\n" +
                "8T772 586\n" +
                "QQQ5Q 875\n" +
                "Q89TT 901";
    }

}
