package com.natiraj.EmployeeAPI.Entity;



import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Employee {
    
    
	@Id
    private Integer id;
    
    private String fname;
    private String lname;
    private String email;
    private String phone;
    private String address;

}
