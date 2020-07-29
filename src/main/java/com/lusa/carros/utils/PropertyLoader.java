package com.lusa.carros.utils;

import com.lusa.carros.customexceptions.NoPropertiesException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Properties;

public class PropertyLoader {
    private static final Logger LOGGER = LogManager.getLogger();

    private PropertyLoader() {}

    public static String retornarValorArquivoConfiguracao(final String propriedade) {
        Properties properties = new Properties();

        try (InputStream propFileInpStream = PropertyLoader.class.getClassLoader()
                .getResourceAsStream("conf/config.properties")) {

            properties.load(propFileInpStream);
            LOGGER.info(MessageFormat.format("Localizado a propriedade: {0} no arquivo conf/config.properties com o valor {1}", propriedade, properties.getProperty(propriedade)));

            return properties.getProperty(propriedade);
        } catch (IOException e) {
            LOGGER.error(MessageFormat.format("Propriedade {0} não foi encontrada nos arquivos de configuração", propriedade), e);
            throw new NoPropertiesException("Sem arquivo de configuração!");
        }
    }

}
