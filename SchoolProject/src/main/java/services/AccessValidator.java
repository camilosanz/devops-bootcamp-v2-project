package services;

// import models.Student;
// import models.Teacher;
import repositories.Repository;
// import repositories.TeacherRepository;

public class AccessValidator<T> {
    private Repository<T> repository;

    public AccessValidator(Repository<T> repository) {
        this.repository = repository;
    }

    public T verifyAccess(String code) {
        return this.repository.getByCode(code);
    }

}
