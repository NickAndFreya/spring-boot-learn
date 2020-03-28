package com.freya.nc.netcdf.springschedule;

import com.freya.nc.netcdf.springtask.NetCDFTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class NetCDFSchedulePrd {
    @Autowired
    private NetCDFTask netCDFTask;

    /**
     * 每月1号的00:00触发
     */
    @Scheduled(cron = "0 0 0 1 * ?")
    public void create4DNetCDF() {
        netCDFTask.create4DNetCDF();
    }

    /**
     * 每小时的第25分钟触发一次
     */
    @Scheduled(cron = "0 25 * * * *")
    public void write4DNetCDF() throws Exception {
        netCDFTask.write4DNetCDF();
    }


}
