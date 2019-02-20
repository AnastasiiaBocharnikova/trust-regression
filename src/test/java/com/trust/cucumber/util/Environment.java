package com.trust.cucumber.util;

import org.aeonbits.owner.Config.Sources;
import org.aeonbits.owner.Config;


@Sources({
        "file:src/test/resources/${tier}-env.properties"
    })
    public interface Environment extends Config {

        String env();

        String username();

        String password();

        String url_db();

        String username_db();

        String password_db();
    }
