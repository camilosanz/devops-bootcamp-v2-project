package models;

// import services.TeacherServices;
import services.UserServices;

// import java.util.List;

public class School {
    private String name;
    // private List<Student> students;

    public School(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void showMainMenu(UserServices userServices) {
        userServices.mainMenu();
    }
}
