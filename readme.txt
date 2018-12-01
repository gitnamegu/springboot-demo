一、springboot
1.  springboot注解
    1.1 启动类上的注解
            @SpringBootApplication注解：标注在springboot的主程序类上
            1.1 @SpringBootConfiguration：springboot的配置类
                1.1.1 @Configuration：spring定义的注解，标注在配置类上。配置类是啥：配置类等价于以前的配置文件，给容器中注入bean/aop等等组件
                    1.1.1.1 @Component：表明配置类也是一个组件
            1.2 @EnableAutoConfiguration：开启自动配置功能，加上这个注解，springmvc等都不用我们来配置了
                1.2.1 @AutoConfigurationPackage：
                    1.2.1.1 @Import(AutoConfigurationPackages.Registrar.class)：给容器中导入组件，该导入哪些组件，由后面的类决定。
                        Registrar类给容器中导入的组件：将主配置类所在的包及其子包的组件扫描进容器。
                1.2.2 @Import(AutoConfigurationImportSelector.class)：给容器中导入组件，该导入哪些组件，由后面的类决定。
                    AutoConfigurationImportSelector类给容器中导入的组件：这个类会扫描各种springboot官方的自动配置类，然后这些配置
                类会导入各种组件。例如导入了spirngmvc的配置类,进而导入springmvc的组件和默认配置，所以我们可以不用再写springmvc的配置类。

2.  项目架构
    java:
    resources:
        static:放静态资源，放在css/js/images包下
        templates：放模板(springboot内嵌了tomcat,不支持jsp,所以可以使用模板引擎)

3.  application.properties配置文件：
    这个配置文件里的配置的键包括自定义的配置和官方指定的已经约定俗成的配置。
    官方约定的配置的键对应着各种AutoConfiguration类。AutoConfiguration类有哪些可参考spring-boot-autoconfigure包下的spring.factories文件
    自动配置类一般都顶了@Conditional*注解，配置了这个注解则必须满足条件下配置类才会生效才会注入bean等组件

4.  静态资源：
    客户端访问/**(所有的请求)时，没有controller处理，就会去静态资源里查找。
    在静态资源文件夹下创建index.html文件，访问address:port时，没有controller处理，就会默认访问到该页面
二、整合其他框架
1.  整合日志框架
    slf4j/jcl/jboss-logging是日志的抽象层框架，log4j/log4j2/logback是日志的实现层框架。整合日志框架时，依赖中添加一个抽象层的依赖一个实现层的依赖。
    slf4j/log4j/logback是一个作者,因为log4j有性能问题所以实现层选用logback。
    springboot默认已经配置好logback了。springboot默认是info级别
        1) springboot默认使用logback框架
        2) 每个日志的实现层框架都有自己的配置文件
        3) 其他的框架可能有自己依赖的日志框架，有可能不是logback, 比如hibernate使用的日志框架就不是logback. 那么引入该框架时需要移除该框架的日志依赖。
    springboot整合logback的步骤：






附加：
    1. idea使用lombok省略手写get/set/toString()方法
        步骤：1) idea安装lombok插件
             2) maven的pom.xml添加lombok依赖
        使用方式：在类上加上相应的注解就完成了。
        注解类型：
             @Data 注解在类上；提供类所有属性的 getting 和 setting 方法，此外还提供了equals、canEqual、hashCode、toString 方法
             @Setter ：注解在属性上；为属性提供 setting 方法
             @Setter ：注解在属性上；为属性提供 getting 方法
             @Log4j ：注解在类上；为类提供一个 属性名为log 的 log4j 日志对象
             @NoArgsConstructor ：注解在类上；为类提供一个无参的构造方法
             @AllArgsConstructor ：注解在类上；为类提供一个全参的构造方法
             @Cleanup : 可以关闭流
             @Builder ： 被注解的类加个构造者模式
             @Synchronized ： 加个同步锁
             @SneakyThrows : 等同于try/catch 捕获异常
             @NonNull : 如果给参数加个这个注解 参数为null会抛出空指针异常