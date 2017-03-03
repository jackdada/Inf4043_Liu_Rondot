# Projet Architecture Logicielle

Auteurs: 

- Kévin Liu - kliu@et.esiea.fr
- Romain Rondot - rondot@et.esiea.fr

# Déroulement du jeu:
 - Choisir un mode: Player VS IA ou Player VS Players
    - Mode Player VS IA
        - Entrer nom du joueur
        - Choisir le nombre de IA
    - Mode Player VS Player
        - Entrer le nombre de joueurs
        - Entrer le nom des joueurs au fur et à mesure
 - Au tour d'un joueur, 3 options s'offrent à lui:
    - q : passer son tour
    - n : ajouter un nouveau mot 
    - s : voler un mot adverse et l'améliorer 
 - Le jeu termine lorsque le premier joueur trouve 10 mots. Ce dernier gagne la partie

# L'IA 
 - L'Intelligence Artificielle cherchera à chaque qu'elle joue, si les lettres d'un mot du dictionnaire sont présent sur le Pot Commun (Common Jar) 
 - Elle parcourt donc tous les mots du dictionnaires et prend le mots le plus long selon les lettres disponibles dans le Pot Commun
 - Elle essaye de créer exclusivement de nouveaux mots et ne cherche pas à voler un mot d'un adversaire 
 
# Notre architecture 
 - Notre projet est composé de 5 classes .java explicement separées dans des paquets dédiés:
   - board : ce package contient le **Common Jar** et l'**Engine** 
   - domain : ce package contient la classe **Player**
   - literature : ce package contient le **Dictionnary** et la classe **Word**
   
# Principe SOLID et Design Pattern
  - Notre projet respecte deux des principes SOLID :
    - **S** : Chaque méthode de notre projet a une seule et unique action.
    - **O** : Nos classes sont ouvertes à l'extension mais fermées à la modification. Certains de nos classes contiennent des *getter* et *setter*
  - Notre projet utilise le Design Pattern du **Iterator Pattern**
    - Nous utilisons des *Iterator* pour parcourir nos collections sans connaitre la taille et ainsi éviter des *segmentation fault*
