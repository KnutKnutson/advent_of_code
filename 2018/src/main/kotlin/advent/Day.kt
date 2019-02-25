package advent

abstract class Day<T, S> {
  abstract fun solve1(inputResource: String): T
  abstract fun solve2(inputResource: String): S

  protected fun resourceContents(resource: String): String {
    return ClassLoader.getSystemResource(resource).readText()
  }
}