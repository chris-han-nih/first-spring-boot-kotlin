package issueservice.domain

import java.util.*

enum class IssueType {
  BUG, TASK, STORY;
  
  companion object {
    operator fun invoke(value: String): IssueType = valueOf(value.uppercase())
  }
}
