package infra;

public class Jogador {

    String nome;
    String ipJogador;
    int idSala;
    Tabuleiro tabuleiro;
    boolean emJogo;

    public Jogador(String nome, String ipJogador) {
        this.nome = nome;
        this.ipJogador = ipJogador;
    }

    void convidar(){

    }
    
    void aceitar(){

    }
    
    void mandaStatus(){

    }
    
    void mandaJogada(){

    }
    
    void desistirPartida(){

    }

    public String getNome() {
            return nome;
    }

    public void setNome(String nome) {
            this.nome = nome;
    }

    public String getIpServidor() {
        return ipJogador;
    }

    public void setIpServidor(String ipServidor) {
        this.ipJogador = ipServidor;
    }

    public int getIdSala() {
        return idSala;
    }

    public void setIdSala(int idSala) {
        this.idSala = idSala;
    }

    public Tabuleiro getTabuleiro() {
        return tabuleiro;
    }

    public void setTabuleiro(Tabuleiro tabuleiro) {
        this.tabuleiro = tabuleiro;
    }

    public boolean isEmJogo() {
        return emJogo;
    }

    public void setEmJogo(boolean emJogo) {
        this.emJogo = emJogo;
    }

    @Override
    public String toString() {
        return "Jogador{" +
                "nome='" + nome + '\'' +
                ", ipJogador='" + ipJogador + '\'' +
                "}\n";
    }
}
