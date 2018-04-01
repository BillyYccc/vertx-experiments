package com.billyyccc.experiments.impl;

import com.billyyccc.experiments.ExperimentApplication;

import static java.lang.String.*;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */
public class ExperimentApplicationImpl implements ExperimentApplication {
  @Override
  public ExperimentApplication send(String message, String address) {
    System.out.println(format("Message sent to address: %s, content is: %s", address, message));
    return this;
  }
}
