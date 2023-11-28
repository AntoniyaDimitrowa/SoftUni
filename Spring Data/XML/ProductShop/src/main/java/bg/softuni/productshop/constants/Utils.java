package bg.softuni.productshop.constants;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Marshaller;
import org.modelmapper.ModelMapper;

import java.io.File;
import java.nio.file.Path;

public enum Utils {
    ;
    public static final ModelMapper MODEL_MAPPER = new ModelMapper();
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static <T> void writeIntoXmlFile(T wrapper, Path path) throws JAXBException {
        final File file = path.toFile();

        final JAXBContext context = JAXBContext.newInstance(wrapper.getClass());
        final Marshaller marshaller = context.createMarshaller();

        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        marshaller.marshal(wrapper, file);
    }
}
