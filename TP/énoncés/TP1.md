# Objectifs

* Prise en main de Kotlin
* Faire tourner un projet super minimaliste sur Spring avec Kotlin et Gradle


## Avant de démarrer

### Installation de Java 21

* Windows, Mac, ArchLinux, Debian, Arm https://www.oracle.com/java/technologies/downloads/#java21
   * Si vous avez plusieurs versions de Java sur Windows, pensez à vérifier celle utilisée par la variable `JAVA_HOME` dans les variables d'environnement et si vous avez accès à java/bin dans votre `PATH` pensez à en vérifier les versions.

* Ubuntu, Mint `sudo apt install openjdk-21-jdk`
   * Si vous avez plusieurs versions de Java, vous pouvez utiliser `sudo update-alternatives --config java` et sélectionner celle qui vous intéresse.

### Installation d'IntelliJ
* https://www.jetbrains.com/idea/download/ laisser tourner l'installation en background
   * IntelliJ permet également de paramétrer sa version de Java en précisant un PATH dédié si jamais vous ne souhaitez/pouvez pas changer la version à la volée.

### Installation du projet starter pack

* https://start.spring.io/
  * Kotlin+Gradle
  * Kotlin
  * Spring Boot 3.4.1
  * Jar 
  * Les noms des packages par défaut sont laissés à votre imagination, la correction utilisera pokemon
  * Java 21

## Kotlin
### Les koans c'est trop bien, utilisez-les

* https://play.kotlinlang.org/koans/overview, faire uniquement les exercices d'Introductions et sur les classes

### Un peu de mise en pratique
* https://pl.kotl.in/hPfWvZleL

Dans le fichier suivant, que se passe-t-il si vous faites un run ?

Pourquoi le fichier ne compile-t-il pas ?

Corriger le fichier en permettant sa compilation

Ajouter la forme Square avec une implémentation logique

#### Bonus
* https://pl.kotl.in/kQgdQ-5eP
  * Pourquoi le bonus compile-t-il alors qu'on n'a pas implémenté la méthode drawShape ?
  * Implémenter la méthode drawShape pour que les dessins correspondent à la figure dédiée
