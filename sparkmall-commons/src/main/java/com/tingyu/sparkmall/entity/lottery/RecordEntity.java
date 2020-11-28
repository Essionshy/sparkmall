package com.tingyu.sparkmall.entity.lottery;

import com.baomidou.mybatisplus.annotation.*;
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


    @TableId(type = IdType.AUTO)
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
    @TableField(fill = FieldFill.INSERT)
    private Date createtime;
    /**
     *
     */
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updatetime;

}
