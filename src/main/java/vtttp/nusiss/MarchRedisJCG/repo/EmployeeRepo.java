package vtttp.nusiss.MarchRedisJCG.repo;

import java.util.Map;

import org.springframework.stereotype.Repository;

import vtttp.nusiss.MarchRedisJCG.model.Employee;

@Repository
public interface EmployeeRepo {
    
    void save(Employee employee);

    Employee findById(String id);

    Map<String, Employee> findAll();

    void delete(String id);

}
