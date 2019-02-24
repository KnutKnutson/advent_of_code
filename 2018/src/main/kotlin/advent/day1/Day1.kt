package advent.day1

/**
 * --- Day 1: Chronal Calibration ---
 */
class Day1 {
  companion object {
    @JvmStatic
    fun main(args: Array<String>) {
    }
  }

  fun resolveFrequency(resource: String): Int {
    return resourceContents(resource).lines().sumBy { it.toInt() }
  }

  /**
   * Returns the first duplicate frequency
   */
  fun duplicateFrequency(resource: String): Int {
    return findFirstDup(0, resource, mutableSetOf(0))
  }

  private fun findFirstDup(currentFrequency: Int, resource: String, observedFrequencies: MutableSet<Int>): Int {
    val freq = resourceContents(resource).lines().fold(currentFrequency) { acc, s ->
      val newFrequency = acc + s.toInt()
      if (observedFrequencies.contains(newFrequency)) return newFrequency
      observedFrequencies.add(newFrequency)
      newFrequency
    }
    return findFirstDup(freq, resource, observedFrequencies)
  }

  private fun resourceContents(resource: String): String {
    return ClassLoader.getSystemResource(resource).readText()
  }
}