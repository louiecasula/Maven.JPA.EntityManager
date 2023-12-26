package services;

import entities.WordInfo;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.util.List;

public class WordInfoService implements DAO<WordInfo> {
    private final EntityManager entityManager;

    public WordInfoService(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    public WordInfo findById(Long id) {
        return entityManager.find(WordInfo.class, id);
    }

    @Override
    public List<WordInfo> findAll() {
        Query query = entityManager.createQuery("SELECT w FROM WordInfo w", WordInfo.class);
        return query.getResultList();
    }

    @Override
    public WordInfo create(WordInfo wordInfo) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            entityManager.persist(wordInfo);
            transaction.commit();
            return wordInfo;
        } catch (Exception e) {
            if (transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        }
    }

    @Override
    public WordInfo update(WordInfo wordInfo) {
        EntityTransaction transaction = entityManager.getTransaction();

        try {
            transaction.begin();
            WordInfo updatedWordInfo = entityManager.merge(wordInfo);
            transaction.commit();
            return updatedWordInfo;
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
            WordInfo wordInfoToDelete = entityManager.find(WordInfo.class, id);

            if (wordInfoToDelete != null) {
                entityManager.remove(wordInfoToDelete);
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
