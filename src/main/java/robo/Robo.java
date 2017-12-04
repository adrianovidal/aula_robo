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

    public Robo() {
        Logger.salvarArquivo(format("Posição inicial [{0}][{1}]", posicaoX, posicaoY));
    }

    public void tamanhoMapa(Integer x, Integer y) {
        TAMANHO_X = x;
        TAMANHO_Y = y;
    }

    public void andarDireta(Integer passos) {
        for (int i = 0; i < passos; i++) {
            if (posicaoX + 1 <= TAMANHO_X) {
                posicaoX += 1;
            }
        }
        salvarLog("direita", passos);
    }

    public void andarEsquerda(Integer passos) {
        for (int i = 0; i < passos; i++) {
            if (posicaoY - 1 >= 1) {
                posicaoX -= 1;
            }
        }
        salvarLog("esquerda", passos);
    }

    public void andarCima(Integer passos) {
        for (int i = 0; i < passos; i++) {
            if (posicaoY - 1 >= 1) {
                posicaoY -= 1;
            }
        }
        salvarLog("cima", passos);
    }

    public void andarBaixo(Integer passos) {
        for (int i = 0; i < passos; i++) {
            if (posicaoY + 1 <= TAMANHO_Y) {
                posicaoY += 1;
            }
        }
        salvarLog("baixo", passos);
    }

    private void salvarLog(String direcao, Integer passos) {
        Logger.salvarArquivo(format("Andou para {0}! {1} passo(s)\n", direcao, passos));
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
        Logger.salvarArquivo(format("Trajeto [{0}][{1}]", ateX, ateY));
    }

    public void iniciarTrajeto() {
        if (posicaoX <= ateX) {
            caminharEixoX(ateX - posicaoX, true);
        } else {
            caminharEixoX(posicaoX - ateX, false);
        }

        if (posicaoY <= ateY) {
            caminhaEixoY(ateY - posicaoY, true);
        } else {
            caminhaEixoY(posicaoY - ateY, false);
        }
    }

    private void caminharEixoX(Integer passos, boolean paraFrente) {
        if (paraFrente) {
            andarDireta(passos);
        } else {
            andarEsquerda(passos);
        }
    }

    private void caminhaEixoY(Integer passos, boolean paraBaixo) {
        if (paraBaixo) {
            andarBaixo(passos);
        } else {
            andarCima(passos);
        }
    }
}
