package com.vimukthi.security_demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student
{
    @Id
    private Integer studentId;
    private String name;
    private Integer age;
    private Integer marks;

}
