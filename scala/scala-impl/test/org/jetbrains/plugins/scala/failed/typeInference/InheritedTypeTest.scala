package org.jetbrains.plugins.scala.failed.typeInference

import org.jetbrains.plugins.scala.PerfCycleTests
import org.jetbrains.plugins.scala.lang.typeInference.TypeInferenceTestBase
import org.junit.experimental.categories.Category

/**
  * @author Roman.Shein
  * @since 28.03.2016.
  */
@Category(Array(classOf[PerfCycleTests]))
class InheritedTypeTest extends TypeInferenceTestBase {

  override protected def shouldPass: Boolean = false

  override def folderPath: String = super.folderPath + "bugs5/"

  def testSCL8411(): Unit = doTest()
}
