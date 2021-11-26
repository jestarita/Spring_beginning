package com.testing.stream.lambdas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;
import java.util.stream.Collectors;

@RestController

public class Controller {



    @GetMapping("/search")
    public Map<String, Object> listarSearch(){


        Persons p1 = new Persons();
        p1.setId(1);
        p1.setDepartment("science");
        p1.setName("jorge andres");
        p1.setRole("data scients");

        Persons p2 = new Persons();
        p2.setId(2);
        p2.setDepartment("development");
        p2.setName("juan camilo");
        p2.setRole("backend developer");

        Persons p3 = new Persons();
        p3.setId(3);
        p3.setDepartment("science");
        p3.setName("marco andres");
        p3.setRole("master piece");

        Persons p4 = new Persons();
        p4.setId(4);
        p4.setDepartment("chemestry");
        p4.setName("daniela perez");
        p4.setRole("engenieer chemestry");


        Department department = new Department();
        department.setName("science");
        department.setPersonId(1);


        Department department2 = new Department();
        department2.setName("development");
        department2.setPersonId(2);



        List<Persons> list_person = new ArrayList<>();
        list_person.add(p1);
        list_person.add(p2);
        list_person.add(p3);
        list_person.add(p4);


        List<Department> departmentList = new ArrayList<>();
        departmentList.add(department);
        departmentList.add(department2);

        var filter = list_person.stream().filter(
                lp -> departmentList.stream().anyMatch(
                        dl -> dl.getName().equals(lp.getDepartment())
                )
        ).collect(Collectors.toList());


        var filter2 = list_person.stream().filter(
                lp -> departmentList.stream().noneMatch(
                        dl -> dl.getName().equals(lp.getDepartment())
                )
        ).collect(Collectors.toList());

        var filter3 = list_person.stream().filter(
                lp -> departmentList.stream().noneMatch(
                        dl -> dl.getName().equals(lp.getDepartment())
                )
        ).map(Persons::getId).collect(Collectors.toList());

        Map<String, Object> resp =  new TreeMap<>();
        resp.put("filter1", filter);
        resp.put("filter2", filter2);
        resp.put("filter3", filter3);

        return  resp;
    }

}
