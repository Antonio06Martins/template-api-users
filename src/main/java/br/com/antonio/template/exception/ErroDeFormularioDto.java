package br.com.antonio.template.exception;

import java.time.LocalDateTime;

public class ErroDeFormularioDto {

    private String campo;
    private String erro;

    private LocalDateTime momentoErro;
    private Integer codigoStatus;
    private String status;
    private String mensagem;

    public ErroDeFormularioDto(String campo, String erro) {
        this.campo = campo;
        this.erro = erro;
    }

    public ErroDeFormularioDto(LocalDateTime momentoErro, Integer codigoStatus, String status, String mensagem) {
        this.momentoErro = momentoErro;
        this.codigoStatus = codigoStatus;
        this.status = status;
        this.mensagem = mensagem;
    }

    public String getCampo() {
        return campo;
    }

    public String getErro() {
        return erro;
    }

    public LocalDateTime getMomentoErro() {
        return momentoErro;
    }

    public Integer getCodigoStatus() {
        return codigoStatus;
    }

    public String getStatus() {
        return status;
    }

    public String getMensagem() {
        return mensagem;
    }
}
