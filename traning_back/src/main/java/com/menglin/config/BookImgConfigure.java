package com.menglin.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class BookImgConfigure implements WebMvcConfigurer {

    @Value("${file.ProfilePhoto}")
    private String ProfilePhoto;
    @Value("${file.ProfilePhotoMapper}")
    private String ProfilePhotoMapperPath;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(ProfilePhotoMapperPath+"**").addResourceLocations("file:"+ProfilePhoto);
    }
}
