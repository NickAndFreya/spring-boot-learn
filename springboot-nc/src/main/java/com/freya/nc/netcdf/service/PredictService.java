/**
 * Longshine.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.netcdf.service;


import com.freya.nc.common.result.ResultData;

/**
 * @author chengpiny.hds
 * @version $Id: PredictService.java, v 0.1 2019-05-17 10:18 chengpiny.hds Exp $$
 */
public interface PredictService {
    ResultData getPredictStation() throws Exception;
    ResultData getPredictStationById(String siteId) throws Exception;

}
