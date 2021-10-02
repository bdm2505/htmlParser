package ru.bdm.htmlparser;

import java.io.OutputStream;
import java.io.PrintStream;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class WordCounter {

    public static final String regex = "[\s!.,?<>/@#$%^&*()_\\-+=0-9:;{}\\[\\]'\"\\\\]+";


    HashMap<String, Integer> map = new HashMap<>();

    void parseWords(String input){
        var words = input.split(regex);
        for(var word : words){
            if(map.containsKey(word)){
                map.put(word, map.get(word) + 1);
            } else {
                map.put(word, 1);
            }
        }
        for(var pair : map.entrySet()){
            System.out.println(pair);
        }
    }

    void save(OutputStream out){
        var stream = new PrintStream(out);
        map.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder())).forEach((pair -> {
            stream.println(pair.getKey() + " : " + pair.getValue());
        }));
        stream.close();
    }
}
