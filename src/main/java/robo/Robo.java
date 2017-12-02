package robo;

import java.text.MessageFormat;

public class Robo {

    private Integer TAMANHO_X = 3;
    private Integer TAMANHO_Y = 3;
    private Integer posicaoX = 1;
    private Integer posicaoY = 1;

    private Integer ateX = 0;
    private Integer ateY = 0;

    public Robo() {
    }

    public void tamanhoMapa(Integer x, Integer y) {
        TAMANHO_X = x;
        TAMANHO_Y = y;
    }

    public void andarDireta() {
        if (posicaoX + 1 <= TAMANHO_X) {
            posicaoX += 1;
            System.out.print("Andou para direita! ");
        }
    }

    public void andarEsquerda() {
        if (posicaoY - 1 >= 1) {
            posicaoX -= 1;
            System.out.print("Andou para esquerda!");
        }
    }

    public void andarCima() {
        if (posicaoY - 1 >= 1) {
            posicaoY -= 1;
            System.out.print("Andou para cima!    ");
        }
    }

    public void andarBaixo() {
        if (posicaoY + 1 <= TAMANHO_Y) {
            posicaoY += 1;
            System.out.print("Andou para baixo!   ");
        }
    }

    public Integer obterPosicaoX() {
        return posicaoX;
    }

    public Integer obterPosicaoY() {
        return posicaoY;
    }

    public void novaCoordenada(Integer x, Integer y) {
        ateX = x;
        ateY = y;
    }

    public void iniciarTrajeto() {
        System.out.println(MessageFormat.format("\nNovo trajeto [{0}][{1}]  - Posição inicial [{2}]:[{3}]", ateX, ateY, posicaoX, posicaoY));

        if (posicaoX <= ateX) {
            caminharEixoX(posicaoX, ateX, true);
        } else {
            caminharEixoX(ateX, posicaoX, false);
        }

        if (posicaoY <= ateY) {
            caminhaEixoY(posicaoY, ateY, true);
        } else {
            caminhaEixoY(ateY, posicaoY, false);

        }
    }

    private void caminharEixoX(Integer posicaoX, Integer ateX, boolean paraFrente) {
        for (int i = posicaoX; i < ateX; i++) {
            if (paraFrente) { andarDireta(); } else { andarEsquerda(); }
            System.out.println(MessageFormat.format(" - Posição Atual   [{0}]:[{1}]", this.posicaoX, this.posicaoY));
        }
    }

    private void caminhaEixoY(Integer posicaoY, Integer ateY, boolean paraBaixo) {
        for (int i = posicaoY; i < ateY; i++) {
            if (paraBaixo) { andarBaixo(); } else { andarCima(); }
            System.out.println(MessageFormat.format(" - Posição Atual   [{0}]:[{1}]", this.posicaoX, this.posicaoY));
        }
    }
}
