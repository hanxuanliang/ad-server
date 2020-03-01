package com.hxl.ad.increment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @Description: binlog模板文件的整个结构字段定义
 * @Author: hanxuanliang
 * @Date: 2020/3/1 19:21
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Template {

    private String database;

    private List<JsonTable> tableList;

}
