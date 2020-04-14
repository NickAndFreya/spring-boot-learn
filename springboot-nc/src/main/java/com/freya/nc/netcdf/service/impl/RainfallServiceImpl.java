
package com.freya.nc.netcdf.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.freya.nc.common.ncutil.DateUtil;
import com.freya.nc.common.ncutil.HttpClientUtil;
import com.freya.nc.common.result.ResponseEnum;
import com.freya.nc.common.result.ResultData;
import com.freya.nc.netcdf.config.RequestParamConfig;
import com.freya.nc.netcdf.service.RainfallService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author
 * @version $Id: RainfallServiceImpl.java
 */
@Service
@Slf4j
public class RainfallServiceImpl implements RainfallService {
    @Autowired
    private RequestParamConfig requestParamConfig;

    @Override
    public ResultData getStationRainfall(String siteId) {
        ResultData data = new ResultData();
        List<Map<String, Object>> resultMapList = new ArrayList<Map<String, Object>>();

        try {
            String uri = requestParamConfig.getParam().getUri();
            String userId = requestParamConfig.getParam().getUserId();
            String pwd = requestParamConfig.getParam().getPwd();
            String interfaceId = requestParamConfig.getParam().getInterfaceId();
            String dataFormat = requestParamConfig.getParam().getDataFormat();
            //获取当前时间
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:00:00");
            String date = sdf.format(new Date());

            String currentTime = DateUtil.getUTCtime(new Date());
            // 请求url
            StringBuilder urlBuilder = new StringBuilder();
            urlBuilder.append(uri).append("?").append("userId").append("=").append(userId).append("&").
                    append("pwd").append("=").append(pwd).append("&").append("interfaceId").append("=").
                    append(interfaceId).append("&").append("dataFormat").append("=").append(dataFormat).
                    append("&").append("ymdhms").append("=").append(currentTime).append("&").append("iiiii").
                    append("=").append(siteId);
            String resultJson = HttpClientUtil.doGet(urlBuilder.toString());
            log.info("requestInfo = {}", urlBuilder.toString());
            log.info("resultJson = {}", resultJson);
            JSONObject jasonObject = JSONObject.parseObject(resultJson);
            Map map = (Map) jasonObject;
            List<Map<String, Object>> resolverData = null;
            if (map.get("DATA") != null) {
                resolverData = (List<Map<String, Object>>) map.get("DATA");
            }

            if (null != resolverData) {
                for (Map<String, Object> objectMap : resolverData) {
                    Map<String, Object> res = new HashMap<String, Object>();
                    res.put("rainfall_1h", objectMap.get("V13019"));
                    res.put("province",objectMap.get("V_PRCODE"));
                    res.put("city",objectMap.get("V_CITY"));
                    res.put("county",objectMap.get("V_COUNTY"));
                    res.put("street",objectMap.get("VF01015_CN"));
                    res.put("date",date);
                    resultMapList.add(res);
                }
            }
            data.setData(resultMapList);
            data.setCode(ResponseEnum.SUCCESS.getCode());
            data.setMsg(ResponseEnum.SUCCESS.getMsg());
            return data;

        } catch (Exception e) {
            data.setCode(ResponseEnum.SYS_EXCEPTION.getCode());
            data.setMsg(ResponseEnum.SYS_EXCEPTION.getMsg());
            return data;
        }

    }
}
