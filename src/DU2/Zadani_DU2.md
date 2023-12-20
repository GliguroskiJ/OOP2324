# Zadání DÚ 2 - OOP
* cílem je namodelovat "zjednodušenou" sociální síť
* hlavními třídami bude User, Post, Group, Feed, SocialNetwork
* Ve třídě SocialNetwork jsou registrováni uživatelé a registrovány skupiny v rámci sociální sítě
* Uživatel může mít více přátel a může být členem několika skupin
* Do těchto skupin může člen přidávat Post
* Každý uživatel si pak může přidávat Posty ke svému profilu a také má vlastní personalizovaný Feed na základě skupin a přátel, které sleduje
    * Tj. ve Feedu uživatele by měly být Posty jeho přátel a a Posty ze skupin, kterých je členem
    * v aplikaci budeme určitě potřebovat držet informaci o autorovi Postu, tj. i Post by měl mít v sobě obsaženého autora (např. abychom mohli ve Feedu zobrazovat, který Post je od jakého uživatele)
    * to samé by mělo platit i pro Group (ať ve Feedu umíme rozlišit, jestli se jedná o post ze skupiny)
* na specifikační úrovni nejprve namodelujte UML class diagram (vyexportujte jako obrázek)
* naprogramujte funkční verzi takovéto aplikace - pouze logiku a Test
* scénář SocialNetworkTestu bude takový, že:  
    * nejprve vytvoříte 4 uživatele (u1, u2, u3, u4) a dáte jim rozdílné usernamy, zaregistrujete je do sociální sítě (metoda, která uživatele přidá do SocialNetwork)
    * u1 bude mít v přátelích u2, u3, u4
    * u2 pouze u3 a u4
    * Pozor, pokud si u1 přidá jako přítele u2, je nutné zajistit, že u1 bude i v seznamu přátel uživatele u2 
    * Vytvořte skupinu "Pejskaři" a přidejte do ní u3 a u4
    * Vytvořte skupinu "Kočkaři" a přidejte do ní u1 a u2
    * Je nutné zajistit, že pokud si uživatel přidá něco do svých profilových Postů (drží pouze text), musí se příspěvek objevit ve Feedu všech jeho přátel
    * To samé platí pro skupiny, pokud některý člen přidá Post, musí se objevit ve Feedu všech členů
    * K oboum těmto scénářům využijete návrhový vzor Observer
    * V samotném testu pak u3 přidá Post na vlastní profil, poté do skupiny "Pejskaři"
    * Následně si přidá Post na svůj profil u1, následně do skupiny Kočičkáři přidá Post u2
    * V testu ověříte, že jsou ve Feedech všech uživatelů ty správné posty
