package com.smart.web;

import com.smart.domain.ExportInfo;
import com.smart.mq.RabbitMqSender;
import com.smart.util.EasyExcelUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

/**
 * @description:
 * @author: dongql
 * @date: 2018/3/29 15:03
 */
@Controller
public class TestController {

    @Autowired
    RabbitMqSender rabbitMqSender;
    @RequestMapping("/mq/topic/{type}")
    public String sendTop(@PathVariable String type) {
        boolean b = rabbitMqSender.sendTopicMessage("topic." + type, "nihao");
        System.out.println("发送topic消息:你好" + b);
        return null;
    }
    @RequestMapping("/mq/direct/{type}")
    public String sendDirect(@PathVariable String type) {
        boolean b = rabbitMqSender.sendDirectMessage("direct." + type, "nihao");
        System.out.println("发送direct消息:你好" + b);
        return null;
    }
    @RequestMapping("/mq/fount/{type}")
    public String sendFount(@PathVariable String type) {
        boolean b = rabbitMqSender.sendFountMessage("fount." + type, "nihao");
        System.out.println("发送fount消息:你好" + b);
        return null;
    }

    @RequestMapping("export")
    public void export(HttpServletResponse response) throws IOException {
        EasyExcelUtil.EasyExcelParams params = new EasyExcelUtil.EasyExcelParams();
        params.setSheetName("easyExcel");
        params.setNeedHead(true);
        params.setExcelNameWithoutExt("ceshi");
        params.setDataModelClazz(ExportInfo.class);
        params.setResponse(response);
        ArrayList<ExportInfo> objects = new ArrayList<>();
        ExportInfo exportInfo = new ExportInfo();
        exportInfo.setAddress("sd");
        exportInfo.setAge("asdf");
        exportInfo.setEmail("dsfs");
        exportInfo.setName("sdf");
        objects.add(exportInfo);
        params.setData(objects);
        EasyExcelUtil.exportExcel2007Format(params);
    }
}
