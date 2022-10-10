import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import helpers.Grade;
import services.*;
import models.Student;
import repositories.StudentRepository;


@ExtendWith(MockitoExtension.class)
public class StudentServicesTests {
    private StudentServices service;
    private List<Student> rawData;

    @Mock
    private WriteDataService<Student> writeDataService;

    @Mock
    private ReadDataService<Student> readDataService;

    @Mock
    private StudentRepository repository;

    @BeforeEach
    public void initialConfiguration(){
        service = new StudentServices(repository);
        repository = new StudentRepository();
    }


    @Test
    public void readStudentDataFromJson(){
        String path = "C:/Users/USUARIO/Desktop/DevOpsBootcamp/DevFundamentals/project-v3/devops-bootcamp-v2-project/SchoolProject/src/test/resources/studentsTest.json";

        readDataService = new ReadDataService<Student>();
        var result = readDataService.readDataFromJson(path, Student[].class);

        assertThat(result).isNotNull();
        assertThat(result.size()).isEqualTo(3);


    }

    @Test
    public void writeStudentDataToRepository(){
        List<Student> students = new ArrayList<>(){{
            add(new Student("someone0", 10, Grade.ELEMENTARY_SCHOOL));
            add(new Student("someone1", 12, Grade.MIDDLE_SCHOOL));
            add(new Student("someone2", 15, Grade.HIGH_SCHOOL));
        }};           

        // repository = new StudentRepository();
        writeDataService = new WriteDataService<Student>(repository);
        writeDataService.writeDataToRepository(students);
        
        var result = repository.getAll();

        assertThat(result).isEqualTo(students);
    }

    @Test
    public void validateStudentAccess(){
        // AccessValidator<Student> accessValidator = Mockito.mock(AccessValidator.class);   
        // Student student = new Student("someone0", 10, Grade.ELEMENTARY_SCHOOL);

        
        //TODO: Method validateAccess is initializing  class Access validator, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        String code = "ST-01-someone0";
        var result = service.validateAccess(code);

        assertThat(result);
    }

}
