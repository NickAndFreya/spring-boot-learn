package com.freya.design.patterns.utils;

import com.jcraft.jsch.*;
import lombok.extern.slf4j.Slf4j;

import javax.print.DocFlavor;
import java.util.Map;
import java.util.Properties;

@Slf4j
public class SFTPChannel {
    Session session = null;
    Channel channel = null;

    public ChannelSftp getChannel(int timeout) throws JSchException {

        String ftpHost = SFTPConstants.SFTP_REQ_HOST;
        String port = SFTPConstants.SFTP_REQ_PORT;
        String ftpUserName = SFTPConstants.SFTP_REQ_USERNAME;
        String ftpPassword = SFTPConstants.SFTP_REQ_PASSWORD;
        int ftpPort = SFTPConstants.SFTP_DEFAULT_PORT;
        if (port != null && !port.equals("")) {
            ftpPort = Integer.valueOf(port);
        }
        // 创建JSch对象
        JSch jsch = new JSch();
        // 按照用户名,主机ip,端口获取一个Session对象
        session = jsch.getSession(ftpUserName, ftpHost, ftpPort);
        log.info("session created");
        if (ftpPassword != null) {
            session.setPassword(ftpPassword); // 设置密码
        }
        Properties config = new Properties();
        config.put("StrictHostKeyChecking", "no");
        // 为Session对象设置properties
        session.setConfig(config);
        // 设置过期时间
        session.setTimeout(timeout);
        // 经由过程Session建树链接
        session.connect();
        log.info("session connected.");
        log.info("opening channel");
        // 打开SFTP通道
        channel = session.openChannel("sftp");
        // 建树SFTP通道的连接
        channel.connect();
        return (ChannelSftp) channel;
    }

    public static void closeChannel(Channel channel) throws Exception {
        if (channel != null) {
            channel.disconnect();
            if (channel.getSession() != null) {
                channel.getSession().disconnect();
            }
        }
    }
}
