package db.service;

import db.dao.ProductDAO;
import db.entities.ProductEntitty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.transaction.Transactional;

@Service
public class ProductService {

        @Autowired
        private ProductDAO productDAO;

        @Transactional
        public void add(ProductEntitty productEntitty) {
            productDAO.add(productEntitty);
        }
}
