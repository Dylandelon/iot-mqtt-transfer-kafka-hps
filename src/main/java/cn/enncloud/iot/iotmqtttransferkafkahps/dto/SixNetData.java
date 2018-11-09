package cn.enncloud.iot.iotmqtttransferkafkahps.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.math.BigInteger;

/**
 * Created by zhangdelong on 2018/7/5.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Component
public class SixNetData implements Serializable{
// todo 增加点表

    private BigInteger deviceId;

    private String metric;

    private BigInteger did;//网关配置中的设备id

    private BigInteger itemId;    //网关数据项id

    private Integer devType;   //设备类型

    private String deviceName;  //设备名称

    private BigInteger orgId; //组织id

    private String attrGroup; //设备分类
//    private String cimDataName ; //1
    private String devCimId  ; //2
    private String cimPath; //3

}
