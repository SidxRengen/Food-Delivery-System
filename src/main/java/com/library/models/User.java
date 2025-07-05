package main.java.com.library.models;

public class User extends BaseEntry {
    private String name;
    private String address;
    private String email;
    private String phoneNumber;

    public User(String name, String address,String email,String phoneNumber){
       this.address = address;
       this.email = email;
       this.phoneNumber = phoneNumber;
       this.name = name;
    }
    public String getAddress() {
        return address;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getName() {
        return name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "User{id= "+getId() +", name= "+name+", email= "+email+", address= "+address+", Phone Number= "+phoneNumber+" }";
    }
}

