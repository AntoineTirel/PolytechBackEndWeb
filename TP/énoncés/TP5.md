# Préambule

## Installations nécessaires

Pour le prochain TP, il va être nécessaire de disposer de Node sur votre machine -> https://nodejs.org

Pour le reste, tout votre code peut être écrit dans n'importe quel éditeur de texte, y compris IntelliJ que vous avez gardé 😉.

# Sujet

## Jouons un peu avec les commandes simples du html et du css
Ouvrez le fichier tp5_1.html avec votre navigateur.

Vous constatez que le texte est rendu en un seul bloc.

En utilisant uniquement du html, comment peut-on faire pour que la page rendue possède la même aération que le code source ?

Remarque : La balise <p> du HTML sert à définir des paragraphes.

Une fois que le texte est bien aéré comme dans le code source, ajouter des styles sur le fichier pour faire en sorte de centrer le texte.

N'oubliez pas, la définition du style se fait dans le <header>, par l'intermédiaire de la balise <style>.

Pour définir un style qui s'applique à une balise dotée d'une classe particulière, on utilise la notation suivante :

.myClass {
    propriété1: valeur 1
}

Pour centrer du texte, la propriété "text-align" doit prendre la valeur "center".

## Les sélecteurs JavaScript, qu'est-ce que ça donne ?
Ouvrez le fichier tp5_2.html avec votre navigateur.

Que voyez-vous ?

Pourquoi ne se passe-t-il rien quand vous cliquez sur le bouton ?

Mettre à jour le code pour que le compteur ait l'effet attendu.

Faites attention au nommage des méthodes 😇

## Un script un peu plus poussé

Pour faire disparaitre un objet, on peut utiliser la ligne de commande suivante :

document.getElementsByClassName("") ... .style.display = "none"

Puis le faire réapparaitre en utilisant la même logique, mais en remplaçant l'opérande de droite de l'égalité par un = "".

écrire une nouvelle fonction JavaScript dans le fichier pour faire disparaitre le texte du compteur lorsque le compteur atteint 10, puis le faire réapparaitre lorsqu'il dépasse cette valeur.

## Jouons un peu avec le style
Tout comme il est possible d'interagir avec la visibilité, il est également possible d'interagir avec les couleurs, en utilisant la propriété "color" de l'objet "style".

écrire une nouvelle fonction JavaScript qui met le bouton en rouge quand il y a 0 click, puis qui le passe en noir, puis qui le passe en vert à chaque multiple de 10
(10, 20, 30, 40).

L'opérateur de modulo s'écrit % en JavaScript.


## Pour parler d'observables

Aller sur la page de rxjs dans l'overview https://rxjs.dev/guide/overview
Cliquer sur un des blocs de code pour l'ouvrir dans StackBlitz et le remplacer par :
import { of } from 'rxjs';

of(1,2,3,4,5,6,7,8,9,10).pipe().subscribe(value => console.log(value));

Utiliser la documentation de rxjs pour remplacer le code de manière à logger les carrés des multiples de 3, sans toucher au subscribe.