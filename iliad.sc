import edu.holycross.shot.cite._
import  edu.holycross.shot.ohco2._
import  edu.holycross.shot.greek._
import  edu.holycross.shot.gsphone._

val corpus = CorpusSource.fromFile("in-progress/iliad-oct-ascii.tsv")
val urnList = corpus.nodes.map(_.urn)


val asciiStrings = corpus.nodes.map( cn =>  LiteraryGreekString(cn.text).ascii )
val asciiZipped = urnList.zip(asciiStrings)
val asciiCorpus =  asciiZipped.map{ t=> CitableNode(t._1,t._2) }
val asciiTwoColumns = asciiCorpus.map (cn => cn.urn.toString + "\t" + cn.text).mkString("\n"
)
import java.io._
new PrintWriter("iliad-oct-ascii.tsv") { write(asciiTwoColumns); close }



val goodlines = asciiCorpus.filterNot(_.text.contains("#"))
val goodlinesTwoColumns = goodlines.map(cn => cn.urn.toString + "\t" + cn.text).mkString("\n")

new PrintWriter("iliad-goodlines.tsv") { write(goodlinesTwoColumns); close }

/*
val goodIl = CorpusSource.fromFile("iliad-goodlines.tsv")
val goodWordVects = goodIl.nodes.map(cn => cn.text.split(" ").toVector)
val gkWordVects = goodWordVects.map{ v => v.map (LiteraryGreekString(_)) }
val sylls = gkWordVects.map { v => LGSyllable.syllabify(v) }
val syllsDisplay = sylls.map{v => (v.map(_.ucode)).mkString("-") }
val pitchLines = sylls.map{v => (v.map(_.accent.getOrElse("-")).mkString) }
*/
