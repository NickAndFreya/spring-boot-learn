/**
 * Longshine.com Inc.
 * Copyright (c) 2004-2018 All Rights Reserved.
 */
package com.freya.nc.netcdf.controller;

import com.freya.nc.common.result.ResultData;
import com.freya.nc.netcdf.service.PredictService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @author
 * @version $Id: PredictController.java, v 0.1 2019-05-17 9:34 chengpiny.hds Exp $$
 */
@RestController
@Api(tags = "站点预测数据")
@CrossOrigin(origins = "*")
public class PredictController {

    @Autowired
    private PredictService predictService;

    @ApiOperation(value = "站点预测数据", notes = "获取所有站点预测数据或根据站点ID获取站点数据")
    @ApiImplicitParam(name = "siteId", value = "站点ID")
    @GetMapping("/getPredictStation")
    public ResultData getPredictStation(String siteId) throws Exception {
        if (null !=siteId && ""!=siteId ){
            return predictService.getPredictStationById(siteId);
        }else {
            return predictService.getPredictStation();
        }

    }
}
