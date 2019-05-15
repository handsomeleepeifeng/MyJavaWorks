#Foosball Dynasty
##Description
Balaji and his coworkers like to play Foosball on their lunch break.Foosball is a game
typically played by 2 players (individual matchup) or 4players (team play). However, 
due to the increasing interest and availabilityof coworkers, Balaji has created a new
variation that supports 5 ormore players. Each individual point is played by four
players: two on the White team and two on the Black team.

![Foosball Dynasty](https://github.com/handsomeleepeifeng/MyJavaWorks/blob/master/PIC/Foosball%20Dynasty.png)

The remaining players wait in line for their turn to play. On each point, the players
on the scoring team switch positions (e.g., if White scores the point,then the White
Offense player becomes the White Defense player, and vice versa). The Offense player
of the team that lost the point becomes the Defense player of the same team, while 
the Defense player of the team that lost thepoint goes to the back of the line and
waits for their next chance to play.The person at the front of the line becomes the
new Offense player of the team that lost the point.Based on these rules, a team that
continues scoring consecutive points gets tokeep playing together (swapping
positions with each other after each point) until the other team breaks the streak.
Each such streak of points creates adynastyfor the winning team. Dynasties can be 
short-lived (a single point) or long-lived,but they are always broken when the opposing 
team scores a point. The ``winners" of this variation of foosball are the players that 
can create the longest dynasty.

##Input
Input begins with a line containing an integer nn representing thenumber of players 
(5 \leq n \leq 105≤n≤10). The next line contains the nn names ofall participating 
players. The first four are the names of the fourplayers who initially arrive at the 
table (in that order): the first person toarrive starts at White Offense, the second 
starts at Black Offense, the third starts atWhite Defense, and the fourth starts at 
Black Defense. The remainingplayers get in line to wait for their turn. The final input 
line containsa non-empty string indicating which side scored each point, with a Whiteteam 
point represented by 'W' and a Black team point represented by `B'.  Themaximum length 
of this string will be 1000.

##Output
Display the team that has achieved the longest dynasty. If morethan one team ties for 
the record, then display each of theseteams in chronological order, one team per line. 
When displaying ateam, names should be displayed in the order in which the players 
arrived at the table for that team.Note that it is possible for the same team to appear 
more than once in the output, potentially with the player names in a different order.

##Sample
### Input 1
    6
    Balaji David Alex Scott Andrew Ravi
    WWBWBBWBW
###Output 1
    Balaji Alex
    Andrew David
###Input 2
    6
    Amy Jinu Kasey Sarah Sheetal Julia
    BBBBB
###Onput 2
    Jinu Sarah
##MyCode