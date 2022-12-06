package repository;

import configuration.DatabaseConfiguration;
import entity.BaseEntity;
import entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import javax.persistence.Query;
import java.io.Serializable;
import java.util.List;

public abstract class BaseRepository<E extends BaseEntity> {

    SessionFactory sessionFactory = DatabaseConfiguration.getSessionFactory();
    String entityName;
    private Class<E> type;

    public BaseRepository(String entityName, Class<E> type) {
        this.entityName = entityName;
        this.type = type;
    }

    public boolean create(E e) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        Serializable createdId = session.save(e);
        session.getTransaction().commit();
        session.close();

        return createdId instanceof Long;
    }

    public void update(E e, Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        E result = session.load(type, id);
        result = e;
        result.setId(id);
        session.update(result);
        session.getTransaction().commit();
        session.close();
    }

    public E findById(Long id) {
        Session session = sessionFactory.openSession();
        E result = session.get(type, id);
        session.close();
        return result;
    }


    public List<E> findAll() {
        Session session = sessionFactory.openSession();
        Query query = session.createQuery("select e from " + entityName + " e");
        List list = ((org.hibernate.query.Query<?>) query).list();
        session.close();
        return list;
    }

    public void delete(Long id) {
        Session session = sessionFactory.openSession();
        session.beginTransaction();

        E result = session.get(type, id);
        Student user = session.get(Student.class, 1);

        session.delete(result);
        session.getTransaction().commit();
        session.close();
    }
}
