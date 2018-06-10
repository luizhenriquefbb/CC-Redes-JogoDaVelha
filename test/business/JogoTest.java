//
//package business;
//
//import infra.Jogador;
//import org.junit.After;
//import org.junit.AfterClass;
//import org.junit.Before;
//import org.junit.BeforeClass;
//import org.junit.Test;
//import static org.junit.Assert.*;
//
///**
// *
// * @author luiz
// */
//public class JogoTest {
//
//    Jogador jogador1 = new Jogador("Joao");
//    Jogador jogador2 = new Jogador("Pedro");
//    Jogo jogo = new Jogo(jogador1, jogador2);
//
//    public JogoTest() {
//        this.jogador1 = new Jogador("Joao");
//        this.jogador2 = new Jogador("Pedro");
//        this.jogo = new Jogo(jogador1, jogador2);
//    }
//
//    @BeforeClass
//    public static void setUpClass() {
//    }
//
//    @AfterClass
//    public static void tearDownClass() {
//    }
//
//    @Before
//    public void setUp() {
//    }
//
//    @After
//    public void tearDown() {
//    }
//
//    /**
//     * Test of lidarComJogada method, of class Jogo.
//     */
//    @Test
//    public void testLidarComJogada() {
//        System.out.println("lidarComJogada");
//        int indexQuadrado = 0;
//        String result = this.jogo.lidarComJogada(this.jogador1, 0);
//
//        System.out.println(result);
//    }
//
//}
