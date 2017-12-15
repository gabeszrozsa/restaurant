# Projektötlet - Étterem
Az alapötlet egy éttermek keresésével és értékelésével foglalkozó alkalmazás lenne. Különböző szűrőket használva tudunk éttermekre keresni, mint például városra lebontva vagy értékelés alapján rendezve. Ezen belül megtekinthetjük az adott éttermet részletesen (étlap, értékelések, cím, stb.), mi is értékelhetjük.
Polgármester jogosultsággal mi is hozzáadhatunk további városokat a meglévőkhöz. Étteremvezetőként nyithatunk új éttermet az adott városban – miután a polgármester elfogadta -, majd összeállíthatjuk a saját étlapunkat az étterem számára. Ezen kívül új ételt/italt vehetünk fel a listához. Egyszerű felhasználóként lehetőségünk van különböző éttermek értékelésére.

Az adatok csak belépett felhasználók számára láthatóak.
*  belépett user: városok/éttermek keresése, ezek részletes megtekintése; éttermek értélelése; értékelések/felhasználók listájának megtekintése
*  polgármester: alap jogosultságokon kívül város hozzáadása/módosítása/törlése illetve új étterem véglegesítése
*  étteremvezető: alap jogosultságokon kívül étterem hozzáadása/módosítása/törlése illetve új étel/ital hozzáadása/módosítása/törlése

# Backend

## Fejlesztői környezet
*  Front-end
*  - Sublime Text 3
*  - ATOM
*  - Node.js Command promt
*  Back-end
*  - Netbeans IDE
*  Verziókövetés
*  - Git
*  Task Management
*  - Wunderlist

## Könyvtár struktúra
### Front-end
├───app<br />
│   ├───components<br />
│   │   └───menu<br />
│   ├───model<br />
│   ├───pages<br />
│   │   ├───city<br />
│   │   │   ├───city-detail<br />
│   │   │   ├───city-list<br />
│   │   │   └───city-new<br />
│   │   ├───error<br />
│   │   ├───login<br />
│   │   ├───register<br />
│   │   ├───restaurant<br />
│   │   │   ├───restaurant-detail<br />
│   │   │   ├───restaurant-list<br />
│   │   │   └───restaurant-new<br />
│   │   ├───review<br />
│   │   │   ├───review-detail<br />
│   │   │   ├───review-list<br />
│   │   │   └───review-new<br />
│   │   └───user<br />
│   │       └───user-list<br />
│   ├───services<br />
│   └───utils<br />
├───assets<br />
└───environments<br />

### Back-end
├───main<br />
│   ├───java<br />
│   │   └───hu<br />
│   │       └───elte<br />
│   │           └───alkfejl<br />
│   │               └───issuetracker<br />
│   │                   ├───api<br />
│   │                   ├───config<br />
│   │                   ├───controller<br />
│   │                   ├───model<br />
│   │                   ├───repository<br />
│   │                   └───service<br />
│   │                       ├───annotations<br />
│   │                       └───exceptions<br />
│   └───resources<br />
│       └───templates<br />
└───test<br />
    └───java<br />
        └───hu<br />
            └───elte<br />
                └───alkfejl<br />
                    └───issuetracker<br />

## Adatbázis terv
![alt text](https://raw.githubusercontent.com/Tremx389/restaurant/master/db.png)

### Éttermek (Restaurants)
*	azonosító: int
*	név: string
*	város: (Város) azonosító		amelyik városban található
*	cím: string

### Városok (Cities)
*	azonosító: int
*	név: string

### Étlapok (Menus)
*	azonosító: id
*	típus: string		„food” vagy „drink”
*	név: string
*	étterem: (Étterem) azonosító		amelyik étteremben felszolgálják

### Értékelések (Reviews)
*	azonosító: int
*	étterem: (Étterem) azonosító
*	user: (User azonosító)
*	értékelés: int		1-5 fokú skála
*	üzenet: string

### Felhasználók
*	azonosító: int
*	felhasználónév: string
*	jelszó: password

## Könyvtárstruktúra

## Végpont-tervek és leírások
*	POST: /api/restaurants/ – étterem hozzáadása (étteremvezető)
*	GET: /api/restaurants/ – éttermek lekérdezése (belépett user)
*	GET: /api/restaurants/:id – adott étterem lekérdezése (belépett user)
*	PUT: /api/restaurants/:id – adott étterem módosítása (étteremvezető)
*	DELETE: /api/restaurants/:id – adott étterem törlése (étteremvezető)

*	POST: /api/cities/ – város hozzáadása (polgármester)
*	GET: /api/cities/ – városok lekérdezése (belépett user)
*	GET: /api/cities/:id – adott város éttermeinek lekérdezése (belépett user)
*	PUT: /api/cities/:id – adott város módosítása (polgármester)
*	DELETE: /api/cities/:id – adott város törlése a listából (polgármester)

*	POST: /api/reviews/ – értékelés hozzáadása (belépett user)
*	GET: /api/reviews/ – értékelések lekérdezése (belépett user)
*	GET: /api/reviews/:id – adott értékelés lekérdezése (belépett user)
*	PUT: /api/reviews/:id – adott értékelés módosítása (tulajdonos user)
*	DELETE: /api/reviews/:id – adott értékelés törlése a listából (tulajdonos user)

*	POST: /api/menus/ – menü elem hozzáadása (étteremvezető user)
*	GET: /api/menus/ – menü elemek lekérdezése (belépett user)
*	GET: /api/menus/:id – adott menü elem lekérdezése (belépett user)
*	PUT: /api/menus/:id – adott menü elem módosítása (étteremvezető user)
*	DELETE: /api/menus/:id – adott menü elem törlése a listából (étteremvezető user)

*	GET: /api/users/ – felhasználók lekérdezése (belépett user)

### 3)	REST Api
Frontend – oldalak megjelenítése (route)
*	/restaurants			éttermek listája
*	/restaurants/:id		egy specifikus étterem
*	/restaurants/:id/reviews	az adott étterem értékelései
*	/restaurants/:id/menus		adott étterem étlapja
*	/reviews			értékelések listája
*	/cities				városok listája
*	/cities/:id			kilistázza az adott város éttermeit
*	/users				felhasználók listája
*	/users/:id			adott felhasználó
*	/users/:id/reviews		adott felhasználó értékelései
