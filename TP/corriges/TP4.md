# Question 1

Lors du cours, nous avons vu que les projets suivaient les principes SOLID, qui comportent notamment le principe de Single responsability principle, qui stipule que 
chaque classe doit avoir sa responsabilité, sa fonctionnalité, et sa représentation de données.

Ici, le PokedexController est en charge de la représentation de données Pokémon.
Le dresseur, ou trainer, étant une entité différente, il doit donc en être séparé, et il est donc nécessaire de créer un TrainerController.

# Questions 2

## a
Ce choix de modèle de représentation comporte plusieurs inconvénients :
* Il limite toute évolution possible, un dresseur ne pouvant avoir qu'au maximum six Pokémon, toute évolution future nécessiterait de tout réécrire.
* Il fait porter à l'entité Trainer une responsabilité qui n'est pas inhérente au dresseur : les Pokémon d'un dresseur ne le définissent pas, seule est définie la relation dresseur Pokémon.
* Il impose aussi un tri des Pokémon, on pourrait très bien avoir un dresseur avec 3 Pokémon qui correspondent à pokemon_id2, pokemon_id4 et pokemon_id5, ce qui décorrèle la logique métier de l'entité.

## b
La meilleure alternative consiste à créer une table de jointure, sur le principe de ce qui avait été fait pour les faiblesses et résistances, qui utiliserait les
pokemon_id et les trainer_id en clé primaire, assurant une unique combinaison et portant la responsabilité de la relation.