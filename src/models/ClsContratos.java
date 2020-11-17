package models;

/**
 *
 * @author Tiago Teixeira
 */
public class ClsContratos {

    private int id;
    private int idCliente;
    private int idCarro;
    private int idColaborador;
    private String observacoes;
    private String tipoLocacao;
    private String dataChegada;
    private String dataSaida;
    private String dataContrato;
    private String Status;
    private int quantidadeDiarias;
    private int quantidadeKmRet;
    private float valorExtra;
    private float valorTotal;

    public ClsContratos() {}
    
    public ClsContratos(int id, int idCliente, int idCarro, int idColaborador, String observacoes, String tipoLocacao, String dataChegada, String dataSaida, String dataContrato, String Status, int quantidadeDiarias, int quantidadeKmRet, float valorExtra, float valorTotal) {
        this.id = id;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.idColaborador = idColaborador;
        this.observacoes = observacoes;
        this.tipoLocacao = tipoLocacao;
        this.dataChegada = dataChegada;
        this.dataSaida = dataSaida;
        this.dataContrato = dataContrato;
        this.Status = Status;
        this.quantidadeDiarias = quantidadeDiarias;
        this.quantidadeKmRet = quantidadeKmRet;
        this.valorExtra = valorExtra;
        this.valorTotal = valorTotal;
    }

    public float calcularValorTotalKM(float valorKm, int kmAtual) {
        int mutiplicador = quantidadeKmRet - kmAtual;
        valorTotal = mutiplicador * valorKm;
        return valorTotal;
    }

    public float calcularValorTotalDIA(float valorDiaria) {
        valorTotal = quantidadeDiarias * valorDiaria;
        return valorTotal;
    }
    
    public float calcularValorExtra(){
        valorTotal += valorExtra;
        return valorTotal;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdCarro() {
        return idCarro;
    }

    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    public int getIdColaborador() {
        return idColaborador;
    }

    public void setIdColaborador(int idColaborador) {
        this.idColaborador = idColaborador;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public String getTipoLocacao() {
        return tipoLocacao;
    }

    public void setTipoLocacao(String tipoLocacao) {
        this.tipoLocacao = tipoLocacao;
    }

    public String getDataChegada() {
        return dataChegada;
    }

    public void setDataChegada(String dataChegada) {
        this.dataChegada = dataChegada;
    }

    public String getDataSaida() {
        return dataSaida;
    }

    public void setDataSaida(String dataSaida) {
        this.dataSaida = dataSaida;
    }

    public String getDataContrato() {
        return dataContrato;
    }

    public void setDataContrato(String dataContrato) {
        this.dataContrato = dataContrato;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public int getQuantidadeDiarias() {
        return quantidadeDiarias;
    }

    public void setQuantidadeDiarias(int quantidadeDiarias) {
        this.quantidadeDiarias = quantidadeDiarias;
    }

    public int getQuantidadeKmRet() {
        return quantidadeKmRet;
    }

    public void setQuantidadeKmRet(int quantidadeKmRet) {
        this.quantidadeKmRet = quantidadeKmRet;
    }

    public float getValorExtra() {
        return valorExtra;
    }

    public void setValorExtra(float valorExtra) {
        this.valorExtra = valorExtra;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }

}
