package org.apache.spark

import org.apache.hadoop.service.Service.STATE
import org.apache.hadoop.yarn.conf.YarnConfiguration
import org.apache.hadoop.yarn.server.MiniYARNCluster

object Test {

  private var yarnCluster: MiniYARNCluster = _

  def main(args: Array[String]): Unit = {

    val yarnConf = new YarnConfiguration()

    yarnCluster = new MiniYARNCluster(getClass().getName(), 1, 1, 1)
    yarnCluster.init(yarnConf)
    yarnCluster.start()

    assert(yarnCluster.getServiceState == STATE.STARTED)

    yarnCluster.stop()
  }

}
