package co.istad.testapi.feature;

import co.istad.testapi.domain.Product;
import co.istad.testapi.feature.dto.ProductRequest;
import co.istad.testapi.feature.dto.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {

        return productRepository.findAll();

    }



    @Override
    public void createProduct(ProductRequest productRequest) {

        Product product = new Product();
        product.setId(UUID.randomUUID().toString());
        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());
        productRepository.save(product);

    }

    @Override
    public ProductResponse getProductById(String id) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id)
                );
        return ProductResponse.builder()
                .id(product.getId())
                .name(product.getName())
                .description(product.getDescription())
                .price(product.getPrice())
                .quantity(product.getQuantity())
                .build();
    }

    @Override
    public void updateProduct(String id, ProductRequest productRequest) {

        Product product = productRepository.findById(id)
                .orElseThrow(
                        () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found with id: " + id)
                );

        product.setName(productRequest.name());
        product.setDescription(productRequest.description());
        product.setPrice(productRequest.price());
        product.setQuantity(productRequest.quantity());

        productRepository.save(product);
    }

    @Override
    public Page<Product> getAllProducts(int pageNumber, int pageSize) {
        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
        return productRepository.findAll(pageRequest);
    }


//    @Override
//    public Page<Product> filterById(int pageNumber, int pageSize) {
//        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize);
//        return productRepository.findAll(pageRequest);
//    }

}
