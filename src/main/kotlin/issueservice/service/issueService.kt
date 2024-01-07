package issueservice.service

import issueservice.domain.Issue
import issueservice.domain.IssueRepository
import issueservice.domain.IssueStatus
import issueservice.exception.NotFoundException
import issueservice.model.IssueRequest
import issueservice.model.IssueResponse
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class IssueService(
  private val issueRepository: IssueRepository,
) {
  @Transactional
  fun createIssue(userId: Long, issue: IssueRequest): IssueResponse {
    
    val issue = Issue(
      summary = issue.summary,
      description = issue.description,
      userId = userId,
      status = issue.status,
      priority = issue.priority,
      type = issue.type,
    )
    return IssueResponse(issueRepository.save(issue))
  }
  
  @Transactional
  fun getIssues(userId: Long, status: IssueStatus) =
    issueRepository.findAllByUserIdAndStatusOrderByCreatedAtDesc(userId, status)?.map { IssueResponse(it) }
  
  @Transactional
  fun updateIssue(userId: Long, id: Long, request: IssueRequest): IssueResponse {
    val issue = issueRepository.findByIdAndUserId(id, userId) ?: throw NotFoundException("Issue not found")
    return with(issue) {
      summary = request.summary
      description = request.description
      status = request.status
      priority = request.priority
      type = request.type
      IssueResponse(issueRepository.save(this))
    }
  }
  
  fun deleteIssue(id: Long) = issueRepository.deleteById(id)
}
