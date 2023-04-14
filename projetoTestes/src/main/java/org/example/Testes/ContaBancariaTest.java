package org.example.Testes;

import org.example.Biblioteca;
import org.example.ContaBancaria;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ContaBancariaTest {
    private ContaBancaria contaBancaria;


    @BeforeEach
    public void setUp() {
        contaBancaria = new ContaBancaria("123","eu");
    }

    // deposito
    @Test
    public void testeDeposito(){
        Assertions.assertEquals(true, contaBancaria.depositar(15));
    }

    @Test
    public void testeDeposito2(){
        Assertions.assertEquals(true, contaBancaria.depositar(-5));
    }


    // saque
    @Test
    public void testeSaque(){
        contaBancaria.depositar(12);
        Assertions.assertEquals(true,contaBancaria.sacar(1));
    }

    @Test
    public void testeSaque2(){
        contaBancaria.depositar(12);
        Assertions.assertEquals(true,contaBancaria.sacar(14));
    }


    // transferencia
    @Test
    public void testeTransferencia(){
        ContaBancaria conta1 = new ContaBancaria("23","maria");
        conta1.depositar(12.0);
        ContaBancaria conta2 = new ContaBancaria("32","bruno");
        conta2.depositar(2.0);
        conta1.transferir(conta2,2.0);
        Assertions.assertEquals(4,conta2.getSaldo());
    }

    @Test
    public void testeTransferencia2(){
        ContaBancaria conta1 = new ContaBancaria("23","maria");
        conta1.depositar(12.0);
        ContaBancaria conta2 = new ContaBancaria("32","bruno");
        conta2.depositar(2.0);
        conta1.transferir(conta2,2.0);
        Assertions.assertEquals(5,conta2.getSaldo());
    }

    //titular
    @Test
    public void testeTitular(){
        contaBancaria.alterarTitular("bruno");
        Assertions.assertEquals("bruno",contaBancaria.getTitular());
    }

    @Test
    public void testeTitular2(){
        contaBancaria.alterarTitular("bruno");
        Assertions.assertEquals("maria",contaBancaria.getTitular());
    }

    //get Numero da conta
    @Test
    public void numeroContaTest(){
        Assertions.assertEquals("123",contaBancaria.getNumeroConta());
    }

    @Test
    public void numeroContaTest2(){
        Assertions.assertEquals("12",contaBancaria.getNumeroConta());
    }

    //set e get Juros
    @Test
    public void getSetJuros() {
        contaBancaria.setTaxaJuros(0.1);
        Assertions.assertEquals(0.1, contaBancaria.getTaxaJuros());
    }

    //Juros

    @Test
    public void aplicarJuros(){
        contaBancaria.setTaxaJuros(0.1);
        contaBancaria.depositar(100);
        contaBancaria.aplicarJuros();
        Assertions.assertEquals(110.0,contaBancaria.getSaldo());
    }

    @Test
    public void aplicarJuros2(){
        contaBancaria.setTaxaJuros(0.1);
        contaBancaria.depositar(100);
        contaBancaria.aplicarJuros();
        Assertions.assertEquals(111.0,contaBancaria.getSaldo());
    }

    //get titular

    @Test
    public void getTitularTest(){
        Assertions.assertEquals("eu",contaBancaria.getTitular());
    }

    @Test
    public void getTitularTest2(){
        Assertions.assertEquals("maria",contaBancaria.getTitular());
    }

    // get saldo
    @Test
    public void getSaldo(){
        contaBancaria.depositar(2);
        Assertions.assertEquals(2,contaBancaria.getSaldo());
    }

    @Test
    public void getSaldo2(){
        contaBancaria.depositar(1);
        Assertions.assertEquals(2,contaBancaria.getSaldo());
    }

    //


}
