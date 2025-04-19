package de.schaeferd.sample.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.vaadin.flow.theme.Theme;
import com.vaadin.flow.component.page.AppShellConfigurator;

@Theme("theme")
@SpringBootApplication
public class SampleClientApplication implements AppShellConfigurator {

    public static void main(String[] args) {
        SpringApplication.run(SampleClientApplication.class, args);
    }
}
