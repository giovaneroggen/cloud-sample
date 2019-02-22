package br.com.roggen.product.contract.v1.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by Seven on 04/07/2018.
 */
@Data
@Builder
@AllArgsConstructor
public class ProductResponse {
    private String id;
    private String name;
    private BigDecimal price;
}
