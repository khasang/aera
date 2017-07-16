package io.aera.service.soap;

import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.SpellServiceSoap;
import org.springframework.stereotype.Component;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

@Component
public class SpellService {
    private static final String ADDRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    public String spellCheckWord(String word) throws MalformedURLException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

        Service service = Service.create(url, qName);

        SpellServiceSoap hello = service.getPort(SpellServiceSoap.class);

        CheckTextRequest checkTextRequest = new CheckTextRequest();
        checkTextRequest.setText(word);
        checkTextRequest.setLang("en");
        checkTextRequest.setFormat("plain");

        return hello.checkText(checkTextRequest).getSpellResult().getError().get(0).getS().toString();
    }
}
