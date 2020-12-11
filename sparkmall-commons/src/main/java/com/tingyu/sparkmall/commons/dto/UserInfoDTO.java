package com.tingyu.sparkmall.commons.dto;

import lombok.Data;

/**
 * @Author essionshy
 * @Create 2020/12/7 22:00
 * @Version renren-fast
 */
@Data
public class UserInfoDTO {

    private String userId; //保存登录用户ID

    private String userKey;  //保存临时用户

    private Boolean hasTempUserKey = false; //是否有临时用户Key,不论用户是否登录，都需要保存一个临时用户

}
