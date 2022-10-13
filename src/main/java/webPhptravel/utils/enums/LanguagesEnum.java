package webPhptravel.utils.enums;

public enum LanguagesEnum {
    TURKISH("Turkish"),
    RUSSIAN("Russian"),
    PHILIPPINE("Philippine"),
    KOREAN("Korean"),
    KHMER("Khmer"),
    INDONESIA("Indonesia"),
    FRENCH("French"),
    SPANISH("Spanish"),
    ENGLISH("English"),
    GERMAN("German"),
    CHINESE("Chinese"),
    PORTUGUES("Portugues"),
    ARABIC("Arabic");

    private String language;

    LanguagesEnum(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }

}
