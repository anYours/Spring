- @Value 注解

    @Value 注解对 Bean 的变量或者方法参数进行标注，职责是基于表达式给字段或方法参数设置默认属性值。通常格式是注解 + SpEL 表达式，如 @Value("SpEL 表达式")，并标注在对应的字段或者方法上方，且必须对变量一一标注。这种方式适用于小而不复杂的属性结构。属性结构复杂，字段很多的情况下，这种方式会比较繁琐，应该考虑使用 @ConfigurationProperties 注解。
- @ConfigurationProperties 注解
    
    类似 @Value 注解方式，使用 @ConfigurationProperties(prefix = "demo.book") 注解标注在类上方可以达到相同的效果。 @ConfigurationProperties 注解的 prefix 是指定属性的参数名称。会匹配到配置文件中 “ demo.book.* ” 结构的属性，星号 “ * ” 是指会一一对应匹配 BookComponent 类的字段名。例如，字段 name 表示书名，会匹配到 demo.book.name 属性值。
    
    @Value 注解方式强制字段必须对应在配置文件， @ConfigurationProperties 注解方式则不是必须的。一般情况下，所有字段应该保证一一对应在配置文件。如果没有属性值对应的话，该字段默认为空， @ConfigurationProperties 注解方式也不会引发任何异常，Spring Boot 推荐使用 @ConfigurationProperties 注解方式获取属性。
 
 - @PropertySource注解
 
    使用外部配置时用到，具体用法如下：
    @PropertySource("classpath:test_application.yml")