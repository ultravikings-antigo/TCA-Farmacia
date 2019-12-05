package sample.model;

public class Salesman {

    private int id;
    private String name;
    private Float salary;
    private String address;
    private String telephone;
    private String cpf;
    private String password;
    private String email;
    private Boolean admin;

    public Salesman(int id, String name, Float salary, String address, String telephone, String cpf, String password, String email, Boolean admin) {
        this.id = id;
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.telephone = telephone;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    public Salesman(String name, Float salary, String address, String telephone, String cpf, String password, String email, Boolean admin) {
        this.name = name;
        this.salary = salary;
        this.address = address;
        this.telephone = telephone;
        this.cpf = cpf;
        this.password = password;
        this.email = email;
        this.admin = admin;
    }

    public Salesman() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Float getSalary() {
        return salary;
    }

    public void setSalary(Float salary) {
        this.salary = salary;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Boolean getAdmin() {
        return admin;
    }

    public void setAdmin(Boolean admin) {
        this.admin = admin;
    }

    @Override
    public String toString() {
        return name;
    }
}
