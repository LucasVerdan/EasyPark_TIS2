import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Estacionamento {
    private String nome;
    private String horaAbertura;
    private String horaFechamento;
    private int qtdVagas;
    private int qtdVeiculosEstacionados;
    private Valores valores;
    protected Map<String,Estada> estadaList;

    public Estacionamento(String nome, String horaAbertura, String horaFechamento, int qtdVagas, Valores valores, Map<String,Estada> estadaList) {

        this.nome = nome;
        this.horaAbertura = horaAbertura;
        this.horaFechamento = horaFechamento;
        this.qtdVagas = qtdVagas;
        this.valores = valores;
        this.estadaList = new HashMap<String,Estada>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getHoraAbertura() {
        return horaAbertura;
    }

    public void setHoraAbertura(String horaAbertura) {
        this.horaAbertura = horaAbertura;
    }

    public String getHoraFechamento() {
        return horaFechamento;
    }

    public void setHoraFechamento(String horaFechamento) {
        this.horaFechamento = horaFechamento;
    }

    public int getQtdVagas() {
        return qtdVagas;
    }

    public void setQtdVagas(int qtdVagas) {
        this.qtdVagas = qtdVagas;
    }

    public int getQtdVeiculosEstacionados() {
        return qtdVeiculosEstacionados;
    }

    public void setQtdVeiculosEstacionados(int qtdVeiculosEstacionados) {
        this.qtdVeiculosEstacionados = qtdVeiculosEstacionados;
    }

    public Valores getValores() {
        return valores;
    }

    public void setValores(Valores valores) {
        this.valores = valores;
    }



    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();
        sb.append("Nome: ").append(this.getNome()).append("\n")
                .append("Hora de abertura: ").append(this.horaAbertura).append("\n")
                .append("Hora de fechamento: ").append(this.horaFechamento).append("\n")
                .append("Quantidade de vagas: ").append(this.getQtdVagas()).append("\n")
                .append(valores.toString());
        return sb.toString();
    }
}
