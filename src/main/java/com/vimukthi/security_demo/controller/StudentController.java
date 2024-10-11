package com.vimukthi.security_demo.controller;

import com.vimukthi.security_demo.entity.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController
{
    private List<Student> students = new ArrayList<>( List.of(
            new Student( 1,"Vimukthi", 10, 40 ),
            new Student( 2,"Bandara", 22, 79 ),
            new Student( 3,"Saman", 32, 89 )
    ) );

    @GetMapping( "/students" )
    public List<Student> getStudents()
    {
        return students;
    }

    @PostMapping( "/add" )
    public void setStudents( @RequestBody Student student )
    {
        students.add( student );
    }

    @GetMapping( "/csrf-token" )
    public CsrfToken getCSRFToken( HttpServletRequest httpServletRequest )
    {
       return ( CsrfToken ) httpServletRequest.getAttribute( "_csrf" );
    }
}
