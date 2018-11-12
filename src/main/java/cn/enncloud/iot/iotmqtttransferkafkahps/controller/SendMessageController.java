package cn.enncloud.iot.iotmqtttransferkafkahps.controller;

import cn.enncloud.iot.iotmqtttransferkafkahps.configuration.MqttConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SendMessageController {

    @Autowired
    MqttConfig.MessageWriter messageWriter;


    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void send(@RequestParam(value = "message") String message){
        log.info("收到meseage"+message);
        messageWriter.write(message);

    }

}
