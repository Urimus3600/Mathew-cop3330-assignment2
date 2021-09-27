package ex27;

public class Employee {
    private final String firstName;
    private final String lastName;
    private final String zip;
    private final String employeeID;

    Employee(String firstName, String lastName, String zip, String employeeID){
        this.firstName = firstName;
        this.lastName = lastName;
        this.zip = zip;
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getZip() {
        return zip;
    }

    public String getEmployeeID() {
        return employeeID;
    }
    public static String validateInput(Employee employee) {
        String output="";
        output += checkfirstLen(employee.getFirstName());
        output += checklastLen(employee.getLastName());
        output += checkfirst(employee.getFirstName());
        output += checklast(employee.getLastName());
        output += checkID(employee.getEmployeeID());
        output += checkZIP(employee.getZip());
        if(output.equals("")){
            output = "There were no errors found.";
        }
        return output;
    }

    private static String checkfirstLen(String firstName) {
        if(firstName.length()<2){
            return "The first name must be at least 2 characters long.\n";
        }
        return "";
    }

    private static String checklastLen(String lastName) {
        if(lastName.length()<2){
            return "The last name must be at least 2 characters long.\n";
        }
        return "";
    }

    private static String checkfirst(String firstName) {
        if(firstName.equals("")){
            return "The first name must be filled in.\n";
        }
        return "";
    }

    private static String checklast(String lastName) {
        if(lastName.equals("")){
            return "The last name must be filled in.\n";
        }
        return "";
    }

    private static String checkZIP(String zip) {
        int len=zip.length();
        if( len != 5 ){
            return "The zipcode must be a 5 digit number.\n";
        }
        for(int i=0; i<len; i++){
            char digit= zip.charAt(i);
            if(digit<48 || digit>57){
                return "The zipcode must be a 5 digit number.\n";
            }
        }
        return "";
    }

    private static String checkID(String employeeID) {
        int len = employeeID.length();
        if(len!=7){
            return "The employee ID must be in the format of AA-1234.\n";
        }
        for(int i=0; i<2; i++){
            if(employeeID.charAt(i)<65 || employeeID.charAt(i)>90){
                return "The employee ID must be in the format of AA-1234.\n";
            }
        }

        if(employeeID.charAt(2) != '-'){
            return "The employee ID must be in the format of AA-1234.\n";
        }

        for(int i=3; i<len; i++){
            if(employeeID.charAt(i)<48 || employeeID.charAt(i)>57){
                return "The employee ID must be in the format of AA-1234.\n";
            }
        }

        return "";
    }

}

