# Game-of-life
<p>Game of life written in Java, using Swing and AWT libraries. It's not the standard implentation of John Conway game, because it's unbounded. I mean whole board is combined, so left border is conneced with right edge and similarly - top edge is connected with bottom side.</p>
<p>You can create your own alive shapes clicking on grey squares. By default the game progresses with standard Conway's rules, so:
 <ul>
<li>When an alive cell have 2 or 3 neighbours it survives</li>
<li>When dead cell have 3 neighbours, it revives</li>
<li>When cell have less than two neighbours it dies from loneliness and when it has more than three neighbours - it dies from congestion</li>
</ul></p>
 <p>The games allow you to set your own rules in GUI, typing according with the following pattern: <em>alive/revive</em><br>
 For example type rules: <strong>1357/1357</strong><br>
 The pattern is called <em>Replicator</em> because when you set your shape, after a few iterations it will be replicated. What is really interesting, just before the replication you would see complete chaos and disorder.</p>
<h3>How to iterate?</h3>
Press right array to get next iteration.
