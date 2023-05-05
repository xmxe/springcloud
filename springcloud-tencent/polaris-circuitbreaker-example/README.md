# Spring Cloud Polaris CircuitBreaker Example

- [Spring Cloud Tencent Circuitbreaker使用文档](https://github.com/Tencent/spring-cloud-tencent/wiki/Spring-Cloud-Tencent-Circuitbreaker-%E4%BD%BF%E7%94%A8%E6%96%87%E6%A1%A3)

## 样例简介

本样例将介绍如何在Spring Cloud项目中使用```spring-cloud-starter-tencent-polaris-circuitbreaker```以使用其各项功能。

该样例分为两个微服务，即 

1. ```polaris-circuitbreaker-example-a``` 
2. ```polaris-circuitbreaker-example-b``` 有两个实例B（默认正常服务）和B2（模拟异常服务）

``` polaris-circuitbreaker-example-a``` 对 ```polaris-circuitbreaker-example-b```发生调用。

## 使用说明

### 修改配置

修改 resource/bootstrap.yml中北极星的服务端地址

```yaml
spring:
  cloud:
    polaris:
       address: grpc://${ip}:8091
```

### 启动样例

#### 启动Polaris后端服务

参考[Polaris Getting Started](https://github.com/PolarisMesh/polaris#getting-started)。

### 启动应用

- IDEA启动

分别启动

1. ```polaris-circuitbreaker-example/polaris-circuitbreaker-example-a```下的```CircuitBreakerServiceAApplication```
2. ```polaris-circuitbreaker-example/polaris-circuitbreaker-example-b```下的```CircuitBreakerServiceBApplication```
3. ```polaris-circuitbreaker-example/polaris-circuitbreaker-example-b2```下的```CircuitBreakerServiceB2Application```


## 验证

### Feign调用

执行以下命令发起Feign调用，其逻辑为```ServiceB```抛出一个异常

```shell
curl -L -X GET 'localhost:48080/example/service/a/getBServiceInfo'
```

预期返回情况：

在出现
```
hello world ! I'm a service B1
```            

时，表示B2已经被熔断了，请求只会打到B1。

### 验证更多场景

您也可以调整 ```example-b``` 和 ```example-b2``` 中 ```resource/bootstrap.yml``` is-throw-runtime-exception
参数调整服务是否抛出异常。

例如测试以下场景：
1. 两个实例都是正常的，这时候预期是B1和B2都能正常被调用到
2. 一个实例正常一个实例不正常，这时候预期是不正常实例被熔断，请求只会打到正常的实例
3. 两个实例都不正常，这时候Feign会自动Fallback到ProviderBFallback.java的实现类