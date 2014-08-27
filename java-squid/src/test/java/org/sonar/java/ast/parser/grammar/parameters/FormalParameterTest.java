/*
 * SonarQube Java
 * Copyright (C) 2012 SonarSource
 * dev@sonar.codehaus.org
 *
 * This program is free software; you can redistribute it and/or
 * modify it under the terms of the GNU Lesser General Public
 * License as published by the Free Software Foundation; either
 * version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston, MA  02
 */
package org.sonar.java.ast.parser.grammar.parameters;

import org.junit.Ignore;
import org.junit.Test;
import org.sonar.java.ast.parser.JavaGrammar;
import org.sonar.java.ast.parser.grammar.RuleMock;
import org.sonar.sslr.grammar.LexerlessGrammarBuilder;

import static org.sonar.sslr.tests.Assertions.assertThat;

public class FormalParameterTest {

  @Test
  @Ignore("FIXME")
  // FIXME
  public void ok() {
    LexerlessGrammarBuilder b = JavaGrammar.createGrammarBuilder();

    b.rule(JavaGrammar.ANNOTATION).override(RuleMock.word(b, "annotation"));
    b.rule(JavaGrammar.VARIABLE_DECLARATOR_ID).override(RuleMock.word(b, "variableDeclaratorId"));

    assertThat(b, JavaGrammar.FORMAL_PARAMETER)
      .matches("int variableDeclaratorId")
      .matches("final List<Integer> variableDeclaratorId")
      .matches("annotation int variableDeclaratorId")
      .matches("final final int variableDeclaratorId")
      .matches("annotation annotation int variableDeclaratorId")
      .matches("annotation final annotation final int variableDeclaratorId");
  }

}
