package com.tingyu.sparkmall.coupon.bean;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * 自定义容器组件导入选择器
 *
 * @Author essionshy
 * @Create 2020/12/5 16:16
 * @Version renren-fast
 */

public class CustomImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {

        // 不能返回 null ,否则程序会报错

        return new String[]{""};
    }
}
