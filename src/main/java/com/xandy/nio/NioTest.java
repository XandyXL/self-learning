package com.xandy.nio;

import java.net.InetSocketAddress;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Set;

public class NioTest {

    public static void main(String[] args) throws Exception {


        InetSocketAddress inetSocketAddress = new InetSocketAddress("www.baidu.com", 80);
        SocketChannel socketChannel = SocketChannel.open(inetSocketAddress);
        socketChannel.configureBlocking(false);
        Selector selector = Selector.open();

        socketChannel.register(selector, SelectionKey.OP_READ);

        Set<SelectionKey> selectedKeys = selector.selectedKeys();
        Iterator<SelectionKey> iteratorKeys = selectedKeys.iterator();
        while (true) {
            int readyChannels = selector.select();
            if (readyChannels == 0) continue;
            SelectionKey key = iteratorKeys.next();
            if (key.isAcceptable()) {
                System.out.println("a connection was accepted by a ServerSocketChannel.\n");
            } else if (key.isConnectable()) {
                System.out.println("a connection was established with a remote server.\n");
            } else if (key.isReadable()) {
                System.out.println("a channel is ready for reading\n");
            } else if (key.isWritable()) {
                System.out.println("a channel is ready for writing\n");
            }
            iteratorKeys.remove();

        }


    }
}
