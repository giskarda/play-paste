import sbt._
import Keys._
import PlayProject._

object ApplicationBuild extends Build {

    val appName         = "gpasties"
    val appVersion      = "1.0-SNAPSHOT"

    val appDependencies = Seq(
      "org.apache.hadoop" % "hadoop-core" % "0.20.2",
      "org.apache.hbase" % "hbase" % "0.94.1"
    )

    val main = PlayProject(appName, appVersion, appDependencies, mainLang = SCALA).settings(

      resolvers += "Apache HBase" at "https://repository.apache.org/content/repositories/releases",
      
      resolvers += "Thrift" at "http://people.apache.org/~rawson/repo/"

    )
}
