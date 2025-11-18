//SOAP
// on utilise des annotatoions de JAX-WS
// ces annotations sont basées sur du JAXB et permettent la serialisation et la deserialization:
//      creer des objets java depuis des fichiers XML et voce-versa

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

@WebService(targetNamespace = "http://www.polytech.fr")
public class MonServiceWeb {

    @WebMethod(operationName = "convertir")
    public double conversion(double mt){
        return mt*0.9;
    }
    public double somme(@WebParam(name = "paraemtre1") double a, double b){
        return a + b;
    }

    public Etudiant getEtudiant(int identifiant){
        return new Etudiant(identifiant, "Mario", 19);
    }
}
