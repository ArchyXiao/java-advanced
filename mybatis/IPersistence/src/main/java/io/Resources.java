package io;

import java.io.InputStream;

/**
 *
 * @Auther: Archy
 * @Date: 2020/11/28 21:40
 */
public class Resources {
    // 根据配置文件路径，将配置文件加载成字节输入流，存储在内存中
    public static InputStream getResourceAsStream(String path) {
        InputStream resourceAsStream = Resources.class.getClassLoader().getResourceAsStream(path);

        return resourceAsStream;
    }


}
