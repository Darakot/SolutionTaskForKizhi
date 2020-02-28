package service;

import java.util.*;

public class Iterator implements DebuggerService, IterratorService {
    private Map<String,Integer> values = new HashMap<>();
    List<Integer> breakpoints = new ArrayList<>();
    Map<Integer, String> subStrings = new HashMap<>();
    private int countLine = 0;


    // методы дебагера
    @Override
    public void addBreak(String strCode) {
        String[] arrStr = strCode.split(" ");
        try {
            breakpoints.add(Integer.parseInt(arrStr[2]));
        } catch (NullPointerException ex){
            printTrace(strCode);
        }finally {
            System.out.println(breakpoints);
        }
    }

    @Override
    public void stepOver() {

    }

    @Override
    public void step() {

    }

    @Override
    public List<String> printMem() {
        return null;
    }

    @Override
    public String printTrace(String strCode) {
        return strCode + "что то не так";
    }

    @Override
    public void run() {

    }

    // методы итератора

    @Override
    public void set(String strCode) {
        String[] arrStr = strCode.split(" ");
        try {
            values.put(arrStr[1],Integer.parseInt(arrStr[2]));
        } catch (NullPointerException ex){
            printTrace(strCode);
        }
    }

    @Override
    public void sub(String strCode) {
        String[] arrStr = strCode.split(" ");
        if(values.containsKey(arrStr[1])) {
            int numA = values.get(arrStr[1]);
            int numB = Integer.parseInt(arrStr[2]);
            values.put(arrStr[1],numA-numB);
        }else {
            printTrace(strCode);
        }
    }

    @Override
    public void print(String strCode) {
        String[] arrStr = strCode.split(" ");
        if(values.containsKey(arrStr[1])){
            System.out.println(values.get(arrStr[1]));
        }else {
            printTrace(strCode);
        }
    }

    @Override
    public List<Integer> call(String strCode) {
        List<Integer> lines = new ArrayList<>();
        String[] arrStr = strCode.split(" ");
        if(!arrStr[1].isEmpty()){
            for (Map.Entry<Integer,String> entry: subStrings.entrySet()) {
                if(entry.getValue().contains("def "+arrStr[1])){
                    lines.add(entry.getKey());
                }
                if(entry.getValue().contains(strCode)){
                    lines.add(entry.getKey());
                }
            }
        }
        return lines;

    }


    @Override
    public void addStrCode(String strCode) {
        subStrings.put(++countLine, strCode.trim());
    }

    @Override
    public String getStrCode(Integer numLine) {
//        countLine--;
        return subStrings.get(numLine);
    }

    @Override
    public void rem(String strCode) {
        String[] arrStr = strCode.split(" ");
        if(values.containsKey(arrStr[1])) {
            values.remove(arrStr[1]);
        }else {
            printTrace(strCode);
        }
    }

    @Override
    public Integer getLastLine() {
        return countLine;
    }
}
