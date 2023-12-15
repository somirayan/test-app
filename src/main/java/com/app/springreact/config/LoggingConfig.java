package com.app.springreact.config;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.encoder.PatternLayoutEncoder;
import ch.qos.logback.core.rolling.RollingFileAppender;
import ch.qos.logback.core.rolling.TimeBasedRollingPolicy;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoggingConfig {

    public LoggingConfig() {
        configureLogging();
    }

    private void configureLogging() {
        LoggerContext context = (LoggerContext) LoggerFactory.getILoggerFactory();
        context.reset();

        // Set the log file path and pattern
        System.setProperty("LOG_FILE", "/var/log/app");
        System.setProperty("FILE_LOG_PATTERN", "%d %-5p [%t] %c{2} - %m%n");

        // Create a DailyRollingFileAppender
        RollingFileAppender appender = new RollingFileAppender();
        appender.setFile(System.getProperty("LOG_FILE") + "/app.log");

        // Configure encoder with pattern
        PatternLayoutEncoder encoder = new PatternLayoutEncoder();
        encoder.setPattern(System.getProperty("FILE_LOG_PATTERN"));
        encoder.setContext(context);
        encoder.start();

        appender.setEncoder(encoder);

        // Use DailyRollingFileAppender
        TimeBasedRollingPolicy rollingPolicy = new TimeBasedRollingPolicy();
        rollingPolicy.setFileNamePattern(System.getProperty("LOG_FILE") + "/app.%d{yyyy-MM-dd}.log");
        rollingPolicy.setMaxHistory(30); // Keep logs for 30 days

        appender.setRollingPolicy(rollingPolicy);
        appender.setContext(context);
        appender.start();

        // Add the appender to the root logger
        context.getLogger(org.slf4j.Logger.ROOT_LOGGER_NAME).addAppender(appender);
    }
}
