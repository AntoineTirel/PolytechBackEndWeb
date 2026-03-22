# Objectifs

Le but de ce TP est de contrôler vos connaissances et de s'assurer que la mise en pratique des conditions à disposition.
Ce TP est noté, mais il peut être réalisé en équipe, avec l'aide d'internet ou d'un assistant IA (le mot-clé ici étant assistant).

## Remarques
Pour les réponses aux différentes questions, merci d'envoyer vos réponses par mail à <antoine.tirel@viseo.com>.

Les extraits de code à envoyer se limitent à ceux demandés dans les questions, merci de ne pas m'envoyer l'intégralité de votre projet, je l'ai déjà terminé.

Si votre code ne compile pas, n'hésitez pas à l'envoyer quand même, un code imparfait est toujours meilleur que pas de code du tout.

Vous avez jusqu'au jeudi 26 mars 18h au plus tard pour envoyer vos réponses, au-delà, le TP sera considéré comme non-réalisé.

# Sujet

Dans Pokémon, en plus d'être question de Pokémon, il est souvent question de dresseurs qui portent les Pokémon avec eux, dans une limite de six la plupart du temps.

Le but de ce TP est de rajouter cette nouvelle entrée qu'est le dresseur, avec ses six Pokémon et de s'assurer qu'un dresseur a au moins un Pokémon.

## Commençons par le commencement : Un nouveau controller

Pour assurer la manipulation des dresseurs, il semble nécessaire de faire un nouveau controller.

### Question 1
Pourquoi est-il nécessaire de faire appel à un nouveau controller plutôt que d'utiliser l'existant ?

### Suite
Commencez par créer la classe TrainerController, avec les annotations qui vont bien (la base est très proche de celle de PokedexController)

Créez ensuite les méthodes getAll, getById, create et delete, vides dans un premier temps.

## Étape suivante : les données à manipuler

### Un nouveau DTO.
Créer le fichier TrainerDTO avec les champs suivants : id de type Long, name de type String et pokemon de type List<String>

### Une nouvelle entité.
Malheureusement pour vous, le choix a été fait de manipuler des données étranges en base de données :
Le modèle représentant un dresseur est le modèle suivant :

```
trainer(
    trainer_id,
    trainer_name,
    pokemon_id1,
    pokemon_id2,
    pokemon_id3,
    pokemon_id4,
    pokemon_id5,
    pokemon_id6
)
``` 

#### Question 2
2.a Pourquoi ce choix de représentation des données est-il mauvais ?

2.b Quelle serait, selon-vous, la meilleure approche ?

#### TrainerEntity
Créer l'entité TrainerEntity, en vous basant sur le modèle et la classe PokemonEntity, n'oubliez-pas les annotations pour que Jakarta puisse faire le lien.

### Un mapping supplémentaire
Créez la classe TrainerMapper qui réalise les conversions.

Vous constatez que votre TrainerDTO et votre TrainerEntity ne contiennent pas tout à fait les mêmes champs, et notamment que le nom du Pokémon trouvé dans le DTO n'est pas dans l'entité TrainerEntity.

Pour faire le mapping entre les deux, on va donc devoir faire une méthode trainerEntityToTrainerDTO qui prendra deux paramètres :
* Une entité de dresseur TrainerEntity
* Une entité de Pokémon PokemonEntity

Écrire la méthode, en utilisant les deux paramètres, n'hésitez pas à vous inspirer de la méthode typeEntityToTypeDTO du PokemonMapper.

## Les intéractions entre les données.

### Un nouveau repository

Créez l'interface TrainerRepository afin de faire les requêtes de base.
Il s'agit également d'un JpaRepository<TrainerEntity, Long>, n'oubliez pas les annotations pour indiquer à Spring ce que réalisent vos requêtes.

### Un nouveau service

On a maintenant :
* Un nouveau point d'entrée, le TrainerController
* Un nouvel modèle de données représenté par TrainerEntity
* Une méthode de conversion de l'entité vers le Schema DTO que l'on renvoie.

Il nous manque encore le service pour faire le traitement intermédiaire.

Créer le TrainerService pour faire le lien entre tous les élèments.

N'oubliez pas, le TrainerService doit centraliser le Mapper, les appels aux repository et faire les appels nécessaires au Mapper pour faire les conversions entre Entity et DTO.

Le service doit donc avoir dans ses dépendances un PokemonRepository, un TrainerRepository et un TrainerMapper.


# Compte-rendu
Pour le compte-rendu, vous pouvez m'envoyer un mail dont le corps contient les réponses aux questions
et en pièce-jointe toutes les classes que vous avez dû créer pour réaliser le TP

Pour rappel, n'hésitez pas à vous appuyer sur le cours et sur les classes existantes, vous pouvez vous aider entre vous et avec StackOverflow et de l'IA, le mot important étant "aider".

Si vous utilisez du code généré par IA sans le comprendre, merci de le préciser, ce code fera l'objet d'un second examen sur table donc soyez le plus honnête possible pour me permettre de vous
aider à acquérir le cours et les notions de TP et diminuer le risque de se prendre le mur lors de ce devoir sur table.
