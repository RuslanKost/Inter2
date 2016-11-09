package interMagg.service;



import interMagg.dao.DAO;
import interMagg.model.Products;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rysja on 11.10.16.
 */
public class ProductsServiceImpl implements ProductsService {
    private DAO dao;

    public void setDao(DAO dao) {
        this.dao = dao;
    }

    @Override
    @Transactional
    public void addProducts(Products products) {
        this.dao.addProducts(products);
    }

    @Override
    @Transactional
    public void updateProduct(Products products) {
this.dao.updateProduct(products);
    }

    @Override
    @Transactional
    public void removeProduct(int id) {
this.dao.removeProduct(id);
    }

    @Override
    @Transactional
    public Products getProductById(int id) {
        return this.dao.getProductById(id);
    }

    @Override
    @Transactional
    public List<Products> listProducts() {
        return this.dao.listProducts();
    }
}
