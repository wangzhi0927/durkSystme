package com.dpm.web.menu.service.impl;

import com.dpm.resource.common.enity.MenuTree;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TRoleMenu;
import com.dpm.web.feigns.IMenuFeignClient;
import com.dpm.web.menu.service.IMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Service
public class MenuServiceImpl implements IMenuService {

    @Autowired
    IMenuFeignClient feignClient;

    @Override
    public List<MenuTree> getMenuList() {
        return feignClient.getMenuList();
    }

    @Override
    public List<TRoleInfo> getRoleList() {
        return feignClient.getRoleList();
    }

    @Override
    public TMenuInfo saveOrUpdateMenu(TMenuInfo tMenuInfo) {
        return feignClient.saveOrUpdateMenu(tMenuInfo);
    }

    @Override
    public TRoleInfo saveOrUpdateRole(TRoleInfo tRoleInfo) {
        return feignClient.saveOrUpdateRole(tRoleInfo);
    }

    @Override
    public List<TRoleMenu> saveOrUpdateRoleMenus(List<TRoleMenu> tRoleMenus) {
        return feignClient.saveOrUpdateRoleMenus(tRoleMenus);
    }

    @Override
    public int delMenus(List<String> menuKeyList) {
        return feignClient.delMenus(menuKeyList);
    }

    @Override
    public int delRoles(List<String> roleKeyList) {
        return feignClient.delRoles(roleKeyList);
    }

    @Override
    public List<String> getMenuCodeByRoleId(String roleId) {
        return feignClient.getMenuCodeByRoleId(roleId);
    }
}
