package com.web.kiosk.repository;

import java.util.List;

import com.web.kiosk.vo.MenuVo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepository extends JpaRepository<MenuVo, Long> {
    public List<MenuVo> findById(Integer Id);

    public List<MenuVo> findByName(String name);
}
