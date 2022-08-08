package br.com.dev.spring.essentials.domain.services;

import br.com.dev.spring.essentials.SpringEssentialsApplication;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Objects;
import java.util.stream.Stream;

public class newUtils {

//    public static <T> T fillObject(Field field) {
//        try {
//            T object = (T) field.getType().getConstructor().newInstance();
//            Stream.of(field.getType().getDeclaredFields()).forEach(campo -> fillField(field)
//            );
//            return object;
//        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }

    public static <T> T mustRaiseStartDateException(Class<?> type) {
        T object = fillObject(type);
        SpringEssentialsApplication
                .invokeSet(object, FieldType.START_DATE.getName(), LocalDate.now().minusDays(1));
        return object;
    }

    public static <T> T mustRaiseEndDateException(Class<?> type) {
        T object = fillObject(type);
        SpringEssentialsApplication
                .invokeSet(object, FieldType.END_DATE.getName(), LocalDate.now().minusDays(1));
        return object;
    }

    public static <T> T fillObject(Class<?> type) {
        try {
            T object = (T) type.getConstructor().newInstance();
            Stream.of(type.getDeclaredFields()).forEach(campo -> {
                SpringEssentialsApplication
                        .invokeSet(object, campo.getName(), fillField(campo));
            });
            return object;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static <T> Object fillField(Field field) {
        Class<?> type = field.getType();
        if (Objects.equals(type, String.class)) {
            return FieldType.STRING.getValue();
        }
        if (Objects.equals(type, LocalDate.class)) {
            return field.getName().equals(FieldType.START_DATE.getName()) ? FieldType.START_DATE.getValue() : FieldType.END_DATE.getValue();
        }
        if (Objects.equals(type, LocalDateTime.class)) {
            return FieldType.REGISTRATION_DATE.getValue();
        }
        if (Objects.equals(type, Integer.class)) {
            return FieldType.INTEGER.getValue();
        }
        if (Objects.equals(type, Long.class)) {
            return FieldType.LONG.getValue();
        }
        if (Objects.equals(type, Boolean.class)) {
            return FieldType.BOOLEAN.getValue();
        }
        return null;
    }

    public static void main(String[] args) {
        Object object = mustRaiseStartDateException(Exemplo.class);
        System.out.println(object.toString());
    }
}
