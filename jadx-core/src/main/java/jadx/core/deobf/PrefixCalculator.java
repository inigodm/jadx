package jadx.core.deobf;

import jadx.core.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrefixCalculator{
    List<Integer> indexes = new ArrayList<>();
    List<String> cache = new ArrayList<>();
    int minLength = 1;
    int maxLength = 100;
    int numberOfWords = 0;

    public PrefixCalculator(String dictFileName){
        try {
            ClassLoader classLoader = getClass().getClassLoader();
            Scanner sc = new Scanner(classLoader.getResourceAsStream(dictFileName));
            cache.clear();
            String aux;
            indexes.add(-1);
            while (sc.hasNextLine()) {
                aux = sc.nextLine();
                if (aux.length() > minLength && aux.length() < maxLength) {
                    cache.add(aux);
                }
            }
            numberOfWords = cache.size();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    public String getNextName(){
        incrementElementAtIndex(0);
        changeLastWordIfEqualsToPrevious();
        return buildName();
    }

    private void incrementElementAtIndex(int index){
        indexes.set(index, indexes.get(index) + 1);
        if (indexes.get(index) >= numberOfWords) {
            indexes.set(index, 0);
            if (index == indexes.size() - 1) {
                indexes.add(0);
            } else {
                incrementElementAtIndex(index + 1);
            }
        }
    }

    private void changeLastWordIfEqualsToPrevious(){
        if ((indexes.size() > 1) && (indexes.get(0) == indexes.get(1))) {
            incrementElementAtIndex(0);
            changeLastWordIfEqualsToPrevious();
        }
    }

    private String buildName(){
        StringBuilder sb = new StringBuilder();
        for (Integer i : indexes){
            sb.insert(0, StringUtils.firstCharToUpper(cache.get(i)));
        }
        return StringUtils.firstCharToLower(sb.toString());
    }
}