package petrov.vitaliy.lab3server.model;

import lombok.Data;

@Data
public class Product {
    private String username;
    private String productName;
    private int count;
    private Integer price;

    public int buyProduct(int valueToBuy) {
        count -= valueToBuy;
        return count;
    }

    public int addProducts(int valueToAdd) {
        count += valueToAdd;
        return count;
    }
}
