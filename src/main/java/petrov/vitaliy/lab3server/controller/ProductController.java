package petrov.vitaliy.lab3server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import petrov.vitaliy.lab3server.forms.ConfirmationResponse;
import petrov.vitaliy.lab3server.forms.ProductListResponse;
import petrov.vitaliy.lab3server.forms.InputRequest;
import petrov.vitaliy.lab3server.forms.ResponseCode;
import petrov.vitaliy.lab3server.model.Product;
import petrov.vitaliy.lab3server.service.ProductService;

import java.util.ArrayList;


@RestController
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/list")
    public ProductListResponse getProductList() {
        ProductListResponse response = new ProductListResponse();
        response.setProducts(productService.getProductList());
        return response;
    }

    @PostMapping("/add")
    public ConfirmationResponse addProducts(@RequestBody InputRequest addProductsRequest) {

        ConfirmationResponse response = new ConfirmationResponse();
        response.setUsername(addProductsRequest.getProducts().get(0).getUsername());

        ArrayList<Product> productList = addProductsRequest.getProducts();

        for (Product product : productList) {
            if (!productService.addProduct(product))
                response.setCode(ResponseCode.PRODUCT_NOT_ADDED);
        }
        if (response.getCode() == null)
            response.setCode(ResponseCode.PRODUCT_ADDED);

        return response;
    }

    @PostMapping("/buy")
    public ConfirmationResponse buyProducts(@RequestBody InputRequest buyProductsRequest) {

        ConfirmationResponse response = new ConfirmationResponse();
        response.setUsername(buyProductsRequest.getProducts().get(0).getUsername());

        ArrayList<Product> productList = buyProductsRequest.getProducts();

        for (Product product : productList) {
            if (!productService.buyProduct(product))
                response.setCode(ResponseCode.PURCHASE_NOT_COMPLETE);
        }
        if (response.getCode() == null)
            response.setCode(ResponseCode.PURCHASE_COMPLETE);

        return response;
    }
}
