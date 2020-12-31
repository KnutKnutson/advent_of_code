package com.knutknut.advent.twenty

class Day4 {
  fun solve1(passports: List<Passport>): Int {
    return passports.count { it.isValid() }
  }

  fun solve2(passports: List<Passport>): Int {
    return passports.count { it.isValid2() }
  }
}

data class Passport(
  var birthYear: String? = null,
  var issueYear: String? = null,
  var expirationYear: String? = null,
  var height: String? = null,
  var hairColor: String? = null,
  var eyeColor: String? = null,
  var passportId: String? = null,
  var countryId: String? = null
) {
  fun isValid(): Boolean {
    return !(birthYear.isNullOrEmpty()
        || issueYear.isNullOrEmpty()
        || expirationYear.isNullOrEmpty()
        || height.isNullOrEmpty()
        || hairColor.isNullOrEmpty()
        || eyeColor.isNullOrEmpty()
        || passportId.isNullOrEmpty())
  }

  fun isValid2(): Boolean {
    //    byr (Birth Year) - four digits; at least 1920 and at most 2002.
    //    iyr (Issue Year) - four digits; at least 2010 and at most 2020.
    //    eyr (Expiration Year) - four digits; at least 2020 and at most 2030.
    //    hgt (Height) - a number followed by either cm or in:
    //      If cm, the number must be at least 150 and at most 193.
    //      If in, the number must be at least 59 and at most 76.
    //    hcl (Hair Color) - a # followed by exactly six characters 0-9 or a-f.
    //    ecl (Eye Color) - exactly one of: amb blu brn gry grn hzl oth.
    //    pid (Passport ID) - a nine-digit number, including leading zeroes.
    //    cid (Country ID) - ignored, missing or not.
    return isValid()
        && birthYear?.toIntOrNull()?.let { (1920..2002).contains(it) } ?: false
        && issueYear?.toIntOrNull()?.let { (2010..2020).contains(it) } ?: false
        && expirationYear?.toIntOrNull()?.let { (2020..2030).contains(it) } ?: false
        && height?.let { hgt ->
          when(val suffix = hgt.takeLast(2)) {
            "cm" -> hgt.substringBefore(suffix).toIntOrNull()?.let { (150..193).contains(it) } ?: false
            "in" -> hgt.substringBefore(suffix).toIntOrNull()?.let { (59..76).contains(it) } ?: false
            else -> false
          }
        } ?: false
        && hairColor?.let { "#[0-9a-f]{6}".toRegex().matches(it) } ?: false
        && setOf("amb", "blu", "brn", "gry", "grn", "hzl", "oth").contains(eyeColor)
        && passportId?.let { it.length == 9 && it.toIntOrNull() != null } ?: false
  }
}