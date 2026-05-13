package DTO;

public class CadastroConsumoFaturaGipDTO {

    

    private String CodigoBarrasCon_cadastroConsumoFatura;
    private String Valor_cadastroConsumoFatura;
    private String Kw_cadastroConsumoFatura;
    private String MesVencimento_cadastroConsumoFatura;
    private String MesReferente_cadastroConsumoFatura;
    private String DataCadastro_cadastroConsumoFatura;
    private String Ano_cadastroConsumoFatura;
    private String CodBarrasRed_cadastroConsumoFatura;
    private String CodigoBarraConTextField;
    private String CodBarrasRedTextField;
    private String Atrasadas_cadastroConsumoFatura;
    private String Atrasadas_acordo;
    //DTO serve para armazenar os dados que são encapsulados, e sempre precisam ter o mesmo nome dos componentes da tb do bd

@Override
      public String toString(){
       if (getCodigoBarraConTextField().length() > 48) {
       return getCodigoBarraConTextField().substring(42,48) + "...";
       }
        return "CodigoBarraConTextField" + getCodigoBarraConTextField();
        
    }

    /**
     * @return the CodigoBarrasCon_cadastroConsumoFatura
     */
    public String getCodigoBarrasCon_cadastroConsumoFatura() {
        return CodigoBarrasCon_cadastroConsumoFatura;
    }

    /**
     * @param CodigoBarrasCon_cadastroConsumoFatura the CodigoBarrasCon_cadastroConsumoFatura to set
     */
    public void setCodigoBarrasCon_cadastroConsumoFatura(String CodigoBarrasCon_cadastroConsumoFatura) {
        this.CodigoBarrasCon_cadastroConsumoFatura = CodigoBarrasCon_cadastroConsumoFatura;
    }

    /**
     * @return the Valor_cadastroConsumoFatura
     */
    public String getValor_cadastroConsumoFatura() {
        return Valor_cadastroConsumoFatura;
    }

    /**
     * @param Valor_cadastroConsumoFatura the Valor_cadastroConsumoFatura to set
     */
    public void setValor_cadastroConsumoFatura(String Valor_cadastroConsumoFatura) {
        this.Valor_cadastroConsumoFatura = Valor_cadastroConsumoFatura;
    }

    /**
     * @return the Kw_cadastroConsumoFatura
     */
    public String getKw_cadastroConsumoFatura() {
        return Kw_cadastroConsumoFatura;
    }

    /**
     * @param Kw_cadastroConsumoFatura the Kw_cadastroConsumoFatura to set
     */
    public void setKw_cadastroConsumoFatura(String Kw_cadastroConsumoFatura) {
        this.Kw_cadastroConsumoFatura = Kw_cadastroConsumoFatura;
    }

    /**
     * @return the MesVencimento_cadastroConsumoFatura
     */
    public String getMesVencimento_cadastroConsumoFatura() {
        return MesVencimento_cadastroConsumoFatura;
    }

    /**
     * @param MesVencimento_cadastroConsumoFatura the MesVencimento_cadastroConsumoFatura to set
     */
    public void setMesVencimento_cadastroConsumoFatura(String MesVencimento_cadastroConsumoFatura) {
        this.MesVencimento_cadastroConsumoFatura = MesVencimento_cadastroConsumoFatura;
    }

    /**
     * @return the MesReferente_cadastroConsumoFatura
     */
    public String getMesReferente_cadastroConsumoFatura() {
        return MesReferente_cadastroConsumoFatura;
    }

    /**
     * @param MesReferente_cadastroConsumoFatura the MesReferente_cadastroConsumoFatura to set
     */
    public void setMesReferente_cadastroConsumoFatura(String MesReferente_cadastroConsumoFatura) {
        this.MesReferente_cadastroConsumoFatura = MesReferente_cadastroConsumoFatura;
    }

    /**
     * @return the DataCadastro_cadastroConsumoFatura
     */
    public String getDataCadastro_cadastroConsumoFatura() {
        return DataCadastro_cadastroConsumoFatura;
    }

    /**
     * @param DataCadastro_cadastroConsumoFatura the DataCadastro_cadastroConsumoFatura to set
     */
    public void setDataCadastro_cadastroConsumoFatura(String DataCadastro_cadastroConsumoFatura) {
        this.DataCadastro_cadastroConsumoFatura = DataCadastro_cadastroConsumoFatura;
    }

    /**
     * @return the Ano_cadastroConsumoFatura
     */
    public String getAno_cadastroConsumoFatura() {
        return Ano_cadastroConsumoFatura;
    }

    /**
     * @param Ano_cadastroConsumoFatura the Ano_cadastroConsumoFatura to set
     */
    public void setAno_cadastroConsumoFatura(String Ano_cadastroConsumoFatura) {
        this.Ano_cadastroConsumoFatura = Ano_cadastroConsumoFatura;
    }

    /**
     * @return the CodBarrasRed_cadastroConsumoFatura
     */
    public String getCodBarrasRed_cadastroConsumoFatura() {
        return CodBarrasRed_cadastroConsumoFatura;
    }

    /**
     * @param CodBarrasRed_cadastroConsumoFatura the CodBarrasRed_cadastroConsumoFatura to set
     */
    public void setCodBarrasRed_cadastroConsumoFatura(String CodBarrasRed_cadastroConsumoFatura) {
        this.CodBarrasRed_cadastroConsumoFatura = CodBarrasRed_cadastroConsumoFatura;
    }

    /**
     * @return the CodigoBarraConTextField
     */
    public String getCodigoBarraConTextField() {
        return CodigoBarraConTextField;
    }

    /**
     * @param CodigoBarraConTextField the CodigoBarraConTextField to set
     */
    public void setCodigoBarraConTextField(String CodigoBarraConTextField) {
        this.CodigoBarraConTextField = CodigoBarraConTextField;
    }

    /**
     * @return the CodBarrasRedTextField
     */
    public String getCodBarrasRedTextField() {
        return CodBarrasRedTextField;
    }

    /**
     * @param CodBarrasRedTextField the CodBarrasRedTextField to set
     */
    public void setCodBarrasRedTextField(String CodBarrasRedTextField) {
        this.CodBarrasRedTextField = CodBarrasRedTextField;
    }

    /**
     * @return the Atrasadas_cadastroConsumoFatura
     */
    public String getAtrasadas_cadastroConsumoFatura() {
        return Atrasadas_cadastroConsumoFatura;
    }

    /**
     * @param Atrasadas_cadastroConsumoFatura the Atrasadas_cadastroConsumoFatura to set
     */
    public void setAtrasadas_cadastroConsumoFatura(String Atrasadas_cadastroConsumoFatura) {
        this.Atrasadas_cadastroConsumoFatura = Atrasadas_cadastroConsumoFatura;
    }
    /**
     * @return the Atrasadas_acordo
     */
    public String getAtrasadas_acordo() {
        return Atrasadas_acordo;
    }

    /**
     * @param Atrasadas_acordo the Atrasadas_acordo to set
     */
    public void setAtrasadas_acordo(String Atrasadas_acordo) {
        this.Atrasadas_acordo = Atrasadas_acordo;
    }

}