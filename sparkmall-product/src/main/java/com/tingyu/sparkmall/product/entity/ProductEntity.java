package com.tingyu.sparkmall.product.entity;

import lombok.*;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @Author essionshy
 * @Create 2020/4/22 18:25
 * @Version sparkmall
 */

@NoArgsConstructor
@AllArgsConstructor
@Data
@EqualsAndHashCode
@ToString
@Accessors(chain = true)
public class ProductEntity implements Serializable {

    /**
     * 商品ID
     */
    private Long id;

    /**
     * 商品名称
     */
    @NotBlank(message = "商品名称不能为空")
    private String name;

}
