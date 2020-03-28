/**
 * Longshine.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.netcdf.service.impl;

import com.freya.nc.common.result.ResponseEnum;
import com.freya.nc.common.result.ResultData;
import com.freya.nc.netcdf.dao.PredictDao;
import com.freya.nc.netcdf.service.PredictService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author chengpiny.hds
 * @version $Id: PredictServiceImpl.java, v 0.1 2019-05-17 10:18 chengpiny.hds Exp $$
 */
@Service
public class PredictServiceImpl implements PredictService {

    @Autowired
    private PredictDao predictDao;

    @Override
    public ResultData getPredictStation() throws Exception {
        ResultData data = new ResultData();
        try {
            List<Map<String, Object>> resultList = predictDao.getPredictStation();
            if (null != resultList) {
                data.setData(resultList);
                data.setCode(ResponseEnum.SUCCESS.getCode());
                data.setMsg(ResponseEnum.SUCCESS.getMsg());
                return data;
            }
        } catch (Exception e) {
            data.setCode(ResponseEnum.SYS_EXCEPTION.getCode());
            data.setMsg(ResponseEnum.SYS_EXCEPTION.getMsg());
            return data;
        }

        return null;
    }

    @Override
    public ResultData getPredictStationById(String siteId) throws Exception {
        ResultData data = new ResultData();
        Map<String, Object> result = null;
        try{
            result = new HashMap<String,Object>();
            Map<String, Object> one = predictDao.get1HourBeforePredictStationById(siteId);
            Map<String, Object> two = predictDao.get2HourBeforePredictStationById(siteId);
            Map<String, Object> three = predictDao.get3HourBeforePredictStationById(siteId);
            result.putAll(one);
            result.putAll(two);
            result.putAll(three);

            if (null != result) {
                data.setData(result);
                data.setCode(ResponseEnum.SUCCESS.getCode());
                data.setMsg(ResponseEnum.SUCCESS.getMsg());
                return data;
            }

        }catch (Exception e){
            data.setCode(ResponseEnum.SYS_EXCEPTION.getCode());
            data.setMsg(ResponseEnum.SYS_EXCEPTION.getMsg());
            return data;
        }
        return null;
    }
}
