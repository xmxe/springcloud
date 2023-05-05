##### springcloud-config-server

- 客户端通过直接调用配置中心的server端来获取配置文件信息。但是存在了一个问题，客户端和服务端的耦合性太高，如果server端要做集群，客户端只能通过原始的方式来路由，server端改变IP地址的时候，客户端也需要修改配置，不符合springcloud服务治理的理念。
springcloud提供了这样的解决方案，我们只需要将server端当做一个服务注册到eureka中，client端去eureka中去获取配置中心server端的服务既可。与之前配置相比主要是去掉了spring.cloud.config.uri直接指向server端地址的配置，增加了最后的三个配置：
1. spring.cloud.config.discovery.enabled ：开启Config服务发现支持
2. spring.cloud.config.discovery.serviceId ：指定server端的name,也就是server端spring.application.name的值
3. eureka.client.serviceUrl.defaultZone ：指向注册中心的地址

- config server集成spring-cloud-starter-bus-kafka和spring-boot-starter-actuator
在远程仓库修改配置文件的时候通过 http://config-server:port/actuator/bus-refresh 来刷新所有springcloud-config-client，无须重启springcloud-config-client,也无须在springcloud-config-client上一个一个单独通过 http://configclientID:port/actuator/refresh 来刷新config-client的数据。
借助Git仓库的WebHook，我们就可轻松实现配置的自动刷新

- [Nacos、Apollo、Config配置中心如何选型](https://mp.weixin.qq.com/s/em0GYlJteARwSowzBSUF_Q)

