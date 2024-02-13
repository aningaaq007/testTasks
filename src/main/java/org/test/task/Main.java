package org.test.task;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

import groovy.lang.GroovyShell;
import groovy.util.logging.Slf4j;

@Slf4j
public class Main {
    public static void main(String[] args) {

        Map<Integer, Long> result = Arrays.stream(new Integer[]{1, 3, 4, 5, 1, 5, 4})
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println("result: " + result);

        try {
            var shell = new GroovyShell();
            var scriptFile = new File(Objects.requireNonNull(shell.getClassLoader()
                    .getResource("scripts/test_task.groovy")).getFile());

            var script = shell.parse(scriptFile);
            script.run();

        } catch (IOException exc) {
            System.out.println("Exception: " + exc.getMessage());
        }

    }

}