package com.tingyu.sparkmall.product.app;

import com.tingyu.sparkmall.commons.dto.ProductDTO;
import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.product.param.ProductParam;
import com.tingyu.sparkmall.product.service.ProductService;
import com.tingyu.sparkmall.product.vo.ProductVo;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/4/21 23:55
 * @Version sparkmall
 */
@Slf4j
@RestController
@RequestMapping("/product/item")
public class ProductController {

    @Autowired
    private ProductService productService;

    @ApiOperation("")
    @PostMapping("list/page")
    public R listByPage(@RequestBody ProductParam param) {

        Map<String, Object> map = productService.listByPage(param);

        return R.ok().put(map);
    }

    @ApiOperation("")
    @GetMapping("list")
    public R list() {
        List<ProductVo> list = productService.listAll();
        return R.ok().put("items", list);
    }

    @ApiOperation("添加商品类别")
    @PostMapping("save")
    public R save(@RequestBody ProductParam param) {
        boolean isSuccess = productService.saveProduct(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }


    @ApiOperation("添加商品类别")
    @PutMapping("update")
    public R update(@RequestBody ProductParam param) {

        boolean isSuccess = productService.updateProduct(param);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();

        }
    }

    @ApiOperation("")
    @GetMapping("get/{ProductId}")
    public R get(@PathVariable("ProductId") Long ProductId) {
        ProductVo Product = productService.getByProductId(ProductId);
        return R.ok().put("item", Product);
    }

    @ApiOperation("")
    @GetMapping("delete/{ProductId}")
    public R delete(@PathVariable("ProductId") Long ProductId) {
        boolean isSuccess = productService.deleteByProductId(ProductId);
        if (isSuccess) {
            return R.ok();
        } else {
            return R.error();
        }
    }

    /*远程调用方法*/

    @PostMapping("fiegn/list")
    public List<ProductDTO> listByProducts(@RequestBody List<String> products) {

        List<ProductDTO> productDTOS = productService.listByProducts(products);

        return productDTOS;

    }

}
