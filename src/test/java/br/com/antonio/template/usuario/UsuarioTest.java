package br.com.antonio.template.usuario;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UsuarioTest {

    @Test
    @DisplayName("Teste unitario")
    public void testeUnitario() throws Exception {

        Usuario usuario = new Usuario("Antonio", 18);

        assertEquals(usuario.getNome(), "Antonio");
        assertNotEquals(usuario.getIdade(), 17);
        assertNull(null, "");
    }

    @Test
    @DisplayName("Teste unitario1")
    public void testeUnitario1() throws Exception {

        Usuario usuario = new Usuario("Antonio", 17);

        assertEquals(usuario.getNome(), "Antonio");

        assertNotEquals(usuario.getIdade(), 18);

        assertEquals(usuario.getIdade(), 17);
    }

}