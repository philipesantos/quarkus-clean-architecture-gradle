package org.acme.main;

import io.quarkus.runtime.Quarkus;
import io.quarkus.runtime.annotations.QuarkusMain;

@QuarkusMain
public class QuarkusFrameworkMain {
    public static void main(String[] args) {
        Quarkus.run(args);
    }
}