# Zadání DÚ 1 - OOP
* **Deadline**: 20.11. 23:59 
* Vytvořte aplikaci pro vytváření a správu fotbalových turnajů
* Základní struktura - Tým, Zápas, Šampionát, ZápasováUdálost, GenerátorZápasů
* naprogramujte mechanismus pro roztřídění týmů do vzájemných zápasů každý s každým
    * k tomuto mechanismu budou napsány smysluplné unit testy
    * s pomocí OOP nástrojů (hint: polymorfismus/dědičnost a logika ve vlastní třídě) naprogramujte tak, aby bylo možné třídící mechanismus týmů jednoduše změnit
* pozor na vstupní podmínky - není možné spustit generování 
¨_.zápasů, pokud nemám registrovaný žádný nebo 1 tým atd.
    * pokud se toto stane, vyhoďte výjimku IllegalStateException (zabudovaná v Javě)
* k zápasu přidejte funkcionalitu, která umožní přidávat události, které ve hře nastaly
    * pro rozlišení typu události použijte enum, určitě bude existovat událost GOAL, START, END, přidejte alespoň další 2
    * událost bude mít určitě Datum vytvoření záznamu (java.util.time.ZonedDateTime) a minutu herního času, kde nastala
    * vytvořte metodu co vhodně vytiskne herní log (záznam událostí, co ve hře proběhl)
    * zápas bude možné zahájit a ukončit odpovídajícími metodami
    * událost by měla jít zadat pouze pokud je zápas zahájený (nelze zadávat po vyhodnocení)
    * nad zápasem budou metody pro zadání gólu daného týmu
    * dále bude obsahovat metodu, která vrátí skóre zápasu
        * nedržte skóre přímo v zápasu, ale dopočítejte dle počtu událostí GOAL
        * napište vhodný unit test
    * dále bude obsahovat metodu, která pro zápas vrátí vítězný tým
* v šampionátu vytvořte metodu pro simulaci hry turnaje
    * pro každý z vygenerovaných zápasů bude simulována hra
    * tzn. hra je zahájena, vygenerujete náhodně několik gólů pro domácí, několik gólu pro hosty, zápas ukončíte
* v poslední řadě vytvoříte metodu, která pro turnaj vrátí vítězný tým a vhodně tuto informaci vytiskne do konzole
    * k metodě co vrátí vítězný tým napište vhodný unit test
* připravte test, ve kterém vytvoříte šampionát a necháte v něm spustit losování, simulujete hru a vrátíte vítěze
    * jelikož máte generování gólů náhodné, tak nepůjde určit vítěz na výstupu pro Assert, zkontrolujte tedy jen, že se nějaký vítěz vrátí
* vytvořte specifikační diagram tříd celého řešení