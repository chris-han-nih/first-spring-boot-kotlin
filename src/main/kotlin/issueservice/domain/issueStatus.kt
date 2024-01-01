package issueservice.domain

enum class IssueStatus {
  OPEN, IN_PROGRESS, DONE;

  companion object {
    operator fun invoke(value: String): IssueStatus = valueOf(value.uppercase())
  }
}
