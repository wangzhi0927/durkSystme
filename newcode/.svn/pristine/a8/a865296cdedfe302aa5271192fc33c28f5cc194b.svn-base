package com.dpm.db.web.menu.controller;

import com.dpm.db.web.menu.service.impl.MenuServiceImpl;
import com.dpm.resource.common.enity.*;
import com.dpm.resource.common.enity.resource.ResourceParam;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.controller
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@RestController
@RequestMapping("/menu")
@Api(description = "用户菜单角色业务处理")
public class MenuController {
    @Autowired
    MenuServiceImpl menuService;

    @ApiOperation(value = "获取菜单树", notes = "")
    @RequestMapping(value = "/getMenuList", method = RequestMethod.POST)
    List<MenuTree> getMenuList() {
        return menuService.getMenuList();
    }

    @ApiOperation(value = "获取所有角色信息", notes = "")
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    List<TRoleInfo> getRoleList() {
        return menuService.getRoleList();
    }

    @ApiOperation(value = "保存菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateMenu", method = RequestMethod.POST)
    TMenuInfo saveOrUpdateMenu(@RequestBody TMenuInfo tMenuInfo) {
        return menuService.saveOrUpdateMenu(tMenuInfo);
    }

    @ApiOperation(value = "保存角色信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRole", method = RequestMethod.POST)
    TRoleInfo saveOrUpdateRole(@RequestBody TRoleInfo tRoleInfo) {
        return menuService.saveOrUpdateRole(tRoleInfo);
    }

    @ApiOperation(value = "保存角色菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    List<TRoleMenu> saveOrUpdateRoleMenus(@RequestBody List<TRoleMenu> tRoleMenus) {
        return menuService.saveOrUpdateRoleMenus(tRoleMenus);
    }

    @ApiOperation(value = "删除菜单数据", notes = "")
    @RequestMapping(value = "/delMenus", method = RequestMethod.POST)
    int delMenus(@RequestBody List<String> menuKeyList) {
        return menuService.delMenus(menuKeyList);
    }

    @ApiOperation(value = "删除角色数据", notes = "")
    @RequestMapping(value = "/delRoles", method = RequestMethod.POST)
    int delRoles(@RequestBody List<String> roleKeyList) {
        return menuService.delRoles(roleKeyList);
    }

    @ApiOperation(value = "根据角色获取菜单信息", notes = "")
    @RequestMapping(value = "/getMenuCodeByRoleId", method = RequestMethod.GET)
    List<String> getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId) {
        return menuService.getMenuCodeByRoleId(roleId);
    }

    ;


}
