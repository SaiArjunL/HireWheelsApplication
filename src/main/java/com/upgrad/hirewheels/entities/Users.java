package com.upgrad.hirewheels.entities;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Users {
    @Id
    @GeneratedValue
    @Column(name = "user_id")
    private int userId;


    @Column(name = "first_name", length = 50, nullable = false)
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(length = 50,nullable = false)
    private String password;

    @Column(name = "email", nullable = false, length = 50, unique = true)
    private String emailId;

    @Column(name ="mobile_no", nullable = false, unique = true)
    private String mobileNumber;

    @Column(name = "wallet_money",precision = 10, scale =2)
    private float walletMoney;

    @ManyToOne
    @JoinColumn(name = "role_id", nullable = false)
    private Role role;

    @OneToMany (mappedBy = "user", fetch = FetchType.EAGER, cascade =  {CascadeType.ALL})
    private Set<Booking> bookings;

    public Users(int userId, String firstName, String lastName, String password, String emailId,
                 String mobileNumber, float walletMoney, Role role) {
        this.userId = userId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.emailId = emailId;
        this.mobileNumber = mobileNumber;
        this.walletMoney = walletMoney;
        this.role=role;


    }

    public Users() {
    }

    public Set<Booking> getBookings() {
        return bookings;
    }

    public void setBookings(Set<Booking> bookings) {
        this.bookings = bookings;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public float getWalletMoney() {
        return walletMoney;
    }

    public void setWalletMoney(float walletMoney) {
        this.walletMoney = walletMoney;
    }

    @Override
    public String toString() {
        return "User{userId="+userId
                +", firstName="+firstName
                +", lastName="+lastName
                +", password="+password
                +", emailId="+emailId
                +", mobileNumber="+mobileNumber
                +", walletMoney="+walletMoney
                +", role="+role
                +"}";
    }
}
