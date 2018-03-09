package jadx.core.deobf;

public interface NameGenerator {
    public String generatePackageName(String name);
    public String generateClassName(String name);
    public String generateMethodName(String name);
    public String generateFieldName(String name);
    public String generateOverridedMethodName(String name);
}
