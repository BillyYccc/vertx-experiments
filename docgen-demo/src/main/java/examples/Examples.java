package examples;

import com.billyyccc.experiments.ExperimentApplication;
import io.vertx.core.Vertx;
import io.vertx.docgen.Source;

/**
 * @author Billy Yuan <billy112487983@gmail.com>
 */

@Source
public class Examples {

  public void example1(Vertx vertx) {

    // deploy our experiment HTTP server
    ExperimentApplication.deployHttpServer(vertx);
  }

  public void example2(Vertx vertx) {

    // deploy our experiment TCP server
    ExperimentApplication.deployTcpServer(vertx);
  }

  public void example3() {

    // send a message
    ExperimentApplication experimentApplication = ExperimentApplication.createApplication();
    experimentApplication.send("Your message", "Address");
  }
}
