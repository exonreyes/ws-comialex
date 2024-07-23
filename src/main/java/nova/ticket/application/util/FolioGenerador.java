package nova.ticket.application.util;

import java.time.LocalDateTime;
import java.util.Random;

public final class FolioGenerador {

    private static final String BASE_36_CHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    public static String generarFolio() {
        LocalDateTime fecha = LocalDateTime.now();
        String[] partes = new String[]{
                toBase36(fecha.getYear() % 100),
                toBase36(obtenerDia(fecha)),
                toBase36(fecha.getHour()),
                toBase36(fecha.getMinute()),
                toBase36(fecha.getSecond()),
                toBase36(new Random().nextInt(36))
        };
        return String.join("", partes);
    }

    private static int obtenerDia(LocalDateTime fecha) {
        LocalDateTime inicioDeAnio = LocalDateTime.of(fecha.getYear(), 1, 1, 0, 0);
        int diff = (int) inicioDeAnio.until(fecha, java.time.temporal.ChronoUnit.DAYS);
        return diff + 1;
    }

    private static String toBase36(int num) {
        StringBuilder result = new StringBuilder();
        do {
            result.insert(0, BASE_36_CHARS.charAt(num % 36));
            num = num / 36;
        } while (num > 0);
        return result.toString();
    }
}
