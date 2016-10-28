# bluesky-spring-boot
spring-boot实践
此项目在不断地丰富中，会持续集成redis，activemq。。。。
2016-10-28 记：
一：集成mybatis并使用通用mapper，方便单表操作，个人感觉没有自己生产的好用灵活
如果需要集成通用mapper需要注意以下几点：
1：需要配置MybatisMapperScannerConfig，本项目见AdsMybatisMapperScannerConfig和RdsMybatisMapperScannerConfig
2：通用mapper会根据entity对象动态的生产sql语句，所以需在entity对象上加上表名：如：@Table(name = "t_member")
3：如此一来建议使用通用mapper专用的mybatis生产插件；地址：http://git.oschina.net/free/Mapper/blob/master/wiki/mapper3/7.UseMBG.md
