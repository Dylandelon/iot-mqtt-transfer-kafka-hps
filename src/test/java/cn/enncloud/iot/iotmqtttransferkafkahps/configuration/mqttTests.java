package cn.enncloud.iot.iotmqtttransferkafkahps.configuration;

import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@RunWith(SpringRunner.class)
@SpringBootTest
public class mqttTests {

    @Test
    public void contextLoads() {
//        PushPayload pushPayload = PushPayload.getPushPayloadBuider().setContent("test")
//                .setMobile("119")
//                .setType("2018")
//                .bulid();
//        mqttClientComponent.push("yes",pushPayload);
    }
    @Test
    public void testmqtt() {

        HttpHeaders headers = new HttpHeaders();

        headers.setContentType(MediaType.APPLICATION_JSON);
        String url = "http://localhost:8080/send?message=aaaaaa";
//        stringBuffer.append("dmsPointGroupId=").append("2");
//        stringBuffer.append("&").append("id=").append(1);
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = restTemplate.getForEntity(url, String.class);
    }



}
