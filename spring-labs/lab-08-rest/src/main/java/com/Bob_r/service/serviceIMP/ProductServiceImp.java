package com.Bob_r.service.serviceIMP;

import com.Bob_r.dto.ProductDTO;
import com.Bob_r.dto.ProductRequest;
import com.Bob_r.entity.Product;
import com.Bob_r.mapper.MapperUtil;
import com.Bob_r.repository.ProductRepository;
import com.Bob_r.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImp implements ProductService {
private final ProductRepository productRepository;
private final MapperUtil mapperUtil;

    public ProductServiceImp(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }


    @Override
    public List<ProductDTO> retrieveProductList() {
        // i  need list of product from my database
        // end return them as dto
//        productRepository.findAll()
//                .stream()
//                .map(product ->
//                        mapperUtil.convert(product,new ProductDTO()))
//                .collect(Collectors.toList());
        List<Product> all = productRepository.findAll();
        return  all.stream().map(list-> mapperUtil.convert(list,new ProductDTO())).collect(Collectors.toList());
    }



    @Override
    public ProductDTO updateProduct(ProductDTO productDTO) {
        Product save = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return mapperUtil.convert(save,new ProductDTO());
    }

    @Override
    public ProductDTO createProduct(ProductDTO productDTO) {
        Product save = productRepository.save(mapperUtil.convert(productDTO, new Product()));
        return mapperUtil.convert(save,new ProductDTO());
    }

    @Override
    public List<ProductDTO> retrieveAllProductByCategoryAndPrice(List<Long> categoryList, BigDecimal price) {
        return productRepository.retrieveProductListByCategory(categoryList,price).stream()
                .map(product -> mapperUtil.convert(product,new ProductDTO())).collect(Collectors.toList());
    }


}
