package com.example.aluno.myapplication;

/**
 * Created by Akira on 08/06/2017.
 */

public class Score {

    private Integer acerto = 0;
    private Integer erro = 0;
    private Integer pulo = 0;
    private Integer viuResp = 0;

    public Integer getAcerto() {
        return acerto;
    }

    public void setAcerto(Integer acerto) {
        this.acerto = acerto + 1;
    }

    public Integer getErro() {
        return erro;
    }

    public void setErro(Integer erro) {
        this.erro = erro + 1;
    }

    public Integer getPulo() {
        return pulo;
    }

    public void setPulo(Integer pulo) {
        this.pulo = pulo + 1;
    }

    public Integer getViuResp() {
        return viuResp;
    }

    public void setViuResp(Integer viuResp) {
        this.viuResp = viuResp + 1;
    }
}
