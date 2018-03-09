package jadx.core.deobf;

public class SecuentialNameGenerator implements NameGenerator{
    private int pkgIndex = 0;
    private int clsIndex = 0;
    private int fldIndex = 0;
    private int mthIndex = 0;
    private int mthOIndex = 1;
    private int maxLength;

    public SecuentialNameGenerator(DeobfPresets deobfPresets, int pkgsize){
        pkgIndex = pkgsize;
        clsIndex = deobfPresets.getClsPresetMap().size();
        fldIndex = deobfPresets.getFldPresetMap().size();
        mthIndex = deobfPresets.getMthPresetMap().size();
        //this.minLength = args.getDeobfuscationMinLength();
        //this.maxLength = args.getDeobfuscationMaxLength();
    }

    @Override
    public String generatePackageName(String pkgname) {
        return String.format("p%03d%s", pkgIndex++, makeName(pkgname));
    }

    @Override
    public String generateClassName(String clsName) {
        return String.format("C%04d%s", clsIndex++, makeName(clsName));
    }

    @Override
    public String generateMethodName(String mthName) {
        return String.format("m%d%s", mthIndex++, makeName(mthName));
    }

    @Override
    public String generateFieldName(String fieldName) {
        return String.format("f%d%s", fldIndex++, makeName(fieldName));
    }

    @Override
    public String generateOverridedMethodName(String name) {
        return String.format("mo%d%s", mthOIndex++, makeName(name));
    }

    private String makeName(String name) {
        if (name.length() > maxLength) {
            return "x" + Integer.toHexString(name.hashCode());
        }
        if (NameMapper.isReserved(name)) {
            return name;
        }
        if (!NameMapper.isAllCharsPrintable(name)) {
            return removeInvalidChars(name);
        }
        return name;
    }
    private String removeInvalidChars(String name) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < name.length(); i++) {
            int ch = name.charAt(i);
            if (NameMapper.isPrintableChar(ch)) {
                sb.append((char) ch);
            }
        }
        return sb.toString();
    }

}
