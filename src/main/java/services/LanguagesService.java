package services;

import entities.Languages;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class LanguagesService implements DAO<Languages> {
    private final EntityManager entityManager;

    public LanguagesService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public Languages findById(Long id) {
        return entityManager.find(Languages.class, id);
    }

    @Override
    public List<Languages> findAll() {
        Query query = entityManager.createQuery("SELECT l FROM Languages l", Languages.class);
        return query.getResultList();
    }

    @Override
    public Languages create(Languages languages) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(languages);
            transaction.commit();
            return languages;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public Languages update(Languages languages) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Languages updatedLanguages = entityManager.merge(languages);
            transaction.commit();
            return updatedLanguages;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            Languages languagesToDelete = entityManager.find(Languages.class, id);

            if (languagesToDelete != null) {
                entityManager.remove(languagesToDelete);
            }

            transaction.commit();
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }
}
