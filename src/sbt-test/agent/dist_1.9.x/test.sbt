TaskKey[Unit]("check") := {
  assert(
    (Universal / mappings).value exists { case (file, path) =>
      path == "maxwell/maxwell.jar"
    },
    "dist mappings do not include 'maxwell/maxwell.jar'"
  )

  import scala.sys.process._
  val output =
    ((Universal / stagingDirectory).value / "bin" / packageName.value).absolutePath.!!

  assert(
    output contains "Agent 86",
    "output does not include 'Agent 86'"
  )
}
