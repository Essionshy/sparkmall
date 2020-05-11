package com.tingyu.sparkmall.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author essionshy
 * @email 1218817610@qq.com
 * @date 2020-05-11 14:20:55
 */
@Data
@TableName("record")
public class RecordEntity implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     *
     */
    @TableId
    private Long recordId;
    /**
     *
     */
    private String username;
    /**
     *
     */
    private String phone;
    /**
     *
     */
    private String address;
    /**
     *
     */
    private Integer prizeId;
    /**
     *
     */
    private Integer status;
    /**
     *
     */
    private Date createtime;
    /**
     *
     */
    private Date updatetime;

}
