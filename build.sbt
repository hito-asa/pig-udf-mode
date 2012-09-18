name := "pig-udf-mode"

version := "1.0"

javacOptions ++= Seq("-source", "1.6", "-target", "1.6")

resolvers +=  "Cloudera" at "https://repository.cloudera.com/artifactory/cloudera-repos/"

resolvers += "thrift-0.2.0" at "http://people.apache.org/~rawson/repo/"

libraryDependencies += "org.apache.pig" % "pig" % "0.8.0-cdh3u0"

libraryDependencies += "org.apache.hadoop" % "hadoop-core" % "0.20.2-cdh3u0"

