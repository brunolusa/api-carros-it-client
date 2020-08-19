package com.lusa.carros.utils;

import com.lusa.carros.customexceptions.NoPropertiesException;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;
import java.util.logging.Logger;

public class PropertyLoader {
    private static final Logger LOGGER = Logger.getLogger(PropertyLoader.class.getName());
    private PropertyLoader() {}

    public static String retornarValorArquivoConfiguracao(final String propriedade) {
        Properties properties = new Properties();
        String env = Env.getEnv();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("conf/"+env+"/config.properties")) {

            properties.load(propFileInpStream);
            LOGGER.info(MessageFormat.format("Localizado a propriedade: {0} no arquivo conf/config.properties com o valor {1}", propriedade, properties.getProperty(propriedade)));

            return properties.getProperty(propriedade);
        } catch (IOException e) {
            LOGGER.warning(MessageFormat.format("Propriedade {0} não foi encontrada nos arquivos de configuração", propriedade));
            throw new NoPropertiesException("Sem arquivo de configuração!");
        }
    }

}
