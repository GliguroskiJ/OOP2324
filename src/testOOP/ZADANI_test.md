Vytvořte základní verzi e-shopu.
-  Implementujte funkci "notifikace o dostupnosti zboží", která informuje uživatele, když se vyprodané zboží vrátí na sklad. Uživatelé se mohou pro tuto notifikaci přihlásit u zboží, které není momentálně dostupné. Jakmile je zboží opět na skladě (množství větší než 0), přihlášení uživatelé obdrží informaci o dostupnosti, současné ceně a počtu kusů na skladě.
-  Notifikace obsahují informace o Uživateli, názvu zboží, jeho ceně a celkovém množství skladových zásob zboží.
-  Uživatelé mohou přidávat zboží do svých košíků, čímž se snižuje skladová zásoba. Pokud uživatel vyprázdní svůj košík, zásoba zboží se opět zvýší.
-  Navrhněte model reprezentující tento e-shop.
-  Ošetřete, aby mohla být puštěna naráz pouze jedna instance aplikace.
-  Určete, jaký designový vzor použijete pro implementaci notifikační funkce dostupnosti zboží a aplikujte ho.
-  Implementujte další potřebné metody, jako je vyprázdnění košíku a přidání zboží do košíku.
-  Pro výpis informací použijte standardní výstup (System.out).

-  Otestujte v mainu
  -  Uživatel U1 dá do košíku veškeré zboží Z1.
  -  Uživatelé U2 a U3 se zaregistrují pro oznámení o dostupnosti zboží Z1.
  -  Uživatel U1 vyprázdní svůj košík, což aktivuje notifikaci pro U2 a U3.
  -  Uživatel U3 dáním do košíku vyčerpá celé zboží Z1.
  -  Zboží Z1 je naskladněno, což znamená zvýšení jeho množství.
  -  Uživatelé U2 a U3 jsou opět notifikováni o dostupnosti zboží Z1.

Bonus:
  Pokud je uživatel zaregistrován jako pro notifikace, přidáním do košíku se jako čekatel na notifikaci odstraní
