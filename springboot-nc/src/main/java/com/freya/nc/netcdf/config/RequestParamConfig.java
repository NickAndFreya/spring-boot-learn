package com.freya.nc.netcdf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author chengpiny
 */
@Component
@ConfigurationProperties(prefix = "request")
public class RequestParamConfig {
    private final SysParam param = new SysParam();

    public SysParam getParam() {
        return param;
    }

    public static class SysParam {
        private String uri = "http://172.22.1.175/di/http.action";
        private String userId = "idc";
        private String pwd = "U3cuYV";
        private String interfaceId = "getSurfAwstQC4Iiiii";
        private String dataFormat = "json";

        public String getUri() {
            return uri;
        }

        public void setUri(String uri) {
            this.uri = uri;
        }


        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public String getPwd() {
            return pwd;
        }

        public void setPwd(String pwd) {
            this.pwd = pwd;
        }

        public String getInterfaceId() {
            return interfaceId;
        }

        public void setInterfaceId(String interfaceId) {
            this.interfaceId = interfaceId;
        }

        public String getDataFormat() {
            return dataFormat;
        }

        public void setDataFormat(String dataFormat) {
            this.dataFormat = dataFormat;
        }
    }
}
