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
public class UsersExtends implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * users表id
     */
    private Integer userId;


}
