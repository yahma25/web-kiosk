package com.web.kiosk.controller;

import java.sql.Connection;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import com.web.kiosk.service.MenuService;
import com.web.kiosk.vo.MenuVo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("menu")
public class MenuController {
    /* JDBC
    @Autowired
    DataSource dataSource;

    @Autowired
    JdbcTemplate jdbcTemplate;
    */
    
    @Autowired
    MenuService menuService;

    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<MenuVo>> getAllMenu() {
        List<MenuVo> menuList = menuService.findAll();
        return new ResponseEntity<List<MenuVo>>(menuList, HttpStatus.OK);
    }

    /* JDBC
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE })
    public ResponseEntity<List<MenuVo>> getAllMenuByJDBC() {
        List<MenuVo> menuList = new ArrayList<MenuVo>();

        try (Connection connection = dataSource.getConnection()) {
            String sql = "SELECT * FROM menu";
            List<Map<String, Object>> rows = jdbcTemplate.queryForList(sql);

            for (Map<String, Object> row : rows) {
                menuList.add(new MenuVo((Integer)row.get("id"), row.get("name").toString()));
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return new ResponseEntity<List<MenuVo>>(menuList, HttpStatus.OK);
    }
    */
}
