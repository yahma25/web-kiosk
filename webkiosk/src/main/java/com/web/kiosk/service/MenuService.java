package com.web.kiosk.service;

import java.util.List;

import com.web.kiosk.repository.MenuRepository;
import com.web.kiosk.vo.MenuVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MenuService {
    @Autowired
    private MenuRepository menuRepository;

    public List<MenuVo> findAll() {
        return menuRepository.findAll();
    }
}
