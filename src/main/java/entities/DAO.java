package entities;
import java.util.List;

public interface DAO<T> {
    T findById(int id);
    List<T> findAll();
    T create(T t);
    T update(T t);
    void delete(int id);
}
