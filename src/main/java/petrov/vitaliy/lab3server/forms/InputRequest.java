package petrov.vitaliy.lab3server.forms;

import lombok.Data;
import petrov.vitaliy.lab3server.model.Product;

import java.util.ArrayList;

@Data
public class InputRequest {
    private ArrayList<Product> products;
}
