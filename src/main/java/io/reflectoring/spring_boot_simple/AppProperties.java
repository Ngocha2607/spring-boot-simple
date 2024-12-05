package io.reflectoring.spring_boot_simple;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
// @PropertySource("classpath:application.properties") // Đánh dấu để lấy config từ trong file loda.yml
@ConfigurationProperties(prefix = "global")
public class AppProperties {
    private String email;
    private String googleAnalyticsId;
}
