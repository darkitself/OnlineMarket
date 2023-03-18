package com.study.onlinemarket.service.impl;

import com.study.onlinemarket.adapter.repository.ProductRepository;
import com.study.onlinemarket.domain.dto.request.CreateProductRequest;
import com.study.onlinemarket.domain.dto.response.ProductResponse;
import com.study.onlinemarket.domain.entity.Product;
import com.study.onlinemarket.domain.entity.context.ProductContext;
import com.study.onlinemarket.service.ProductService;
import com.study.onlinemarket.service.factory.ProductFactory;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
public class ProductServiceImpl implements ProductService {

    ProductFactory productFactory;
    ProductRepository productRepository;

    @Override
    public List<ProductResponse> getProductsByManufacturer(Long manufacturerId) {

        //Конечно, фильтрация по производителю должна быть реализована на уровне запроса в бд
        //Т.к. мы не используем бд, то, чтобы не перегружать наш BaseStubRepository, просто достаем все продукты, и уже потом производим фильтрацию
        return productRepository.findAll().stream()
                .filter(p -> p.getManufacturer().getId().equals(manufacturerId))
                .map(productFactory::createProductResponseFrom)
                .collect(Collectors.toList());
    }

    @Override
    public List<ProductResponse> getProductList() {
        return productRepository.findAll().stream()
                .map(productFactory::createProductResponseFrom)
                .collect(Collectors.toList());
    }

    @Override
    public ProductResponse addNewProduct(CreateProductRequest request) {
        ProductContext context = productFactory.createProductContextFrom(request);
        Product product = Product.createProductFrom(context);

        //Мы добавляем связь между производителем и продуктом на уровне сервиса, что не очень правильно и приятно.
        //Это вызвано в первую очередь тем, что мы работаем без настоящей базы, и связи у нас не "настоящие".
        //Так что это одно из тех мест, которые придется переписать после перехода к настоящей базе и настоящим репозиториям
        //Поэтому если будете использовать похожий подход в своём проекте -- стараетесь не плодить сущности до тех пор, пока не появятся нормальные репозитории.
        //Вместо этого постарайтесь сделать акцент на более общих вещах, которые пригодятся в любом случае (валидация, логирование, обработка ошибок, тесты?, etc)
        product.getManufacturer().addNewProduct(product);
        product = productRepository.save(product);
        return productFactory.createProductResponseFrom(product);
    }
}
