package co.istad.testapi.feature;



import co.istad.testapi.domain.Product;
import co.istad.testapi.feature.dto.ProductRequest;
import co.istad.testapi.feature.dto.ProductResponse;
import org.springframework.data.domain.Page;

import java.util.List;

public interface ProductService {

    List<Product> getAllProducts();

    void createProduct(ProductRequest productRequest);

    ProductResponse getProductById(String id);

    void updateProduct(String id, ProductRequest productRequest);

//    Page<ProductResponse> getAllProducts(int pageNumber, int pageSize );
    Page<Product> getAllProducts(int pageNumber, int pageSize);

//    Page<Product> filterById(int pageNumber, int pageSize);


}
