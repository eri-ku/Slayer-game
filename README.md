<h1>Slayer</h1>
This project is a Roguelike RPG Adventure game, which I have named Slayer.
The player is placed in the path of an enemy or other interactive object. The player's perspective is first person.
The player interacts with the environment by clicking the left mouse button on the corresponding interactive object. At the beginning of each scene, the game waits for the player to click on the enemy. 
The player then enters combat and is allowed to use special abilities that enhance his powers. These special abilities have a cost called energy. The energy is replenished to the default value each time the scene changes. 
The game currently has two powers implemented - the Power of Attack and the Power of Healing.
Both values of these powers can be temporarily increased. After attacking or healing, these values will return to the default value. The two powers are independent of each other.
The enemy attack takes place immediately after the player is attacked or healed.
Using special abilities does not trigger a response from the enemy.
After each attack or heal, the current energy is increased by one, up to the maximum default value.
For defeating an enemy, the player receives a reward, representing the game currency called money. The player can use this money to upgrade his attributes.
The end of the game is set after the last enemy is defeated or after the player reaches zero health.
The player wins the game if he defeats the last enemy in the game.

<br></br>

[Screenshot1](docs/images/Screenshot1.jpg)
<br></br>
[Screenshot2](docs/images/Screenshot2.jpg)
