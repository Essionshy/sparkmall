package com.tingyu.sparkmall.product.app;

import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.product.param.CategoryParam;
import com.tingyu.sparkmall.product.service.CategoryService;
import com.tingyu.sparkmall.product.vo.CategoryVo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @Author essionshy
 * @Create 2020/11/29 11:55
 * @Version renren-fast
 */
@RestController
@RequestMapping("api/product/category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @ApiOperation("条件分页查询商品分类列表")
    @PostMapping("list/page")
    public R listByPage(@RequestBody CategoryParam param) {

        Map<String, Object> map = categoryService.listByPage(param);

        return R.ok().put(map);
    }

    @ApiOperation("查询全部商品分类列表")
    @GetMapping("list")
    public R list() {

        List<CategoryVo> list = categoryService.listAll();

        return R.ok().put("items", list);
    }

    @ApiOperation("添加商品类别")
    @PostMapping("save")
    public R save(@RequestBody CategoryParam param) {

        boolean isSuccess = categoryService.saveCategory(param);
        if (isSuccess) {

            return R.ok();
        } else {
            return R.error();

        }
    }


    @ApiOperation("添加商品类别")
    @PutMapping("update")
    public R update(@RequestBody CategoryParam param) {

        boolean isSuccess = categoryService.updateCategory(param);
        if (isSuccess) {

            return R.ok();
        } else {
            return R.error();

        }
    }

    @ApiOperation("根据商品分类ID查询商品分类信息")
    @GetMapping("get/{categoryId}")
    public R get(@PathVariable("categoryId") Long categoryId) {

        CategoryVo category = categoryService.getByCategoryId(categoryId);

        return R.ok().put("item", category);
    }


    @ApiOperation("根据商品分类ID删除商品分类信息")
    @GetMapping("delete/{categoryId}")
    public R delete(@PathVariable("categoryId") Long categoryId) {
        boolean isSuccess = categoryService.deleteByCategoryId(categoryId);
        if (isSuccess) {

            return R.ok();
        } else {
            return R.error();

        }
    }

}
