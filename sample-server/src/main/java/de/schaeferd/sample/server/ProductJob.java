package de.schaeferd.sample.server;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Slf4j
@Component
@RequiredArgsConstructor
public class ProductJob
{
    private final ProductRepository repository;

    @Scheduled(fixedDelay = 60, initialDelay = 5, timeUnit = TimeUnit.SECONDS)
    public void run()
    {
        var products = repository.findAll();
        log.info("Found {} products in database", products.size());
        products.forEach(product -> log.debug(" - {}", product));
    }
}
