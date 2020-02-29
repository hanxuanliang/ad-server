package com.hxl.ad.dump.table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description:
 * @Author: hanxuanliang
 * @Date: 2020/2/21 13:12
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdUnitKeywordTable {

    private Long unitId;

    private String keyword;
}
