package org.uarrive.filecabinets.Util;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@Data
@ConfigurationProperties(prefix = "server")
public class ApplicationProperties {


    @Value("${server.port}")
    private  int port;

    @Value("${server.servlet.context-path}")
    private  String contextPath;


}