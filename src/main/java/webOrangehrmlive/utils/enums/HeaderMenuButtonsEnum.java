package webOrangehrmlive.utils.enums;

public enum HeaderMenuButtonsEnum {

    ABOUT("About"),

    SUPPORT("Support"),

    CHANGE_PASSWORD("Change Password"),

    LOGOUT("Logout");

    private String button;

    HeaderMenuButtonsEnum(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
