package webOrangehrmlive.utils.enums;

public enum PimButtonsEnum {
    OPTIONAL_FIELDS("Optional Fields"),
    CUSTOM_FIELDS("Custom Fields"),
    DATA_IMPORT("Data Import"),
    REPORTING_METHODS("Reporting Methods"),
    EMPLOYEE_LIST("Employee List"),
    REPORTS("Reports"),
    ADD_EMPLOYEE("Add Employee"),
    TERMINATION_REASONS("Termination Reasons");
    private String button;

    PimButtonsEnum(String button) {
        this.button = button;
    }

    public String getButton() {
        return button;
    }
}
