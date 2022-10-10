package repositories;

import java.util.List;

public interface Repository <T> {
    List<T> getAll();
    T getByCode(String code);
    void add(T o); 
}
