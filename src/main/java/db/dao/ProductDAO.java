package db.dao;

import db.entities.ProductEntitty;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class ProductDAO {
    @Autowired
    private SessionFactory sessionFactory;

    public void add(ProductEntitty productEntitty) {
        sessionFactory.getCurrentSession().save(productEntitty);
    }


}
