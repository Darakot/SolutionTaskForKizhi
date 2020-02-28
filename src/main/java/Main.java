import service.Iterator;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    static final String SETCODE = "set code";
    static final String ENDSETCODE = "end set code";
    static final String RUN = "run";
    static final String ADDBREAK = "add break";
    static final String SET = "set";
    static final String SUB = "sub";
    static final String PRINT = "print";
    static final String DEF = "def";
    static final String CALL = "call";
    static int countFunction = 0;
    static int begin = 0;
    static int end = 0;

    private static Iterator iterator = new Iterator();

    public static void main(String[] args) {
        boolean runProgram = false;

        String[] input = new String[]{
                "set code",
                "def test\n" +
                        "   set a 5\n" +
                        "   sub a 3\n" +
                                "def ref\n" +
                                "   set c 10\n" +
                                "   sub c 3\n" +
                                        "def fuck\n" +
                                        "   set d 14\n" +
                                        "   sub a 3\n" +
                                        "   print d\n" +
                                        "call fuck\n" +
                                "   print c\n" +
                                "call ref\n" +
                        "   print a\n" +
                        "   print b\n" +
                        "call test",
                "end set code",
                "add break 2",
                "run",
                "print mem"};

        for (String strCode: input) {
            if(strCode.contains(RUN)){runProgram = true;}
        }

        if (runProgram) {
            for (String str : input) {
                String[] arrInputStr = str.split("\n");
                if (arrInputStr.length > 1) {
                    for (String subStr : arrInputStr) {
                        iterator.addStrCode(subStr);
                        if(subStr.contains(DEF)) {
                            countFunction++;
                            lineOperation(subStr);
                        }
                        if(subStr.contains(CALL)) {
                            countFunction--;
                            lineOperation(subStr);
                        }
                    }
                } else {
                    iterator.addStrCode(str);
                    if(str.contains(DEF)) {
                        countFunction++;
                        lineOperation(str);
                    }
                    if(str.contains(CALL)) {
                        countFunction--;
                        lineOperation(str);
                    }
                }
            }
            System.out.println(countFunction);
        }


    }


    private static void lineOperation(String strCode){
        if(strCode.contains(SETCODE)){
//            System.out.println(SETCODE);
        } else if(strCode.contains(SET)){
            iterator.set(strCode.trim());
        } else if(strCode.contains(SUB)){
            iterator.sub(strCode.trim());
        } else if(strCode.contains(PRINT)){
            iterator.print(strCode.trim());
        } else if(strCode.contains(DEF)){
            if(countFunction==1){
                begin = iterator.getLastLine();
            }
        } else if(strCode.contains(CALL)){
            end = iterator.getLastLine();
            if(countFunction==0){
                for ( int i =begin;begin<=end;i++){
                    lineOperation(iterator.getStrCode(i));
                }
            }

//            List<Integer> lines = iterator.call(strCode);
//            if(!lines.isEmpty()){
//                for (int i = lines.get(0);i<=lines.get(1);i++){
//                    lineOperation(iterator.getStrCode(i));
//                }
//            }
        } else if(strCode.contains(RUN)){

        } else if(strCode.contains(ENDSETCODE)){
//            System.out.println(ENDSETCODE);
        } else if(strCode.contains(ADDBREAK)){
            iterator.addBreak(strCode);
        }

    }

}
