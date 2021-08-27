package entities;

public class user
{
    private String fName;
    private String lName;
    private String password;
    private String phoneNumber;
    private String address;

    public user()
    {
    }

    public user(String fName, String lName, String password, String phoneNumber, String address)
    {
        this.fName = fName;
        this.lName = lName;
        this.password = password;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String fName)
    {
        this.fName = fName;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String lName)
    {
        this.lName = lName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getPhoneNumber()
    {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress()
    {
        return address;
    }

    public void setAddress(String address)
    {
        this.address = address;
    }

    @Override
    public String toString()
    {
        return "user{" +
                "firstName='" + fName + '\'' +
                ", lastName='" + lName + '\'' +
                ", password='" + password + '\'' +
                ", phoneNumber=" + phoneNumber +
                ", address='" + address + '\'' +
                '}';
    }
}
