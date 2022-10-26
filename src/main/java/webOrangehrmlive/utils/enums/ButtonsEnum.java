package webOrangehrmlive.utils.enums;

public enum ButtonsEnum {

    ADMIN("Admin"),
    PIM("PIM"),
    LEAVE("Leave"),
    TIME("Time"),
    RECRUITMENT("Recruitment"),
    MY_INFO("My Info"),
    PERFOMANCE("Performance"),

    DASHBOARD("Dashboard"),
    DIRECTORY("Directory"),
    MAINTENANCE("Maintenance"),
    ABOUT("About"),

    SUPPORT("Support"),

    CHANGE_PASSWORD("Change Password"),

    LOGOUT("Logout"),
    OPTIONAL_FIELDS("Optional Fields"),
    CUSTOM_FIELDS("Custom Fields"),
    DATA_IMPORT("Data Import"),
    REPORTING_METHODS("Reporting Methods"),
    EMPLOYEE_LIST("Employee List"),
    REPORTS("Reports"),
    ADD_EMPLOYEE("Add Employee"),
    TERMINATION_REASONS("Termination Reasons");;
    private String button;

    ButtonsEnum(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
