package cn.enncloud.iot.iotmqtttransferkafkahps.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

@EnableBinding(value = Source.class)
@Slf4j
@Component
public class MessageMqttProcessHandler {
    @Resource
    private MessageChannel output;

    public void doProcess(Message<?> message){
        try {
            this.output.send(message);
        }catch (Exception e){
            log.error("mqtt to uncimkafka thread handler  exception:{}",e);
        }
    }

}
