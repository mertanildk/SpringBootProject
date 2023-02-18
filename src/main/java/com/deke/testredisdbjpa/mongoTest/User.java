package com.deke.testredisdbjpa.mongoTest;

import jakarta.persistence.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashMap;

@Data
@Document(value = "userTable")//collectiona denk geldiğnii söylediğimiz yer table gibi düşün
public class User {
    @Id
    private String id;
    private String name;
    private String email;
    private HashMap<String, String> properties;

}
