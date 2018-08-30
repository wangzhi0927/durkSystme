package com.dpm.db.web.menu.service;

import com.dpm.resource.common.enity.MenuTree;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TRoleMenu;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.service
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
public interface IMenuService {

    List<MenuTree> getMenuList();

    List<TRoleInfo> getRoleList();

    TMenuInfo saveOrUpdateMenu(TMenuInfo tMenuInfo);

    TRoleInfo saveOrUpdateRole(TRoleInfo tRoleInfo);

    List<TRoleMenu> saveOrUpdateRoleMenus(List<TRoleMenu> tRoleMenus);

    int delMenus(List<String> menuKeyList);

    int delRoles(List<String> roleKeyList);

    List<String> getMenuCodeByRoleId(String roleId);
}
