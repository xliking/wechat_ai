package xlike.top.kn_ai_chat;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.Arrays;

/**
 * @author xlike
 */
@SpringBootApplication
@EnableScheduling
@EnableAsync
@EnableCaching
public class KnAiChatApplication {

    private final static Logger LOGGER = LoggerFactory.getLogger(KnAiChatApplication.class);
    public static void main(String[] args) {
        SpringApplication app = new SpringApplication(KnAiChatApplication.class);
        ConfigurableApplicationContext run = app.run(args);
        Environment env = run.getEnvironment();
        String severPort = env.getProperty("server.port");
        String logo = """
                 █████╗ ██╗      ██╗    ██╗███████╗ ██████╗██╗  ██╗ █████╗ ████████╗
                ██╔══██╗██║      ██║    ██║██╔════╝██╔════╝██║  ██║██╔══██╗╚══██╔══╝
                ███████║██║█████╗██║ █╗ ██║█████╗  ██║     ███████║███████║   ██║  \s
                ██╔══██║██║╚════╝██║███╗██║██╔══╝  ██║     ██╔══██║██╔══██║   ██║  \s
                ██║  ██║██║      ╚███╔███╔╝███████╗╚██████╗██║  ██║██║  ██║   ██║  \s
                ╚═╝  ╚═╝╚═╝       ╚══╝╚══╝ ╚══════╝ ╚═════╝╚═╝  ╚═╝╚═╝  ╚═╝   ╚═╝  \s
                PROFILE: %s
                SERVER PORT: %s""";
        LOGGER.warn("\n" + String.format(logo, Arrays.toString(env.getActiveProfiles()), severPort));
    }
}
