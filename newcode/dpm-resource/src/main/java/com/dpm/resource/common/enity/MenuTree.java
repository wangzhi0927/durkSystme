package com.dpm.resource.common.enity;

import lombok.Data;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.resource.common
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Data
public class MenuTree extends TMenuInfo {
    private List<MenuTree> children;
}
