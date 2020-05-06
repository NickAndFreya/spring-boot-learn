package com.freya.design.patterns.utils;

import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSchException;

public class SFTPUtil {
    public static ChannelSftp getSFTPChannel(int timeout) throws JSchException {
        SFTPChannel channel = new SFTPChannel();
        ChannelSftp sc = channel.getChannel(timeout);
        return sc;
    }

    /**
     * 私有化构造器，禁止实例化
     */
    private SFTPUtil() {

    }
}
