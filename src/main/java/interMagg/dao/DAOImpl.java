package interMagg.dao;

import interMagg.model.Products;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;


/**
 * Created by rysja on 11.10.16.
 */
public class DAOImpl implements DAO {
    private static final Logger logger = LoggerFactory.getLogger(DAOImpl.class);
    private SessionFactory sessionFactory;

    public void setSessionFactory(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public void addProducts(Products products) {
        Session session=this.sessionFactory.getCurrentSession();
        session.persist(products);
        logger.info("Product successfully saved. Product details: "+products);

    }

    @Override
    public void updateProduct(Products products) {
        Session session=this.sessionFactory.getCurrentSession();
        session.update(products);
        logger.info("Product successfully update. Product details: "+products);

    }

    @Override
    public void removeProduct(int id) {
        Session session=this.sessionFactory.getCurrentSession();
        Products products = (Products) session.load(Products.class, new Integer(id));

        if(products!=null){
            session.delete(products);
        }
        logger.info("Book successfully removed. Book details: " + products);
    }

    @Override
    public Products getProductById(int id) {
        Session session =this.sessionFactory.getCurrentSession();
        Products products = (Products) session.load(Products.class, new Integer(id));
        logger.info("Book successfully loaded. Book details: " + products);

        return products;
    }

    @Override
    public List<Products> listProducts() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Products> bookList = session.createQuery("from Products").list();

        for(Products products: bookList){
            logger.info("Book list: " + products);
        }

        return bookList;
    }
}
