scalaPolyGlotJam
================

Scala exercise for Cengage's Friday afternoon polyglot jams.  Solve a simple problem using functional or imperative style coding.

Overview
--------
ScalaFunctional is an exercise created for Cengage's "Friday Afternoon Polyglot Jam".  The intent is to
experience functional programming using Scala.  

You might find value in executing a google search on "scala functional vs imperative".  While the intent of
this exercise is to experience functional-style problem-solving in Scala, you have the freedom to use the 
imperative style that we have grown accustomed to using.  Why not try it both ways and decide for yourself?


Getting Started
---------------
- clone the project from GitHub (git://github.com/tflander/scalaPolyGlotJam.git)
- Install sbt (http://www.scala-sbt.org/)
- run sbt from the cloned project
- type "test" from the sbt prompt

Running "test" from sbt will download dependencies (including Scala), compile the code and run the tests.  
You should be rewarded with the message "[success]" and see no failed tests.

You are free to use the text editor of your choice.  If you want to use eclipse, you can import the sbt project --
but first, you need to "eclipsify" the project.  Just type "eclipse" from the sbt prompt.  You should be rewared
with the message "[info] Successfully created Eclipse project files for project(s)".  Now you can import the project
into eclipse.  You will also want these eclipse plug-ins for eclipse:  Scala IDE for Eclipse, and ScalaTest for Scala IDE.


Problem Overview
----------------
Your task is to implement the method "unearnedBadgesUnlockedFor(earner: String): List[Badge]" in 
src/main/scala/services/MyBadgesService.scala.  You will test-drive this class using
src/test/scala/services/UnearnedBadgesTest.scala.  You will spend most of your effort in the service code, but
you will also be required to write some tests.

Spoiler Alert -- the files MyBadgesServiceSolution.scala and UnearnedBadgesTestSolution.scala.txt contain possible
solutions.  Refer to these files if you need help.


My Badges
---------
Badges are achievements earned in a game or a gamified system.  The idea is to encourage engagement by offering the 
user or player rewards for certain behaviors.

The method "unearnedBadgesUnlockedFor(earner: String): List[Badge]" takes an earner (e.g. user or player), and 
returns a list of badges that the earner can earn.  There are a few twists, however.  Most of these rules are outlined
 in UnearnedBadgesTest.scala.  Here are the rules for creating the list of unearned badges unlocked for the earner:

1)  In general, list any badges the earner has not earned.  The rest of the rules are exceptions to this rule.
2)  Don't list any surprise badges.  We want to be able to surprise the user by rewarding them with certain 
    behaviors.  For example, if they use the system between midnight and 4:00am, we might award a "night owl"
    badge.  Listing the "night owl" badge as an unearned badge would spoil the surprise.
3)  Obscure any mystery badges by displaying a question mark for the badge name.  The real badge name is revealed
    only when the user earns the badge.  This encourages exploration.  For example, we might reward a mystery 
    badge if the user opens the FAQ for the application.
4)  (We might not get this far) Don't list any locked leveled badges.  A leveled badge has prerequisites.
    For example, we might have a leveled badge for using a feature once, 10 times, 25 times, and 50 times.
    We would lock the 10x, 25x, and 50x badges until the user earns the 1x badge.  At that point we would unlock
    the 10x badge.  When the 10x badge is earned, we unlock the 25x badge and so forth.
    
We can think about other rules, but this is a good start.  Perhaps we can allow leveled surprise badges and leveled
mystery badges.  We could also have a leveled badge that opens up multiple paths.  For example, if a user earns a 
badge for using flash cards, we could unlock badges for going through flash cards multiple times, for speed and 
accuracy, or for exploring multiple flash card decks.

     
Getting Help
------------

In addition to the spoilers (MyBadgesServiceSolution.scala and UnearnedBadgesTestSolution.scala.txt), I've created
three tests to help you learn some of the mechanics necessary to solve the problem:

  - FunctionTest.scala ==>  Demonstrates coding in the functional style.  This is perhaps the preferred way to
    solve the problem.  This should be fairly familiar to you if you have used underscore in JavaScript.
  
  - MutableTest.scala ==>  Demonstrates more of a Java-like approach.  This might make more sense to you then the 
    functional approach. 
    
  - ImperitiveTest.scala ==> Sort of a hybrid approach that is not totally functional in style, but avoid mutable
    data types.
    
These three tests are not spoilers.  They address mechanics only and do not pertain directly to the problem domain.


Philosophy -- Heaven and Hell
-----------------------------

Imagine how the world would be if the original Java architects made java.lang.String mutable.  While it seems like
a good idea on the surface, there would be problems:
  - You would never be 100% sure that any string referenced in a thread has not been modified by a different thread
  - Hashes would either need to be calculated on-demand, or refreshed when a string is changed
  - Pooling of identical values would be problematic or impractical

Now image a world where all objects are immutable.  While it seems overly restrictive, there would be benefits:
  - Threads could safely share and distribute objects without locking and blocking
  - Calculated values become easy and efficient to cache
  - Programs would focus on transforming input into output rather than tracking state transitions
  
Perhaps describing this as "Heaven and Hell" is a bit hyperbolic.  You be the judge.
