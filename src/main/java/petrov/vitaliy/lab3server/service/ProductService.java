package petrov.vitaliy.lab3server.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import petrov.vitaliy.lab3server.dao.ProductDAO;
import petrov.vitaliy.lab3server.model.Product;

import java.util.List;

@Service
public class ProductService {

    private final ProductDAO productDAO;

    @Autowired
    public ProductService(ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    public boolean addProduct(Product product) {
        List<Product> productList = productDAO.getProductList();
        Product productCandidate = findProductByName(product.getProductName());
        if (productCandidate == null) {
            productList.add(product);
            productCandidate = product;
        } else
            productCandidate.addProducts(product.getCount());
        return productList.contains(productCandidate);
    }

    public boolean buyProduct(Product product) {
        Product productCandidate = findProductByName(product.getProductName());
        if (productCandidate != null) {
            productCandidate.buyProduct(product.getCount());
        }
        return productCandidate != null;
    }

    public List<Product> getProductList() {
        return productDAO.getProductList();
    }

    private Product findProductByName(String productName) {
        List<Product> productList = productDAO.getProductList();
        return productList.stream().filter(product -> product.getProductName().equals(productName)).findAny().orElse(null);
    }
}
