package cn.enncloud.iot.iotmqtttransferkafkahps.service.impl;

import cn.enncloud.iot.iotmqtttransferkafkahps.beans.DevGatewayEntity;
import cn.enncloud.iot.iotmqtttransferkafkahps.repository.DevGatewayRepository;
import cn.enncloud.iot.iotmqtttransferkafkahps.service.IDevGatewayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DevGatewayServiceImpl implements IDevGatewayService {

    @Autowired
    private DevGatewayRepository devGatewayRepository;

    @Override
    public DevGatewayEntity findBySerialnumber(String serialnumber){
        return devGatewayRepository.findBySerialnumber(serialnumber);
    }
}
