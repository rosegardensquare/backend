package com.zs.backend.socket.net.client;

import io.netty.channel.ChannelHandler;

/**
 * 用于ssl重连，客户端自定义channel传递
 */
public interface FireChannelHandler {
    ChannelHandler channelHandler();
}