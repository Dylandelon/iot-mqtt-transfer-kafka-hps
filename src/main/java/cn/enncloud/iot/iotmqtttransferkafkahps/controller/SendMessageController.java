package cn.enncloud.iot.iotmqtttransferkafkahps.controller;

import cn.enncloud.iot.iotmqtttransferkafkahps.configuration.MqttConfig;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class SendMessageController {

    @Autowired
    MqttConfig.MessageWriter messageWriter;

    @Autowired
    private IDataCacheService dataCacheService;

    @RequestMapping(value = "send",method = RequestMethod.GET)
    public void send(@RequestParam(value = "message") String message){
        log.info("收到meseage"+message);
        messageWriter.write(message);

    }
    @RequestMapping(value = "deleteCache",method = RequestMethod.GET)
    public String deleteCache(@RequestParam(value = "hk",required = false) String hk){
        log.info("收到hk"+hk);
        long res = 0;
        if(StringUtils.isEmpty(hk)){
            dataCacheService.deleteWithkeys();
            return "全部项目怒缓存删除";
        }else{
            res = dataCacheService.deleteWithAgentId(hk);
        }
        if(res==0){
            return "没有缓存被删除";
        }else if(res >0){
            return "缓存被删除"+res;
        }else{
            return "缓存被删除异常";
        }

    }
}
