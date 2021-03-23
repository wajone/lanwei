package com.sifunit.lanwei.config;
import com.sifunit.lanwei.common.FileUploadUtils;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class FileUploadConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler(FileUploadUtils.MappingPath + "**").addResourceLocations("file:" + FileUploadUtils.UploadPath);
        super.addResourceHandlers(registry);
    }
}
