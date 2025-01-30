package org.formation.dto;

import java.util.List;
import java.util.Map;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "account")
public record AcountInfoDto(String message, Map<String, String> details, List<String> phone) {

}
