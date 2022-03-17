package vtttp.nusiss.MarchRedisJCG.service;

import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import vtttp.nusiss.MarchRedisJCG.model.Employee;
import vtttp.nusiss.MarchRedisJCG.repo.EmployeeRepo;

@Service
public class EmployeeService implements EmployeeRepo{

    private final String EMPLOYEE= "EMPLOYEE";

    @Autowired
    RedisTemplate<String,Object> redisTemplate;
    private HashOperations<String,String,Employee> hashOperations;

    @PostConstruct
    private void initializeHashOperations(){
        hashOperations = redisTemplate.opsForHash();
    }

    @Override
    public void save(final Employee employee){
        hashOperations.put(EMPLOYEE, employee.getId(), employee);
    }

    @Override
    public Employee findById(final String id){
        return (Employee) hashOperations.get(EMPLOYEE, id);
    }

    @Override
    public Map<String, Employee> findAll(){
        return  hashOperations.entries(EMPLOYEE);
    }

    @Override
    public void delete(String id){
        hashOperations.delete(EMPLOYEE, id);
    }
    
}
