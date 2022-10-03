package web.utils.enums;

public enum HomeButtonsEnum {
    HOTELS("hotels","hotels-search"),
    FLIGHTS("flights","flights"),
    TOURS("tours","tours-search"),
    TRANSFERS("cars","cars-search"),
    VISA("visa","visa-submit");
    private String button;
    private String checkButton;

    HomeButtonsEnum(String button, String checkButton) {
        this.button = button;
        this.checkButton = checkButton;
    }

    public String getButton() {
        return button;
    }
    public String getCheckButton(){return checkButton;}



}
