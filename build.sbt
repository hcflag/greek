

resolvers += Resolver.jcenterRepo
resolvers += Resolver.bintrayRepo("neelsmith","maven")
libraryDependencies ++=   Seq(
  "edu.holycross.shot.cite" %% "xcite" % "1.3.0",
  "edu.holycross.shot" %% "ohco2" % "4.0.0",
  "edu.holycross.shot" %% "greek" % "1.3.0",
  "edu.holycross.shot" %% "gsphone" % "1.0.1"
)
