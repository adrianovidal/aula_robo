package components;

public class Trajeto {

    //TODO Classe apenas para diversão - Exibe o trajeto do robo!

    public static void exibir(Integer tamanhoX, Integer tamanhoY, Integer posicaoX, Integer posicaoY) {
        System.out.println("\n");

        try {
            Thread.sleep(300);
            System.out.print("\033[H\033[2J");
        } catch (InterruptedException ignore) {}

        for (int i = 0; i < tamanhoY; i++) {
            for (int j = 0; j <= tamanhoX; j++) {
                if (j < tamanhoX && (j == posicaoX-1 && i == posicaoY-1)) {
                    System.out.print("|x");
                } else if(j < tamanhoX) {
                    System.out.print("| ");
                } else {
                    System.out.println("| ");
                }
            }
        }
    }

    public static void main(String[] args) {
        exibir(3, 3, 1, 3);
    }
}
