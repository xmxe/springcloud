package com.xmxe.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SentinelController {

    @SentinelResource(value = "hello",blockHandler = "blockHandler",fallback = "fallback")
    @RequestMapping("/hello")
    public String hello(){
        int a = 1/0;
        return "hello";
    }

    /**
     * 实现处理函数，该函数的传参必须与资源点的传参一样，并且最后加上BlockException异常参数；同时，返回类型也必须一样
     * sentinel dashboard中配置的资源名一定要与@SentinelResource中的value值一致，否则不生效
     */
    public String blockHandler(BlockException ex){
        ex.printStackTrace();
        return "blockHandler";
    }

    /**
     * 实现异常调用处理函数，该函数的传参必须与资源点的传参一样返回类型也必须一样
     */
    public String fallback(Throwable throwable){
        throwable.printStackTrace();
        return "fallback";
    }
}
/*
 * @SentinelResource
 * value:资源名称，必需项，因为需要通过resource name找到对应的规则，这个是必须配置的。
 * entryType:entry 类型，可选项,有IN和OUT两个选项，默认为 EntryType.OUT。
 * blockHandler:blockHandler 对应处理 BlockException 的函数名称，可选项。blockHandler 函数访问范围需要是 public，返回类型需要与原方法相匹配，参数类型需要和原方法相匹配并且最后加一个额外的参数，类型为 BlockException。
 * blockHandlerClass:blockHandler 函数默认需要和原方法在同一个类中，如果希望使用其他类的函数，则需要指定 blockHandlerClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
 * fallback:fallback 函数名称，可选项，用于在抛出异常的时候提供 fallback 处理逻辑。fallback 函数可以针对所有类型的异常（除了 exceptionsToIgnore 里面排除掉的异常类型）进行处理。
 * fallbackClass :fallbackClass的应用和blockHandlerClass类似，fallback 函数默认需要和原方法在同一个类中。若希望使用其他类的函数，则可以指定 fallbackClass 为对应的类的 Class 对象，注意对应的函数必需为 static 函数，否则无法解析。
 * defaultFallback（since 1.6.0）:如果没有配置defaultFallback方法，默认都会走到这里来。默认的 fallback 函数名称，可选项，通常用于通用的 fallback 逻辑。默认 fallback 函数可以针对所有类型的异常（除了 exceptionsToIgnore 里面排除掉的异常类型）进行处理。若同时配置了 fallback 和 defaultFallback，则只有 fallback 会生效。
 * exceptionsToIgnore（since 1.6.0）:用于指定哪些异常被排除掉，不会计入异常统计中，也不会进入 fallback 逻辑中，而是会原样抛出。
 */