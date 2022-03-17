package vtttp.nusiss.MarchRedisJCG.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import vtttp.nusiss.MarchRedisJCG.model.Employee;
import vtttp.nusiss.MarchRedisJCG.service.EmployeeService;

@RestController
@RequestMapping(value="/api/redis/employee")
public class EmployeeController {
    
    @Autowired
    EmployeeService service;


    @PostMapping
    public String save(@RequestBody final Employee employee){
        service.save(employee);
        return "Success added";
    }

}
