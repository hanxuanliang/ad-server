# ad-server

构建商城的广告服务，微服务项目

## Mysql Binlog 处理

广告检索系统和广告投放系统解耦，所以在检索系统中没有放置对数据库的表ORM层控制。
转而使用 `Mysql Binlog` 对数据库的数据变化进行监控，一起到解耦的效果，二也对数据库架构释放压力，
因为投放系统的不断操作数据，会导致两个系统之间的数据差距变大。

具体的操作：

- 解析 `template.json` 文件的结构，看看对数据库的哪个表进行监控，并且在文件中还定义了监控的字段。

```json
{
  "database": "ad_data",
  "tableList": [
    { "tableName": "ad_plan",
      "level": 2,
      "insert": [
        {"column": "id"},
        {"...":  "..."}
      ],
      "update": [
        {"column": "id"},
        {"...":  "..."}
      ],
      "delete": [
        {"column": "id"}
      ]
    },
    { "tableName": "ad_unit" },
    { "tableName": "ad_creative" },
    { "tableName": "creative_unit" },
    { "tableName": "ad_unit_district" },
    { "tableName": "ad_unit_it" },
    { "tableName": "ad_unit_keyword" }
  ]
}
```