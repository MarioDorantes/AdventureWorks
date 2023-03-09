/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Poco;

/**
 *
 * @author mario
 */
public class Persona {
    
    private String personType;  
    private int nameStyle;
    private String firstName;
    private String middleName;
    private String lastName;
    private int emailPromotion;
    private String creditCardNumber;
    private String cardType;
    private String emailAddress;
    private String phoneNumber;
    private String phoneNumberTypeID;  
    private int creditCardExpMonth;
    private int creditCardExpYear;
    private int businessEntityID;
    private int creditCardID;

    public Persona() {
    }

    public Persona(String personType, int nameStyle, String firstName, String middleName, String lastName, int emailPromotion, String creditCardNumber, String cardType, String emailAddress, String phoneNumber, String phoneNumberTypeID, int creditCardExpMonth, int creditCardExpYear, int businessEntityID, int creditCardID) {
        this.personType = personType;
        this.nameStyle = nameStyle;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.emailPromotion = emailPromotion;
        this.creditCardNumber = creditCardNumber;
        this.cardType = cardType;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
        this.phoneNumberTypeID = phoneNumberTypeID;
        this.creditCardExpMonth = creditCardExpMonth;
        this.creditCardExpYear = creditCardExpYear;
        this.businessEntityID = businessEntityID;
        this.creditCardID = creditCardID;
    }

    public String getPersonType() {
        return personType;
    }

    public void setPersonType(String personType) {
        this.personType = personType;
    }

    public int getNameStyle() {
        return nameStyle;
    }

    public void setNameStyle(int nameStyle) {
        this.nameStyle = nameStyle;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getEmailPromotion() {
        return emailPromotion;
    }

    public void setEmailPromotion(int emailPromotion) {
        this.emailPromotion = emailPromotion;
    }

    public String getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(String creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPhoneNumberTypeID() {
        return phoneNumberTypeID;
    }

    public void setPhoneNumberTypeID(String phoneNumberTypeID) {
        this.phoneNumberTypeID = phoneNumberTypeID;
    }

    public int getCreditCardExpMonth() {
        return creditCardExpMonth;
    }

    public void setCreditCardExpMonth(int creditCardExpMonth) {
        this.creditCardExpMonth = creditCardExpMonth;
    }

    public int getCreditCardExpYear() {
        return creditCardExpYear;
    }

    public void setCreditCardExpYear(int creditCardExpYear) {
        this.creditCardExpYear = creditCardExpYear;
    }

    public int getBusinessEntityID() {
        return businessEntityID;
    }

    public void setBusinessEntityID(int businessEntityID) {
        this.businessEntityID = businessEntityID;
    }

    public int getCreditCardID() {
        return creditCardID;
    }

    public void setCreditCardID(int creditCardID) {
        this.creditCardID = creditCardID;
    }
    
    
    
    
}
