package read;


import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "read")
@EnableAspectJAutoProxy
public class AppConfig {

    @Bean
    public Read read(){
        return new Read();
    }

}
