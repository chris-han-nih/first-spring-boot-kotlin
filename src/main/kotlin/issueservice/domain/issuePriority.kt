package issueservice.domain

enum class IssuePriority {
  LOW, MEDIUM, HIGH;

  companion object {
    operator fun invoke(value: String): IssuePriority = valueOf(value.uppercase())
  }
}
