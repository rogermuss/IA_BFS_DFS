package microcontroladores;

public class DelayAVRCalculator {

    static final double F_CPU = 16_000_000.0; // 16 MHz

    // calcula ciclos del inner loop
    static long innerCycles(int iVal) {
        // (iVal - 1)*4 + 3
        return (long)(iVal - 1) * 4 + 3;
    }

    // calcula ciclos totales del delay
    static long totalCycles(int oVal, int iVal) {

        long inner = innerCycles(iVal);

        // ciclos por outer loop normal
        long normalOuter = 1 + 1 + inner + 1 + 2;
        // última iteración outer
        long lastOuter = 1 + 1 + inner + 1 + 1;

        long total = (long)(oVal - 1) * normalOuter + lastOuter;

        // instrucciones fuera del loop principal
        total += 1; // eor
        total += 1; // out
        total += 1; // ldi outer
        total += 2; // rjmp

        return total;
    }

    public static void main(String[] args) {

        double desiredMs = 400; // cambia aquí el tiempo deseado
        double desiredCycles = (desiredMs / 1000.0) * F_CPU;

        long bestError = Long.MAX_VALUE;
        int bestO = 0;
        int bestI = 0;
        long bestCycles = 0;

        for (int o = 1; o <= 255; o++) {
            for (int i = 1; i <= 65535; i++) {

                long cycles = totalCycles(o, i);
                long error = Math.abs((long)desiredCycles - cycles);

                if (error < bestError) {
                    bestError = error;
                    bestO = o;
                    bestI = i;
                    bestCycles = cycles;
                }
            }
        }

        double realMs = (bestCycles / F_CPU) * 1000.0;

        System.out.println("Tiempo deseado: " + desiredMs + " ms");
        System.out.println("Mejor oVal: " + bestO);
        System.out.println("Mejor iVal: " + bestI);
        System.out.println("Tiempo real: " + realMs + " ms");
        System.out.println("Error ciclos: " + bestError);

        System.out.println("Ciclos totales del delay: " + bestCycles);
        System.out.println("Ciclos necesarios para " + desiredMs + " ms: " + (long)desiredCycles);
    }
}