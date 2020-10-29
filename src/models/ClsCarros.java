package models;

/**
 * Classe dos Patrimonios e Veiculos
 *
 * @author Tiago Teixeira
 */
public class ClsCarros {

    private int Id;
    private String Nome;
    private String Marca;
    private String Modelo;
    private String Classe;
    private String TipoVeiculo;
    private String Cor;
    private String Placa;
    private int Renavam;
    private String ObsEstado;
    private String DataCompra;
    private int AnoModelo;
    private int AnoFabricacao;
    private String Chassi;
    private int KmRodados;
    private float ValorMercado;
    private float ValorSeguro;
    private float ValorKmRd;
    private float ValorDiariaLoc;
    private int Status;
    private int Inativo;
    private int id_colaborador;

    public ClsCarros(String Nome, String Marca, String Modelo, String Classe, String TipoVeiculo, String Cor, String Placa, int Renavam, String ObsEstado, String DataCompra, int AnoModelo, int AnoFabricacao, String Chassi, int KmRodados, float ValorMercado, float ValorSeguro, float ValorKmRd, float ValorDiariaLoc, int Status, int Inativo, int id_colaborador) {
        this.Nome = Nome;
        this.Marca = Marca;
        this.Modelo = Modelo;
        this.Classe = Classe;
        this.TipoVeiculo = TipoVeiculo;
        this.Cor = Cor;
        this.Placa = Placa;
        this.Renavam = Renavam;
        this.ObsEstado = ObsEstado;
        this.DataCompra = DataCompra;
        this.AnoModelo = AnoModelo;
        this.AnoFabricacao = AnoFabricacao;
        this.Chassi = Chassi;
        this.KmRodados = KmRodados;
        this.ValorMercado = ValorMercado;
        this.ValorSeguro = ValorSeguro;
        this.ValorKmRd = ValorKmRd;
        this.ValorDiariaLoc = ValorDiariaLoc;
        this.Status = Status;
        this.Inativo = Inativo;
        this.id_colaborador = id_colaborador;
    }


    /*public ClsCarros(ClsCarros clscarros){
        this.Id = clscarros.getId();
        this.Nome = clscarros.getNome();
        this.Marca = clscarros.getMarca();
        this.Modelo = clscarros.getModelo();
        this.Classe = clscarros.getClasse();
        this.TipoVeiculo = clscarros.getTipoVeiculo();
        this.Cor = clscarros.getCor();
        this.Placa = clscarros.getPlaca();
        this.Renavam = clscarros.getRenavam();
        this.ObsEstado = clscarros.getObsEstado();
        this.DataCompra = clscarros.getDataCompra();
        this.AnoModelo = clscarros.getAnoModelo();
        this.AnoFabricacao = clscarros.getAnoFabricacao();
        this.Chassi = clscarros.getChassi();
        this.KmRodados = clscarros.getKmRodados();
        this.ValorMercado = clscarros.getValorMercado();
        this.ValorSeguro = clscarros.getValorSeguro();
        this.ValorKmRd = clscarros.getValorKmRd();
        this.ValorDiariaLoc = clscarros.getValorDiariaLoc();
        this.Status = clscarros.getStatus();
        this.Inativo = clscarros.getInativo();
        this.id_colaborador = clscarros.getId_colaborador();    
    }
     */
    public ClsCarros() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String Nome) {
        this.Nome = Nome;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String Marca) {
        this.Marca = Marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String Modelo) {
        this.Modelo = Modelo;
    }

    public String getClasse() {
        return Classe;
    }

    public void setClasse(String Classe) {
        this.Classe = Classe;
    }

    public String getTipoVeiculo() {
        return TipoVeiculo;
    }

    public void setTipoVeiculo(String TipoVeiculo) {
        this.TipoVeiculo = TipoVeiculo;
    }

    public String getCor() {
        return Cor;
    }

    public void setCor(String Cor) {
        this.Cor = Cor;
    }

    public String getPlaca() {
        return Placa;
    }

    public void setPlaca(String Placa) {
        this.Placa = Placa;
    }

    public int getRenavam() {
        return Renavam;
    }

    public void setRenavam(int Renavam) {
        this.Renavam = Renavam;
    }

    public String getObsEstado() {
        return ObsEstado;
    }

    public void setObsEstado(String ObsEstado) {
        this.ObsEstado = ObsEstado;
    }

    public String getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(String DataCompra) {
        this.DataCompra = DataCompra;
    }

    public int getAnoModelo() {
        return AnoModelo;
    }

    public void setAnoModelo(int AnoModelo) {
        this.AnoModelo = AnoModelo;
    }

    public int getAnoFabricacao() {
        return AnoFabricacao;
    }

    public void setAnoFabricacao(int AnoFabricacao) {
        this.AnoFabricacao = AnoFabricacao;
    }

    public String getChassi() {
        return Chassi;
    }

    public void setChassi(String Chassi) {
        this.Chassi = Chassi;
    }

    public int getKmRodados() {
        return KmRodados;
    }

    public void setKmRodados(int KmRodados) {
        this.KmRodados = KmRodados;
    }

    public float getValorMercado() {
        return ValorMercado;
    }

    public void setValorMercado(float ValorMercado) {
        this.ValorMercado = ValorMercado;
    }

    public float getValorSeguro() {
        return ValorSeguro;
    }

    public void setValorSeguro(float ValorSeguro) {
        this.ValorSeguro = ValorSeguro;
    }

    public float getValorKmRd() {
        return ValorKmRd;
    }

    public void setValorKmRd(float ValorKmRd) {
        this.ValorKmRd = ValorKmRd;
    }

    public float getValorDiariaLoc() {
        return ValorDiariaLoc;
    }

    public void setValorDiariaLoc(float ValorDiariaLoc) {
        this.ValorDiariaLoc = ValorDiariaLoc;
    }

    public int getStatus() {
        return Status;
    }

    public void setStatus(int Status) {
        this.Status = Status;
    }

    public int getInativo() {
        return Inativo;
    }

    public void setInativo(int Inativo) {
        this.Inativo = Inativo;
    }

    public int getId_colaborador() {
        return id_colaborador;
    }

    public void setId_colaborador(int id_colaborador) {
        this.id_colaborador = id_colaborador;
    }

}
