package ru.itis;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.net.URL;
import java.net.URLClassLoader;
import java.nio.file.Files;
import java.nio.file.Paths;

public class Main {

    @Parameter(names = "-classFolder")
    private String classFolder;

    public static void main(String[] args) {
        Main main = new Main();
        JCommander.newBuilder()
                .addObject(main)
                .build()
                .parse(args);
        try {
            main.run();
        } catch (Exception e) {
            throw new IllegalArgumentException(e);
        }
    }

    public void run() throws Exception {
        Class[] classes = new Class[2];
        Files
                .list(Paths.get(classFolder))
                .forEach(file -> {
                    try {
                        URL url = new URL(new File(classFolder).toURI().toString());
                        URLClassLoader loader = URLClassLoader.newInstance(new URL[]{url}, getClass().getClassLoader());
                        classes[0] = loader.loadClass("User");
                        classes[1] = loader.loadClass("Human");
                    } catch (Exception e) {
                        throw new IllegalArgumentException(e);
                    }
                });
        System.out.println("Classes:");
        for (Class element: classes){
            System.out.println("Class " + element.getName() + "\n");
            System.out.println("-Fields");
            for (Field field: element.getDeclaredFields()){
                System.out.println(field.getType().getSimpleName() + " " + field.getName());
            }
            System.out.println();
            System.out.println("-Methods");
            for (Method method: element.getDeclaredMethods()){
                System.out.println(method.getReturnType().getSimpleName() + " " + method.getName());
                System.out.println("Types of method parameters:");
                for (Class paramType: method.getParameterTypes()){
                    System.out.println(paramType.getSimpleName() + " ");
                }
                System.out.println();
            }
            System.out.println("-Constructors");
            for (Constructor constructor: element.getDeclaredConstructors()){
                for (Class paramType: constructor.getParameterTypes()){
                    System.out.print(paramType.getSimpleName() + " ");
                }
            }
            System.out.println("\n");
        }
    }
}
