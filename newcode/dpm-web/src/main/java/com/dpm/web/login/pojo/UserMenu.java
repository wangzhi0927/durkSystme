package com.dpm.web.login.pojo;

import lombok.Data;

import java.util.List;

/**
 * @ Purpose:用户菜单
 * @Package Name: com.dpm.web.login.pojo
 * @Author: liuxiaoxin
 * @Date: 2018/5/18
 */
@Data
public class UserMenu {
    private String path;
    private String name;
    private String component;
    private List<UserMenu> children;

}
