package issueservice.model

import com.fasterxml.jackson.annotation.JsonFormat
import issueservice.domain.IssuePriority
import issueservice.domain.IssueStatus
import issueservice.domain.IssueType
import java.time.LocalDateTime

data class IssueRequest (
  val summary: String,
  val description: String,
  val status: IssueStatus,
  val priority: IssuePriority,
  val type: IssueType,
)

data class IssueResponse (
  val id: Long,
  val summary: String,
  val description: String,
  val status: IssueStatus,
  val priority: IssuePriority,
  val type: IssueType,
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  val createdAt: LocalDateTime,
  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
  val updatedAt: LocalDateTime,
) {
  constructor(issue: issueservice.domain.Issue): this(
    id = issue.id!!,
    summary = issue.summary,
    description = issue.description,
    status = issue.status,
    priority = issue.priority,
    type = issue.type,
    createdAt = issue.createdAt!!,
    updatedAt = issue.updatedAt!!,
  )
}
