package com.accepted_example.matches.config;

import com.fasterxml.jackson.datatype.hibernate6.Hibernate6Module;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.Module;

@Configuration
public class HibernateConfiguration {

    @Bean
    public Module hibernateModule() {
        Hibernate6Module h6m = new Hibernate6Module();

        h6m.configure(Hibernate6Module.Feature.SERIALIZE_IDENTIFIER_FOR_LAZY_NOT_LOADED_OBJECTS, true);

        return h6m;
    }

}
