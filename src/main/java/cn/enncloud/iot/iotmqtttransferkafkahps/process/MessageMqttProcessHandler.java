package cn.enncloud.iot.iotmqtttransferkafkahps.process;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.integration.support.MessageBuilder;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@EnableBinding(value = Source.class)
@Slf4j
@Component
public class MessageMqttProcessHandler {
    @Qualifier(value = Source.OUTPUT)
    @Autowired
    private MessageChannel output;

    public void doProcess(Message<?> message){
        try {
            log.info("mqtt to uncimkafka thread handler  receive:{}",message.getPayload());
            this.output.send(message);
        }catch (Exception e){
            log.error("mqtt to uncimkafka thread handler  exception:{}",e);
        }
    }

}
