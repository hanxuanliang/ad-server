package com.hxl.ad.dao;

import com.hxl.ad.entity.AdCreative;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Description: 创意 repository
 * @Author: hanxuanliang
 * @Date: 2020/2/21 14:03
 */
public interface CreativeRepository extends JpaRepository<AdCreative, Long> {

}
