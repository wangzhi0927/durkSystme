package com.dpm.db.web.menu.service.impl;

import com.dpm.db.common.example.TMenuInfoExample;
import com.dpm.db.common.example.TRoleInfoExample;
import com.dpm.db.common.example.TRoleMenuExample;
import com.dpm.db.common.mapper.TMenuInfoMapper;
import com.dpm.db.common.mapper.TRoleInfoMapper;
import com.dpm.db.common.mapper.TRoleMenuMapper;
import com.dpm.db.web.menu.service.IMenuService;
import com.dpm.resource.common.enity.MenuTree;
import com.dpm.resource.common.enity.TMenuInfo;
import com.dpm.resource.common.enity.TRoleInfo;
import com.dpm.resource.common.enity.TRoleMenu;
import com.dpm.resource.common.utils.UUIDUtils;
import com.dpm.resource.freamwork.BusinessException;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @ Purpose:
 * @Package Name: com.dpm.db.web.menu.service.impl
 * @Author: liuxiaoxin
 * @Date: 2018/5/27
 */
@Service
public class MenuServiceImpl implements IMenuService {
    @Autowired
    TMenuInfoMapper tMenuInfoMapper;
    @Autowired
    TRoleInfoMapper tRoleInfoMapper;
    @Autowired
    TRoleMenuMapper tRoleMenuMapper;

    @Override
    public List<MenuTree> getMenuList() {
        List<MenuTree> menuTrees = new ArrayList<>();
        TMenuInfoExample tMenuInfoExample = new TMenuInfoExample();
        TMenuInfoExample.Criteria criteria = tMenuInfoExample.createCriteria();
        criteria.andLevelEqualTo("0");
        List<TMenuInfo> parentMenu = tMenuInfoMapper.selectByExample(tMenuInfoExample);
        if (!CollectionUtils.isEmpty(parentMenu)) {
            tMenuInfoExample = new TMenuInfoExample();
            TMenuInfoExample.Criteria childCriteria = tMenuInfoExample.createCriteria();
            childCriteria.andParentCodeIn(parentMenu.stream().map(TMenuInfo::getMenuCode).collect(Collectors.toList()));
            childCriteria.andLevelEqualTo("1");
            List<TMenuInfo> childMenu = tMenuInfoMapper.selectByExample(tMenuInfoExample);
            Map<String, List<MenuTree>> map = new HashMap<>();
            if (!CollectionUtils.isEmpty(childMenu)) {
                childMenu.stream().collect(Collectors.groupingBy(TMenuInfo::getParentCode)).forEach((key, list) -> {
                    List<MenuTree> menuChildTree = new ArrayList<>();
                    list.stream().forEach(menu -> {
                        MenuTree menuTree = new MenuTree();
                        BeanUtils.copyProperties(menu, menuTree);
                        menuChildTree.add(menuTree);
                    });
                    map.put(key, menuChildTree);
                });
            }
            parentMenu.parallelStream().forEach(menu -> {
                MenuTree menuTree = new MenuTree();
                BeanUtils.copyProperties(menu, menuTree);
                if (map.containsKey(menu.getMenuCode())) {
                    menuTree.setChildren(map.get(menu.getMenuCode()));
                }
                menuTrees.add(menuTree);
            });
        }
        if (!CollectionUtils.isEmpty(menuTrees)) {
            Collections.sort(menuTrees, Comparator.comparing(MenuTree::getMenuCode));
        }
        return menuTrees;
    }

    @Override
    public List<TRoleInfo> getRoleList() {
        TRoleInfoExample tRoleInfoExample = new TRoleInfoExample();
        TRoleInfoExample.Criteria criteria = tRoleInfoExample.createCriteria();
        criteria.andEnabledEqualTo("1");
        return tRoleInfoMapper.selectByExample(tRoleInfoExample);
    }

    @Override
    public TMenuInfo saveOrUpdateMenu(TMenuInfo tMenuInfo) {
        if (ObjectUtils.isEmpty(tMenuInfo))
            throw new BusinessException("传参错误");
        if (StringUtils.isEmpty(tMenuInfo.getId())) {
            tMenuInfo.setId(UUIDUtils.getUUID());
            tMenuInfoMapper.insert(tMenuInfo);
        } else {
            tMenuInfoMapper.updateByPrimaryKey(tMenuInfo);
        }
        return tMenuInfo;
    }

    @Override
    public TRoleInfo saveOrUpdateRole(TRoleInfo tRoleInfo) {
        if (ObjectUtils.isEmpty(tRoleInfo))
            throw new BusinessException("传参错误");
        if (StringUtils.isEmpty(tRoleInfo.getId())) {
            tRoleInfo.setId(UUIDUtils.getUUID());
            tRoleInfoMapper.insert(tRoleInfo);
        } else {
            tRoleInfoMapper.updateByPrimaryKey(tRoleInfo);
        }
        return tRoleInfo;
    }

    @Override
    public List<TRoleMenu> saveOrUpdateRoleMenus(List<TRoleMenu> tRoleMenus) {
        if (ObjectUtils.isEmpty(tRoleMenus))
            throw new BusinessException("传参错误");
        TRoleMenuExample tRoleMenuExample = new TRoleMenuExample();
        TRoleMenuExample.Criteria criteria = tRoleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(tRoleMenus.get(0).getRoleId());
        tRoleMenuMapper.deleteByExample(tRoleMenuExample);

        tRoleMenus.parallelStream().forEach(tRoleMenu -> {
            if (!StringUtils.isEmpty(tRoleMenu.getMenuCode())) {
                tRoleMenu.setId(UUIDUtils.getUUID());
                tRoleMenuMapper.insert(tRoleMenu);
            }
        });
        return tRoleMenus;
    }

    @Override
    public int delMenus(List<String> menuKeyList) {
        menuKeyList.parallelStream().forEach(key -> tMenuInfoMapper.deleteByPrimaryKey(key));
        return menuKeyList.size();
    }

    @Override
    public int delRoles(List<String> roleKeyList) {
        roleKeyList.parallelStream().forEach(key -> tRoleInfoMapper.deleteByPrimaryKey(key));
        return roleKeyList.size();
    }

    @Override
    public List<String> getMenuCodeByRoleId(String roleId) {
        if (StringUtils.isEmpty(roleId))
            return new ArrayList<>();
        TRoleMenuExample tRoleMenuExample = new TRoleMenuExample();
        TRoleMenuExample.Criteria criteria = tRoleMenuExample.createCriteria();
        criteria.andRoleIdEqualTo(roleId);
        List<TRoleMenu> list = tRoleMenuMapper.selectByExample(tRoleMenuExample);
        if (CollectionUtils.isEmpty(list))
            return new ArrayList<>();
        return list.stream().map(TRoleMenu::getMenuCode).collect(Collectors.toList());
    }
}
