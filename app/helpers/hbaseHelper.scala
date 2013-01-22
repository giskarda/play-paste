package gpasties

import play._

import org.apache.hadoop.hbase.HBaseConfiguration
import org.apache.hadoop.hbase.client.{HBaseAdmin,HTable,Put,Get}
import org.apache.hadoop.hbase.util.Bytes
import org.apache.hadoop.conf.{Configuration => HConf}

import scala.util.Random

class HbaseHelper extends Logger {
  val config: HConf = HBaseConfiguration create

  val admin = new HBaseAdmin(config)
  val table = new HTable(config, "gpasties")

  def get(id: String) = {
    val theget= new  Get(Bytes.toBytes(id))
    val result=table.get(theget)
    val value= Bytes.toString(result.value())
    value
  }

  def put(text: String) = {
    lazy val key = util.Random.alphanumeric.take(8).mkString
    val theput= new Put(Bytes.toBytes(key))
    theput.add(Bytes.toBytes("cf"),Bytes.toBytes("a"),Bytes.toBytes(text))
    table.put(theput)
    key
  }
}
