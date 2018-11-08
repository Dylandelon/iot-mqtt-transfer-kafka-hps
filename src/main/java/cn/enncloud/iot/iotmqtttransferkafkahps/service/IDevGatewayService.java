package cn.enncloud.iot.iotmqtttransferkafkahps.service;

import cn.enncloud.iot.iotmqtttransferkafkahps.beans.DevGatewayEntity;

public interface IDevGatewayService {
    DevGatewayEntity findBySerialnumber(String serialnumber);
}
