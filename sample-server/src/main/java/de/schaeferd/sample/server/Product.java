package de.schaeferd.sample.server;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Version;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Product
{
    @Id
    private Long id;
    private String name;
    private String description;
    private Double price;

    @Version
    private Long version;
}
