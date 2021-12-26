package br.com.alura.tdd.service;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import br.com.alura.tdd.modelo.Funcionario;

import static org.junit.jupiter.api.Assertions.*;

class BonusServiceTest {

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService service = new BonusService();
		// Exemplo 1:
		assertThrows(IllegalArgumentException.class,
				() -> service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000"))));

		// Exemplo 2: Fazendo o TESTE com o Try / Catch e comparando o conteúdo da Exception
//		try{
//			service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("25000")));
//			fail();
//		} catch (Exception e) {
//			assertEquals("Funcionário com salário maior do que R$ 10.000 não pode receber bônus!", e.getMessage());
//		}
	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BonusService service = new BonusService();
		BigDecimal bonus = service.calcularBonus(new Funcionario("Rodrigo", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}

}
