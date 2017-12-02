package components;

import java.io.*;

public class Logger {

    public static final String NOME_ARQUIVO = "log_robo.txt";

    public static String abrirArquivo() {
        try{
            BufferedReader br = new BufferedReader(new FileReader(NOME_ARQUIVO));
            String linha = "";
            while(br.ready()){
                linha += br.readLine() + "\n";
            }
            br.close();
            return linha;
        }catch(IOException ioe){
            ioe.printStackTrace();
        }
        return "";
    }

    public static void salvarArquivo(String arquivoSalvar){
        FileWriter arq;
        String salvar = abrirArquivo();
        salvar += arquivoSalvar;
        try {
            arq = new FileWriter("log_robo.txt");
            PrintWriter gravarArq = new PrintWriter(arq);
            gravarArq.printf(salvar);
            gravarArq.printf("\n================  ====  ================\n");
            arq.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
