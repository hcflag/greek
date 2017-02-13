import edu.holycross.shot.cite._
import  edu.holycross.shot.ohco2._
import  edu.holycross.shot.greek._
import  edu.holycross.shot.gsphone._

val corpus = CorpusSource.fromFile("in-progress/iliad-oct.tsv")
val urnList = corpus.nodes.map(_.urn)


val asciiStrings = corpus.nodes.map( cn =>  LiteraryGreekString(cn.text).ascii )
val asciiZipped = urnList.zip(asciiStrings)
val asciiCorpus =  asciiZipped.map{ t=> CitableNode(t._1,t._2) }
val asciiTwoColumns = asciiCorpus.map (cn => cn.urn.toString + "\t" + cn.text).mkString("\n"
)
import java.io._
new PrintWriter("iliad-oct-ascii.tsv") { write(asciiTwoColumns); close }



val errors = asciiCorpus.filter(_.text.contains("#"))
val errorsTwoColumns = errors.map(cn => cn.urn.toString + "\t" + cn.text).mkString("\n"
)
new PrintWriter("iliad-errors.tsv") { write(asciiTwoColumns); close }
