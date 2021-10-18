package cat.copernic.jmendezv

import org.junit.jupiter.api.*
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import org.junit.jupiter.params.provider.ValueSource
import java.time.Duration
import java.util.stream.Stream

internal class MainKtTest {
    @BeforeEach
    fun setUp() {
        println("*** Inicio tests... ")
    }

    @AfterEach
    fun tearDown() {
        println("Final tests... *** ")
    }

    @Test
    @DisplayName("Test simple de IMC")
    fun IMCTest() {
        assertEquals(18.35, 0.001, IMC(50.00, 1.65))
    }

    @ParameterizedTest
    @MethodSource("provide")
    @DisplayName("Test con un metodo source de las equaciones de segundo grado.")
    fun equSegundoGradoTest(resultado:Pair<Double, Double>, a:Double, b:Double, c:Double) {
        assertEquals(resultado ,equSegundoGrado(a, b, c))
    }

    @ParameterizedTest
    @ValueSource(doubles = [7.071,6.00,5.00,4.00])
    @DisplayName("Test de un value source")
    fun distanciaEntre2PuntosTest(p: Double) {
        assertEquals(p,0.001, distanciaEntre2Puntos(Punto(12.0,3.0), Punto(5.0,4.0)))
    }

    @Test
    @DisplayName("Test con una condicion de tiempo")
    fun `testing imc for timeout`() {
        val result =
            org.junit.jupiter.api.assertTimeout(
                Duration.ofMillis(2)) {
                assertEquals(0.5, 0.01, Pendiente(Punto(1.0,4.0), Punto(3.0,5.0)))
            }
        println("El resultado es: $result has superado el tiempo")
    }


    @Test
    @DisplayName("Test simple")
    fun puntoMedioTest() {

    }

    @Test
    @DisplayName("Test simple")
    fun calificacionTest() {
    }

    @Test
    @DisplayName("Test simple")
    fun maxMinTest() {
    }

    @Test
    @DisplayName("Test simple")
    fun masCercanoTest() {
    }

    companion object{
        @BeforeAll
        @JvmStatic
        fun init(){
            println("*** Inicio tests... ")
        }

        @AfterAll
        @JvmStatic
        fun end(){
            println("Final tests... ***")

        }

        @JvmStatic
        fun provide(): Stream<Arguments> {

            return Stream.of(
                Arguments.of(Pair(8.60555127546399,1.3944487245360109), 10.0, -5.0, 6.0),
                Arguments.of(Pair(3.4,7.5), 80.0, -1.0, 7.0),
                Arguments.of(Pair(5.4,2.5), 10.0, -4.0, 6.0),
            )

        }
    }


}