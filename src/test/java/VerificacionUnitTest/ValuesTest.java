package VerificacionUnitTest;

import VerificacionUnitTestMock.Generador;
import VerificacionUnitTestMock.PrimoUtils;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.Mockito;

public class ValuesTest {
    PrimoUtils primoUtilsMock = Mockito.mock(PrimoUtils.class);


    @ParameterizedTest
    @CsvSource({
            "0",
            "-1",
    })
    public void verifyNumberValuesException(int n){
        Generador generador = new Generador();
        Assertions.assertThrows(Exception.class, ()-> {generador.getNumberValues(n);} );
    }

    @ParameterizedTest
    @CsvSource({
            "1,1",
            "2,3 2",
            "11,3 4 6 8 9 10",
            "21,3 1 5 7 9 11 13 15 17 19",
            "8,1 3 5 7",

    })
    public void verifyNumberValues(int n, String expectedResult) throws Exception {

        Mockito.when(primoUtilsMock.esPrimo(1)).thenReturn(false);
        Mockito.when(primoUtilsMock.esPrimo(2)).thenReturn(true);
        Mockito.when(primoUtilsMock.esPrimo(3)).thenReturn(true);
        Mockito.when(primoUtilsMock.esPrimo(4)).thenReturn(false);
        Mockito.when(primoUtilsMock.esPrimo(5)).thenReturn(true);
        Mockito.when(primoUtilsMock.esPrimo(6)).thenReturn(false);
        Mockito.when(primoUtilsMock.esPrimo(7)).thenReturn(true);
        Mockito.when(primoUtilsMock.esPrimo(8)).thenReturn(false);
        Mockito.when(primoUtilsMock.esPrimo(11)).thenReturn(true);
        Mockito.when(primoUtilsMock.esPrimo(21)).thenReturn(false);

        Generador generador = new Generador(primoUtilsMock);


        Assertions.assertEquals(expectedResult,generador.getNumberValues(n),"ERROR!! la respuesta es incorrecta");


    }
}
