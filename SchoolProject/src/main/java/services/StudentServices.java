
package services;

import java.util.List;

import models.Student;
import models.SubjectScore;
import repositories.StudentRepository;

public class StudentServices implements UserServices {
    protected Student student;
    protected StudentRepository repository;
    protected List<Student> rawData;

    public StudentServices(StudentRepository repository){
        this.repository = repository;
    }

    public void readData(){
        //TODO: Method readData is initializing  class ReadDataService, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        ReadDataService<Student> readDataService = new ReadDataService<Student>();
        this.rawData = readDataService.readDataFromJson("C:/Users/USUARIO/Desktop/DevOpsBootcamp/DevFundamentals/devops-bootcamp-v2-project/SchoolProject/src/main/resources/students.json", Student[].class);
    }

    public void writeData(){
        //TODO: Method writeData is initializing  class WriteDataService, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        WriteDataService<Student> writeDataService = new WriteDataService<Student>(this.repository);
        writeDataService.writeDataToRepository(rawData);
    }

    public Boolean validateAccess(String code){
        //TODO: Method validateAccess is initializing  class AccessValidator, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        AccessValidator<Student> accessValidator = new AccessValidator<Student>(this.repository);
        Student studentAccess = accessValidator.verifyAccess(code);
        if (studentAccess != null) {
            this.student = studentAccess;
            return true;
        } else {
            return false;
        }
    }

    //TODO: Methods such as editScore, getSubjects or getElementSubjectByname 
    //must be moved from StudentRepository class to this one.

    public void printSubjects(String code) {
        var i = 1;
        for(SubjectScore s: this.repository.getSubjects(code)){
            System.out.println(i + ". " + s.getName() + " ------ " + s.getScore());
            i++;
        }
    }

    public void mainMenu(){
        System.out.println("=============================");
        System.out.println("Wellcome " + this.student.getName() + "!");
        System.out.println("=============================");
        System.out.println("Your subjects:");
        this.printSubjects(this.student.getCode());
    }
}
