package cn.enncloud.iot.iotmqtttransferkafkahps.configuration;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.paho.client.mqttv3.MqttConnectOptions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.MessagingGateway;
import org.springframework.integration.channel.DirectChannel;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.dsl.IntegrationFlows;
import org.springframework.integration.endpoint.MessageProducerSupport;
import org.springframework.integration.handler.LoggingHandler;
import org.springframework.integration.mqtt.core.DefaultMqttPahoClientFactory;
import org.springframework.integration.mqtt.core.MqttPahoClientFactory;
import org.springframework.integration.mqtt.inbound.MqttPahoMessageDrivenChannelAdapter;
import org.springframework.integration.mqtt.outbound.MqttPahoMessageHandler;
import org.springframework.integration.mqtt.support.DefaultPahoMessageConverter;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.MessageHandler;
import org.springframework.messaging.MessagingException;

@Slf4j
@Configuration
public class MqttConfig {
    @Bean
    public MqttPahoClientFactory mqttClientFactory() {
        DefaultMqttPahoClientFactory factory = new DefaultMqttPahoClientFactory();
        MqttConnectOptions options = new MqttConnectOptions();
//        options.setServerURIs(new String[] { "tcp://localhost:1883" });
        options.setServerURIs(new String[] { "tcp://10.39.43.119:1883" });
        options.setUserName("admin1");
        options.setPassword("public".toCharArray());
        factory.setConnectionOptions(options);
        return factory;
    }

    // publisher

    @Bean
    public IntegrationFlow mqttOutFlow() {
        //console input
//        return IntegrationFlows.from(CharacterStreamReadingMessageSource.stdin(),
//                e -> e.poller(Pollers.fixedDelay(1000)))
//                .transform(p -> p + " sent to MQTT")
//                .handle(mqttOutbound())
//                .get();
        return IntegrationFlows.from(outChannel())
                .handle(mqttOutbound())
                .get();
    }

    @Bean
    public MessageChannel outChannel() {
        return new DirectChannel();
    }

    @Bean
    public MessageHandler mqttOutbound() {
        MqttPahoMessageHandler messageHandler = new MqttPahoMessageHandler("siSamplePublisher", mqttClientFactory());
        messageHandler.setAsync(true);
        messageHandler.setDefaultTopic("allInOne");
        return messageHandler;
    }

    // consumer

    @Bean
    public IntegrationFlow mqttInFlow() {
        return IntegrationFlows.from(mqttInbound())
//                .transform(p -> p + ", received from MQTT")
//                .handle(logger())
                .handle(accephandler())
                .get();
    }
    @Bean
//    @ServiceActivator(inputChannel = "mqttInputChannel")
    public MessageHandler accephandler() {
        return new MessageHandler() {
            @Override
            public void handleMessage(Message<?> message) throws MessagingException {
                log.info("my"+message.getPayload());
            }

        };
    }


    private LoggingHandler logger() {
        LoggingHandler loggingHandler = new LoggingHandler("INFO");
        loggingHandler.setLoggerName("siSample");
        return loggingHandler;
    }

    @Bean
    public MessageProducerSupport mqttInbound() {
        MqttPahoMessageDrivenChannelAdapter adapter = new MqttPahoMessageDrivenChannelAdapter("siSampleConsumer",
                mqttClientFactory(), "allInOne");
        adapter.setCompletionTimeout(5000);
        adapter.setConverter(new DefaultPahoMessageConverter());
        adapter.setQos(1);
        return adapter;
    }
    @MessagingGateway(defaultRequestChannel = "outChannel")
    public interface MessageWriter{
        void write(String data);
    }


//    @Autowired
//    MessageWriter messageWriter;
//    void publish(String data){
//        messageWriter.write(data);
//    }

//    @MessagingGateway(defaultRequestChannel = "outChannel")
//    public interface MsgWriter {
//        void write(String note);
//    }

//    @Bean
//    @ServiceActivator(inputChannel = "mqttOutboundChannel")
//    public MessageHandler mqttOutbound() {
//        MqttPahoMessageHandler messageHandler =
//                new MqttPahoMessageHandler("testClient", mqttClientFactory());
//        messageHandler.setAsync(true);
//        messageHandler.setDefaultTopic("testTopic");
//        return messageHandler;
//    }
//
//    @Bean
//    public MessageChannel mqttOutboundChannel() {
//        return new DirectChannel();
//    }
//
//    @MessagingGateway(defaultRequestChannel = "mqttOutboundChannel")
//    public interface MyGateway {
//
//        void sendToMqtt(String data);
//
//    }
}
