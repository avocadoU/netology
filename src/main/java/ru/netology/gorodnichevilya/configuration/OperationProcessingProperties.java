package ru.netology.gorodnichevilya.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "operation.processing")
public class OperationProcessingProperties {
	private int timeout;
}
