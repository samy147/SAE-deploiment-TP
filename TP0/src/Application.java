import javax.xml.ws.Endpoint;

public class Application {
    public static void main(String[] args) {
        System.out.println("Debut du depoloiment du service");
        String url = "http://localhost:8888/";
        Endpoint.publish(url, new MonServiceWeb());
        System.out.println("le service web est deployé");
    }
}
