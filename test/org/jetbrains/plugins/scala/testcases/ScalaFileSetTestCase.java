/*
 * Copyright 2000-2008 JetBrains s.r.o.
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.jetbrains.plugins.scala.testcases;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.module.Module;
import com.intellij.testFramework.fixtures.IdeaProjectTestFixture;
import com.intellij.testFramework.fixtures.IdeaTestFixtureFactory;
import com.intellij.testFramework.fixtures.TestFixtureBuilder;
import com.intellij.psi.codeStyle.CodeStyleSettings;
import com.intellij.psi.codeStyle.CodeStyleSettingsManager;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.plugins.scala.ScalaLoader;
import org.jetbrains.plugins.scala.ScalaFileType;

public abstract class ScalaFileSetTestCase extends FileSetTestCase {
  protected Project project;
  protected Module module;
  protected CodeStyleSettings mySettings;
  private IdeaProjectTestFixture fixture;
  @NonNls
  protected final static String TEMP_FILE = "temp.scala";


  public ScalaFileSetTestCase(String path) {
    super(path);
  }

  protected CodeStyleSettings getSettings() {
    return CodeStyleSettingsManager.getSettings(project);
  }

  protected void setSettings() {
    mySettings = getSettings();
    mySettings.getIndentOptions(ScalaFileType.SCALA_FILE_TYPE).INDENT_SIZE = 2;
    mySettings.getIndentOptions(ScalaFileType.SCALA_FILE_TYPE).CONTINUATION_INDENT_SIZE = 2;
    mySettings.getIndentOptions(ScalaFileType.SCALA_FILE_TYPE).TAB_SIZE = 2;
  }

  protected void setUp() {
    super.setUp();

    TestFixtureBuilder<IdeaProjectTestFixture> fixtureBuilder = IdeaTestFixtureFactory.getFixtureFactory().createLightFixtureBuilder();
    fixture = fixtureBuilder.getFixture();

    try {
      fixture.setUp();
    } catch (Exception e) {
      e.printStackTrace();
    }

    module = fixture.getModule();
    project = module.getProject();
    ScalaLoader.loadScala();
    setSettings();

  }

  protected void tearDown() {
    try {
      fixture.tearDown();
    } catch (Exception e) {
      //ignore
    }
    super.tearDown();
  }

}
