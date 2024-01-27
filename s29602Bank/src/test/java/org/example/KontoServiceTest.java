package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class KontoServiceTest {
    private KontoService kontoService;
    private KontoStorage kontoStorage;
    @BeforeEach
    public void setUp(){
        kontoStorage = new KontoStorage();
        kontoService = new KontoService(kontoStorage);
    }
    @Test
    public void testPrzelewik(){
        //Given
        Konto konto1 = new Konto(1, 1000);
        kontoStorage.addKonto(konto1);

        //When
        Status wynik = kontoService.Przelewik(1,1000,500);

        //Then
        double expected = 1000 - 500;
        assertThat(wynik).isEqualTo(Status.ACCEPTED);
    }

    @Test
    public void testWypłata(){
        //Given
        Konto konto2 = new Konto(1, 10000);
        kontoStorage.addKonto(konto2);

        //When
        Status dodatek = kontoService.Przelewik(1,10000,500);

        //Then
        double expected = 10000 + 500;
        assertThat(dodatek).isEqualTo(Status.ACCEPTED);
    }

}