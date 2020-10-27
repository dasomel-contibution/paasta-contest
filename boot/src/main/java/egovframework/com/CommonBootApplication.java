package egovframework.com;

import egovframework.com.cmm.config.EgovWebApplicationInitializer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.web.firewall.HttpFirewall;
import org.springframework.security.web.firewall.StrictHttpFirewall;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class}, scanBasePackageClasses = CommonBootApplication.class)
@ImportResource({"classpath:/egovframework/spring/com/**/context-*.xml"
				,"classpath:/egovframework/spring/mvc/egov-com-*.xml"})
//@Import(EgovWebApplicationInitializer.class)
//public class CommonBootApplication extends SpringBootServletInitializer {
public class CommonBootApplication extends EgovWebApplicationInitializer {

//    @Override
//    protected SpringApplicationBuilder configure(SpringApplicationBuilder builder) {
//        return builder.sources(EgovWebApplicationInitializer.class);
//    }
//
//    public static void main(String[] args) {
//        SpringApplication springApplication = new SpringApplication(CommonBootApplication.class);
//        springApplication.run(args);
//    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(CommonBootApplication.class, args);
    }

    @Bean
    public HttpFirewall allowUrlEncodedSlashHttpFirewall() {
        StrictHttpFirewall firewall = new StrictHttpFirewall();
        firewall.setAllowUrlEncodedSlash(true);
        return firewall;
    }
}
