package br.com.roggen.product.impl.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
public class Product {
    @Id
    private String id;
    private String name;
    private BigDecimal price;
}
