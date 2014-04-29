package com.baidu.example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by edwardsbean on 2014/4/29.
 */
public class SimpleLibContext {
    private Config config;

    //指定配置文件
    public SimpleLibContext(Config config) {
        this.config = config;
        config.checkValid(ConfigFactory.defaultReference(), "simple-lib");
    }

    // 默认加载classpath下的application.*
    public SimpleLibContext() {
        this(ConfigFactory.load());
    }

    //打印
    public void printSetting(String path) {

        System.out.println("The setting '" + path + "' is: " + config.getString(path));
    }

    public Config getConfig(){
        return this.config;
    }
    public static void main(String[] args) {
        SimpleLibContext s = new SimpleLibContext();
        s.printSetting("simple-app.answer");
        s.printSetting("simple-lib.timeout");
    }
}
