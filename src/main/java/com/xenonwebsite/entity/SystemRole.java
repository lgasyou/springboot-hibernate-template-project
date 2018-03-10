package com.xenonwebsite.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

// 网站角色
@Entity
@Data
public class SystemRole {

    @Id
    @GeneratedValue
    private Long id;

    // 角色名称
    private String name;

}
