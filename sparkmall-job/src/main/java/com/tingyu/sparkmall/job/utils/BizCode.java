package com.tingyu.sparkmall.job.utils;

/**
 * @Author essionshy
 * @Create 2020/12/5 10:32
 * @Version renren-fast
 */
public enum BizCode {

    SCHEDULER_CREATE_ERROR(1001, "创建定时任务失败"),
    SCHEDULER_UPDATE_ERROR(1002, "更新定时任务失败"),
    SCHEDULER_RUN_ERROR(1003, "立即执行定时任务失败"),
    SCHEDULER_PAUSE_ERROR(1004, "暂停定时任务失败"),
    SCHEDULER_RESUME_ERROR(1005, "恢复定时任务失败"),
    SCHEDULER_DELETE_ERROR(1006, "删除定时任务失败");


    private int code;

    private String message;


    BizCode(int code, String message) {
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
