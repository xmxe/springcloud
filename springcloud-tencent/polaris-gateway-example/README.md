# Spring Cloud Polaris Gateway example

## 样例简介

本样例将介绍如何在Spring Cloud项目中使用```spring-cloud-tencent-polaris-gateway```以使用其各项功能。

本样例包括 ```gateway-scg-service```和```gateway-callee-service```。
```gateway-scg-service```调用```gateway-callee-service```。

## 使用说明

### 修改配置

配置如下所示。其中，${ip}和${port}为Polaris后端服务的IP地址与端口号。

```yaml
spring:
  application:
    name: ${application.name}
  cloud:
    polaris:
      address: grpc://${ip}:${port}
```

### 启动样例

#### 启动Polaris后端服务

参考[Polaris Getting Started](https://github.com/PolarisMesh/polaris#getting-started)。

#### 启动应用

- IDEA启动

分别启动```polaris-gateway-example/gateway-scg-service```的```GatewayScgService```和```polaris-gateway-example/gateway-callee-service```的```GatewayCalleeApplication```

- Maven打包启动

在```polaris-gateway-example```下执行

```sh
mvn clean package
```

然后在 ```gateway-scg-service```和```gateway-callee-service```下找到生成的jar包，运行

```
java -jar ${app.jar}
```

启动应用，其中${app.jar}替换为对应的jar包名。

### 验证

#### Spring-Cloud-Gateway调用

```shell
curl -L -X GET 'http://localhost:48083/GatewayCalleeService/gateway/example/callee/echo' -H 'SCT-CUSTOM-METADATA: {"b": 2}'
```

预期返回值

```
{"a":"1","b":2}
```

#### 网关限流

参考[Polaris RateLimit Example](../polaris-ratelimit-example/README.md)