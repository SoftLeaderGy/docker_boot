package com.yang.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import  java.util.Date;

@Data
@TableName("t_user")
public class  User implements Serializable {
    @TableId
    private String  id ;
     /**
     *  用户名
      */
    private  String  username ;

    /**
    *  密码
    */
    private  String  password ;

    /**
    *  性别  0= 女  1= 男
    */
    private  Byte  sex ;

    /**
    *  删除标志，默认 0 不删除， 1 删除
    */
    private  Byte  deleted ;

    /**
    *  更新时间
    */
    private  Date  updateTime ;

    /**
    *  创建时间
    */
    private  Date  createTime ;

} 
 
