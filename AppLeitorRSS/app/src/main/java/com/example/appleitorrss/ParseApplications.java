package com.example.appleitorrss;


import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.util.Log;
import java.io.StringReader;
import java.util.ArrayList;

public class ParseApplications {
    private static final String TAG = "ParseApplications";

    private ArrayList<FeedEntry> applications;

    public ParseApplications() {
        applications = new ArrayList<>();
    }
    //metodo get "getApplications(){}" para acessar os dados do array "ArrayList<FeedEntry>applications" externamente
    public ArrayList<FeedEntry> getApplications(){
        return applications;
    }

    //função responsavel a fazer o Parser o parse do XML concatenar as Strings
    public boolean parse(String xmlText){ //<< recebo por parametro uma String XML
        boolean status = true; // parse com sucesso?  declaração e inicialização
        FeedEntry entry = null; // entrada do RSS a ser lida declaração e inicialização tipo "FeedEntry"
        boolean inEntry = false; // estamos em um <entry>?
        String textValue = ""; //valor texto de cada atributo

        XmlPullParserFactory factory = null;

        try{
            factory = XmlPullParserFactory.newInstance(); // irá retornar uma instancia do XmlPullParser
            factory.setNamespaceAware(true);
            XmlPullParser pullParser = factory.newPullParser();//objeto que faz o parse
            pullParser.setInput(new StringReader(xmlText));

            // começa a fazer o parse
            int eventType = pullParser.getEventType();
            // enquanto não for o fim do documento, ler "tratar" tag por tag
            while(eventType != XmlPullParser.END_DOCUMENT){
                String tag = pullParser.getName();
                //   switch para selecionar o conteudo desejado, dispensando os demais
                switch (eventType){
                    case XmlPullParser.START_TAG:
                        if("entry".equalsIgnoreCase(tag)){
                            inEntry = true;
                            entry = new FeedEntry();
                        }
                        break;
                    case XmlPullParser.TEXT: // conteúdo de uma Tag <tag>conteúdo</tag>
                        textValue = pullParser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if(inEntry){
                            if("entry".equalsIgnoreCase(tag)){ //se a tag for </entry>
                                // terminou a entry, então armazenar o FeedEntry no ArrayList
                                applications.add(entry); // coloca o objeto dentro do array list
                                inEntry = false; // já terminou a entry agora pode sair da entry recebendo false

                            }else if ("name".equalsIgnoreCase(tag)){// </name>?
                                entry.setName(textValue);
                            }else if("artist".equalsIgnoreCase(tag)){ //</artist>?
                                entry.setArtist(textValue);
                            }else if("summary".equalsIgnoreCase(tag)){ //</summary>?
                                entry.setSummary(textValue);
                            }else if ("image".equalsIgnoreCase(tag)){ //</image>?
                                entry.setImgURL(textValue);
                            }else if ("releaseData".equalsIgnoreCase(tag)){ //</releaseData> ?
                                entry.setReleaseData(textValue);
                            }
                            break;
                        }
                }
                eventType = pullParser.next();
            }

        } catch (Exception ex){
            Log.e(TAG, "parse: Erro ao fazer parse: "  + ex.getMessage());
            status = false;
        }
        return status;
    }
}
