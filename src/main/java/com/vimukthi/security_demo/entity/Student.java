package com.vimukthi.security_demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class Student
{
    private String name;
    private Integer age;
    private Integer marks;

}
