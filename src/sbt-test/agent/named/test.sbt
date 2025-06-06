TaskKey[Unit]("check") := {
  assert(
    (Universal / mappings).value exists { case (file, path) =>
      path == "get-smart/maxwell.jar"
    },
    "dist mappings do not include 'get-smart/maxwell.jar'"
  )

  import scala.sys.process._
  val output =
    ((Universal / stagingDirectory).value / "bin" / packageName.value).absolutePath.!!

  assert(
    output contains "Agent 86",
    "output does not include 'Agent 86'"
  )
}
