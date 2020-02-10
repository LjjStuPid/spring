package com.ljj.jdk.spi.dubbo;

import com.alibaba.dubbo.rpc.Protocol;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.protocol.dubbo.DubboProtocol;

public class DubboSPI {

    public static void main(String[] args) {
        ExtensionLoader<Protocol> protocolExtensionLoader = ExtensionLoader.getExtensionLoader(Protocol.class);

        Protocol dubboProtocol = protocolExtensionLoader.getExtension(DubboProtocol.NAME);

        System.out.println(dubboProtocol.getDefaultPort());

    }
}
