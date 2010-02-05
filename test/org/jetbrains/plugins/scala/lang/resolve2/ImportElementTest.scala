package org.jetbrains.plugins.scala.lang.resolve2


/**
 * Pavel.Fatin, 02.02.2010
 */

class ImportElementTest extends ResolveTestBase {
  override def getTestDataPath: String = {
    super.getTestDataPath + "import/element/"
  }

  //TODO
//  def testCaseClass = doTest
  def testClass = doTest
  def testCompanion = doTest
  def testObject = doTest
  def testTrait = doTest
  def testFunctionDefinition = doTest
  def testValue = doTest
  def testVariable = doTest
  def testTypeAlias = doTest
  //TODO
//  def testCaseClassParameter = doTest
  def testFunctionParameter = doTest
}