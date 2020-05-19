package paularnold;


public class Customer {

    private int id;
    private String firstName;
    private String lastName;
    private String businessName;
    private String addressStreetName;
    private String addressStreetNumber;
    private String addressCity;
    private String addressCityZipCode;
    private String phoneNumber;
    private String mail;
    private String bankName;
    private String bankNumber;

    public Customer() {
    }

    public Customer(String firstName, String lastName, String businessName, String addressStreetName, String addressStreetNumber, String addressCity, String addressCityZipCode, String phoneNumber, String mail, String bankName, String bankNumber) {

        //id is autogenerated
        this.firstName = firstName;
        this.lastName = lastName;
        this.businessName = businessName;
        this.addressStreetName = addressStreetName;
        this.addressStreetNumber = addressStreetNumber;
        this.addressCity = addressCity;
        this.addressCityZipCode = addressCityZipCode;
        this.phoneNumber = phoneNumber;
        this.mail = mail;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getBusinessName() {
        return businessName;
    }

    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    public String getAddressStreetName() {
        return addressStreetName;
    }

    public void setAddressStreetName(String addressStreetName) {
        this.addressStreetName = addressStreetName;
    }

    public String getAddressStreetNumber() {
        return addressStreetNumber;
    }

    public void setAddressStreetNumber(String addressStreetNumber) {
        this.addressStreetNumber = addressStreetNumber;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCityZipCode() {
        return addressCityZipCode;
    }

    public void setAddressCityZipCode(String addressCityZipCode) {
        this.addressCityZipCode = addressCityZipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankNumber() {
        return bankNumber;
    }

    public void setBankNumber(String bankNumber) {
        this.bankNumber = bankNumber;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", businessName='" + businessName + '\'' +
                ", addressStreetName='" + addressStreetName + '\'' +
                ", addressStreetNumber='" + addressStreetNumber + '\'' +
                ", addressCity='" + addressCity + '\'' +
                ", addressCityZipCode='" + addressCityZipCode + '\'' +
                ", telefonNumber='" + phoneNumber + '\'' +
                ", mail='" + mail + '\'' +
                ", bankName='" + bankName + '\'' +
                ", bankNumber='" + bankNumber + '\'' +
                '}';
    }
}
