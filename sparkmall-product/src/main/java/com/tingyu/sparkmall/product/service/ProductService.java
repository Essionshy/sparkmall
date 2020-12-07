package com.tingyu.sparkmall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.product.vo.ProductVo;
import com.tingyu.sparkmall.product.entity.ProductEntity;
import com.tingyu.sparkmall.product.param.ProductParam;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:54
 * @Version renren-fast
 */
public interface ProductService extends IService<ProductEntity> {
    boolean deleteByProductId(Long productId);

    ProductVo getByProductId(Long productId);

    boolean updateProduct(ProductParam param);

    boolean saveProduct(ProductParam param);

    List<ProductVo> listAll();

    Map<String, Object> listByPage(ProductParam param);

    List<ProductDTO> listByProducts(List<String> products);

    ProductDTO getByProductNo(String productNo);

}
