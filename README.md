# AtelierAndroid_TP02

**Application Android de gestion des inscriptions des participants**, développée en Kotlin dans le cadre du module **Développement Mobile**. Ce projet met en pratique les concepts fondamentaux de la programmation orientée objet, de la validation des formulaires, de l'héritage et de la gestion de collections en mémoire.

L'application permet d'enregistrer des participants, de consulter leurs fiches, de rechercher un participant par son nom et de gérer les inscriptions pendant l'exécution de l'application.

**Auteur :** Fakher Neila  
**Classe :** ING-A3-GL-AL-04  
**Module :** Développement Mobile

---

## Badges

![Kotlin](https://img.shields.io/badge/Kotlin-7F52FF?style=for-the-badge&logo=kotlin&logoColor=white)
![Android](https://img.shields.io/badge/Android-3DDC84?style=for-the-badge&logo=android&logoColor=white)
![Gradle](https://img.shields.io/badge/Gradle-02303A?style=for-the-badge&logo=gradle&logoColor=white)
![Java 21](https://img.shields.io/badge/Java-21-ED8B00?style=for-the-badge&logo=openjdk&logoColor=white)

---

## Table des matières

- [1. Fonctionnalités](#1-fonctionnalités)
- [2. Technologies utilisées](#2-technologies-utilisées)
- [3. Structure du projet](#3-structure-du-projet)
- [4. Prérequis](#4-prérequis)
- [5. Configuration et installation](#5-configuration-et-installation)
- [6. Compilation et exécution](#6-compilation-et-exécution)
- [7. Scénarios de test](#7-scénarios-de-test)
- [8. Réponses aux questions du TP](#8-réponses-aux-questions-du-tp)
- [9. Dépannage](#9-dépannage)
- [10. Auteur](#10-auteur)

---

## 1. Fonctionnalités

### Formulaire d'inscription

- Saisie du nom, du prénom et de l'âge du participant.
- Sélection du groupe à l'aide d'un `Spinner`.
- Choix de la réponse concernant le soutien aux tests à l'aide de `RadioButton`.
- Confirmation de l'inscription à l'aide d'une `CheckBox`.
- Validation des données saisies avant leur traitement.
- Affichage d'un aperçu de la fiche sans enregistrer le participant.
- Effacement du formulaire sans supprimer les inscriptions existantes.

### Gestion des données

- Modélisation des personnes avec une classe `Personne`.
- Modélisation des participants avec une classe `Participant` héritant de `Personne`.
- Création d'une fiche descriptive grâce à la méthode `fiche()`.
- Enregistrement des participants dans une collection `MutableList<Participant>`.
- Détection des doublons à partir du nom et du prénom, sans distinction entre majuscules et minuscules.
- Affichage de la liste complète des participants inscrits.
- Mise à jour du compteur des inscriptions après chaque nouvel enregistrement.

**Remarque :** les données sont conservées uniquement en mémoire pendant l'exécution de l'application. Elles ne sont pas persistées dans une base de données et sont perdues lorsque le processus de l'application est arrêté.

### Recherche et consultation

- Recherche d'un participant à partir de son nom.
- Comparaison des noms sans distinction entre majuscules et minuscules.
- Affichage de la fiche du participant trouvé.
- Affichage du message `Aucun participant trouvé` lorsqu'aucun résultat ne correspond à la recherche.
- Consultation de toutes les fiches enregistrées avec le bouton `Afficher la liste`.

### Portée du TP

La gestion des places et des sièges, correspondant au bonus du TP02, n'est pas incluse dans cette version.

---

## 2. Technologies utilisées

| Technologie | Version / Configuration | Utilisation |
|---|---|---|
| Kotlin | Langage du projet | Programmation de la logique applicative |
| Android SDK | Target SDK 34 | Développement et exécution de l'application |
| Android SDK | Minimum SDK 24 | Compatibilité à partir d'Android 7.0 |
| Java Development Kit | JDK 21 | Environnement Java utilisé pour la compilation |
| Gradle | 8.5 | Automatisation du build |
| Android Gradle Plugin | 8.2.2 | Compilation et génération de l'application Android |
| Visual Studio Code | IDE utilisé | Édition du code source et exécution des commandes |
| Android Debug Bridge | `adb` | Installation et lancement sur un appareil ou un émulateur |
| Android XML | Ressources de l'interface | Définition des layouts et des ressources Android |

Le projet utilise Gradle comme système de build et ne nécessite pas Android Studio comme éditeur de code. Un Android SDK correctement configuré reste indispensable pour compiler et exécuter l'application.

---

## 3. Structure du projet

La structure ci-dessous représente l'organisation Android attendue du projet. Les fichiers et ressources exacts peuvent varier selon la version du dépôt.

```text
AtelierAndroid_TP02/
├── app/
│   ├── build.gradle.kts
│   └── src/
│       └── main/
│           ├── AndroidManifest.xml
│           ├── java/
│           │   └── <package>/
│           │       ├── MainActivity.kt
│           │       ├── Personne.kt
│           │       └── Participant.kt
│           └── res/
│               ├── layout/
│               │   └── activity_main.xml
│               ├── values/
│               │   ├── strings.xml
│               │   ├── colors.xml
│               │   └── themes.xml
│               └── drawable/
├── gradle/
│   └── wrapper/
│       ├── gradle-wrapper.jar
│       └── gradle-wrapper.properties
├── build.gradle.kts
├── settings.gradle.kts
├── gradle.properties
├── local.properties
└── README.md
```

### Rôle des principaux fichiers

| Fichier | Description |
|---|---|
| `MainActivity.kt` | Gère les interactions utilisateur, la validation, les inscriptions et la recherche. |
| `Personne.kt` | Définit les propriétés communes à une personne. |
| `Participant.kt` | Étend `Personne` et ajoute les informations spécifiques au participant. |
| `activity_main.xml` | Définit l'interface du formulaire et les composants de gestion des participants. |
| `AndroidManifest.xml` | Déclare les composants Android de l'application. |
| `app/build.gradle.kts` | Configure le module Android, le SDK et les paramètres de compilation. |
| `build.gradle.kts` | Configure le build au niveau du projet. |
| `settings.gradle.kts` | Déclare les modules inclus dans le projet. |
| `gradle.properties` | Définit les propriétés globales de Gradle. |
| `local.properties` | Indique notamment le chemin local vers l'Android SDK. |

---

## 4. Prérequis

Avant de compiler le projet, vérifier la présence des outils suivants :

- **JDK 21** installé et correctement configuré.
- **Gradle Wrapper** fourni avec le projet, configuré pour utiliser Gradle 8.5.
- **Android SDK** avec les outils de compilation nécessaires.
- **Android SDK Platform 34**.
- **Android SDK Build-Tools** compatibles avec le projet.
- **Android SDK Platform-Tools**, notamment `adb`.
- Un appareil Android physique ou un émulateur compatible avec le niveau d'API 24 ou supérieur.
- Visual Studio Code ou un éditeur de texte équivalent.

### Vérification de Java

```bash
java -version
```

Le résultat doit indiquer Java 21.

Vérifier également la variable d'environnement `JAVA_HOME` :

```bash
echo "$JAVA_HOME"
```

### Vérification d'ADB

```bash
adb version
```

### Vérification de la configuration Gradle

Depuis la racine du projet :

```bash
./gradlew --version
```

Cette commande doit afficher la version du Gradle Wrapper et la JVM utilisée.

---

## 5. Configuration et installation

### 5.1. Cloner le dépôt

```bash
git clone https://github.com/fakherneila/AtelierAndroid_TP02.git
```

Accéder au répertoire du projet :

```bash
cd AtelierAndroid_TP02
```

### 5.2. Configurer Java 21

Sous Linux, définir `JAVA_HOME` avec le chemin correspondant à l'installation locale du JDK 21.

Exemple pour une installation dans `/usr/lib/jvm/java-21-openjdk` :

```bash
export JAVA_HOME=/usr/lib/jvm/java-21-openjdk
export PATH="$JAVA_HOME/bin:$PATH"
```

Vérifier la version utilisée :

```bash
java -version
javac -version
```

Ces commandes doivent indiquer une version Java 21.

Le chemin présenté est un exemple : il faut utiliser celui réellement présent sur la machine.

### 5.3. Configurer Android SDK avec `local.properties`

Le fichier `local.properties`, situé à la racine du projet, doit indiquer le chemin local de l'Android SDK.

Exemple sous Linux :

```properties
sdk.dir=/home/username/Android/Sdk
```

Remplacer `username` par le nom de l'utilisateur local et adapter le chemin si le SDK est installé ailleurs.

Pour identifier les variables Android éventuellement configurées :

```bash
echo "$ANDROID_HOME"
echo "$ANDROID_SDK_ROOT"
```

Pour vérifier que le répertoire existe :

```bash
ls "$ANDROID_HOME"
```

Si `ANDROID_HOME` n'est pas défini, vérifier le chemin configuré dans `local.properties`.

**Important :** `local.properties` contient une configuration propre à chaque machine. Il ne doit généralement pas être versionné dans Git.

### 5.4. Vérifier `gradle.properties`

Le fichier `gradle.properties`, à la racine du projet, contient les paramètres globaux de Gradle.

Exemple de configuration courante :

```properties
org.gradle.jvmargs=-Xmx2048m -Dfile.encoding=UTF-8
android.useAndroidX=true
```

Ces propriétés définissent notamment la mémoire maximale de la JVM utilisée par Gradle et l'activation d'AndroidX.

Il faut conserver les autres propriétés déjà présentes dans le projet et éviter d'ajouter des paramètres non nécessaires.

### 5.5. Vérifier le Gradle Wrapper

Le fichier `gradle/wrapper/gradle-wrapper.properties` doit référencer Gradle 8.5.

Exemple :

```properties
distributionUrl=https\://services.gradle.org/distributions/gradle-8.5-bin.zip
```

Le Gradle Wrapper télécharge automatiquement la distribution requise lorsqu'elle n'est pas encore disponible localement.

### 5.6. Vérifier les paramètres Android

Le module `app` doit être configuré pour utiliser les versions du SDK prévues par le projet :

- `compileSdk = 34`
- `targetSdk = 34`
- `minSdk = 24`

L'Android Gradle Plugin doit correspondre à la version 8.2.2 indiquée dans la configuration du projet.

---

## 6. Compilation et exécution

### 6.1. Compiler l'application

Depuis la racine du projet, lancer :

```bash
./gradlew assembleDebug
```

Cette commande compile l'application et génère un APK de débogage.

Le fichier est normalement disponible à l'emplacement suivant :

```text
app/build/outputs/apk/debug/app-debug.apk
```

Pour nettoyer les fichiers générés avant une nouvelle compilation :

```bash
./gradlew clean
```

Puis relancer la compilation :

```bash
./gradlew assembleDebug
```

### 6.2. Démarrer un émulateur ou connecter un appareil

Lister les appareils Android disponibles :

```bash
adb devices
```

Si un émulateur est déjà démarré ou qu'un appareil est connecté avec le débogage USB activé, il doit apparaître dans la liste.

### 6.3. Installer l'APK

```bash
adb install -r app/build/outputs/apk/debug/app-debug.apk
```

L'option `-r` permet de réinstaller l'application en conservant les données existantes lorsque cela est possible et que le package est compatible.

### 6.4. Lancer l'application

La commande suivante suppose que le package Android est `com.example.atelierandroid_tp02` et que l'activité de lancement est `MainActivity`.

```bash
adb shell am start -n com.example.atelierandroid_tp02/.MainActivity
```

**À adapter :** remplacer le nom du package et le nom de l'activité par ceux déclarés dans le projet et dans `AndroidManifest.xml`.

### 6.5. Consulter les logs Android

Pour afficher les logs :

```bash
adb logcat
```

Pour filtrer les messages contenant le nom de l'activité :

```bash
adb logcat | grep MainActivity
```

Les logs permettent d'identifier les exceptions, les erreurs de lancement et les problèmes rencontrés pendant les interactions avec l'application.

---

## 7. Scénarios de test

Les scénarios suivants permettent de vérifier les fonctionnalités principales du TP02. Ils doivent être exécutés sur un appareil ou un émulateur Android compatible.

| ID | Scénario | Résultat attendu |
|---|---|---|
| T01 | Lancer l'application. | Le formulaire d'inscription s'affiche correctement. |
| T02 | Saisir un nom, un prénom, un âge valide et les informations complémentaires. | Les données peuvent être utilisées pour générer une fiche. |
| T03 | Cliquer sur `Afficher la fiche` avec des données valides. | La fiche du participant s'affiche sans créer de nouvelle inscription. |
| T04 | Saisir un âge non numérique. | La conversion avec `toIntOrNull()` échoue proprement et la validation empêche le traitement d'une valeur invalide. |
| T05 | Laisser un champ obligatoire vide. | La validation signale le champ manquant et empêche l'enregistrement. |
| T06 | Décocher la case de confirmation, puis tenter l'enregistrement. | L'inscription est refusée si la confirmation est obligatoire dans la logique implémentée. |
| T07 | Cliquer sur `Enregistrer` avec des données valides. | Le participant est ajouté à la collection en mémoire et le compteur est mis à jour. |
| T08 | Enregistrer une seconde fois un participant ayant le même nom et le même prénom. | Le doublon est détecté, sans tenir compte de la casse, et n'est pas ajouté à la collection. |
| T09 | Enregistrer deux participants portant le même nom, mais des prénoms différents. | Les deux participants sont acceptés si aucune autre règle de validation ne les exclut. |
| T10 | Cliquer sur `Afficher la liste` après plusieurs inscriptions. | Toutes les fiches enregistrées sont affichées. |
| T11 | Rechercher un participant avec son nom exact. | La fiche correspondante est affichée. |
| T12 | Rechercher un participant avec une casse différente. | Le participant est retrouvé grâce à la recherche insensible à la casse. |
| T13 | Rechercher un nom absent de la collection. | Le message `Aucun participant trouvé` s'affiche. |
| T14 | Cliquer sur `Effacer` après plusieurs inscriptions. | Les champs du formulaire sont réinitialisés, mais les participants enregistrés restent disponibles. |
| T15 | Vérifier le compteur après plusieurs inscriptions valides. | Le texte `Inscriptions : N` correspond au nombre de participants effectivement enregistrés. |
| T16 | Arrêter complètement le processus de l'application, puis la relancer. | Les données en mémoire ne sont plus disponibles, car aucune persistance n'est implémentée. |

**Remarque :** le comportement exact des messages de validation et la présentation des fiches dépendent de l'implémentation de l'interface. Les résultats attendus ci-dessus décrivent les règles fonctionnelles à vérifier.

---

## 8. Réponses aux questions du TP

### Q1. Pourquoi utiliser l'héritage entre `Personne` et `Participant` ?

L'héritage permet de réutiliser les propriétés communes `nom`, `prenom` et `age` définies dans la classe `Personne`. La classe `Participant` étend cette classe en ajoutant les informations spécifiques au groupe, au soutien et à la fiche descriptive.

### Q2. Quelle est la différence entre `var` et `val` en Kotlin ?

`val` déclare une référence en lecture seule, dont la valeur ne peut pas être réaffectée après son initialisation. `var` déclare une variable réassignable, ce qui permet notamment de modifier l'âge d'une personne si la logique du programme l'autorise.

### Q3. Pourquoi utiliser un `ScrollView` dans le formulaire ?

Un `ScrollView` permet de faire défiler verticalement le contenu lorsque sa hauteur dépasse celle de l'écran. Il améliore ainsi l'accessibilité des champs et des boutons sur les appareils disposant d'un écran de petite taille.

### Q4. Pourquoi la méthode `fiche()` retourne-t-elle une `String` ?

La méthode `fiche()` retourne une `String` contenant les informations formatées du participant. Cette représentation peut ensuite être affichée dans un composant de l'interface, par exemple un `TextView`.

### Q5. Pourquoi la collection des participants doit-elle être une propriété de l'`Activity` ?

La collection doit être accessible par plusieurs méthodes de l'activité, notamment celles qui enregistrent, recherchent et affichent les participants. Une propriété d'instance de l'`Activity` permet de partager les mêmes données entre ces méthodes pendant la durée de vie de cette instance, contrairement à une variable locale recréée à chaque appel.

### Q6. Quelle est la différence entre un objet et une collection ?

Un objet représente une entité individuelle possédant des propriétés et éventuellement des méthodes, comme un `Participant`. Une collection, telle qu'une `MutableList<Participant>`, regroupe plusieurs objets et permet de les parcourir, de les rechercher, de les ajouter ou de les supprimer.

### Q7. Pourquoi utiliser `Participant?` comme type de retour ?

Le type `Participant?` indique qu'une méthode peut retourner soit un objet `Participant`, soit `null` lorsqu'aucun participant ne correspond à la recherche. Cette possibilité oblige le programme à prendre en compte l'absence de résultat et contribue à la sécurité face aux valeurs nulles.

### Q8. À quoi servent l'appel sécurisé `?.` et l'opérateur Elvis `?:` ?

L'opérateur `?.` permet d'accéder à une propriété ou d'appeler une méthode uniquement si la valeur n'est pas `null`. L'opérateur Elvis `?:` fournit une valeur de remplacement lorsque l'expression située à gauche est nulle, ce qui permet de traiter explicitement les cas d'absence de résultat.

Exemple :

```kotlin
val participant: Participant? = participants.find {
    it.nom.equals(nomRecherche, ignoreCase = true)
}

val resultat = participant?.fiche() ?: "Aucun participant trouvé"
```

Dans cet exemple, `find` recherche le premier participant correspondant au nom. Si aucun participant n'est trouvé, le résultat affiché est le message prévu.

---

## 9. Dépannage

| Symptôme | Cause possible | Solution |
|---|---|---|
| `Unsupported class file major version` ou erreur de version Java pendant le build. | La version de Java utilisée par Gradle n'est pas compatible avec la configuration du projet. | Vérifier `java -version`, `JAVA_HOME` et `./gradlew --version`. Utiliser JDK 21 pour ce projet. |
| `Android Gradle plugin requires Java 17 to run` ou message similaire. | La JVM sélectionnée par Gradle ne satisfait pas les exigences de l'Android Gradle Plugin. | Vérifier que Gradle utilise JDK 21 et non une ancienne JVM. L'AGP 8.2.2 nécessite au minimum Java 17. |
| Erreur indiquant que Java 11 est insuffisant pour compiler le projet ou exécuter Gradle. | L'environnement utilise un JDK 11, alors que la configuration du projet demande un environnement Java plus récent. | Installer JDK 21, mettre à jour `JAVA_HOME`, puis vérifier la JVM avec `./gradlew --version`. |
| `SDK location not found`. | Le chemin vers l'Android SDK est absent ou incorrect. | Vérifier `local.properties` et la propriété `sdk.dir`. S'assurer que le répertoire du SDK existe réellement. |
| `Unresolved reference: R`. | Une ressource XML contient une erreur, le package est incorrect ou la génération des ressources Android a échoué. | Examiner les erreurs XML, vérifier les noms des ressources et le namespace du module. Corriger les erreurs, puis lancer `./gradlew clean assembleDebug`. |
| `Cannot mutate dependencies of configuration ... after it has been resolved` ou `Cannot mutate dependencies`. | Une dépendance ou une configuration Gradle est modifiée après la résolution de la configuration concernée, ou un script/plugin utilise une API incompatible. | Examiner la configuration Gradle et les plugins utilisés. Déclarer les dépendances dans les blocs appropriés, éviter les modifications tardives et vérifier la compatibilité des versions de Gradle et de l'AGP. |
| `SDK platform 34 not found`. | La plateforme Android SDK 34 n'est pas installée. | Installer Android SDK Platform 34 à l'aide du gestionnaire de SDK disponible, puis relancer le build. |
| `Permission denied` lors de l'exécution de `./gradlew`. | Le script Gradle Wrapper ne possède pas les droits d'exécution. | Exécuter `chmod +x gradlew`, puis relancer `./gradlew assembleDebug`. |
| `adb: no devices/emulators found`. | Aucun appareil autorisé ni émulateur démarré n'est détecté. | Connecter un appareil avec le débogage USB activé ou démarrer un émulateur, puis exécuter `adb devices`. |
| `INSTALL_FAILED_UPDATE_INCOMPATIBLE`. | L'application déjà installée possède une signature différente de celle de l'APK à installer. | Désinstaller l'ancienne application si nécessaire, puis installer le nouvel APK. Attention : la désinstallation peut supprimer ses données locales. |
| `Activity class does not exist` lors du lancement par ADB. | Le package ou le nom de l'activité fourni à `adb shell am start` ne correspond pas à l'application. | Vérifier le namespace, l'`applicationId` et l'activité déclarée dans `AndroidManifest.xml`, puis corriger la commande. |
| Le compteur ou la liste ne se met pas à jour après une inscription. | La collection ou le compteur n'est pas actualisé au bon endroit dans la logique de l'activité. | Vérifier que le participant est ajouté uniquement après validation et que l'affichage du compteur est actualisé après l'enregistrement réussi. |
| Un participant en double est accepté. | La comparaison du nom et du prénom est sensible à la casse ou la vérification n'est pas exécutée avant l'ajout. | Utiliser `any { ... }` avec `equals(..., ignoreCase = true)` sur le nom et le prénom avant d'ajouter le participant. |
| Les participants disparaissent après la fermeture de l'application. | Les données sont stockées uniquement dans une collection en mémoire. | Ce comportement est normal pour le TP actuel. Une persistance nécessite une solution supplémentaire, par exemple Room ou DataStore, hors du périmètre actuel. |

### Commandes utiles pour diagnostiquer le build

Vérifier Java :

```bash
java -version
```

Vérifier la JVM et la version de Gradle :

```bash
./gradlew --version
```

Nettoyer et reconstruire le projet :

```bash
./gradlew clean assembleDebug
```

Afficher les détails d'une erreur de compilation :

```bash
./gradlew assembleDebug --stacktrace
```

Vérifier les appareils Android disponibles :

```bash
adb devices
```

---

## 10. Auteur

**Fakher Neila**  
Étudiant en ingénierie logicielle — Classe ING-A3-GL-AL-04  
Module : Développement Mobile

**Dépôt GitHub :** [AtelierAndroid_TP02](https://github.com/fakherneila/AtelierAndroid_TP02)

Ce projet a été réalisé dans un cadre universitaire afin de mettre en pratique les bases du développement Android avec Kotlin, la programmation orientée objet, la validation des entrées utilisateur et la manipulation de collections.

---
