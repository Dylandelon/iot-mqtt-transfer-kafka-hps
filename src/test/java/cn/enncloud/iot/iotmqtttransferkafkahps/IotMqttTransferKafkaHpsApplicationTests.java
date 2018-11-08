package cn.enncloud.iot.iotmqtttransferkafkahps;

import cn.enncloud.iot.iotmqtttransferkafkahps.constant.AdapterProperties;
import cn.enncloud.iot.iotmqtttransferkafkahps.process.MessageKafkaOutHandler;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDataCacheService;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IMessageProcessService;
import cn.enncloud.iot.iotmqtttransferkafkahps.utils.JsonUtils;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.DeviceData;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MetricData;
import cn.enncloud.iot.iotmqtttransferkafkahps.vo.MqttDataItem;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class IotMqttTransferKafkaHpsApplicationTests {
    @Autowired
    private IDataCacheService dataCacheService;
    @Autowired
    private MessageKafkaOutHandler messageKafkaOutHandler;
    @Autowired
    private AdapterProperties adapterProperties;

    @Qualifier("AnyLinkDataExecuteServiceImpl")
    private IMessageProcessService anyLinkDataExecuteService;
    @Qualifier("SixNetDataExecuteServiceImpl")
    private IMessageProcessService sixNetDataExecuteService;
    @Qualifier("SfhlDataExecuteServiceImpl")
    private IMessageProcessService sfhlDataExecuteService;

    @Test
    public void anyLinkDataExecuteServiceTest() {
        MqttDataItem dataItem = new MqttDataItem();
        dataItem.setZ(1400501l);

        List<DeviceData> deviceDataList = new ArrayList<>();
        DeviceData deviceData = new DeviceData();
        deviceData.setD(1023l);
        deviceData.setT(1541062257295l);
        deviceData.setC(Arrays.asList(Arrays.asList(1,295998,1)));

        deviceDataList.add(deviceData);
        dataItem.setY(deviceDataList);
        String json = JsonUtils.writeValueAsString(dataItem);
        Map<Long, List<MetricData>> longListMap = anyLinkDataExecuteService.execute(json);
    }

}
