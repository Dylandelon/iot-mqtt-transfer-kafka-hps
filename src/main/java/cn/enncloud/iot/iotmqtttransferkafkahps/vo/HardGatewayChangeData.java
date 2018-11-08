package cn.enncloud.iot.iotmqtttransferkafkahps.vo;

import lombok.ToString;

/**
 * kafka统一格式数据，设备模型修改通知消息
 * Created by lixiangk on 2017/7/26.
 */
@ToString
public class HardGatewayChangeData {

   private String serialnumber;

    public HardGatewayChangeData(String serialnumber) {
        this.serialnumber = serialnumber;
    }
    public HardGatewayChangeData(){
        this.serialnumber = "";
    }

    public String getSerialnumber() {
        return serialnumber;
    }

    public void setSerialnumber(String serialnumber) {
        this.serialnumber = serialnumber;
    }


}