package com.hxl.ad.increment;

import com.hxl.ad.constant.OptionType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/3/1 19:23
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class TableTemplate {

    private String tableName;
    private String level;

    private Map<OptionType, List<String>> opTypeFieldSetMap = new HashMap<>();

    // 字段索引 -> 字段名【binlog文件中对应字段名是索引号，所以这里需要一个map映射】
    private Map<Integer, String> posMap = new HashMap<>();
}
