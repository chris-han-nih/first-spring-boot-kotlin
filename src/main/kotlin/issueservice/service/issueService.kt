package issueservice.service

import issueservice.domain.Issue
import issueservice.domain.IssueRepository
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
}
