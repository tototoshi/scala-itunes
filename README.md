# scala-itunes

## Requirement

 - bash-itunes (https://github.com/illusori/bash-itunes)


## Example

```scala
> console
[info] Compiling 1 Scala source to /Users/toshi/work/scala-itunes/target/scala-2.10/classes...
[info] Starting scala interpreter...
[info]
import com.github.tototoshi.itunes.iTunes._
Welcome to Scala version 2.10.2 (Java HotSpot(TM) 64-Bit Server VM, Java 1.7.0_21).
Type in expressions to have them evaluated.
Type :help for more information.

scala> play
res0: com.github.tototoshi.itunes.iTunes.Result = Result(0,Resuming "I Feel The Earth Move" by Carole King, from "Tapestry" (1971) (0:56 of 2:58))

scala> pause
res1: com.github.tototoshi.itunes.iTunes.Result = Result(0,Pausing iTunes.)
```

