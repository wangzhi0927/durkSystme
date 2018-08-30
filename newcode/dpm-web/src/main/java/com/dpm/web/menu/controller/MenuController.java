package com.dpm.web.menu.controller;

import com.dpm.resource.common.enity.MenuTree;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TRoleMenu;
import com.dpm.resource.freamwork.BusinessResult;
import com.dpm.web.menu.service.impl.MenuServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.menu.controller
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
    BusinessResult getMenuList() {
        return BusinessResult.success(menuService.getMenuList());
    }

    @ApiOperation(value = "获取所有角色信息", notes = "")
    @RequestMapping(value = "/getRoleList", method = RequestMethod.POST)
    BusinessResult getRoleList() {
        return BusinessResult.success(menuService.getRoleList());
    }

    @ApiOperation(value = "保存菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateMenu", method = RequestMethod.POST)
    BusinessResult saveOrUpdateMenu(@RequestBody TMenuInfo tMenuInfo) {
        return BusinessResult.success(menuService.saveOrUpdateMenu(tMenuInfo));
    }

    @ApiOperation(value = "保存角色信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRole", method = RequestMethod.POST)
    BusinessResult saveOrUpdateRole(@RequestBody TRoleInfo tRoleInfo) {
        return BusinessResult.success(menuService.saveOrUpdateRole(tRoleInfo));
    }

    @ApiOperation(value = "保存角色菜单信息", notes = "")
    @RequestMapping(value = "/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    BusinessResult saveOrUpdateRoleMenus(@RequestBody List<TRoleMenu> tRoleMenus) {
        return BusinessResult.success(menuService.saveOrUpdateRoleMenus(tRoleMenus));
    }

    @ApiOperation(value = "删除菜单数据", notes = "")
    @RequestMapping(value = "/delMenus", method = RequestMethod.POST)
    BusinessResult delMenus(@RequestBody List<String> menuKeyList) {
        return BusinessResult.success(menuService.delMenus(menuKeyList));
    }

    @ApiOperation(value = "删除角色数据", notes = "")
    @RequestMapping(value = "/delRoles", method = RequestMethod.POST)
    BusinessResult delRoles(@RequestBody List<String> roleKeyList) {
        return BusinessResult.success(menuService.delRoles(roleKeyList));
    }

    @ApiOperation(value = "根据角色获取菜单信息", notes = "")
    @RequestMapping(value = "/getMenuCodeByRoleId", method = RequestMethod.GET)
    BusinessResult getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId) {
        return BusinessResult.success(menuService.getMenuCodeByRoleId(roleId));
    }
}
