package com.baidu.example;

import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;

/**
 * Created by edwardsbean on 2014/4/29.
 */
public class ComplexUse {
    private static void demoConfigInSimpleLib(Config config) {
        SimpleLibContext context = new SimpleLibContext(config);
        context.printSetting("simple-lib.foo");
        context.printSetting("simple-lib.hello");
        context.printSetting("simple-lib.whatever");
    }

    public static void main(String[] args) {
        Config config2 = ConfigFactory.load("complex");

        Config simpleLibConfig2 = ConfigFactory.defaultOverrides()
                .withFallback(config2.getConfig("complex-app.simple-lib-context"))
                .withFallback(config2);

        demoConfigInSimpleLib(simpleLibConfig2);
    }
}
