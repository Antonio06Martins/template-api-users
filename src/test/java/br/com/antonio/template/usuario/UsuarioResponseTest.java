package br.com.antonio.template.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioResponseTest {

    @Test
    @DisplayName("Teste unitario")
    public void testeUnitario() throws Exception {

        var usuarioId = new Usuario();
        usuarioId.setId(1L);

        UsuarioResponse usuarioResponse = new UsuarioResponse(new Usuario("Antonio", 35));

        assertEquals(usuarioId.getId(), 1L);
        assertEquals(usuarioResponse.getNome(), "Antonio");
        assertEquals(usuarioResponse.getIdade(), 35);
    }

}