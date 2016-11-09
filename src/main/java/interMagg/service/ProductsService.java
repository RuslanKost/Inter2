package interMagg.service;

import interMagg.model.Products;

import java.util.List;

/**
 * Created by rysja on 11.10.16.
 */
public interface ProductsService {

    public void addProducts(Products products);

    public void updateProduct(Products products);

    public void removeProduct(int id);

    public Products getProductById(int id);

    public List<Products> listProducts();
}
