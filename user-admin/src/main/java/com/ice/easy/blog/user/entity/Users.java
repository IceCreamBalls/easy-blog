package com.ice.easy.blog.user.entity;

import java.time.LocalDateTime;
import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuhao
 * @since 2021-09-20
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class Users implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户昵称
     */
    private String name;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 电话号码
     */
    private String phone;

    /**
     * 密码
     */
    private String password;

    /**
     * 创建时间
     */
    private String createAt;

    /**
     * 修改时间
     */
    private String updateAt;

    /**
     * 是否可用
     */
    private Integer deleteFlag;

    /**
     * 邮箱
     */
    private String email;

}
