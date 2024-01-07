package issueservice.model

import java.time.LocalDateTime

data class CommentRequest(
  val id: Long,
  val userId: Long,
  val issueId: Long,
  val body: String,
)

data class CommentResponse(
  val id: Long,
  val userId: Long,
  val issueId: Long,
  val comment: String,
  val createdAt: LocalDateTime,
  val updatedAt: LocalDateTime,
) {
  constructor(comment: issueservice.domain.Comment) : this(
    id = comment.id!!,
    userId = comment.userId,
    issueId = comment.issue.id!!,
    comment = comment.body,
    createdAt = comment.createdAt!!,
    updatedAt = comment.updatedAt!!,
  )
}
