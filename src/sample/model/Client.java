package sample.model;

public class Client {

    private int id;
    private String name;
    private String address;
    private String cpf;
    private String telephone;
    private String email;

    public Client(int id, String name, String address, String cpf, String telephone, String email) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
    }

    public Client(String name, String address, String cpf, String telephone, String email) {
        this.name = name;
        this.address = address;
        this.cpf = cpf;
        this.telephone = telephone;
        this.email = email;
    }

    public Client() {

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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return name;
    }
}
