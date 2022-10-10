import models.School;
import models.Student;
import models.SubjectScore;
import repositories.StudentRepository;
import repositories.TeacherRepository;
import services.StudentServices;
import services.TeacherServices;
import services.UserServices;

import java.util.Scanner;

import helpers.Score;


public class Main {
    public static void main(String args[]) {
        StudentRepository studentRepository = new StudentRepository();
        TeacherRepository teacherRepository = new TeacherRepository();
        StudentServices studentServices = new StudentServices(studentRepository);
        TeacherServices teacherServices = new TeacherServices(teacherRepository, studentRepository);
        UserServices userServices = teacherServices;
        

        Scanner scanner = new Scanner(System.in);
        var school = new School("American School");

        System.out.println("=============================");
        System.out.println("Welcome to " + school.getName());
        System.out.println("=============================");

        System.out.println("Select your role please: ");
        System.out.println("1. Teacher");
        System.out.println("2. Student");

        String option = scanner.nextLine();
        Boolean access = false;
        String action = "";

        switch (option) {
            case "1":
                userServices = teacherServices;
                studentServices.readData();
                studentServices.writeData();
                break;
            case "2":
                userServices = studentServices;
                break;
        }

        userServices.readData();
        userServices.writeData();

        while(!access){
            System.out.println("Please enter your code:");
            String userCode = scanner.nextLine();
            access = userServices.validateAccess(userCode);
        }
        
        while(!action.equals("exit")){
            school.showMainMenu(userServices);
            action = scanner.nextLine();
            while(action.equals("1") && option.equals("1")){
                System.out.println("=============================");
                System.out.println("Enter student code to add a new score:");
                action = scanner.nextLine();
                Student student = studentRepository.getByCode(action);
                System.out.println("=============================");
                System.out.println(student.getName());
                studentServices.printSubjects(action);
                System.out.println("=============================");
                System.out.println("Enter subject name to add a new score to:");
                action = scanner.nextLine();
                SubjectScore subject = studentRepository.getElementSubjectByName(action, student.getCode());
                System.out.println("=============================");
                System.out.println("Enter score");
                action = scanner.nextLine();
                Score newScore = Score.valueOf(action);                
                subject.setScore(newScore);
                System.out.println(student.getName());
                studentServices.printSubjects(student.getCode());
                System.out.println("=============================");
                System.out.println("Press 'Enter' to continue or enter 'exit':");
                action = scanner.nextLine();
            }
        }
        scanner.close();
    }
}
