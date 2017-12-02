package robo;

import components.Logger;

import static java.text.MessageFormat.format;

public class Robo {

    private Integer TAMANHO_X = 3;
    private Integer TAMANHO_Y = 3;
    private Integer posicaoX = 1;
    private Integer posicaoY = 1;

    private Integer ateX = 1;
    private Integer ateY = 1;

    private StringBuilder arquivoLog;

    public Robo() {
        arquivoLog = new StringBuilder();
    }

    public static void main(String[] args) {
        Robo robo = new Robo();
        robo.tamanhoMapa(10, 10);

        robo.novaCoordenada(9, 9);
        robo.iniciarTrajeto();
    }

    public void tamanhoMapa(Integer x, Integer y) {
        TAMANHO_X = x;
        TAMANHO_Y = y;
    }

    public void andarDireta() {
        if (posicaoX + 1 <= TAMANHO_X) {
            posicaoX += 1;
            arquivoLog.append("Andou para direita! ");
        }
    }

    public void andarEsquerda() {
        if (posicaoY - 1 >= 1) {
            posicaoX -= 1;
            arquivoLog.append("Andou para esquerda!");
        }
    }

    public void andarCima() {
        if (posicaoY - 1 >= 1) {
            posicaoY -= 1;
            arquivoLog.append("Andou para cima!    ");
        }
    }

    public void andarBaixo() {
        if (posicaoY + 1 <= TAMANHO_Y) {
            posicaoY += 1;
            arquivoLog.append("Andou para baixo!   ");
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
        arquivoLog = new StringBuilder();
        arquivoLog.append(format("\nPosição inicial [{2}][{3}] -  Novo trajeto [{0}][{1}]\n", posicaoX, posicaoY, ateX, ateY));

        //exibir(TAMANHO_X, TAMANHO_Y, posicaoX, posicaoY); //TODO exibe o trajeto

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

        Logger.salvarArquivo(arquivoLog.toString());
    }

    private void caminharEixoX(Integer posicaoX, Integer ateX, boolean paraFrente) {
        for (int i = posicaoX; i < ateX; i++) {
            if (paraFrente) { andarDireta(); } else { andarEsquerda(); }
            //exibir(TAMANHO_X, TAMANHO_Y, this.posicaoX, this.posicaoY); //TODO exibe o trajeto
            arquivoLog.append(format(" - Posição Atual   [{0}][{1}]\n", this.posicaoX, this.posicaoY));
        }
    }

    private void caminhaEixoY(Integer posicaoY, Integer ateY, boolean paraBaixo) {
        for (int i = posicaoY; i < ateY; i++) {
            if (paraBaixo) { andarBaixo(); } else { andarCima(); }
            //exibir(TAMANHO_X, TAMANHO_Y, this.posicaoX, this.posicaoY); //TODO exibe o trajeto
            arquivoLog.append(format(" - Posição Atual   [{0}][{1}]\n", this.posicaoX, this.posicaoY));
        }
    }
}
