package de.schaeferd.sample.client;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.vaadin.flow.server.auth.AnonymousAllowed;
import com.vaadin.hilla.BrowserCallable;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Objects;

@Slf4j
@Service
@BrowserCallable
@AnonymousAllowed
public class ProductService
{
    private RestClient restClient;
    private ObjectMapper objectMapper = new ObjectMapper();

    public ProductService(RestClient.Builder restClientBuilder, ObjectMapper objectMapper)
    {
        this.objectMapper = objectMapper;
        this.restClient = restClientBuilder
                .baseUrl("http://localhost:8080")
                .build();
    }

    public List<Product> findAll() throws JsonProcessingException
    {
        log.info("Fetching all products from server");
        String response = Objects.requireNonNull(restClient.get()
                .uri("/products")
                .retrieve()
                .body(String.class));

        log.info("Server responded with: {}", response);
        var responseJson = objectMapper.readTree(response);
        List<Product> products = objectMapper.treeToValue(responseJson.get("_embedded").get("products"), new TypeReference<>() {});

        log.info("Fetched {} products", products.size());
        products.forEach(product -> log.debug("- {}", product));
        return products;
    }
}
