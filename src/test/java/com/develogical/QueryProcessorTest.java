package com.develogical;

import org.junit.Ignore;
import org.junit.Test;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class QueryProcessorTest {

  QueryProcessor queryProcessor = new QueryProcessor();

  @Test
  public void knowsWhoWroteRomeoAndJuliet() throws Exception {
    assertThat(queryProcessor.process("Who wrote Romeo And Juliet"), containsString("Shakespeare"));
  }

  @Test
  public void isNotCaseSensitive() throws Exception {
    assertThat(queryProcessor.process("who wrote romeo and juliet"), containsString("Shakespeare"));
  }

  @Test
  public void returnsEmptyStringIfCannotProcessQuery() throws Exception {
    assertThat(queryProcessor.process("test"), is(""));
  }

  @Test
  public void addsTwoNumbers() throws Exception{
    assertThat(queryProcessor.process("ddddd: what is 3 plus 7"), is ("10"));
  }

  @Test
  public void multipliesTwoNumbers() throws Exception{
    assertThat(queryProcessor.process("ddddd: What is 3 * 7"), is ("21"));
  }

  @Test
  @Ignore
  public void findsTheGreatestInList() throws Exception{
    assertThat(queryProcessor.process("ddddd: which of the following numbers is the largest: 16, 596, 848, 25"), is ("848"));
  }


}
