package services;

import java.util.List;

import helpers.Grade;
// import helpers.Score;
import models.Student;
// import models.SubjectScore;
import models.Teacher;
import repositories.StudentRepository;
import repositories.TeacherRepository;

public class TeacherServices implements UserServices {
    protected Teacher teacher;
    protected TeacherRepository repository;
    protected StudentRepository studentRepository;
    protected StudentServices studentServices;
    protected List<Teacher> rawData;

    public TeacherServices(TeacherRepository repository, StudentRepository studentRepository){
        this.repository = repository;
        this.studentRepository = studentRepository;
    }

    public void readData(){
        //TODO: Method readData is initializing  class ReadDataService, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        ReadDataService<Teacher> readDataService = new ReadDataService<Teacher>();
        this.rawData = readDataService.readDataFromJson("C:/Users/USUARIO/Desktop/DevOpsBootcamp/DevFundamentals/devops-bootcamp-v2-project/SchoolProject/src/main/resources/teachers.json", Teacher[].class); 
    }

    public void writeData(){
        //TODO: Method writeData is initializing  class WriteDataService, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        WriteDataService<Teacher> writeDataService = new WriteDataService<Teacher>(repository);
        writeDataService.writeDataToRepository(rawData);
    }

    public Boolean validateAccess(String code){
        //TODO: Method validateAccess is initializing  class AccessValidator, 
        //it has to be initialized from outside and then injected, no mock can 
        //be done and the actual class is initialized to run the test
        AccessValidator<Teacher> accessValidator = new AccessValidator<Teacher>(this.repository);
        Teacher teacherAccess = accessValidator.verifyAccess(code);
        if (teacherAccess != null) {
            this.teacher = teacherAccess;
            return true;
        } else {
            return false;
        }
    }

    //TODO: Methods such as editScore, getSubjects or getElementSubjectByname 
    //must be moved from TeacherRepository class to this one.

    public void mainMenu(){
        System.out.println("=============================");
        System.out.println("Wellcome " + this.teacher.getName() + "!");
        System.out.println("=============================");
        System.out.println("\nMain menu\n");
        System.out.println("Students from " + Grade.ELEMENTARY_SCHOOL + ":");        
        System.out.println("_____________________________");
        for(Student i: studentRepository.getByGrade(Grade.ELEMENTARY_SCHOOL)){
            System.out.println(i.getName() + " -------- " + i.getCode());
        }
        System.out.println("=============================");
        System.out.println("Chose one of the following options or 'exit'.");
        System.out.println("1. manage_student_scores");
        // this.manageScores();
    }

    // public void manageScores(String code, SubjectScore subject, Score newScore){
    //     subject.setScore(newScore);
    // }
}
