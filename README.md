<img align="center" src="https://image.prntscr.com/image/XCr8S0IoRqm1ZtaYTjQfrQ.png" />

# SIMPLE RPG GAME
This program was written for educational purposes as a final project. 
We were asked to design any kind of game in Java but it had to be programmed with BlueJ.
In my case, I wanted to design an RPG game. Which at least has dialogues, music, maps to interact, combat system, events, among others.

<a href="https://www.youtube.com/watch?v=gI9aBzD2ydY" target="_blank">Watch the sample video here.</a>

## Contents

* [Quick Start](#quick-start)
* [Features](#features)
* [How I Did It](#how)

## <a name="quick-start"></a>Quick Start
To get started you must download BlueJ from its <a href="https://www.bluej.org/" target="_blank">official website.</a> After that, you have to download this project, then run the "project" file.

* The arrow keys are used to move the character.
* Press "SHIFT" to run.
* To advance through the dialogues, press the "ENTER" key.
* For the rest, use the pointer and click.

## <a name="features"></a>Features
The features I could add are:
* Sound effects for selection, attacks and damage.
* Introductory music, combat and atmosphere.
* Two characters with their respective images of walking and dialogue.
* Three stages, room, field, and combat.
* Scrolling map.
* Combat-System

## <a name="how"></a>How I Did It
I had the idea of creating an RPG game, so I had to get the main thing first: A little story, sounds, maps, characters, main music, combat music.

Once that was achieved, I began to program, first it would be the stage of the room, I began to discover how to create the "walls" so that the character has limits when walking. I also added that the character could "run" if a key was pressed.

When he left the room, the idea was that the character would walk around the field to get where the scream of the story was heard. But here I had a problem, I didn't know how to scroll the map while the character walks. Then in the various forums I was able to find a class which helped me for this purpose. 

When I managed to do so, I made the stage for the combat, where according to the seconds of the turn (10) the character had to attack the dragon. If the character doesn't do anything during those seconds, the dragon's damage is double and there was a game over, but if he always attacked, there was a victory.

After that, there was the characters' dialogue for the first time, and as the other character walked away, the main character should not move until the other character disappeared from the screen.

And in the end, the character had to go to the city to begin his adventure.
