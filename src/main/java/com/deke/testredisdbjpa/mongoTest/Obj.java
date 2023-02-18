package com.deke.testredisdbjpa.mongoTest;


import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document//collectiona denk geldiğnii söylediğimiz yer table gibi düşün
public class Obj {

    private String name;
    private int age;
    private String phone;
    private String email;
    private String address;
    private String city;
    private String country;
    private String zipCode;
    private String state;
    private String company;
    private String jobTitle;
    private String website;
}
