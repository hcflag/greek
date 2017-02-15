import edu.holycross.shot.cite._
import  edu.holycross.shot.ohco2._
import  edu.holycross.shot.greek._
import  edu.holycross.shot.gsphone._


val  edition = "in-progress/iliad-oct-ascii.tsv"

val corpus = CorpusSource.fromFile(edition)
val asciiStrings = corpus.nodes.map( cn =>  LiteraryGreekString(cn.text).ascii )
val asciiChars = asciiStrings.mkString.toList
val charmaps = asciiChars.groupBy(c => c)
val histo = charmaps.map { m => (m._1,m._2.size)}.toSeq.sortBy(_._2).reverse

println("\n\nSet of " + histo.size + " characters is distributed as follows:")
for ((k,v) <- histo) {
  println(k + " " + v)
}
