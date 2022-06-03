package br.com.antonio.template.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UsuarioRequestTest {

    @Test
    @DisplayName("Teste unitario")
    public void testeUnitario() throws Exception {

        UsuarioRequest usuarioRequest = new UsuarioRequest("Antonio", 18);

        assertEquals(usuarioRequest.getNome(), "Antonio");
        assertNotEquals(usuarioRequest.getIdade(), 17);
    }

}