package com.tingyu.sparkmall.commons.support.enums;

/**
 * 系统业务代码大全
 *
 * @Author essionshy
 * @Create 2020/5/8 12:30
 * @Version sparkmall
 */
public enum BizCodeEnum {
    //异常处理代码


    //登录
    LOGIN_SUCCESS(200, "登录成功"),
    LOGIN_FAIL(201, "登录失败"),
    //验证码
    VERIFYCODE_EXPIRED(201, "验证码已经过期，请重新获取"),
    VERIFYCODE_EROOR(201, "验证码错误"),
    VERIFYCODE_GET_FAIL(10000, "验证码获取失败! 请刷新页面!"),
    VERFICODE_SEND_SUCCESS(10001, "验证码发送成功！！"),
    VERFICODE_SEND_FAIL(10002, "验证码发送失败！！"),
    //退出
    LOGINOUT_SUCCESS(200, "退出成功"),
    LOGINOUT_FAIL(201, "退出失败"),


    //提示代码
    SEARCH_SUCCESS(200, "查询成功"),
    ADD_SUCCESS(200, "添加成功"),
    UPDATE_SUCCESS(200, "修改成功"),
    DELETE_SUCCESS(200, "删除成功"),
    SEARCH_FAIL(201, "查询失败"),
    ADD_FAIL(201, "添加失败"),
    UPDATE_FAIL(201, "修改失败"),
    DELETE_FAIL(201, "删除失败"),

    //异常代码
    //系统模块,
    NULL_POINTER_EXCEPTION(1002, "空指针异常"),
    UNKNOWN_EXCEPTION(10000, "系统未知异常"),
    PARAM_VALID_EXCEPTION(10001, "参数校验异常"),
    PARAM_CONVERT_EXCEPTION(10003, "参数转换异常"),
    //用户模块
    ACCOUNT_LOCKED_EXCEPTION(11001, "账号已被锁定，请联系管理员进行处理！"),
    ACCOUNT_OR_PASSWORD_EROOR(11002, "账号或密码错误"),
    ACCOUNT_NOT_FOUND(11003, "账号不存在"),
    PASSWORD_ERROR(11004, "密码错误！"),
    PASSWORD_UPDATE_SUCCESS(11005, "密码修改成功"),
    PASSWORD_UPDATE_FAIL(11006, "密码修改失败"),
    PASSWORD_UPDATE_FAIL_OLD_PASSWORD_ERROR(11007, "密码修改失败,原密码不正确！！"),
    PASSWORD_RESET_SUCCESS(11008, "密码重置成功"),
    PASSWORD_RESET_FAIL(11009, "密码重置失败"),
    ACCOUNT_NOT_LOGINED(11010, "对不起，你还没有登录"),
    ACCOUNT_FIRST_LOGIN(11011, "用户首次登录，请立即修改密码"),
    //角色模块
    ROLE_EXSITS_EXCEPTION(12001, "该角色已经存在，请不要重复添加"),
    ROLE_NOT_FOUND_EXCEPTION(12002, "角色不存在，请重新选择要修改的角色"),

    //权限模块
    PERMISSION_EXISTS_EXCEPTION(13001, "该权限已经存在，请不要重复添加"),
    PERMISSION_EQUALS_PARENT_EXCEPTION(13002, "父级权限不能与当前权限相同"),
    PERMISSION_LEVEL_LESS_PARENT_EXCEPTION(13003, "当前权限等级不能少于选择父级权限的等级"),
    PERMISSION_ALLOT_SUCCESS(13004, "权限分配成功"),
    PERMISSION_ALLOT_FAIL(13005, "权限分配失败"),
    PERMISSION_NOT_FOUND(13006, "没有找到相关的权限信息"),
    //字典模块
    DICTIONARY_LOCKED(15001, "字典项被锁定"),
    DICTIONARY_TYPE_EXISTS(15002, "字典类型已存在，请不要重复添加！"),
    DICTIONARY_TYPE_NOT_EXISTS(15003, "字典类型不存在，请重新选择要更新的字典类型！"),

    DICTIONARY_ITEM_EXISTS(15004, "字典子项已存在，请不要重复添加！"),
    DICTIONARY_ITEM_NOT_EXISTS(15005, "字典子项不存在，请重新选择要更新的字典子项！"),


    //客户模块
    CUSTOMER_EXISTS(16001, "客户已经存在，请不要重复添加！"),
    CUSTOMER_NOT_EXISTS(16002, "客户不存在，请重新选择要修改的客户！"),

    //联系人模块
    LINKMAN_EXISTS(16001, "联系人已经存在，请不要重复添加！"),
    LINKMAN_NOT_EXISTS(16002, "联系人不存在，请重新选择要修改的联系人！"),

    //客户关怀
    CUSTOMER_CARE_EXISTS(17001, "客户关怀记录已经存在，请不要重复添加！"),
    CUSTOMER_CARE_NOT_EXISTS(17002, "客户关怀记录不存在，请重新选择要修改的客户关怀！"),
    CUSTOMER_CARE_SKIP_SUCCESS(17003, "客户关怀忽略成功！"),
    CUSTOMER_CARE_SKIP_FAIL(17004, "客户关怀忽略失败！"),
    CUSTOMER_CARE_HANDLE_SUCCESS(17005, "客户关怀处理成功！"),
    CUSTOMER_CARE_HANDLE_FAIL(17006, "客户关怀处理失败！"),
    //客户转移
    CUSTOMER_TRANSFER_EXISTS(18001, "客户转移记录已经存在，请不要重复添加！"),
    CUSTOMER_TRANSFER_NOT_EXISTS(18002, "客户转移记录不存在，请重新选择要修改的客户转移！"),
    CUSTOMER_TRANSFER_OLD_MANAGER_NOT_EXISTS(18003, "原客户经理不存在，请核实！"),
    CUSTOMER_TRANSFER_NEW_MANAGER_NOT_EXISTS(18004, "目标客户经理不存在，请重新选择！"),
    CUSTOMER_TRANSFER_SUCCESS(18005, "客户转移处理成功！"),
    CUSTOMER_TRANSFER_FAIL(18006, "客户转移处理失败！"),
    //客户跟踪
    CUSTOMER_FOLLOWUP_EXISTS(19001, "客户跟踪记录已经存在，请不要重复添加！"),
    CUSTOMER_FOLLOWUP_NOT_EXISTS(19002, "客户跟踪记录不存在，请重新选择要修改的客户跟踪！"),
    CUSTOMER_FOLLOWUP_SUCCESS(19005, "客户跟踪处理成功！"),
    CUSTOMER_FOLLOWUP_FAIL(19006, "客户跟踪处理失败！"),
    //客户流失
    CUSTOMER_LOSS_EXISTS(20001, "客户流失记录已经存在，请不要重复添加！"),
    CUSTOMER_LOSS_NOT_EXISTS(20002, "客户流失记录不存在，请重新选择要修改的客户流失！"),
    CUSTOMER_LOSS_SUCCESS(20005, "客户流失处理成功！"),
    CUSTOMER_LOSS_FAIL(20006, "客户流失处理失败！"),

    //工作流

    PROCESS_PUBLISH_SUCCESS(21001, "流程部署成功"),
    PROCESS_PUBLISH_FAIL(21002, "流程部署失败"),
    PROCESS_START_SUCCESS(21003, "流程启动成功"),
    PROCESS_START_FAIL(21004, "流程启动失败"),
    PROCESS_HANDLE_SUCCESS(21005, "流程处理成功"),
    PROCESS_HANDLE_FAIL(21006, "流程处理失败"),
    PROCESS_EXISTS(21007, "流程已存在，请不要重复部署"),
    PROCESS_NOT_FOUND(21008, "流程不存在"),

    //抽奖系统

    LOTTERY_SUCCESS(30001, "恭喜您，中奖啦！奖品编号："),
    LOTTERY_FAIL(30002, "再接再厉！"),
    LOTTERY_EXISTS(30003, "您已经抽中奖品，请不要重复抽取...."),
    LOTTERY_OVER(30004, "抽奖已结束，谢谢您的参与，下次再会..."),

    LOTTERY_REGISTERED(30005, "您已经参加本次抽奖活动，敬请期待"),

    //库存模块
    WARE_NOT_ENOUGH(40001, "库存不足"),


    //Redis
    REDIS_NOT_ENABLE(30001, "Redis服务未开启！");


    //属性
    private int code;

    private String message;

    BizCodeEnum(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

}
