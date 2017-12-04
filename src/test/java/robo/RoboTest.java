package robo;

import components.Logger;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import static org.junit.Assert.assertEquals;

public class RoboTest {

    @RunWith(Suite.class)
    @SuiteClasses({
            AoMover.class
    })
    public static class AllTests { }

    @BeforeClass
    public static void iniciarLog() {
        Logger.resetarLog();
    }

    public static class AoMover extends RoboTest {

        private Robo robo;

        @Before
        public void montarContexto() {
            robo = new Robo();
        }

        @Test
        public void deveriaAndarParaDireita() {
            robo.andarDireta(2);

            assertEquals(new Integer(3), robo.obterPosicaoX());
            assertEquals(new Integer(1), robo.obterPosicaoY());
        }

        @Test
        public void deveriaAndarParaEsquerda() {
            robo.andarEsquerda(1);

            assertEquals(new Integer(1), robo.obterPosicaoX());
            assertEquals(new Integer(1), robo.obterPosicaoY());
        }

        @Test
        public void deveriaAndarParaCima() {
            robo.andarCima(1);

            assertEquals(new Integer(1), robo.obterPosicaoX());
            assertEquals(new Integer(1), robo.obterPosicaoY());
        }

        @Test
        public void deveriaAndarParaBaixo() {
            robo.andarBaixo(1);

            assertEquals(new Integer(1), robo.obterPosicaoX());
            assertEquals(new Integer(2), robo.obterPosicaoY());
        }

        @Test
        public void deveriaNaoUtrapassarAhBordaDireita() {
            robo.andarDireta(2);

            assertEquals(new Integer(3), robo.obterPosicaoX());
            assertEquals(new Integer(1), robo.obterPosicaoY());
        }

        @Test
        public void deveriaNaoUtrapassarAhBordaBaixo() {
            robo.andarBaixo(3);

            assertEquals(new Integer(1), robo.obterPosicaoX());
            assertEquals(new Integer(3), robo.obterPosicaoY());
        }

        @Test
        public void deveriaAndarAteAhCoordenadaInformada() {
            robo.tamanhoMapa(4, 5);

            robo.novaCoordenada(3, 3);
            robo.iniciarTrajeto();
            assertEquals(new Integer(3), robo.obterPosicaoX());
            assertEquals(new Integer(3), robo.obterPosicaoY());
        }
    }
}