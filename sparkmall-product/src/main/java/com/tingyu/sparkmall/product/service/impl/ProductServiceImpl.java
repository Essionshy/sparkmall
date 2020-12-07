package com.tingyu.sparkmall.product.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.product.mapper.ProductMapper;
import com.tingyu.sparkmall.product.vo.ProductVo;
import com.tingyu.sparkmall.product.entity.ProductEntity;
import com.tingyu.sparkmall.product.param.ProductParam;
import com.tingyu.sparkmall.product.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:54
 * @Version renren-fast
 */
@Service
@Slf4j
public class ProductServiceImpl extends ServiceImpl<ProductMapper, ProductEntity> implements ProductService {
    @Override
    public boolean deleteByProductId(Long productId) {
        return baseMapper.deleteById(productId) > 0;
    }

    @Override
    public ProductVo getByProductId(Long productId) {

        ProductEntity productEntity = baseMapper.selectById(productId);

        if (null == productEntity) {
            return null;
        }
        ProductVo productVo = new ProductVo();
        BeanUtils.copyProperties(productEntity, productVo);

        return productVo;
    }

    @Override
    public boolean updateProduct(ProductParam param) {

        if (null == param) {
            return false;
        }
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(param, productEntity);


        return baseMapper.updateById(productEntity) > 0;
    }

    @Override
    public boolean saveProduct(ProductParam param) {
        if (null == param) {
            return false;
        }
        ProductEntity productEntity = new ProductEntity();

        BeanUtils.copyProperties(param, productEntity);


        return baseMapper.insert(productEntity) > 0;
    }

    @Override
    public List<ProductVo> listAll() {


        return null;
    }

    @Override
    public Map<String, Object> listByPage(ProductParam param) {

        Map<String, Object> map = new HashMap<>();
        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();


        Page<ProductEntity> page = new Page<>(param.getPage(), param.getLimit());

        baseMapper.selectPage(page, wrapper);

        long total = page.getTotal();
        List<ProductEntity> records = page.getRecords();
        List<ProductVo> productVoList = null;
        if (records != null && records.size() > 0) {
            productVoList = records.stream().map(productEntity -> {
                ProductVo productVo = new ProductVo();

                BeanUtils.copyProperties(productEntity, productVo);
                return productVo;
            }).collect(Collectors.toList());
        }
        map.put("total", total);
        map.put("items", productVoList);
        return map;
    }

    @Override
    public List<ProductDTO> listByProducts(List<String> productNos) {

        if (null == productNos) {
            return null;
        }

        if (productNos.size() <= 0) {
            return null;
        }

        List<ProductDTO> productDTOS = new ArrayList<>();

        for (String productNo : productNos) {

            ProductDTO productDTO = this.getByProductNo(productNo);
            if (null != productDTO) {
                productDTOS.add(productDTO);
            }

        }

        return productDTOS;
    }

    @Override
    public ProductDTO getByProductNo(String productNo) {

        if (productNo == null || StringUtils.isEmpty(productNo)) {
            return null;
        }

        QueryWrapper<ProductEntity> wrapper = new QueryWrapper<>();
        wrapper.eq("product_no", productNo);

        ProductEntity productEntity = baseMapper.selectOne(wrapper);

        if (null == productEntity) {
            return null;
        }

        ProductDTO productDTO = new ProductDTO();
        BeanUtils.copyProperties(productEntity, productDTO);
        return productDTO;
    }
}
