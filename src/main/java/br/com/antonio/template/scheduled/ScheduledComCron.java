package br.com.antonio.template.scheduled;

import br.com.antonio.template.usuario.UsuarioRepository;
import br.com.antonio.template.usuario.UsuarioRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Range;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class ScheduledComCron {

    private final Logger logger = LoggerFactory.getLogger(ScheduledComCron.class);

    @Autowired
    private UsuarioRepository usuarioRepository;

    //@Scheduled(fixedDelay = 10000)
    @Scheduled(cron = "0 0/1 * * * *")
    public void executar() {
        logger.info("Executou o Scheduled com cron em {}", LocalDateTime.now());
        //System.out.println("Executou o Scheduled com cron");

        Map<String, Integer> map = new HashMap<>();
        map.put("Antonio", 35);
        map.put("João", 25);
        map.put("Ze", 53);
        map.put("Maria", 45);
        map.put("Cida", 42);
        map.put("Carlos", 49);

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            var usuarioRequest = new UsuarioRequest(key, value);
            usuarioRepository.save(usuarioRequest.toModel());
            logger.info("Salvou via Scheduled o usuario {}, com a idade {} ", usuarioRequest.getNome(), usuarioRequest.getIdade());
        }

        //var usuarioRequest = new UsuarioRequest("Antonio", 39);
//        usuarioRepository.save(usuarioRequest.toModel());
//        logger.info("Salvou via Scheduled o usuario {}, com a idade {} ", usuarioRequest.getNome(), usuarioRequest.getIdade());
    }
}
