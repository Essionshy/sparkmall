package com.tingyu.sparkmall.search;

import com.tingyu.sparkmall.commons.utils.R;
import com.tingyu.sparkmall.search.service.SearchService;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Author essionshy
 * @Create 2020/12/7 0:55
 * @Version renren-fast
 */
@RestController
@RequestMapping("search")
@Slf4j
public class SearchController {


    @Resource
    private SearchService searchService;

    @ApiOperation("查询全部")
    @PostMapping("list")
    public R list() {


        return R.ok();
    }

    @PostMapping("save")
    public R save(String content) {


        searchService.save(content);

        return R.ok();
    }

}
