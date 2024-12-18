package com.juiceshop.test.executionservice.steps;

import io.cucumber.java.en.Given;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class CommonStepDef {

  @Given("dummy step def")
  public void dummyStepDef() {
    log.info("dummy step def");
  }
}
