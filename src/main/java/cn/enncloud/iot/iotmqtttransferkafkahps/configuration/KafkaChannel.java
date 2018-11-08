package cn.enncloud.iot.iotmqtttransferkafkahps.configuration;

import org.springframework.cloud.stream.annotation.Output;
import org.springframework.messaging.MessageChannel;

public interface KafkaChannel {
    /**
     * 发消息的通道名称
     */
    String CIM_OUTPUT = "cim_output";

    /**
     * 消息的订阅通道名称
     */
//    String SHOP_INPUT = "shop_input";

    /**
     * 发消息的通道
     *
     * @return
     */
    @Output(CIM_OUTPUT)
    MessageChannel sendCIMMessage();

    /**
     * 收消息的通道
     *
     * @return
     */
//    @Input(SHOP_INPUT)
//    SubscribableChannel recieveShopMessage();
}
