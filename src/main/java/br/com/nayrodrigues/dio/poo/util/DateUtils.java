package br.com.nayrodrigues.dio.poo.util;

import java.time.LocalDate;

public final class DateUtils {
    private DateUtils(){}

    public static LocalDate hoje() {
        return LocalDate.now();
    }
}
