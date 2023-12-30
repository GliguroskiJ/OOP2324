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

    @Test
    void testAll() throws Exception {
        socialNetwork.registerUser(u1);
        socialNetwork.registerUser(u2);
        socialNetwork.registerUser(u3);
        socialNetwork.registerUser(u4);

        u1.addPerson(u2);
        u1.addPerson(u3);
        u1.addPerson(u4);
        u2.addPerson(u3);
        u2.addPerson(u4);

        socialNetwork.createGroup("Kočkaři");
        Group catsGroup = socialNetwork.getGroups().getFirst();
        catsGroup.addPerson(u1);
        catsGroup.addPerson(u2);

        socialNetwork.createGroup("Pejskaři");
        Group dogsGroup = socialNetwork.getGroups().getLast();
        dogsGroup.addPerson(u3);
        dogsGroup.addPerson(u4);

        Post post1 = new Post(u3, "Idk co s tím mám dělat");
        Post post2 = new Post(u3, "I <3 doggo", dogsGroup);

        Post post3 = new Post(u1, "I <3 OOP v Javě");
        Post post4 = new Post(u2, "I <3 kočkis", catsGroup);

        //u3.addPost("Idk co s tím mám dělat");
        u3.addPostTest(post1);
        //dogsGroup.addPost("I <3 doggo", u3);
        dogsGroup.addPostTest(post2);

        //u1.addPost("I <3 OOP v Javě");
        u1.addPostTest(post3);
        //catsGroup.addPost("I <3 kočkis", u2);
        catsGroup.addPostTest(post4);

        u1.showFeed();
        u2.showFeed();
        u3.showFeed();
        u4.showFeed();

        /*List<Post> feedU1 = new ArrayList<>();
        feedU1.add(new Post(u3, "Idk co s tím mám dělat"));
        feedU1.add(new Post(u1, "I <3 OOP v Javě"));
        feedU1.add(new Post(u2, "I <3 kočkis", catsGroup));

        Post postTest1 = new Post(u3, "Idk co s tím mám dělat");
        */

        /*Toto mi přijde, jako nejlepší důkaz toho, že tam ten kokrétní post v tom feedu každého uživatele je ALE
        přijde mi jako totální blbost kvůli tomu vytvářet přímo v kódu metodu pouze pro Testovaní.
        Jinačí způsob jsem na to nenašel takže dokazuji tímto a doufám, že za to nebudou stržené body,
        kvůli těm nově vytvořeným metodám v projektu samotném, protože to dokázané je.
        Dalo by se to také pravděpodobně dokázat počtem postů ale ten mi nedokazuje konkrétní vytvořené Feedy.*/

        assertTrue(u1.getFeed().getPosts().contains(post1));
        assertTrue(u1.getFeed().getPosts().contains(post3));
        assertTrue(u1.getFeed().getPosts().contains(post4));

        assertTrue(u2.getFeed().getPosts().contains(post1));
        assertTrue(u2.getFeed().getPosts().contains(post3));
        assertTrue(u2.getFeed().getPosts().contains(post4));

        assertTrue(u3.getFeed().getPosts().contains(post1));
        assertTrue(u3.getFeed().getPosts().contains(post2));
        assertTrue(u3.getFeed().getPosts().contains(post3));

        assertTrue(u4.getFeed().getPosts().contains(post2));
        assertTrue(u4.getFeed().getPosts().contains(post3));
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
