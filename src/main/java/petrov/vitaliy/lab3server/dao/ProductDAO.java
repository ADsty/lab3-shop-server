package petrov.vitaliy.lab3server.dao;

import org.springframework.stereotype.Component;
import petrov.vitaliy.lab3server.model.Product;

import java.util.ArrayList;
import java.util.List;

@Component
public class ProductDAO {
    List<Product> productList;

    {
        productList = new ArrayList<>();
    }

    public List<Product> getProductList() {
        return productList;
    }
}
