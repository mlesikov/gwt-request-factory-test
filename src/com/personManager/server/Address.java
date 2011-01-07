package com.personManager.server;

/**
 * @author Mihail Lesikov (mlesikov@gmail.com)
 */
public class Address {

  private String city;

  private String street;



  private String zip;

  public Address() {
  }

  public String getCity() {
    return city;
  }



  public String getStreet() {
    return street;
  }

  public String getZip() {
    return zip;
  }

  public void setCity(String city) {
    this.city = city;
  }


  public void setStreet(String street) {
    this.street = street;
  }

  public void setZip(String zip) {
    this.zip = zip;
  }

  @Override
  public String toString() {
    return "Address{" +
            "city='" + city + '\'' +
            ", street='" + street + '\'' +
            ", zip='" + zip + '\'' +
            '}';
  }
}
