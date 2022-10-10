package services;

import repositories.Repository;

import java.util.List;

public class WriteDataService<T> {
    private Repository<T> repository;

    public WriteDataService(Repository<T> repository) {
        this.repository = repository;
    }

    public void writeDataToRepository(List<T> objList) {
        objList.forEach(student -> this.repository.add(student));
    }
}
