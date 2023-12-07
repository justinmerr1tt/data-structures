package day3.src;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day3 {

    private static String in;
    private static String[] arrOfStr;
    private static int sumEngine = 0;

    public static void main(String[] args) {
        setInput();
        arrOfStr = in.split("\n", -1);
        findNumber();
        //isSpecial();
    }

    private static void findNumber() {
        for (int line = 0; line < arrOfStr.length; line++) {

            Pattern pattern = Pattern.compile("\\d");
            Matcher matcher = pattern.matcher(arrOfStr[line]);

            if (matcher.find()) {
                int numStart = matcher.start();
                int numEnd = matcher.end();
                if (squareIsValid(numStart, numEnd, line)) {
                    sumEngine += Integer.parseInt(matcher.group(1));
                }
            }
        }
        System.out.println(sumEngine);
    }

    private static boolean squareIsValid(int numStart, int numEnd, int curLine) {
        ArrayList<Character> squareAround = new ArrayList<Character>();



        if(numStart - 1 < 0)
            squareAround.add(0, '0');
        else
            squareAround.add(0, arrOfStr[curLine].charAt(numStart - 1));

        if(numEnd >= arrOfStr[curLine].length())
            squareAround.add(1, '1');
        else
            squareAround.add(1, arrOfStr[curLine].charAt(numEnd));

        if(numStart - 1 < 0 || curLine - 1 < 0)
            squareAround.add(2, '2');
        else
            squareAround.add(2, arrOfStr[curLine - 1].charAt(numStart - 1));

        if(numStart - 1 < 0 || curLine + 1 >= arrOfStr.length)
            squareAround.add(3, '4');
        else
            squareAround.add(3, arrOfStr[curLine + 1].charAt(numStart - 1));

        if (curLine - 1 < 0 || numEnd >= arrOfStr[curLine].length())
            squareAround.add(4, '3');
        else
            squareAround.add(4, arrOfStr[curLine - 1].charAt(numEnd));

        if (curLine + 1 >= arrOfStr.length || numEnd >= arrOfStr[curLine].length())
            squareAround.add(5, '5');
        else
            squareAround.add(5, arrOfStr[curLine + 1].charAt(numEnd));



        for (int i = numStart; i < numEnd; i++) {
            if (curLine -1 < 0)
                squareAround.add('9');
            else
                squareAround.add(arrOfStr[curLine - 1].charAt(i));

            if (curLine + 1 >= arrOfStr.length)
                squareAround.add('8');
            else
                squareAround.add(arrOfStr[curLine + 1].charAt(i));
        }

        Pattern pattern = Pattern.compile("([^.\\d])");

        for (char curChar : squareAround) {
            String charAsString = String.valueOf(curChar);
            Matcher matcher = pattern.matcher(charAsString);

            if (!matcher.find()) {
                return false;
            }
        }
        return true;
    }


    /*static boolean isSpecial(int numStart, int numEnd) {



        for (int line = 0; line < arrOfStr.length; line++) {

            Pattern pattern = Pattern.compile("([^.\\d])");
            Matcher matcher = pattern.matcher(arrOfStr[line]);

            int start = matcher.start();
            int end = matcher.end();
            char specialCharacter = -1;

            if (matcher.find()) {
                specialCharacter = Integer.parseInt(matcher.group(1));
            }
        }
    }*/


        private static void setInput () {
            in = "..............423....688..934............970................................95.728..........896...113..................153..972.............\n" +
                    "...122..................*.....*..........................919..509*..........&...@.........../...........................+.......*...........\n" +
                    "....+..........259....698..373.992.52.674.........................781...22........130.584.....-...%399.......777.................266........\n" +
                    "......148..+....*........................*.....357.123.......................812.........*756.143...........*...............................\n" +
                    "..691*.....700..708................-...357........*........$177......%..244.............................762.453....477-.707..-168..359*.....\n" +
                    ".......................394.443....456......750..................71.160.....*..183.........835..74.........*.............../............129..\n" +
                    "....578$....................%........................362..1......*.......661....*...........=.....730......744..294..........247............\n" +
                    "..............415...306*....../.452.................+.....*......375.............76....186*....../...............*..........@.......-..441..\n" +
                    ".....*152......#........75.757.......204%..................605.............................77.......%405.......957..324...........404.......\n" +
                    "..545.............../...........................................*....618......%...599...............................&....43.............=...\n" +
                    "..............902...145............170..............568..741.285.592..........54./.......%.......923......522+..........*..../...128....602.\n" +
                    ".......697.16*................322...........$............*............+339..........633.56............$..............792..751...............\n" +
                    ".......*.........................*..752..826.......*...104..861......................................144.....883...............+..778.892...\n" +
                    "......968..690.......#.....769#.718...*.........326..........*..............493..123..........362...........*.........757....570..@....*....\n" +
                    "..681.................242............806................509...307..../.....*......./.350..942...*..614@...511........+.................151..\n" +
                    "........*....../..256.......................235.....923....*..........28..264........*......&..316..............945....522........*823......\n" +
                    ".....961.136.567....................944.......*..........500..-.......................504................765$..........=.......563..........\n" +
                    "..................837..823......480.....627....984.#.........136....969..........-289......$757............................107........593...\n" +
                    ".74.924....../.............+110....*...............511................+....564......................389%.....989*305....@...*.........*.....\n" +
                    ".......+......110..735..........647....658.509*378..........-999............*....#225....937.............147.........778...868.....871..611.\n" +
                    ".........$...........*.....3............*...........................608..842..............*.......589.......*....842...................*....\n" +
                    "......$.963.....634.....................569....&..........177................*..........774.........*..132.153..*.............=.......13....\n" +
                    "...723.........=.......@..324......455#.......417....849$.*.........*372..747.87............./358...35..*.......974..453...811...990........\n" +
                    ".....................174...%............949...............182....684.............414...................201.......................*...../....\n" +
                    "........@.......................62.....*.....-.@669.....................487......*................943.........740*...10.......298....384....\n" +
                    "....446.711.........20.674...........343..806.....................&.574.*........965..............*......776...........*.867................\n" +
                    "......*............&.......705.804.............................374....+.307............&.......683...830...*....625..530....*837...272*.....\n" +
                    ".......791....................*.......&.................108...........................533..............*...966.*.......................515..\n" +
                    "............412...../................764....................658.+292.635.674..337.................98..814......263.......720*...............\n" +
                    "..............*...469..162.....23......................*64..*...............*.............+.........*.....*552...............990......942...\n" +
                    "790.536.......365.......*..587..=..........................313.....512....983....953.......348.....617.982..................................\n" +
                    "........580............227...*....673.808....66......595............./........*............................$..........21..989...............\n" +
                    ".....#.....*.781...........688...*..../........=.........865...............316.162.440.............&......482.663....*.............529......\n" +
                    "...357...182.@......359=..........553.......#....33....................323.........*............702...........*....200........&.....*.......\n" +
                    "...............733....................957.22..........815.........................57..657@..................792..........%.....678.305......\n" +
                    "..701..246........*238....553..107......*...................301..........649.555..............70....................610.233.&...............\n" +
                    "....#...*..&.................$.*....$.......$......438.....*.......943......*.....&675..955*....*..........183...=....%.....595.............\n" +
                    "......719.857...640*299............202...125...802..#...786...........*.....................277.424..........*.790./...............984......\n" +
                    "...@......................368.....................*...............323..587.479....553.272.................843.......518.............*.......\n" +
                    "...382..........892...46..........359..372+.611..585...............*.......*........*...+........&.............................487...35.....\n" +
                    "........&692.......*..*..............@.......-.......*697.......656.....155....34..681............64..641......................*............\n" +
                    "....495..........885..964................993......685................%........*....................../..........543.........863.............\n" +
                    "..........*408................&....244.....*..........................893....339........................109.....................777.........\n" +
                    "...521.985..................677......*......734........18....925#................352...843*74.......&....*.............260.......*..........\n" +
                    "...$........445.$..................802...................#..........=........533...@.................228..612......724....*.................\n" +
                    ".............*..504............=.......*.....177...................502.....+..*.............395......................$.....274.....396......\n" +
                    "......................417....274.....61.504..*........36*..................34..801..........%............224......................*.........\n" +
                    "......789.........139......&.....*............802........674....&..332..............675............819.............814............883..+915.\n" +
                    "...@.....*.....-..*.....970...279.117...............984@.....878..........231*168.*..................*.........793*.........................\n" +
                    "..33..875.....483.433....................*.........................................148.675...581*.....544.........................*537......\n" +
                    "......................884............671..839.....31..........685..@...899....350*...............621........*509............./.913..........\n" +
                    "....947......=742..........*.......................*...............712....*.......722...159............378........438.....300...........381.\n" +
                    "...*....................548..-................*..638.....................827...........*......714/...../...867....$..................%.-....\n" +
                    "998.....966.693..............694...........781...........764......584...............233....58......-......*............67=........161.......\n" +
                    "...........*.....................509..-851.........&.846..#........../...199.................*.443..658..976.130..489..................594..\n" +
                    "243....413.........499-...384.......*............352.+.............................752....298..*...............$..$...............577...*...\n" +
                    "......*......................*......378.335.................*.........+...813.120.*....................654..........$........325...*...984..\n" +
                    "...847..496....151*...........741.......*............624.116....767.988..&.....*...87............807...*.........127....997+......621.......\n" +
                    "........*..........227....345......*........@.....................*............699....566..604...*...760....290.............................\n" +
                    "......526..................*..500..799...761...413*......277....101........$..........*.........342..........*.......589..997......=........\n" +
                    ".............+....379....549............................*............*97.647.779....$.655..975......216...............*.......51..307./496..\n" +
                    "...........485.......&...............................55...........509............825......+.....43.....*...554......36...678+.$.............\n" +
                    "..........................73.....419.....314../...........311...........$....946.....272............351...*........................968../...\n" +
                    ".....786.................*........-..824.$...478......908....*.....455.254.....*.........615....760.....60...$......&.....*562.........102..\n" +
                    ".......*......43.....&...808........*.............267.*...985.....*..........616.........../......*...........189....977........616.........\n" +
                    "......45.932...*.....502..........805...943.840%...*..270......764......680......................750..415*184......................*606.....\n" +
                    "..768....*.....941............%.......8.&..................*................248&..105..745...633...........................584..........692.\n" +
                    ".......684............115....88...396*..................494.354...88...58.....................*.........956......809...53.......615.........\n" +
                    "................*391.............................................$....%.....&64.............488...........$.........*.....*.......*.........\n" +
                    "......440.459...........637...*....866...412.519.183..../.......................*82..963.........*307..=......715.408..421.292....626..*....\n" +
                    ".........*......$..........#...769............./..*....470.939.+......*.....257.....*.........257.....109.578..*.......................290..\n" +
                    "......+.......-..897...............................629.....-...834.254.798..*.......411....................*....411.......309....218........\n" +
                    ".......960..744..............384............................................433................$301.....848.................*.......#..144..\n" +
                    "..746............$....../...........38$...536.....-....@.............*..................-............................320...471..........*...\n" +
                    "....*.............720...59......................260..852...........633.........714...510......256.173.23...850........*........#.....691....\n" +
                    "..294..434...264......................422../639..........378.493...........388*................-....*...*..../.141..............539.........\n" +
                    "........../.&........790..........@....*....................*..........&............$.............16....633.....=.....................458...\n" +
                    "..678...............&.......184....186.934..652...741%.........=887...980.425../....485.732...502...........%........745..............*.....\n" +
                    "...*..........98.......@......*.................+...........................*...989.....$........*......838.9..........-...........464......\n" +
                    ".975..768....*.....*..702.....979....511$....161....645..............44.....18............721.695...348.........400......./.543*............\n" +
                    "........*.769....320......724......................&.....330&........*...................*...........$...188.....*.....977......618...%.....\n" +
                    "......879.....79............*....658..............................601................701..490....#......*........478.......166.........892..\n" +
                    "..844.............706....472....*...........113.........-765..217........267....../.*..........648....973....285............................\n" +
                    ".....*.482..........*...........853....408.....*................&........*.......59.265.........................*.......364....45.......@...\n" +
                    "..164..*...........309....472............#..478...40.......356........328....706..............$...............149.526.....%.....*.....27....\n" +
                    "...........................*.......&..................612...*..58.64%........*...766.......953......488............=.../.......152..........\n" +
                    "...*73....872.............347....27...22......552@.........559.*............435.....*679.............*...13.774......177.#250.......8*......\n" +
                    "977......#.........=....................=.......................56...508......................139.747.....*..*................861.....666...\n" +
                    "..............703...102....../........&....637..448......%..951........*...175.552*235...@.....*.......486..693.............................\n" +
                    "........944..*....@...........590..42.738...*..........861.....&....919.....*............108.837................#....963.530...831..&...251.\n" +
                    "........#.....93.103....708................54.342....+......................496.......................&.........278.....*.....*....162......\n" +
                    "..........860............@.......$167..............431.683......=496....858.........422.............662.154.405..............635.%..........\n" +
                    ".....882/.*.............................%......611..........766.......-...*.....755..@.....................*..........608.........951.......\n" +
                    "..........513......................274...226......*........@.......&..556.151....*.............229...681..............*.....911.............\n" +
                    "..............445....375.....774....*...........348..............643.............302...........*........*.......-...88......*........975....\n" +
                    "....*664.........*...&........@.........................893..........523....13...............825.........558...733.....769...991.....*......\n" +
                    ".328......821....935...................&.......@...457.....*.....+..*.........=..................341..................#............384......\n" +
                    ".........*...........164..........251..756....23...........912.532..879..................459........*...=...................................\n" +
                    "219.....71..821..............654.....................684........................@2....................931...........910.....................\n" +
                    "............&...425+..-.............207........*.....%...360...........190..........69.....................43..........$....................\n" +
                    ".....................116....................127.214.........*..181........@..%...49*....444....57.........*.....................715.........\n" +
                    "............$....*.............-..859.................=..248......*..........82........*.......@.......246..376.........#........*..........\n" +
                    "...726...898...-..772...223.712....%........%464.....342.........442..447.........461..102.....................*355...537....313..596...584.\n" +
                    "....*.........189........@...............................................*187........*...............*....807.............+.....*...........\n" +
                    ".....181.+..........197......530.653+.383...293.........461%.22*..............394....769..104...$.818.36.$....=.......&....860...333........\n" +
                    "..........827..........*................-....*..................110.883..................%.....56............111......872...................\n" +
                    "........................8.321....-............209.....578...583.....$.....948..548#..................868*678......871.......................\n" +
                    "......658...264...........&....105......132............./...................*..................640..................*...........714.........\n" +
                    ".........+.*.....................................................................608..............*....963*565.....472.......93...*.........\n" +
                    "...*717....14.......................702............604.608......................*.....12....689..599.............................423........\n" +
                    "999.........................764......*.......$780.....*.......+.......%........406....*...............278*........600*23.....407.....964....\n" +
                    "...........%....308................183................../......758..&..360..........127.#696...50........................839*.....&.....$...\n" +
                    "......277..449....*............881.......822.....905...205.........345.......572@................../733....=..61...................796......\n" +
                    ".......#..........659...*.....=..........................................................................665...................292..........\n" +
                    "......................887.711.....560..........................11...213*434...................949....761......*856...233*996......%.965.....\n" +
                    ".....699..../.............&....%......103...518...............................673......=.........*....@....149..............................\n" +
                    "............894......=......292..425.....#........@259....787..995..................927..813..326..............439.....379.547..292.........\n" +
                    "....901............678.217......*..............................*.......289.346..875.........*.........653+......*......*....=.....$.........\n" +
                    "......#........................56..887....&540..200...........824............&.....*.414=....629..............893..34.334................731\n" +
                    "...............476.......338........@..#............592..573*.....759...........598........$.........692..474.......*................304....\n" +
                    "..........................*..263*93...541....138......*..........*.....................260.187.......%...*.........436.................*....\n" +
                    ".....#..895............744.....................%.473...92........23..................$..#........853.....443......................12..339...\n" +
                    "...284...*...59*...131...............................................=....354.792...679.....649....*.......................994...%..........\n" +
                    ".......267............*...............176..............=.............743.........*......631......856................166.......*.............\n" +
                    ".....................684.................@...........773....108...........617...965....*........................958............777.....767..\n" +
                    "..........572................#....&.............................51........@..........190..............694..882.#......511..788..............\n" +
                    "...96........%.....119..4.954....81..836....@.....671....161.................*.........................#..*.......730.%...*.................\n" +
                    "....................@.................*...68..924...........*...644.......654.842..473.....449.............936.....*......305............980\n" +
                    "..........188....7..........672......596.........@........473......*..................*418....&.......302.........7...621.....476...938.*...\n" +
                    ".......@...*...........#824..*...303...........................%....486..........290..................*.....-907.....*.......*......*...686.\n" +
                    "....869....976...478*.......56..*...........*..................415......97.@605.....................129............701....626....157........\n" +
                    ".....................455.......306.876......829............430..................956.15@.......302..........938..............................\n" +
                    "..........................43.......*..............$.......-.....998...106.......=.......486*....&.......+......................982..........\n" +
                    ".554......................*.......50.231.........409..............+...$.....*........72.....716.........51..445.....*284........*........350\n" +
                    ".........425............*.94..836......&..............#516..............775.701.....*............................744..........541......-....\n" +
                    "....*810..............34....................&....297..........#........*....................#.............899=..........972..........27.....\n" +
                    "960........762.....................*........394........&355.401........347.....+853.....&...967............................*86..663.........\n" +
                    "............*..........991......686.25.286.......&...................................653...........914........$.....580...........*.........\n" +
                    "...#.....784......-.......*............*......498......*..........*..316........................&.&..........691.2.....*........91..........\n" +
                    "..791..............462....193..........8.............57.685.......90..........201............371.....242............996................579..";
        }


}
