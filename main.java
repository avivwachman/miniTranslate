import com.ibm.cloud.sdk.core.security.Authenticator;
import com.ibm.cloud.sdk.core.security.IamAuthenticator;
import com.ibm.watson.language_translator.v3.LanguageTranslator;
import com.ibm.watson.language_translator.v3.model.TranslateOptions;
import com.ibm.watson.language_translator.v3.model.TranslationResult;
import com.ibm.watson.language_translator.v3.util.Language;

public class main {
  public static void main(String[] args) {
      Authenticator authenticator = new IamAuthenticator("apiKey");
      LanguageTranslator service = new LanguageTranslator("2018-05-01", authenticator);
      service.setServiceUrl("URL.com");
      TranslateOptions translateOptions = new TranslateOptions.Builder()
              .addText("I love programming")
              .source(Language.ENGLISH)
              .target(Language.HEBREW)
              .build();
      TranslationResult translationResult = service.translate(translateOptions).execute().getResult();
      System.out.println(translationResult.getTranslations().get(0).getTranslation());
  }
}
