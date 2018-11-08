package cn.enncloud.iot.iotmqtttransferkafkahps.process;

import cn.enncloud.iot.iotmqtttransferkafkahps.configuration.KafkaChannel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.stereotype.Component;

@Component
@Slf4j
@EnableBinding(value = KafkaChannel.class)
public class MessageKafkaOutHandler {
    @Qualifier(value = KafkaChannel.CIM_OUTPUT)
    @Autowired
    private MessageChannel cimOutput;
    public boolean doProcess(Message<?> message) throws Exception{
        return this.cimOutput.send(message);
    }
}
