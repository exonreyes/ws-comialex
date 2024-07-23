package nova.ticket.application.util;

import java.time.LocalDateTime;
import java.util.Random;
public final class FolioGenerador {

    public static String generar(){
        LocalDateTime ahora = LocalDateTime.now();
        // Obtener los últimos dos dígitos del año
        String anio = String.valueOf(ahora.getYear() % 100);
        int diaDelAnio = ahora.getDayOfYear();
        String hora = String.format("%02d", ahora.getHour());
        String minuto = String.format("%02d", ahora.getMinute());
        String segundo = String.format("%02d", ahora.getSecond());
        Random random = new Random();
        int numX = random.nextInt(36);
        String folioSinCodificacion = anio + String.format("%03d", diaDelAnio) + hora + minuto + segundo + numX;
        long folioBase10 = Long.parseLong(folioSinCodificacion);
        return Long.toString(folioBase10, 36).toUpperCase();
    }
}

