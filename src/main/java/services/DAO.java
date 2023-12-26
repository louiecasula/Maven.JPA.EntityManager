package services;
import java.util.List;

public interface DAO<T> {
    T findById(Long id);
    List<T> findAll();
    T create(T t);
    T update(T t);
    void delete(Long id);
}
