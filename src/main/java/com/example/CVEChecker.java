package com.example;

import org.gradle.api.Plugin;
import org.gradle.api.Project;
import org.gradle.api.artifacts.Configuration;
import org.gradle.api.artifacts.ConfigurationContainer;
import org.gradle.api.artifacts.Dependency;
import org.gradle.api.artifacts.DependencySet;

import java.util.HashSet;
import java.util.Set;


public class CVEChecker implements Plugin<Project> {

    Set<Dependency> dependencySet = new HashSet<>();

    @Override
    public void apply(Project project) {

        ConfigurationContainer configurations = project.getConfigurations();
        project.task("checkCVEs")
                .doFirst(task -> {
                    configurations.forEach(this::storeDependencies);
                })
                .doLast(task -> {

                });
    }

    private void storeDependencies(Configuration config) {
        DependencySet allDependencies = config.getAllDependencies();
        dependencySet.addAll(allDependencies);
    }



}
