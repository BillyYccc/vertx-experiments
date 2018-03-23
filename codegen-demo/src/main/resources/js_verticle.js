var PolyglotClient = require("polyglot-client-js/polyglot_client");

exports.vertxStart = function () {
  var client = PolyglotClient.create(vertx, {});
  client.writeData(function (ar, err) {
    if (err == null) {
      console.log("Write Success...");
    } else {
      console.log("Write Failed...");
    }
  });

  client.readData(function (ar, err) {
    if (err == null) {
      console.log("Read Success...");
      console.log(ar)
    } else {
      console.log("Read Failed...");
    }
  });
};