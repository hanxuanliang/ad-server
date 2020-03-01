package com.hxl.ad.service;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.DeleteRowsEventData;
import com.github.shyiko.mysql.binlog.event.EventData;import com.github.shyiko.mysql.binlog.event.UpdateRowsEventData;
import com.github.shyiko.mysql.binlog.event.WriteRowsEventData;
import lombok.extern.slf4j.Slf4j;

import java.io.IOException;

/**
 * @Description: Binlog service示例
 * @Author: hanxuanliang
 * @Date: 2020/2/29 17:48
 */
@Slf4j
public class BinlogService {

    public static void main(String[] args) throws IOException {
        // 假装成一个 slave（从节点）去连接到配置的数据库
        BinaryLogClient client = new BinaryLogClient(
                "127.0.0.1",
                3306,
                "root",
                "hxl.123"
        );
        // 指定从哪个Binlog日志开始读取记录【如果不设置，将从最新的binlog文件的最新位置开始监听】
        // client.setBinlogFilename("binlog.0001");

        // 事件监听器，监听事件类型【在这里我们只关心 Update / Write / Delete】
        client.registerEventListener(event -> {
            EventData data = event.getData();

            if (data instanceof UpdateRowsEventData) {
                log.info("Update--------");
                log.info(data.toString());
            } else if (data instanceof WriteRowsEventData) {
                log.info("Write--------");
                log.info(data.toString());
            } else if (data instanceof DeleteRowsEventData) {
                log.info("Delete--------");
                log.info(data.toString());
            }
        });
        client.connect();
    }
}
