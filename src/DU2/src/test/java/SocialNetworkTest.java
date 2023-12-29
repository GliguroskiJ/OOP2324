import org.model.*;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

public class SocialNetworkTest {
    SocialNetwork socialNetwork = new SocialNetwork();

    User u1 = new User("Petr Novotný");
    User u2 = new User("Michal Hrůzný");
    User u3 = new User("Lukáš Malý");
    User u4 = new User("Jana Střední");

    Group dogsGroup = new Group("Pejskaři");
    Group catsGroup = new Group("Kočkaři");

    @Test
    void test() throws Exception {
        socialNetwork.registerUser(u1);
        socialNetwork.registerUser(u2);
        socialNetwork.registerUser(u3);
        socialNetwork.registerUser(u4);

        u1.addPerson(u2);
        u1.addPerson(u3);
        u1.addPerson(u4);
        u2.addPerson(u3);
        u2.addPerson(u4);

        catsGroup.addPerson(u1);
        catsGroup.addPerson(u2);
        socialNetwork.createGroup("Kočkaři");

        dogsGroup.addPerson(u3);
        dogsGroup.addPerson(u4);
        socialNetwork.createGroup("Pejskaři");

        u3.addPost("Idk co s tím mám dělat");
        dogsGroup.addPost("I <3 doggo", u3);

        u1.addPost("I <3 OOP v Javě");
        catsGroup.addPost("I <3 kočkis", u2);

        u1.showFeed();
        u2.showFeed();
        u3.showFeed();
        u4.showFeed();
    }

    /*
     - cílem je namodelovat "zjednodušenou" sociální síť
     done - hlavními třídami bude User, Post, Group, Feed, SocialNetwork
     done - Ve třídě SocialNetwork jsou registrováni uživatelé a registrovány skupiny v rámci sociální sítě
     done - Uživatel může mít více přátel a může být členem několika skupin
     done - Do těchto skupin může člen přidávat Post
     done - Každý uživatel si pak může přidávat Posty ke svému profilu a také má vlastní personalizovaný Feed na základě skupin a přátel, které sleduje
     done - Tj. ve Feedu uživatele by měly být Posty jeho přátel a a Posty ze skupin, kterých je členem
     done - v aplikaci budeme určitě potřebovat držet informaci o autorovi Postu, tj. i Post by měl mít v sobě obsaženého autora (např. abychom mohli ve Feedu zobrazovat, který Post je od jakého uživatele)
     done - to samé by mělo platit i pro Group (ať ve Feedu umíme rozlišit, jestli se jedná o post ze skupiny)
     done - na specifikační úrovni nejprve namodelujte UML class diagram (vyexportujte jako obrázek)
     - naprogramujte funkční verzi takovéto aplikace - pouze logiku a Test
     - scénář SocialNetworkTestu bude takový, že:
     done - nejprve vytvoříte 4 uživatele (u1, u2, u3, u4) a dáte jim rozdílné usernamy, zaregistrujete je do sociální sítě (metoda, která uživatele přidá do SocialNetwork)
     done - u1 bude mít v přátelích u2, u3, u4
     done - u2 pouze u3 a u4
     done - Pozor, pokud si u1 přidá jako přítele u2, je nutné zajistit, že u1 bude i v seznamu přátel uživatele u2
     done - Vytvořte skupinu "Pejskaři" a přidejte do ní u3 a u4
     done - Vytvořte skupinu "Kočkaři" a přidejte do ní u1 a u2
     done - Je nutné zajistit, že pokud si uživatel přidá něco do svých profilových Postů (drží pouze text), musí se příspěvek objevit ve Feedu všech jeho přátel
     done - To samé platí pro skupiny, pokud některý člen přidá Post, musí se objevit ve Feedu všech členů
     asi done- K oboum těmto scénářům využijete návrhový vzor Observer
     done - V samotném testu pak u3 přidá Post na vlastní profil, poté do skupiny "Pejskaři"
     done - Následně si přidá Post na svůj profil u1, následně do skupiny Kočičkáři přidá Post u2
     ověřeno, posty se správně vypisují - done - V testu ověříte, že jsou ve Feedech všech uživatelů ty správné posty
    */
}
