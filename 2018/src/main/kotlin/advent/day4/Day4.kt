package advent.day4

import advent.Day
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter
import java.time.temporal.ChronoUnit

class Day4: Day<Int, String?>() {

  override fun solve1(inputResource: String): Int {
    val guards = parseGuardEvents(resourceContents(inputResource).lines())
    val idToSleepTime = guards.map { guard ->
      guard.id to guard.asleep.sumBy { it.endInclusive.minute - 1 - it.start.minute }
    }
    println(idToSleepTime)
    return 0
  }

  override fun solve2(inputResource: String): String? {
    TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
  }

  private fun parseGuardEvents(events: List<String>): List<Guard> {
    val sortedEventsByGuard = parseAndSortEvents(events).groupBy { it.guardId() }
    return sortedEventsByGuard.entries.map {
      val guard = Guard(it.key, mutableListOf(), mutableListOf())
      val guardEvents = it.value

      guardEvents.forEachIndexed { index, event ->
        val nextEvent = if (index+1 > guardEvents.size) null else guardEvents[index+1]
        val shiftEnd = event.time.truncatedTo(ChronoUnit.HOURS).plusMinutes(60)
        val endTime = if (nextEvent == null) shiftEnd else listOf(nextEvent.time, shiftEnd).min()!!
        when {
          event.isShiftStart() -> { guard.awake.add(event.time.rangeTo(endTime)) }
          event.isSleepEvent() -> { guard.asleep.add(event.time.rangeTo(endTime)) }
          event.isAwakeEvent() -> { guard.awake.add(event.time.rangeTo(endTime)) }
        }
      }
      guard
    }
  }

  private fun parseAndSortEvents(events: List<String>): MutableList<Event> {
    val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")
    return events.map {
      Event(
              time = LocalDateTime.parse(it.substringBefore("]").trim('['), formatter),
              description = it.substringAfter("]").trim()
      )
    }.sortedBy { it.time }.toMutableList()
  }

  data class Guard(val id: Int,
                   val awake: MutableList<ClosedRange<LocalDateTime>>,
                   val asleep: MutableList<ClosedRange<LocalDateTime>>)

  data class Event(val time: LocalDateTime, val description: String) {
    fun isShiftStart(): Boolean = description.contains("begins shift")
    fun isAwakeEvent(): Boolean = description.contains("wakes up")
    fun isSleepEvent(): Boolean = description.contains("falls asleep")

    fun guardId(): Int {
      return description.split(" ")[1].trim('#').toInt()
    }
  }

}
