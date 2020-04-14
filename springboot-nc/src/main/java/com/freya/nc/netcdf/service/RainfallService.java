
package com.freya.nc.netcdf.service;


import com.freya.nc.common.result.ResultData;

/**
 * 获取实际降雨量接口
 *
 * @author chengpiny.hds
 * @version $Id: RainfallService.java, v 0.1 2019-05-17 10:15 chengpiny.hds Exp $$
 */
public interface RainfallService {
    ResultData getStationRainfall(String siteId) throws Exception;
}
