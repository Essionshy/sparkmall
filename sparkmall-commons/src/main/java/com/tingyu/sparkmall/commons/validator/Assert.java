package com.tingyu.sparkmall.commons.validator;

/**
 * @Author essionshy
 * @Create 2020/4/14 10:11
 * @Version crm
 */


import com.tingyu.sparkmall.commons.exception.ResultException;
import org.apache.commons.lang.StringUtils;

/**
 * 自定系统参数校验，使得系统可以抛出自定义异常，类似Spring,Shiro等框架都会有自己的断言
 * 构造方法私有化或者设置为抽象类都可以使得该类不能被实例化
 */
public abstract class Assert {
    public Assert() {
    }

    /**
     * 判断字符串是否为空（包含空格，制表符）
     *
     * @param str
     */
    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new ResultException(message);
        }
    }

    /**
     * 判断对象是否为空
     *
     * @param object
     * @param message
     */
    public static void isNull(Object object, String message) {
        if (object == null) {
            throw new ResultException(message);
        }
    }

    /**
     * 判断表达式是否为True
     *
     * @param expression
     * @param message
     */
    public static void isTrue(boolean expression, String message) {
        if (!expression) {
            throw new ResultException(message);
        }
    }
}
