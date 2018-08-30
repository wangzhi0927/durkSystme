package com.dpm.web.feigns;

import com.dpm.resource.common.enity.MenuTree;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TRoleMenu;
import com.dpm.web.feigns.hystric.MenuFeignHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ Purpose:
 * @Package Name: com.dpm.web.feigns
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@FeignClient(value = "dpm-db", fallback = MenuFeignHystric.class)
public interface IMenuFeignClient {

    @RequestMapping(value = "/menu/getMenuList", method = RequestMethod.POST)
    List<MenuTree> getMenuList();

    @RequestMapping(value = "/menu/getRoleList", method = RequestMethod.POST)
    List<TRoleInfo> getRoleList();

    @RequestMapping(value = "/menu/saveOrUpdateMenu", method = RequestMethod.POST)
    TMenuInfo saveOrUpdateMenu(@RequestBody TMenuInfo tMenuInfo);

    @RequestMapping(value = "/menu/saveOrUpdateRole", method = RequestMethod.POST)
    TRoleInfo saveOrUpdateRole(@RequestBody TRoleInfo tRoleInfo);

    @RequestMapping(value = "/menu/saveOrUpdateRoleMenus", method = RequestMethod.POST)
    List<TRoleMenu> saveOrUpdateRoleMenus(@RequestBody List<TRoleMenu> tRoleMenus);

    @RequestMapping(value = "/menu/delMenus", method = RequestMethod.POST)
    int delMenus(@RequestBody List<String> menuKeyList);

    @RequestMapping(value = "/menu/delRoles", method = RequestMethod.POST)
    int delRoles(@RequestBody List<String> roleKeyList);

    @RequestMapping(value = "/menu/getMenuCodeByRoleId", method = RequestMethod.GET)
    List<String> getMenuCodeByRoleId(@RequestParam(value = "roleId") String roleId);
}
