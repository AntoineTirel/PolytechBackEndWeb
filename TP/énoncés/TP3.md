# Objectifs

Savoir intervenir dans un projet déjà grandement mis en place pour pouvoir le faire évoluer, ce qui représente 99,999% du temps de projet classique.

# Avant de débuter le TD

Récupérez la dernière version du projet et n'oubliez pas de mettre à jour vos dépendances en cliquant sur le petit éléphant de Gradle.

Prenez le temps de vous familiariser avec les points communs et différences avec le cours, n'hésitez pas à poser des questions.

## Au début il n'y avait rien

Essayez d'exécuter le code, pourquoi ce-dernier renvoie-t-il une erreur ?

Pour corriger l'erreur, reportez-vous au message ainsi qu'au principes SOLID : la classe Pokemon du package Entity dépend du Type du package Models, ce qui ne respecte pas les principes de séparation en couche.

Créer une classe Type dans le package Entity, afin de régler le problème.

> ⚠️ N'oubliez pas le mapping, un Pokémon a un ou deux types.

Dans un premier temps, limitez l'entity Pokemon à ce qu'elle est aujourd'hui.

## Puis d'un coup il y eu tout

Modifiez le PokedexController pour qu'il garde toutes ses méthodes mais en dépendant uniquement du PokemonService et supprimez ensuite la liste pokemonDTOLists

## Et si on ajoutait les faiblesses et résistances ?

Dans Pokémon, les Pokémon ont un lot de faiblesses et de résistances qui sont liés à la combinaison de leurs types.

Contrairement aux types des Pokémon, les faiblesses et résistances ont une longueur variable, on a donc un nouveau type de relation entre les Pokémon et les types : Many to Many.

Pour ce genre de relation, on utilise donc une joint table, à savoir une table dont le rôle est de faire la relation entre les Pokémon et les types.

Ajouter le bloc suivant dans votre fichier resources/schema.sql

CREATE TABLE IF NOT EXISTS pokemon_weaknesses (
    pokemon_id SMALLINT NOT NULL,
    type_id SMALLINT NOT NULL,
    PRIMARY KEY (pokemon_id, type_id),
    FOREIGN KEY (pokemon_id) REFERENCES pokemon(id),
    FOREIGN KEY (type_id) REFERENCES type(id)
);

Modifiez le data.sql en créant une faiblesse pour un de vos Pokémon.

> ⚠️ N'oubliez pas le mapping, faire le lien entre votre Entity et votre DTO est très important.

Faire de même pour les résistances.

# Bonus
> Cette partie peut être réalisée avec un outil d'aide d'IA type copilot/ChatGPT/Gemini.

Depuis le début, tout notre code est testé à travers Swagger ou en ligne de commande, mais il existe des outils de tests pour valider que notre code fonctionne.

Créer le package mapper dans le dossier src/test puis le fichier PokemonMapperTest.kt, et y associer les tests du Mapper.