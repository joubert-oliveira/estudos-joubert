package sptech.projetojpa07.servico;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculosServiceTest {

    @Test
    @DisplayName("calcularInss() deve calcular corretamente")
    void calcularInss_deveriaCalcularCorretamente() {
        CalculosService service = new CalculosService();
        double salario1 = 500.0;
        double inss1 = 25.0;
        double inssCalculo1 = service.calcularInss(salario1);
        assertEquals(inss1, inssCalculo1);

        double salario2 = 2000.0;
        double inss2 = 100.0;
        double inssCalculo2 = service.calcularInss(salario2);
        assertEquals(inss2, inssCalculo2);

        assertEquals(500, service.calcularInss(5000.0));
    }

    @Test
    @DisplayName("calcularInss() com salário menor que 500 deve ser erro")
    void calcularInss_salarioInvalidoErro() {
        assertThrows(IllegalArgumentException.class, () -> {
            CalculosService service = new CalculosService();
            service.calcularInss(-100.0);
        });

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
            CalculosService service = new CalculosService();
            service.calcularInss(499.99);
        });

        assertEquals("Salário deve ser a partir de 500", excecao.getMessage());
    }

    @Test
    @DisplayName("receberAuxilio() calcular se tem salário menor que 4000 e mais de 3 dependentes")
    void receberAuxilio_calculoSalarioMenor() {
        CalculosService service = new CalculosService();
        double salario1 = 3500.0;
        int dependencia = 5;
        boolean receberAuxilio = service.receberAuxilio(salario1, dependencia);
        assertEquals(true, receberAuxilio);
    }

    @Test
    @DisplayName("receberAuxilio() calcular se tem salário maior que 4000 e menor ou igual a 0 dependentes")
    void receberAuxilio_calculoDependenciaMenor() {

        IllegalArgumentException excecao = assertThrows(IllegalArgumentException.class, () -> {
            CalculosService service = new CalculosService();
            service.receberAuxilio(4500.0, -1);
        });
        assertEquals("O salário deve ser a partir de 500 e os dependendetes a partir de 0", excecao.getMessage());
    }

    @Test
    @DisplayName("receberAuxilio() calcular se tem salário maior que 4000")
    void receberAuxilio_calculoSalarioMaior() {
        CalculosService service = new CalculosService();
        double salario1 = 9500.0;
        int dependencia = 5;
        boolean receberAuxilio = service.receberAuxilio(salario1, dependencia);
        assertEquals(false, receberAuxilio);
    }
}