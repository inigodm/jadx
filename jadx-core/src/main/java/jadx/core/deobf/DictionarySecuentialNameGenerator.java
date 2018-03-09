package jadx.core.deobf;

import jadx.core.utils.StringUtils;

import java.util.ArrayList;
import java.util.List;

public class DictionarySecuentialNameGenerator implements NameGenerator{
    PrefixCalculator pc = new PrefixCalculator("nouns.txt");
    private int total = 0;
    private String basePrefix = "";
    private int currentPrefixIndex = 0;
    private int baserPrefixIndex = 0;
    List<String> cache = new ArrayList<>();
    private String currentPrefix = "";

    @Override
    public String generatePackageName(String name) {
        return pc.getNextName().toLowerCase();
    }

    @Override
    public String generateClassName(String name) {
        return StringUtils.firstCharToUpper(pc.getNextName());
    }

    @Override
    public String generateMethodName(String name) {
        return pc.getNextName();
    }

    @Override
    public String generateFieldName(String name) {
        return pc.getNextName();
    }

    @Override
    public String generateOverridedMethodName(String name) {
        return pc.getNextName();
    }

}
