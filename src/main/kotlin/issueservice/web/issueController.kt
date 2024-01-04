package issueservice.web

import issueservice.config.AuthUser
import issueservice.domain.IssueStatus
import issueservice.model.IssueRequest
import issueservice.service.IssueService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/issues")
class IssueController(
  private val issueService: IssueService,
) {
  @PostMapping
  fun createIssue(
    authUser: AuthUser,
    @RequestBody issue: IssueRequest,
  ) = issueService.createIssue(authUser.userId, issue)
  
  @GetMapping
  fun getIssues(
    authUser: AuthUser,
    @RequestParam(required = false, defaultValue = "OPEN") status: IssueStatus,
  ) = issueService.getIssues(authUser.userId, status)
  
  @PutMapping("/{id}")
  fun updateIssue(
    authUser: AuthUser,
    @PathVariable id: Long,
    @RequestBody issue: IssueRequest,
  ) = issueService.updateIssue(authUser.userId, id, issue)
  
  @DeleteMapping("/{id}")
  @ResponseStatus(HttpStatus.NO_CONTENT)
  fun deleteIssue(
    @PathVariable id: Long,
  ) = issueService.deleteIssue(id)
}
