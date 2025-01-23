# Objectifs
Crudités

Nous allons écrire une API REST permettant de manipuler et gérer des pokémons.

C'est ce service que vous allez devoir réutiliser lors des cours sur le Frontend. Nous allons définir les pokémons et comment les manipuler, tandis que la (future) application front se chargera de mettre une UI pour interagir avec les actions que vous allez définir.

# Familiarisez-vous avec les classes créées

Reprenez le projet disponible au niveau du TP2 et lancez-le.

Puis, connectez-vous sur l'URL http://localhost:8080/swagger-ui/index.html

N'hésitez pas à jouer avec les données que vous avez dans le PokemonController

## Récupération des données

Implémentez la première méthode commentée. Dans les paramètres de la méthode, on retrouve un @RequestParam.
Cette annotation Spring permet de signaler que notre endpoint doit recevoir une requête dont le body contient un paramètre tel que spécifié

## Continuez l'exploration en lecture

Ajoutez une nouvelle méthode get permettant de récupérer les Pokémon selon leur génération, cette nouvelle méthode doit renvoyer la liste de tous les Pokémon de la génération passée en paramètre.

### Du propre
Kotlin est très exigeant en termes de compilation, pour s'assurer d'un typage correct, on "enrobe" la méthode d'une ResponseEntity, qui contient un code de réponse.
Ceux utilisés pour ce TD seront uniquement les 200 et 404 pour les GET et PUT, ainsi que les 201 pour les POST.

## Un peu d'écriture

Notre serveur web Pokémon est pour l'instant très statique, mais on va le faire évoluer pour pouvoir modifier un peu les données.

Décommentez la méthode createPokemon et implémentez-la.

💡 Souvenez-vous qu'en Kotlin, on a une importante division entre les données mutables et non mutables, ça peut servir pour la liste de Pokémon.

## Et de modification

Écrire la méthode patchPokemon, qui permet de mettre à jour la description du Pokémon et qui renvoie le Pokémon ainsi mis à jour.

## De la suppression ensuite

Enfin, écrire une méthode permettant de supprimer un Pokémon a l'aide de son ID.