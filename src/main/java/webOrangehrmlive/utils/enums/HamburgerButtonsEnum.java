package webOrangehrmlive.utils.enums;

public enum HamburgerButtonsEnum {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFOMANCE("Performance"),

    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance");
    private String button;

    HamburgerButtonsEnum(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
