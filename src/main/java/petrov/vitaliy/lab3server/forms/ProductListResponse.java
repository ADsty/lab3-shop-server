package petrov.vitaliy.lab3server.forms;

import lombok.Data;
import petrov.vitaliy.lab3server.model.Product;

import java.util.List;


@Data
public class ProductListResponse {
    private List<Product> products;
}
