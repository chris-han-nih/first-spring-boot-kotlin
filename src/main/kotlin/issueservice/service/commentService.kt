package issueservice.service

import issueservice.domain.Comment
import issueservice.domain.CommentRepository
import issueservice.domain.IssueRepository
import issueservice.model.CommentRequest
import issueservice.model.CommentResponse
import jakarta.transaction.Transactional
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class CommentService(
  private val commentRepository: CommentRepository,
  private val issueRepository: IssueRepository,
) {
  @Transactional
  fun createComment(userId: Long, request: CommentRequest): CommentResponse {
    val issue = issueRepository.findByIdOrNull(request.issueId) ?: throw Exception("Issue not found")
    val comment = Comment(
      userId = userId,
      issue = issue,
      body = request.body,
    )
    return CommentResponse(commentRepository.save(comment))
  }
}
