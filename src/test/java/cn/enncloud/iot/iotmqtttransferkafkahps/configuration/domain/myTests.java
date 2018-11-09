package cn.enncloud.iot.iotmqtttransferkafkahps.configuration.domain;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.concurrent.TimeUnit;

@Slf4j
@SpringBootTest
public class myTests {

    @Test
    public void contextLoads() {
        Date date = new Date();
        long time = date.getTime();
        log.info("时间{}", time);
        log.info("时间{}", time/1000);
        log.info("时间{}", TimeUnit.MILLISECONDS.toSeconds(date.getTime()));
    }



}
