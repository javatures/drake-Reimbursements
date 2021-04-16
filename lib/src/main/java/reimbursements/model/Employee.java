package reimbursements.model;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String user;
    private String pass;
    private String type;

    public Employee(int id, String firstName, String lastName, String user, String pass, String type) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.user = user;
        this.pass = pass;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUser() {
        return user;
    }

    public String getPass() {
        return pass;
    }

    public String getType() {
        return type;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    @Override
    public String toString() {
        String output = "{\n";
        output += "\"id\":" + id + ",\n";
        output += "\"firstName\":\"" + firstName + "\",\n";
        output += "\"lastName\":\"" + lastName + "\",\n";
        output += "\"user\":\"" + user + "\",\n";
        output += "\"type\":\"" + type + "\"\n";
        output += "}";
        return output;
    }
}
