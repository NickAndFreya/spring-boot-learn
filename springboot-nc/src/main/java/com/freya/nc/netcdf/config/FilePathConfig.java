package com.freya.nc.netcdf.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 文件路径配置类
 *
 * @author chengpiny
 */
@Component
@ConfigurationProperties(prefix = "file")
public class FilePathConfig {

    private final Path path = new Path();

    public Path getPath() {
        return path;
    }

    public static class Path {
        private String linux;
        private String ncmllin;

        public String getLinux() {
            return linux;
        }

        public void setLinux(String linux) {
            this.linux = linux;
        }

        public String getNcmllin() {
            return ncmllin;
        }

        public void setNcmllin(String ncmllin) {
            this.ncmllin = ncmllin;
        }
    }

}

