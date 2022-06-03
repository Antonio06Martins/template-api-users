package br.com.antonio.template.usuario;

import com.google.gson.Gson;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Locale;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class UsuarioControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private UsuarioRepository usuarioRepository;

    Gson gson = new Gson();

//    @BeforeEach
//    void setup() {
//        usuarioRepository.deleteAll();
//    }

    @Test
    @DisplayName("Cadastra Usuario com sucesso")
    public void cadastrarUsuarioComDadosSucesso() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("Antonio", 18);
        mockMvc.perform(post("/usuarios")
                .content(gson.toJson(usuarioRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").exists())
                .andExpect(jsonPath("$.nome").value(usuarioRequest.getNome()))
                .andExpect(jsonPath("$.idade").value(usuarioRequest.getIdade()))
                .andExpect(status().isCreated());
    }

    @Test
    @DisplayName("Falha no cadastro do Usuario atributo nome nulo")
    public void falhaNoCadastroUsuarioAtributoNulo() throws Exception {
        UsuarioRequest usuarioRequest = new UsuarioRequest("", 18);
        mockMvc.perform(post("/usuarios")
                .locale(new Locale("pt", "BR"))
                .content(gson.toJson(usuarioRequest))
                .contentType(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().is(400))
                .andExpect(jsonPath("$[0].campo").value("nome"))
                .andExpect(jsonPath("$[0].erro").value("não deve estar em branco"))
                .andReturn().getResponse();
    }

}