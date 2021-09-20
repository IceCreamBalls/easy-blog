package com.ice.easy.blog.user.entity;

import java.io.Serializable;
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
public class Oauths implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer userId;

    private Integer oauthId;

    /**
     * 第三方类型:[微信，qq，微博]
     */
    private String oauthType;

    /**
     * 第三方unionid
     */
    private String unionid;

    /**
     * 密码凭证
     */
    private String credentials;

    /**
     * 是否可用
     */
    private Integer deleteFlag;


}
