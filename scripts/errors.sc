import edu.holycross.shot.cite._
import  edu.holycross.shot.ohco2._
import  edu.holycross.shot.greek._
import  edu.holycross.shot.gsphone._


val  edition = "in-progress/lysias.speeches.tsv"

val corpus = CorpusSource.fromFile(edition)
val urns = corpus.nodes.map(_.urn)
val gk = corpus.nodes.map( cn =>  LiteraryGreekString(cn.text).ascii)
val gkWUrn = urns.zip(gk).map( pr => CitableNode(pr._1, pr._2))


val errors = gkWUrn.filter(_.text.contains("#"))
val report = errors.map (cn => cn.urn.toString + "\t" + cn.text).mkString("\n")

import java.io._
new PrintWriter("error-report.txt") { write(report); close }
