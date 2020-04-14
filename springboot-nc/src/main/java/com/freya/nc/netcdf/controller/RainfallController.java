
package com.freya.nc.netcdf.controller;

import com.freya.nc.common.result.ResultData;
import com.freya.nc.netcdf.service.RainfallService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 调用客户实际降雨量返回前端展示
 *
 * @author wenshengl.hds
 * @version $Id: RainfallController.java, v 0.1 2019-01-22 10:10 wenshengl.hds Exp $$
 */
@RestController
@Api(tags = "站点实际降雨量")
@CrossOrigin(origins = "*")
public class RainfallController {
    @Autowired
    private RainfallService rainfallService;

    @ApiOperation(value = "站点实际数据", notes = "获取指定站点实际降雨量数据")
    @ApiImplicitParam(name = "siteId", value = "有参数的方法", required = true)
    @GetMapping("/getStationRainfall")
    public ResultData getStationRainfall(String siteId) throws Exception {
        return rainfallService.getStationRainfall(siteId);
    }
}
