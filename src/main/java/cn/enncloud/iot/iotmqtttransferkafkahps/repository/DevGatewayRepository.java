package cn.enncloud.iot.iotmqtttransferkafkahps.repository;

import cn.enncloud.iot.iotmqtttransferkafkahps.beans.DevGatewayEntity;
import org.springframework.data.repository.CrudRepository;

public interface DevGatewayRepository extends CrudRepository<DevGatewayEntity,Long> {

    DevGatewayEntity findBySerialnumber(String serialnumber);
}
